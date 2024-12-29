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

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.TokmanniSprite;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

import java.util.HashSet;

public class Tokmanni extends Mob {

	{
		spriteClass = TokmanniSprite.class;
		
		HP = HT = 350;
		defenseSkill = 15;

		maxLvl = 31;
		EXP = 25;

		properties.add(Property.BOSS);
	}

	@Override
	protected boolean act() {
		return super.act();
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 9, 19 );
	}
	
	@Override
	public int attackSkill( Char target ) {
		return 18;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 5);
	}


	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
	}

	@Override
	public void die(Object cause) {
		HashSet<Mob> buckets = new HashSet<>();
		for (Mob mob : Dungeon.level.mobs) {
			if (mob instanceof Bucket) {
				buckets.add(mob);
			}
		}
		for (Mob bucket : buckets) {
			bucket.die(Dungeon.hero);
		}
		super.die(cause);
	}
}
