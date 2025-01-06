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

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Rat;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.DeviceCompat;
import com.watabou.utils.PathFinder;

import java.util.Calendar;

public class CheeseSlice extends TastyFood {

	{
		image = ItemSpriteSheet.CHEESE_SLICE;
		energy = 20f;
		carbs = 0f;
		fats = 5f;
		proteins = 1f;
		salt = 0f;
	}

	@Override
	public void execute(Hero hero, String action) {
		Calendar calendar = Calendar.getInstance();
		if (action.equals( AC_EAT ) && calendar.get(Calendar.HOUR_OF_DAY) == 3) {
			GLog.n(Messages.get(CheeseSlice.class, "3am"));
			for (int i : PathFinder.NEIGHBOURS8) {
				if (!Dungeon.level.solid[i+hero.pos] && Dungeon.level.findMob(i+hero.pos) == null){
					Rat rat = new Rat();
					rat.pos = i + hero.pos;
					GameScene.add(rat);
				}
			}

		}
		//if (DeviceCompat.isDebug())
			//Dungeon.level.drop(new ScrollOfDebug(), hero.pos);
		super.execute(hero, action);
	}

	@Override
	public int value() {
		return 2 * quantity;
	}

	public static class Recipe extends com.shatteredpixel.shatteredpixeldungeon.items.Recipe.SimpleRecipe {

		{
			inputs =  new Class[]{Cheese.class};
			inQuantity = new int[]{1};

			cost = 3;

			output = CheeseSlice.class;
			outQuantity = 6;
		}
	}
}
