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
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.Bag;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.ui.InventoryPane;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndBag;
import com.watabou.noosa.audio.Sample;

import java.util.ArrayList;

public class BattleAxe extends MeleeWeapon {

	public static final String AC_PAINT = "PAINT";

	{
		image = ItemSpriteSheet.BATTLE_AXE;
		hitSound = Assets.Sounds.HIT_SLASH;
		hitSoundPitch = 0.9f;

		tier = 4;
		ACC = 1.24f; //24% boost to accuracy

		skinnable = true;
		skin = Skin.AXE;
		type = Type.AXE;
	}

	@Override
	public int max(int lvl) {
		return trueMax( 4*(tier+1) +    //20 base, down from 25
							lvl*(tier+1));   //scaling unchanged
	}

	@Override
	public String targetingPrompt() {
		return Messages.get(this, "prompt");
	}

	@Override
	protected void duelistAbility(Hero hero, Integer target) {
		//+(5+1.5*lvl) damage, roughly +40% base dmg, +50% scaling
		int dmgBoost = augment.damageFactor(5 + Math.round(1.5f*buffedLvl()));
		Mace.heavyBlowAbility(hero, target, 1, dmgBoost, this);
	}

	@Override
	public String abilityInfo() {
		int dmgBoost = levelKnown ? 5 + Math.round(1.5f*buffedLvl()) : 5;
		if (levelKnown){
			return Messages.get(this, "ability_desc", augment.damageFactor(min()+dmgBoost), augment.damageFactor(max()+dmgBoost));
		} else {
			return Messages.get(this, "typical_ability_desc", min(0)+dmgBoost, max(0)+dmgBoost);
		}
	}

	public String upgradeAbilityStat(int level){
		int dmgBoost = 5 + Math.round(1.5f*level);
		return augment.damageFactor(min(level)+dmgBoost) + "-" + augment.damageFactor(max(level)+dmgBoost);
	}

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
				case TRUEGOLDAXE:
					return "True Golden Axe";
				case CHAINAXE:
					return "Chainaxe";
				case PILEAXE:
					return "Pile of Battleaxes";
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

	protected static WndBag.ItemSelector skinSelector = new WndBag.ItemSelector() {

		@Override
		public String textPrompt() {
			return  Messages.get(BattleAxe.class, "skin");
		}

		@Override
		public Class<?extends Bag> preferredBag(){
			if (InventoryPane.lastBag != null) return InventoryPane.lastBag.getClass();
			return Belongings.Backpack.class;
		}

		@Override
		public boolean itemSelectable(Item item) {
			return Skin.containsIngredient(item, BattleAxe.class) && item.isIdentified();
		}

		@Override
		public void onSelect( Item item ) {
			if (item != null && itemSelectable(item)) {
				Skin skin = Skin.fromIngredient(item, BattleAxe.class);

				GLog.p(Messages.get(BattleAxe.class, "applyskin"));
				Dungeon.hero.sprite.operate(Dungeon.hero.pos);
				Sample.INSTANCE.play(Assets.Sounds.EQUIP_AXE);
				curItem.applySkin(skin);
			}
		}
	};

}
