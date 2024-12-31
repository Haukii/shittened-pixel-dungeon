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
import com.shatteredpixel.shatteredpixeldungeon.items.Recipe;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class StewedSmallMeat extends Food {
	
	{
		image = ItemSpriteSheet.STEWEDSMALL;
		energy = Hunger.HUNGRY/4.5f;
		carbs = 0f;
		fats = 4f;
		proteins = 7f;
		salt = 0f;
	}
	
	@Override
	public int value() {
		return 3 * quantity;
	}
	
	public static class oneMeat extends Recipe.SimpleRecipe{
		{
			inputs =  new Class[]{SmallMeat.class};
			inQuantity = new int[]{1};
			
			cost = 0;
			
			output = StewedSmallMeat.class;
			outQuantity = 1;
		}
	}
	
	public static class twoMeat extends Recipe.SimpleRecipe{
		{
			inputs =  new Class[]{SmallMeat.class};
			inQuantity = new int[]{2};
			
			cost = 1;
			
			output = StewedSmallMeat.class;
			outQuantity = 2;
		}
	}
	
	//red meat
	//blue meat
	
	public static class threeMeat extends Recipe.SimpleRecipe{
		{
			inputs =  new Class[]{SmallMeat.class};
			inQuantity = new int[]{3};
			
			cost = 1;
			
			output = StewedSmallMeat.class;
			outQuantity = 3;
		}
	}

}