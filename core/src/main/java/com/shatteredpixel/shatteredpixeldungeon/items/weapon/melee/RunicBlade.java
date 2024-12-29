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
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.FlavourBuff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Invisibility;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Belongings;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.Waterskin;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.SandalsOfNature;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.Bag;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.ui.AttackIndicator;
import com.shatteredpixel.shatteredpixeldungeon.ui.InventoryPane;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndBag;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Callback;

import java.util.ArrayList;
import java.util.Locale;

public class RunicBlade extends MeleeWeapon {

	public static final String AC_PAINT = "PAINT";

	{
		image = ItemSpriteSheet.RUNIC_BLADE;
		hitSound = Assets.Sounds.HIT_SLASH;
		hitSoundPitch = 1f;

		tier = 4;
		type = Type.SWORD;
		skinnable = true;
		skin = Skin.RUNIC;

	}

	//Essentially it's a tier 4 weapon, with tier 3 base max damage, and tier 5 scaling.
	//equal to tier 4 in damage at +5

	@Override
	public int max(int lvl) {
		return  5*(tier) +                	//20 base, down from 25
				Math.round(lvl*(tier+2));	//+6 per level, up from +5
	}

	@Override
	public String targetingPrompt() {
		return Messages.get(this, "prompt");
	}

	@Override
	protected void duelistAbility(Hero hero, Integer target) {
		if (target == null) {
			return;
		}

		Char enemy = Actor.findChar(target);
		if (enemy == null || enemy == hero || hero.isCharmedBy(enemy) || !Dungeon.level.heroFOV[target]) {
			GLog.w(Messages.get(this, "ability_no_target"));
			return;
		}

		//we apply here because of projecting
		RunicSlashTracker tracker = Buff.affect(hero, RunicSlashTracker.class);
		tracker.boost = 3f + 0.50f*buffedLvl();
		hero.belongings.abilityWeapon = this;
		if (!hero.canAttack(enemy)){
			GLog.w(Messages.get(this, "ability_target_range"));
			tracker.detach();
			hero.belongings.abilityWeapon = null;
			return;
		}
		hero.belongings.abilityWeapon = null;

		hero.sprite.attack(enemy.pos, new Callback() {
			@Override
			public void call() {
				beforeAbilityUsed(hero, enemy);
				AttackIndicator.target(enemy);
				if (hero.attack(enemy, 1f, 0, Char.INFINITE_ACCURACY)){
					Sample.INSTANCE.play(Assets.Sounds.HIT_STRONG);
					if (!enemy.isAlive()){
						onAbilityKill(hero, enemy);
					}
				}
				tracker.detach();
				Invisibility.dispel();
				hero.spendAndNext(hero.attackDelay());
				afterAbilityUsed(hero);
			}
		});
	}

	@Override
	public String abilityInfo() {
		if (levelKnown){
			return Messages.get(this, "ability_desc", 300+50*buffedLvl());
		} else {
			return Messages.get(this, "typical_ability_desc", 300);
		}
	}

	@Override
	public String upgradeAbilityStat(int level) {
		return "+" + (300+50*level) + "%";
	}


	public static class RunicSlashTracker extends FlavourBuff{

		public float boost = 2f;

	};

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
				case TRUEGOLDRUNIC:
					return "Golden Blade";
				case AMULETRUNIC:
					return "The Amulet Blade";
				case NATURERUNIC:
					return "The Blade of Nature";
				case WATERRUNIC:
					return "Blade of Water";
				case EARTHRUNIC:
					return "Blade of Earth";
				case FIRERUNIC:
					return "Blade of Fire";
				case WINDRUNIC:
					return "Blade of Air";
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
			return  Messages.get(RunicBlade.class, "skin");
		}

		@Override
		public Class<?extends Bag> preferredBag(){
			if (InventoryPane.lastBag != null) return InventoryPane.lastBag.getClass();
			return Belongings.Backpack.class;
		}

		@Override
		public boolean itemSelectable(Item item) {
			return Skin.containsIngredient(item, RunicBlade.class) && item.isIdentified();
		}

		@Override
		public void onSelect( Item item ) {
			if (item != null && itemSelectable(item)) {
				Skin skin = Skin.fromIngredient(item, RunicBlade.class);

				if (item instanceof Waterskin && ((Waterskin) item).volume < 20) {
					GLog.w(Messages.get(RunicBlade.class, "nowater"));
					return;
				} else if (item instanceof SandalsOfNature && item.level() != 10) {
					GLog.w(Messages.get(RunicBlade.class, "sandals", item.name().toLowerCase(Locale.ROOT)));
					return;
				}

				GLog.p(Messages.get(RunicBlade.class, "applyskin"));
				Dungeon.hero.sprite.operate(Dungeon.hero.pos);
				Sample.INSTANCE.play(Assets.Sounds.EQUIP_SWORD);
				curItem.changeSkin(skin);
			}
		}
	};

}
