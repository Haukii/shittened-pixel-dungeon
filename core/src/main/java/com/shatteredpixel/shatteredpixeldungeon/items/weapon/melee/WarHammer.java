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
import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.Challenges;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.Skin;
import com.shatteredpixel.shatteredpixeldungeon.Statistics;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.WellFed;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Belongings;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Talent;
import com.shatteredpixel.shatteredpixeldungeon.effects.SpellSprite;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.Bag;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Berry;
import com.shatteredpixel.shatteredpixeldungeon.items.food.CoffeeBean;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Milk;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.GooBlob;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.ui.InventoryPane;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndBag;
import com.watabou.noosa.audio.Sample;

import java.util.ArrayList;

public class WarHammer extends MeleeWeapon {

	public static final String AC_PAINT = "PAINT";
	public static final String AC_EAT = "EAT";

	{
		image = ItemSpriteSheet.WAR_HAMMER;
		hitSound = Assets.Sounds.HIT_CRUSH;
		hitSoundPitch = 1f;

		tier = 5;
		ACC = 1.20f; //20% boost to accuracy

		type = Type.AXE;
		skinnable = true;
		skin = Skin.HAMMER;
	}

	@Override
	public int max(int lvl) {
		return  trueMax(4*(tier+1) +    //24 base, down from 30
				lvl*(tier+1));   //scaling unchanged
	}

	@Override
	public String targetingPrompt() {
		return Messages.get(this, "prompt");
	}

	@Override
	protected void duelistAbility(Hero hero, Integer target) {
		//+(6+1.5*lvl) damage, roughly +40% base dmg, +45% scaling
		int dmgBoost = augment.damageFactor(6 + Math.round(1.5f*buffedLvl()));
		Mace.heavyBlowAbility(hero, target, 1, dmgBoost, this);
	}

	public String upgradeAbilityStat(int level){
		int dmgBoost = 6 + Math.round(1.5f*level);
		return augment.damageFactor(min(level)+dmgBoost) + "-" + augment.damageFactor(max(level)+dmgBoost);
	}

	@Override
	public String abilityInfo() {
		int dmgBoost = levelKnown ? 6 + Math.round(1.5f*buffedLvl()) : 6;
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
		} else if (skin == Skin.CAKEHAMMER) {
			actions.add(AC_EAT);
		}
		return actions;

	}

	@Override
	public void execute(Hero hero, String action) {
		super.execute(hero, action);
		if (action.equals(AC_PAINT)) {
			curItem = this;
			GameScene.selectItem(skinSelector);
		} else if (action.equals(AC_EAT)) {
			applySkin(Skin.BITTENHAMMER);

			//Basically just Food.execute()
			if (Dungeon.isChallenged(Challenges.NO_FOOD)){
				Buff.affect(hero, Hunger.class).satisfy(100f);
			} else {
				Buff.affect(hero, Hunger.class).satisfy(300f);
			}
			hero.sprite.operate( hero.pos );
			hero.busy();
			SpellSprite.show( hero, SpellSprite.FOOD );
			Sample.INSTANCE.play( Assets.Sounds.EAT );
			GLog.i( Messages.get(this, "eat_msg") );
			if (Dungeon.hero.hasTalent(Talent.IRON_STOMACH)
					|| Dungeon.hero.hasTalent(Talent.ENERGIZING_MEAL)
					|| Dungeon.hero.hasTalent(Talent.MYSTICAL_MEAL)
					|| Dungeon.hero.hasTalent(Talent.INVIGORATING_MEAL)){
				hero.spend(1f);
			} else {
				hero.spend(3f);
			}

			Talent.onFoodEaten(hero, Dungeon.isChallenged(Challenges.NO_FOOD) ? 100f : 300f, this);
			Buff.affect(hero, WellFed.class).reset(50);

			Statistics.foodEaten++;
			Badges.validateFoodEaten();
		}
	}

	@Override
	public String name() {
		if (skin != null && skin.rarityTier() >= 4) {
			switch (skin) {
				case TRUEGOLDHAMMER:
					return "True Golden Hammer";
				case AMULETHAMMER:
					return "Amulet Hammer";
				case GOOLDENHAMMER:
					return "Goolden Hammer";
				case CAKEHAMMER:
					return "Hammer of Cake";
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
			return  Messages.get(WarHammer.class, "skin");
		}

		@Override
		public Class<?extends Bag> preferredBag(){
			if (InventoryPane.lastBag != null) return InventoryPane.lastBag.getClass();
			return Belongings.Backpack.class;
		}

		@Override
		public boolean itemSelectable(Item item) {
			return Skin.containsIngredient(item, WarHammer.class) && item.isIdentified();
		}

		@Override
		public void onSelect( Item item ) {
			if (item != null && itemSelectable(item)) {
				Skin skin = Skin.fromIngredient(item, WarHammer.class);

				if ((item instanceof Berry && skin != Skin.CREAMHAMMER) || (item instanceof Milk && skin != Skin.CHOCOHAMMER) || (item instanceof CoffeeBean && skin != Skin.CAKEBASEHAMMER)) {
					GLog.w(Messages.get(WarHammer.class, "cake"));
					return;
				}
				if (item instanceof GooBlob && skin == Skin.GOLDHAMMER) {
					skin = Skin.GOOLDENHAMMER;
					Sample.INSTANCE.play(Assets.Sounds.BURNING);
				} else if (item instanceof Berry) {
					item.detach(Dungeon.hero.belongings.backpack);
					Sample.INSTANCE.play(Assets.Sounds.BURNING);
				}

				GLog.p(Messages.get(WarHammer.class, "applyskin"));
				Dungeon.hero.sprite.operate(Dungeon.hero.pos);
				Sample.INSTANCE.play(Assets.Sounds.EQUIP_AXE);
				curItem.applySkin(skin);
			}
		}
	};
}
