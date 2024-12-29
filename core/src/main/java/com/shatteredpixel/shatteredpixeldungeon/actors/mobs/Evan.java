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

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Adrenaline;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Dread;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Haste;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Invisibility;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Vulnerable;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Weakness;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.KindOfWeapon;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.Armor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.ClassArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.ClothArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.LeatherArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.Artifact;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Berry;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Blandfruit;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Food;
import com.shatteredpixel.shatteredpixeldungeon.items.food.FrozenCarpaccio;
import com.shatteredpixel.shatteredpixeldungeon.items.food.GoldenMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.MeatPie;
import com.shatteredpixel.shatteredpixeldungeon.items.food.MysteryMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.RatatouilleFood;
import com.shatteredpixel.shatteredpixeldungeon.items.food.SmallMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.GooBlob;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.Ring;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfTransmutation;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.Weapon;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Greatgreatsword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Greatsword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Longsword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.MeleeWeapon;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.PileOfSais;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Sai;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Shortsword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.SmallGreatsword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Sword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.WornShortsword;
import com.shatteredpixel.shatteredpixeldungeon.mechanics.Prefix;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.EvanSprite;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Evan extends Mob {

	{
		spriteClass = EvanSprite.class;
		
		HP = HT = Dungeon.depth * 5 + 10;
		defenseSkill = 6;
	}

	int speech = 0;
	boolean seenHero = false;
	boolean warning = false;

	@Override
	protected boolean act() {

		if (!warning) {
			GLog.w("You can sense a powerful creature with you in this floor...");
			warning = true;
		}
		if (Dungeon.level.heroFOV[pos] && !seenHero && speech > 0 && state == HUNTING) {
			yell(Messages.get(this,"seenagain"));
			seenHero = true;
		} else if (!seenHero && Dungeon.level.heroFOV[pos] && speech == 0 && state == HUNTING) {
			seenHero = true;
		}

		if (Dungeon.level.heroFOV[pos] && Random.Int(3) == 1 && state == HUNTING) {
			switch (speech) {
				case 0:
					yell(Messages.get(this,"hello_" + Random.Int(3)));
					break;
				case 1:
					yell(Messages.get(this,"balance_" + Random.Int(6)));
					break;
				case 2:
				case 3:
				case 4:
					perform();
					break;
				case 5:
					yell(Messages.get(this,"leave_" + Random.Int(3)));
					Buff.affect(this, Dread.class);
					break;
			}
			speech++;
		}
		return super.act();
	}

	private void perform() {
		boolean success = false;

		do {
			int action = Random.Int(0,5);
			switch (action) {
				case 0:
					success = affectWeapon();
					break;
				case 1:
					success = affectArmor();
					break;
				case 2:
					success = affectRing();
					break;
				case 3:
					success = affectArtifact();
					break;
				case 4:
					success = miscAction();
					break;
			}
		} while (!success);
	}

	@Override
	protected boolean canAttack(Char enemy) {
		if (speech > 2) {
			return super.canAttack(enemy);
		}
		return false;
	}

	private static final String SPEECH = "speech";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(SPEECH, speech);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		speech = bundle.getInt(SPEECH);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 0, Dungeon.depth / 2 );
	}
	
	@Override
	public int attackSkill( Char target ) {
		return 8;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 3);
	}

	@Override
	public void die(Object cause) {
		Sample.INSTANCE.play(Assets.Sounds.DEATH_11);
		Buff.prolong(Dungeon.hero, Weakness.class, Random.Float(50f, 400f));
		super.die(cause);
	}

	private boolean affectWeapon() {
		int action = Random.Int(4);

		KindOfWeapon kindOfWeapon = Dungeon.hero.belongings.weapon();
		if (kindOfWeapon == null) {
			yell(Messages.get(this,"noweapon"));
			return false;
		}
		Weapon weapon;
		try {
			weapon = (Weapon) kindOfWeapon;
		} catch (Exception e) {
			yell(Messages.get(this,"weaponerror"));
			return false;
		}

		switch (action) {
			case 0:
				Prefix prefix = Prefix.random();
				weapon.reforge(prefix);
				yell(Messages.get(this,"weapon_" + action, prefix.name()));
				return true;
			case 1:
				weapon.doDrop(Dungeon.hero);
				yell(Messages.get(this,"weapon_" + action));
				return true;
			case 2:
				Dungeon.hero.belongings.weapon = transformWeapon(weapon);
				yell(Messages.get(this,"weapon_" + action));
				return true;
			case 3:
				weapon.upgrade(Random.Int(1,4));
				yell(Messages.get(this,"weapon_" + action));
				return true;
		}
		return false;
	}

	private boolean affectArmor() {
		Armor armor = Dungeon.hero.belongings.armor();

		if (armor == null) {
			yell(Messages.get(this,"noarmor"));
			Armor newArmor;
			if (Dungeon.depth > 15){
				newArmor = new LeatherArmor();
			} else {
				newArmor = new ClothArmor();
			}
			newArmor.upgrade(Random.Int(Dungeon.depth));
			newArmor.collect();
			try {
				newArmor.doEquip(Dungeon.hero);
				return true;
			} catch (Exception ignored){
				Dungeon.level.drop(newArmor, Dungeon.hero.pos);
				return true;
			}
		}

		int action = Random.Int(3);
		switch (action) {
			case 0:
				Armor.Glyph glyph = Armor.Glyph.random();
				armor.inscribe(glyph);
				yell(Messages.get(this,"armor_" + action, glyph.name()));
				return true;
			case 1:
				if (Random.Float() > 0.5f) {
					yell(Messages.get(this,"armor_" + action + "_upgrade"));
					armor.upgrade(Random.Int(1,3));
					Sample.INSTANCE.play(Assets.Sounds.CHARGEUP);
				} else {
					yell(Messages.get(this,"armor_" + action + "_downgrade"));
					armor.degrade(Random.Int(1,3));
					Sample.INSTANCE.play(Assets.Sounds.DEGRADE);
				}
				return true;
			case 2:
				if (armor instanceof ClassArmor) {
					((ClassArmor) armor).charge += Random.Float(-200f, 200f);
					yell(Messages.get(this,"classarmor"));
					return true;
				}
				if (armor.level() > 0) {
					Buff.affect(Dungeon.hero, Vulnerable.class, 150f);
					yell(Messages.get(this,"armor_" + action + "_vulnerable"));
				} else {
					armor.degrade(armor.level() + 3);
					yell(Messages.get(this,"armor_" + action + "_downgrade"));
					Sample.INSTANCE.play(Assets.Sounds.DEGRADE);
				}
				return true;
		}
		return false;
	}

	private boolean affectRing() {
		Ring ring = Dungeon.hero.belongings.ring();
		int slot = 0;

		//If ring slot doesn't have ring, we check misc slot for ring
		if (ring == null) {
			if (Dungeon.hero.belongings.misc instanceof Ring) {
				ring = (Ring) Dungeon.hero.belongings.misc;
				slot = 1;
			} else {
				return false;
			}
		} else if (Dungeon.hero.belongings.misc instanceof Ring && Random.Float() > 0.5f) {
			//If both slots have a ring, we pick one of them randomly
			ring = (Ring) Dungeon.hero.belongings.misc;
			slot = 1;
		}

		int action = Random.Int(3);
		switch (action) {
			case 0:
				ring.upgrade();
				Sample.INSTANCE.play(Assets.Sounds.CHARGEUP);
				yell(Messages.get(this,"ring_" + action));
				return true;
			case 1:
				ring = (Ring) ScrollOfTransmutation.changeItem(ring);
				ring.anonymize();
				Dungeon.hero.belongings.ring = ring;
				Sample.INSTANCE.play(Assets.Sounds.READ);
				yell(Messages.get(this,"ring_" + action));
				return true;
			case 2:
				if (slot == 0)
					Dungeon.hero.belongings.ring = null;
				else
					Dungeon.hero.belongings.misc = null;
				yell(Messages.get(this,"ring_" + action));
				return true;
		}
        return false;
    }

	private boolean affectArtifact() {
		Artifact artifact = Dungeon.hero.belongings.artifact();
		int slot = 0;
		if (artifact == null) {
			if (Dungeon.hero.belongings.misc instanceof Artifact) {
				artifact = (Artifact) Dungeon.hero.belongings.misc;
				slot = 1;
			} else {
				return false;
			}
		} else if (Dungeon.hero.belongings.misc instanceof Artifact && Random.Float() > 0.5f) {
			//If both slots have artifact, we pick one of them randomly
			artifact = (Artifact) Dungeon.hero.belongings.misc;
			slot = 1;
		}

		if (Random.Float() > 0.5f) {
			artifact.image = Random.Int(5,500);
			yell(Messages.get(this,"artifact_0"));
			return true;
		} else if (!artifact.cursed) {
			artifact.cursed = true;
			artifact.cursedKnown = true;
			yell(Messages.get(this,"artifact_1"));
			return true;
		} else {
			Dungeon.level.drop(artifact, Dungeon.hero.pos);
			if (slot == 0)
				Dungeon.hero.belongings.artifact = null;
			else
				Dungeon.hero.belongings.misc = null;
			ScrollOfTeleportation.teleportChar(Dungeon.hero);
			yell(Messages.get(this,"artifact_2"));
			return true;
		}
	}

	private boolean miscAction() {
		int action = Random.Int(4);
		switch (action) {
			case 0:
				Dungeon.hero.HT = Dungeon.hero.HT - Random.Int(5, Dungeon.hero.HP / 2);
				yell(Messages.get(this,"random_" + action));
				return true;
			case 1:
				for (int i = 0; i < 3; i++) {
					Item food = Generator.random(Generator.Category.FOOD_NEW);
					int ofs;
					do {
						ofs = PathFinder.NEIGHBOURS8[Random.Int(8)];
					} while (!Dungeon.level.passable[pos + ofs]);
					Dungeon.level.drop( food, pos + ofs ).sprite.drop( pos );
				}
				yell(Messages.get(this,"random_" + action));
				break;
			case 2:
				Mob mob = Random.oneOf(new CaveBat(), new Evan(), new DM105(), new DM100(), new Golem(), new Goldfish(),
						new Mimic(), new Crab(), new ArmoredStatue(), new Bee(), new Bandit(), new CapybaraPile(),
						new DM16(), new Skeleton(), new Slime(), new Thief(), new EvolvedSwarm(), new Minibara(), new Bucket(), new Mimic(), new Stool());
				mob.pos = Dungeon.hero.pos;
				GameScene.add(mob);
				yell(Messages.get(this,"random_" + action));
				break;
			case 3:
				Buff.prolong(Dungeon.hero, Haste.class, 50f);
				Buff.prolong(Dungeon.hero, Adrenaline.class, 50f);
				Buff.prolong(Dungeon.hero, Invisibility.class, 50f);
				yell(Messages.get(this,"random_" + action));
				break;
		}
        return false;
    }

	private Weapon transformWeapon(Weapon input) {
		int lvl = input.level();
		Weapon.Enchantment enchantment = input.enchantment;
		Weapon.Augment augment = input.augment;
		Prefix prefix = input.prefix;

		Weapon output;

		if (input.getClass() == WornShortsword.class) {
			output = new Shortsword();
		} else if (input.getClass() == Shortsword.class) {
			output = new Sword();
		} else if (input.getClass() == Sword.class) {
			output = new Longsword();
		} else if (input.getClass() == Longsword.class) {
			output = new Greatsword();
		} else if (input.getClass() == Greatsword.class) {
			output = new Greatgreatsword();
		} else if (input.getClass() == Greatgreatsword.class) {
			output = new SmallGreatsword();
		} else if (input.getClass() == SmallGreatsword.class) {
			output = new Greatgreatsword();
		} else if (input.getClass() == Sai.class) {
			output = new PileOfSais();
		} else {
			if (input instanceof MeleeWeapon) {
				//Transform to another weapon of the same tier.
				try {
					output = (MeleeWeapon) ScrollOfTransmutation.changeItem(input);
				} catch (Exception ignored) {
					output = (MeleeWeapon) Generator.random(Generator.wepTiers[((MeleeWeapon) input).tier]);
				}

			} else {
				output = input;
				output.reforge(Prefix.random());
				output.upgrade();
				output.enchant(Weapon.Enchantment.random());
				return output;
			}
		}
		output.enchant(enchantment);
		output.level(lvl);
		output.augment = augment;
		output.reforge(prefix);

		return output;
	}
}
