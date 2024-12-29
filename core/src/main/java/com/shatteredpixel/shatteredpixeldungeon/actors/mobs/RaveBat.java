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
import com.shatteredpixel.shatteredpixeldungeon.items.bags.FoodCrate;
import com.shatteredpixel.shatteredpixeldungeon.sprites.RaveBatSprite;

public class RaveBat extends Bat {

	{
		spriteClass = RaveBatSprite.class;
		
		HP = HT = 25;
		
		EXP = 6;
	}

	@Override
	public void die(Object cause) {
		if (Dungeon.LimitedDrops.FOODCRATE.count == 0) {
			Dungeon.level.drop(new FoodCrate(), pos).sprite.drop();
			Dungeon.LimitedDrops.FOODCRATE.count++;
		}
		super.die(cause);
	}
}
