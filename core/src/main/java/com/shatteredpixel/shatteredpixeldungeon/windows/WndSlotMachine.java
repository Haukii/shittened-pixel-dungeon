/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2022 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.windows;

import com.badlogic.gdx.utils.Timer;
import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.Chrome;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.SlotMachine;
import com.shatteredpixel.shatteredpixeldungeon.items.Amulet;
import com.shatteredpixel.shatteredpixeldungeon.items.Dewdrop;
import com.shatteredpixel.shatteredpixeldungeon.items.Gold;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.LootBag;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Egg;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.DarkGold;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.GoldBar;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.GooBlob;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.MetalShard;
import com.shatteredpixel.shatteredpixeldungeon.mechanics.LootGenerator;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.PixelScene;
import com.shatteredpixel.shatteredpixeldungeon.ui.ItemSlot;
import com.shatteredpixel.shatteredpixeldungeon.ui.RedButton;
import com.shatteredpixel.shatteredpixeldungeon.ui.RenderedTextBlock;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;
import com.watabou.noosa.NinePatch;
import com.watabou.noosa.audio.Sample;
import com.watabou.noosa.ui.Component;
import com.watabou.utils.Random;

import java.util.HashMap;
import java.util.Map;

//this is what your code looks like when you do 0 planning before implementing stuff.

public class WndSlotMachine extends Window {

	private static final int BTN_SIZE	= 24;
	private static final float BTN_GAP	= 10;
	private static final int WIDTH		= 116;

	private ItemButton slot1;
	private ItemButton slot2;
	private ItemButton slot3;
	private RenderedTextBlock message;
	private RedButton btnPlay;
	private RedButton btnBet;

	private Item item1;
	private Item item2;


	private final int[] bets = {2,10,20,50,100};
	private int betIndex = 0;

	public WndSlotMachine(SlotMachine slotMachine ) {
		super();


		IconTitle titlebar = new IconTitle();
		titlebar.icon( slotMachine.sprite() );
		titlebar.label( Messages.get(this, "title") );
		titlebar.setRect( 0, 0, WIDTH, 0 );
		add( titlebar );

		slot1 = new ItemButton();
		slot2 = new ItemButton();
		slot3 = new ItemButton();
		slot1.item(new Amulet());
		slot2.item(new Amulet());
		slot3.item(new Amulet());

		slot1.setRect( (WIDTH - BTN_GAP) / 2 - (BTN_SIZE + 15), titlebar.bottom() + BTN_GAP, BTN_SIZE, BTN_SIZE );
		add(slot1);

		slot2.setRect( slot1.right() + BTN_GAP, slot1.top(), BTN_SIZE, BTN_SIZE );
		add(slot2);

		slot3.setRect( slot2.right() + BTN_GAP, slot2.top(), BTN_SIZE, BTN_SIZE );
		add(slot3);

		message = PixelScene.renderTextBlock( Messages.get(this, "prompt"), 6 );
		message.maxWidth( WIDTH);
		message.setPos(slot1.right(), slot1.bottom() + BTN_GAP / 2 );
		add( message );
		
		btnPlay = new RedButton( Messages.get(this, "play") ) {
			@Override
			protected void onClick() {
				play();
			}
		};

		btnBet = new RedButton( bets[betIndex] + "g" ) {
			@Override
			protected void onClick() {
				betIndex = (betIndex + 1) % bets.length;
				this.text.text(bets[betIndex] + "g");
					btnPlay.enable(notBroke());
			}
		};

		btnPlay.enable(notBroke());
		btnPlay.setRect( 0, message.bottom() + BTN_GAP, WIDTH - 24, 20 );
		btnBet.enable( true );
		btnBet.setRect( btnPlay.right(), btnPlay.top(), 24, 20 );
		add(btnPlay);
		add(btnBet);
		
		resize( WIDTH, (int) btnPlay.bottom() );
	}

