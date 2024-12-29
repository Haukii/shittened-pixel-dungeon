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

package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class ChargrilledSmallMeat extends Food {
	
	{
		image = ItemSpriteSheet.SMALLSTEAK;
		energy = Hunger.HUNGRY/4f;
		carbs = 1f;
		fats = 7f;
		proteins = 11f;
		salt = 1.1f;
	}
	
	@Override
	public int value() {
		return 3 * quantity;
	}


	public static Food cook( int quantity ) {
		ChargrilledSmallMeat result = new ChargrilledSmallMeat();
		result.quantity = quantity;
		return result;
	}

}
