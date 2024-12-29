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
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Poison;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Piethon;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CobraSprite;
import com.watabou.utils.Random;

public class Cobra extends Snake {
	
	{
		spriteClass = CobraSprite.class;
		
		HP = HT = 6;
		
		EXP = 3;
		maxLvl = 8;


		loot = new Piethon();
		lootChance = 0.25f;
	}

	@Override
	public int attackProc(Char enemy, int damage) {

		if (Random.Int(2) == 0) {
			int duration = Random.IntRange(Dungeon.depth / 2, Dungeon.depth);
			Buff.affect(enemy, Poison.class).set(duration);
		}

		return super.attackProc(enemy, damage);
	}
}
