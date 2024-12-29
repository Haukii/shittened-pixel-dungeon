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

import com.shatteredpixel.shatteredpixeldungeon.items.misc.RatItem;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class DeepfriedRat extends Food {

	{
		image = ItemSpriteSheet.FRIED_RAT;
		energy = 190f;
		carbs = 12f;
		fats = 20f;
		proteins = 26f;
		salt = 2.5f;
	}

	@Override
	public int value() {
		return 40 * quantity;
	}

	public static class Recipe extends com.shatteredpixel.shatteredpixeldungeon.items.Recipe.SimpleRecipe {

		{
			inputs =  new Class[]{RatItem.class, Oil.class};
			inQuantity = new int[]{1,1};

			cost = 1;

			output = DeepfriedRat.class;
			outQuantity = 1;
		}
	}
}
