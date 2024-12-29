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

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.food.MysteryMeat;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CrabSprite;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Crab extends Mob {

	{
		spriteClass = CrabSprite.class;
		
		HP = HT = 15;
		defenseSkill = 5;
		baseSpeed = 2f;
		
		EXP = 4;
		maxLvl = 9;
		
		loot = new MysteryMeat();
		lootChance = 0.167f;
	}
	
	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 1, 7 );
	}
	
	@Override
	public int attackSkill( Char target ) {
		return 12;
	}
	
	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 4);
	}

	@Override
	public int attackProc(Char enemy, int damage) {
		if (fieldOfView != null && fieldOfView[Dungeon.hero.pos])
			Sample.INSTANCE.play( Assets.Sounds.CRAB_RAVE, 0.6f);
		return super.attackProc(enemy, damage);
	}

	@Override
	public void move(int step, boolean travelling) {
		if (state == this.WANDERING && fieldOfView != null && fieldOfView[Dungeon.hero.pos]) {

			switch (Random.Int(1,12)) {
				case 1:
					Sample.INSTANCE.play( Assets.Sounds.CRAB_01, 0.05f);
					break;
				case 2:
					Sample.INSTANCE.play( Assets.Sounds.CRAB_02, 0.05f);
					break;
				case 3:
					Sample.INSTANCE.play( Assets.Sounds.CRAB_03, 0.05f);
					break;
				case 4:
					Sample.INSTANCE.play( Assets.Sounds.CRAB_04, 0.05f);
					break;
				case 5:
					Sample.INSTANCE.play( Assets.Sounds.CRAB_05, 0.05f);
					break;
				case 6:
					Sample.INSTANCE.play( Assets.Sounds.CRAB_06, 0.05f);
					break;
				default:
					break;
			}
		}
		super.move(step, travelling);
	}

	@Override
	public boolean getCloser( int target ) {

		if (fieldOfView != null && fieldOfView[Dungeon.hero.pos] && target == Dungeon.hero.pos) {
			switch (Random.Int(1,12)) {
				case 1:
					Sample.INSTANCE.play( Assets.Sounds.CRAB_01, 0.3f);
					break;
				case 2:
					Sample.INSTANCE.play( Assets.Sounds.CRAB_02, 0.3f);
					break;
				case 3:
					Sample.INSTANCE.play( Assets.Sounds.CRAB_03, 0.3f);
					break;
				case 4:
					Sample.INSTANCE.play( Assets.Sounds.CRAB_04, 0.3f);
					break;
				case 5:
					Sample.INSTANCE.play( Assets.Sounds.CRAB_05, 0.3f);
					break;
				case 6:
					Sample.INSTANCE.play( Assets.Sounds.CRAB_06, 0.3f);
					break;
				default:
					break;
			}
		}

		return super.getCloser(target);
	}}
