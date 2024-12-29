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
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Blindness;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.sprites.TableSprite;
import com.watabou.utils.Random;

public class Table extends Furniture {

	{
		spriteClass = TableSprite.class;
		
		HP = HT = 25;
		defenseSkill = 3;
	}

	@Override
	protected boolean act() {
		return super.act();
	}

	@Override
	public int attackProc(Char enemy, int damage) {
		if (enemy.buff(Blindness.class) == null && Random.Int(4) == 0) {
			Buff.affect(enemy, Blindness.class, 5f);
		}
		return super.attackProc(enemy, damage);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 4, 9 );
	}
	
	@Override
	public int attackSkill( Char target ) {
		return 12;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 3);
	}
}
