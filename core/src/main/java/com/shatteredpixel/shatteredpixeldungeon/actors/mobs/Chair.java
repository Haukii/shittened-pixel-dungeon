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

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Bleeding;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ChairSprite;
import com.watabou.utils.Random;

public class Chair extends Furniture {

	{
		spriteClass = ChairSprite.class;
		
		HP = HT = 15;
		defenseSkill = 4;

		baseSpeed = 2f;
	}

	@Override
	protected boolean act() {
		return super.act();
	}

	@Override
	public int attackProc(Char enemy, int damage) {
		if (enemy.buff(Bleeding.class) == null && Random.Int(4) == 0) {
			Buff.affect(enemy, Bleeding.class).set(damage / 2f + 2);
		}
		return super.attackProc(enemy, damage);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 2, 6 );
	}
	
	@Override
	public int attackSkill( Char target ) {
		return 9;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 3);
	}
}
