/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2024 Evan Debenham
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

package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.Skin;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Belongings;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.Torch;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.Bag;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.UnstableBrew;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.ui.InventoryPane;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndBag;
import com.watabou.noosa.audio.Sample;
import com.watabou.noosa.particles.Emitter;

import java.util.ArrayList;

public class Glaive extends MeleeWeapon {

	public static final String AC_PAINT = "PAINT";

	{
		image = ItemSpriteSheet.GLAIVE;
		hitSound = Assets.Sounds.HIT_SLASH;
		hitSoundPitch = 0.8f;

		tier = 5;
		DLY = 1.5f; //0.67x speed
		RCH = 2;    //extra reach

		skinnable = true;
		skin = Skin.GLAIVE;
		type = Type.AXE;
	}

	@Override
	public int max(int lvl) {
		return  Math.round(6.67f*(tier+1)) +    //40 base, up from 30
				lvl*Math.round(1.33f*(tier+1)); //+8 per level, up from +6
	}

	@Override
	public String targetingPrompt() {
		return Messages.get(this, "prompt");
	}

	@Override
	protected void duelistAbility(Hero hero, Integer target) {
		//+(12+2.5*lvl) damage, roughly +55% base damage, +55% scaling
		int dmgBoost = augment.damageFactor(12 + Math.round(2.5f*buffedLvl()));
		Spear.spikeAbility(hero, target, 1, dmgBoost, this);
	}

	public String upgradeAbilityStat(int level){
		int dmgBoost = 12 + Math.round(2.5f*level);
		return augment.damageFactor(min(level)+dmgBoost) + "-" + augment.damageFactor(max(level)+dmgBoost);
	}

	@Override
	public String abilityInfo() {
		int dmgBoost = levelKnown ? 12 + Math.round(2.5f*buffedLvl()) : 12;
		if (levelKnown){
			return Messages.get(this, "ability_desc", augment.damageFactor(min()+dmgBoost), augment.damageFactor(max()+dmgBoost));
		} else {
			return Messages.get(this, "typical_ability_desc", min(0)+dmgBoost, max(0)+dmgBoost);
		}
	}

	@Override
	public ArrayList<String> actions(Hero hero) {
		ArrayList<String> actions = super.actions( hero );
		if (isIdentified()) {
			actions.add(AC_PAINT);
		}
		return actions;

	}

	@Override
	public void execute(Hero hero, String action) {
		super.execute(hero, action);
		if (action.equals(AC_PAINT)) {
			curItem = this;
			GameScene.selectItem(skinSelector);
		}
	}

	@Override
	public String name() {
		if (skin != null && skin.rarityTier() >= 4) {
			switch (skin) {
				case TRUEGOLDGLAIVE:
					return "True Golden Glaive";
				case BEEGLAIVE:
					return "Glaive of Bees";
				case SNAKEGLAIVE:
					return "Medusa's Glaive";
				case SHROUDEDGLAIVE:
					return "Glaive of Darkness";
				case BLOWNUPGLAIVE:
					return "Blown Up Glaive";
				case FIERYGLAIVE:
					return "Fiery Glaive";
			}
		}
		return super.name();
	}

	@Override
	public String desc() {
		String desc = super.desc();
		if (skin.rarityTier() != 0) {
			desc += Messages.get(this,"desc_skin",skin.rarity() + " _" + skin.skinName() + "_");
			if (!skin.desc().isEmpty()) {
				desc += "\n\n\"" + skin.desc() + "\"";
			}
		}

		return desc;
	}

	@Override
	public Emitter emitter() {

		Emitter emitter = new Emitter();
		emitter.pos(ItemSpriteSheet.film.width(image)/2f, ItemSpriteSheet.film.height(image)/2f - 3f);
		emitter.fillTarget = false;
		switch (skin) {
			case TRUEGOLDGLAIVE:
				emitter.randomSize = true;
				emitter.randomHeight = 6f;
				emitter.randomWidth = 6f;
				emitter.pour(Speck.factory( Speck.PUREGOLDSEAL), 0.3f);
				return emitter;
			case BEEGLAIVE:
				emitter.randomSize = true;
				emitter.randomHeight = 6f;
				emitter.randomWidth = 6f;
				emitter.pour(Speck.factory(Speck.BEES), 0.4f);
				return emitter;
			case SNAKEGLAIVE:
				emitter.randomSize = true;
				emitter.randomHeight = 6f;
				emitter.randomWidth = 6f;
				emitter.pour(Speck.factory( Speck.SNAKESEAL), 0.5f);
				return emitter;
			case SHROUDEDGLAIVE:
				emitter.randomSize = true;
				emitter.randomHeight = 5f;
				emitter.randomWidth = 5f;
				emitter.centerOffsetY = -2f;
				emitter.pour(Speck.factory( Speck.SMOKE), 0.3f);
				return emitter;
			case BLOWNUPGLAIVE:
				emitter.pos(ItemSpriteSheet.film.width(image)/2f, ItemSpriteSheet.film.height(image)/2f + 4f);
				emitter.randomSize = true;
				emitter.randomHeight = 2f;
				emitter.randomWidth = 2f;
				emitter.centerOffsetY = 1f;
				emitter.pour(Speck.factory( Speck.BLOWNUPSEAL), 0.3f);
				return emitter;
			case FIERYGLAIVE:
				emitter.randomSize = true;
				emitter.randomHeight = 5f;
				emitter.randomWidth = 5f;
				emitter.centerOffsetY = -2f;
				emitter.pour(Speck.factory( Speck.FIERYSEAL), 0.05f);
				return emitter;
		}

		return emitter;
	}

	protected static WndBag.ItemSelector skinSelector = new WndBag.ItemSelector() {

		@Override
		public String textPrompt() {
			return  Messages.get(Glaive.class, "skin");
		}

		@Override
		public Class<?extends Bag> preferredBag(){
			if (InventoryPane.lastBag != null) return InventoryPane.lastBag.getClass();
			return Belongings.Backpack.class;
		}

		@Override
		public boolean itemSelectable(Item item) {
			return Skin.containsIngredient(item, Glaive.class) && item.isIdentified();
		}

		@Override
		public void onSelect( Item item ) {
			if (item != null && itemSelectable(item)) {
				Skin skin = Skin.fromIngredient(item, Glaive.class);

				if (item instanceof UnstableBrew && skin == Skin.RAINBOWGLAIVE) {
					skin = Skin.FULLRAINBOWGLAIVE;
				}

				if (item instanceof Torch) {
					if (skin == Skin.NUTGLAIVE || skin == Skin.NATUREGLAIVE) {
						skin = Skin.FIERYGLAIVE;
						Sample.INSTANCE.play(Assets.Sounds.BURNING, 1f);
					} else if (skin == Skin.BOMBGLAIVE) {
						skin = Skin.BLOWNUPGLAIVE;
						Sample.INSTANCE.play(Assets.Sounds.BLAST, 1f);
					}
				}

				GLog.p(Messages.get(Glaive.class, "applyskin"));
				Dungeon.hero.sprite.operate(Dungeon.hero.pos);
				Sample.INSTANCE.play(Assets.Sounds.EQUIP_AXE);
				curItem.applySkin(skin);
			}
		}
	};


}
