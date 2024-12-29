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
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Chill;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.levels.CavesLevel;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.TitleScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.shatteredpixel.shatteredpixeldungeon.utils.Holiday;

public class IceCream extends Food {

	{
		image = ItemSpriteSheet.ICE_CREAM;
		energy = 105f;
		carbs = 30f;
		fats = 7f;
		proteins = 3f;
		salt = 0.1f;
	}

	@Override
	protected void satisfy(Hero hero) {
		super.satisfy(hero);
		if (Holiday.getCurrentHoliday() == Holiday.WINTER_HOLIDAYS && Dungeon.level instanceof CavesLevel) {
			Buff.affect(hero, Chill.class, 8f);
			GLog.w(Messages.get(IceCream.class, "chill"));
		}
	}

	@Override
	public int value() {
		return 20 * quantity;
	}

	public static class Recipe extends com.shatteredpixel.shatteredpixeldungeon.items.Recipe.SimpleRecipe {

		{
			inputs =  new Class[]{Milk.class, Sugar.class};
			inQuantity = new int[]{1,1};

			cost = 1;

			output = IceCream.class;
			outQuantity = 1;
		}
	}
}