	private void play() {
		Dungeon.gold -= bets[betIndex];
		btnPlay.enable(false);
		btnBet.enable(false);
		message.text(" ");

		int slot1Repeats = Random.Int(15, 25);
		int slot2Repeats = Random.Int(slot1Repeats + 5, slot1Repeats + 15);
		int slot3Repeats = Random.Int(slot2Repeats + 5, slot2Repeats + 15);
		final int[] slot1Total = {0};
		final int[] slot2Total = {0};
		final int[] slot3Total = {0};

		float slot1Interval = Random.Float(0.04f, 0.06f);
		float slot2Interval = Random.Float(0.05f, 0.07f);
		float slot3Interval = Random.Float(0.06f, 0.08f);

		Timer.schedule(new Timer.Task(){
			@Override
			public void run(){
				slot1.item(rollItem(null));
				Sample.INSTANCE.play(Assets.Sounds.SLOT_TICK, 0.9f, 1.05f);
				if (slot1Total[0] == slot1Repeats) {
					item1 = slot1.item;
				}
				slot1Total[0]++;
			}
		}, 0f, slot1Interval, slot1Repeats);
		Timer.schedule(new Timer.Task(){
			@Override
			public void run(){
				slot2.item(rollItem(item1));
				Sample.INSTANCE.play(Assets.Sounds.SLOT_TICK, 1f, 1f);
					if (slot2Total[0] == slot2Repeats) {
						item2 = slot2.item;
					}
				slot2Total[0]++;
			}
		}, 0f, slot2Interval, slot2Repeats);
		Timer.schedule(new Timer.Task(){
			@Override
			public void run(){
				slot3.item(rollItem(item2));
				Sample.INSTANCE.play(Assets.Sounds.SLOT_TICK, 1f, 1f);
				if (slot3Total[0] == slot3Repeats) {
					Sample.INSTANCE.play(Assets.Sounds.SLOT_TICK, 15f, 0.8f);
					btnPlay.enable(notBroke());
					btnBet.enable(true);

					int winnings = calculateWinnings();
					if (winnings > 0) {
						message.text(Messages.get(WndSlotMachine.class, "win", winnings));
						Dungeon.level.drop(new Gold(winnings), Dungeon.hero.pos).sprite.drop();
						if (winnings > 100 * bets[betIndex]) {
							Sample.INSTANCE.play(Assets.Sounds.WIN_LARGE);
						} else if (winnings > 14 * bets[betIndex]) {
							Sample.INSTANCE.play(Assets.Sounds.WIN_MEDIUM);
						} else {
							Sample.INSTANCE.play(Assets.Sounds.WIN_SMALL);
						}
						if (winnings >= 10000) {
							Sample.INSTANCE.play(Assets.Sounds.HIT_STRONG);
							Badges.validateJackpot();
						}
					//If we get lootbag
					} else if (winnings < 0) {
						message.text(Messages.get(WndSlotMachine.class, "loot"));
						Item lootItem;
						do {
							lootItem = LootGenerator.rollItem();
						} while (lootItem.value() >= bets[betIndex] * 5 + 10 || lootItem.value() < bets[betIndex] / 2);
						Dungeon.level.drop(lootItem, Dungeon.hero.pos);
						Sample.INSTANCE.play(lootItem.value() <= 50
								? Assets.Sounds.WIN_SMALL : Assets.Sounds.WIN_MEDIUM);
					}
				}
				slot3Total[0]++;
			}
		}, 0f, slot3Interval, slot3Repeats);
	}

	private boolean notBroke() {
		return Dungeon.gold >= bets[betIndex];
	}

	private Item rollItem(Item previousSlot) {
		Map<Item, Float> items = new HashMap<>();
		items.put(new Amulet(), 0.03f);
		items.put(new GoldBar(), 0.05f);
		items.put(new DarkGold(), 0.07f);
		items.put(new MetalShard(), 0.13f);
		items.put(new GooBlob(), 0.15f);
		items.put(new Dewdrop(), 0.21f);
		items.put(new LootBag(), 0.23f);
		items.put(new Egg(), 0.26f);

		Item result = null;

		do {
			float roll = Random.Float();
			for (Map.Entry<Item, Float> entry : items.entrySet()) {
				if (Random.Float() > 0.5f)
					continue;

				if (roll < entry.getValue()) {
					//25% chance to skip item if it doesn't match item on the previous slot. This is to increase chance for big wins.
					if (previousSlot != null && entry.getKey().getClass()
							!= previousSlot.getClass() && Random.Float() < 0.25f) {
						continue;
					}

					result = entry.getKey();
				}
			}
		} while (result == null);

		return result;
	}

	private int calculateWinnings() {
		int winnings = 0;

		int dewdrops = 0;
		int goldores = 0;

		if (slot1.item instanceof Dewdrop) dewdrops++;
		if (slot2.item instanceof Dewdrop) dewdrops++;
		if (slot3.item instanceof Dewdrop) dewdrops++;
		if (slot1.item instanceof DarkGold) goldores++;
		if (slot2.item instanceof DarkGold) goldores++;
		if (slot3.item instanceof DarkGold) goldores++;

		if (slot1.item.getClass() == slot2.item.getClass()
				&& slot2.item.getClass() == slot3.item.getClass()) {
			if (slot1.item instanceof Amulet) winnings = 500;
			else if (slot1.item instanceof GoldBar) winnings = 200;
			else if (slot1.item instanceof DarkGold) winnings = 100;
			else if (slot1.item instanceof MetalShard) winnings = 60;
			else if (slot1.item instanceof GooBlob) winnings = 30;
			else if (slot1.item instanceof Dewdrop) winnings = 17;
            else if (slot1.item instanceof Egg) winnings = 10;
            else if (slot1.item instanceof LootBag) winnings = -1;
		} else {
			if (dewdrops == 1) winnings = 1;
			else if (dewdrops == 2) winnings = 1;
			if (goldores == 1) winnings += 2;
			else if (goldores == 2) winnings += 5;
		}

		if (winnings == 1) {
			winnings *= bets[betIndex];
			winnings /= 2;
		}
		else {
			winnings *= bets[betIndex];
		}
		return winnings;
	}

	@Override
	public void onBackPressed() {
		if (btnBet.active) {
			super.onBackPressed();
		}
	}
	
	public static class ItemButton extends Component {
		
		protected NinePatch bg;
		protected ItemSlot slot;
		
		public Item item = null;
		
		@Override
		protected void createChildren() {
			super.createChildren();
			
			bg = Chrome.get( Chrome.Type.RED_BUTTON);
			add( bg );
			
			slot = new ItemSlot() {
			};
			slot.enable(true);
			add( slot );
		}
		
		protected void onClick() {}
		
		@Override
		protected void layout() {
			super.layout();
			
			bg.x = x;
			bg.y = y;
			bg.size( width, height );
			
			slot.setRect( x + 2, y + 2, width - 4, height - 4 );
		}
		
		public void item( Item item ) {
			slot.item( this.item = item );
		}

		public void clear(){
			slot.clear();
		}
	}
}
