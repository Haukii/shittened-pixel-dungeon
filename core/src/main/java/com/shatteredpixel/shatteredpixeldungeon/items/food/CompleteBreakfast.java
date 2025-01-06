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

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class CompleteBreakfast extends TastyFood {

	{
		image = ItemSpriteSheet.COMPLETE_BREAKFAST;
		energy = 400f;
		carbs = 45f;
		fats = 28f;
		proteins = 19f;
		salt = 1.2f;
	}

	@Override
	public int value() {
		return 115 * quantity;
	}

	public static class Recipe extends com.shatteredpixel.shatteredpixeldungeon.items.Recipe.SimpleRecipe {

		{
			inputs =  new Class[]{FriedEgg.class, Hashbrowns.class, Pancakes.class};
			inQuantity = new int[]{1, 1, 1};

			cost = 3;

			output = CompleteBreakfast.class;
			outQuantity = 1;
		}
	}
}
