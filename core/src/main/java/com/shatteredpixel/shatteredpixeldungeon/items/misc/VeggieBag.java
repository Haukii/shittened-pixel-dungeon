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

package com.shatteredpixel.shatteredpixeldungeon.items.misc;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.food.CoffeeBean;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Potato;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Tomato;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Wheat;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class VeggieBag extends Item {

	{
		image = ItemSpriteSheet.SMALLBAG;

		defaultAction = AC_OPEN;
		stackable = true;
	}

	@Override
	public boolean isIdentified() {
		return true;
	}

	public static final String AC_OPEN = "OPEN";

	public void execute(Hero hero, String action) {

		super.execute(hero, action);

		if (action.equals(AC_OPEN)) {
			detach(hero.belongings.backpack);
			int amount = Random.Int(2,5); // 2-4 items
//			int amount = 15;
			for (int i = 0; i < amount; i++) {
				Dungeon.level.drop( Random.oneOf(
						new CoffeeBean(),
						new Wheat(),
						new Tomato(),
						new Potato()
				), Dungeon.hero.pos ).sprite.drop();
//				Dungeon.level.drop(Generator.randomNewFood(), Dungeon.hero.pos ).sprite.drop();
			}
		}
	}


	@Override
	public ArrayList<String> actions(Hero hero) {
		ArrayList<String> actions = super.actions(hero);
		actions.add(AC_OPEN);
		return actions;
	}

	@Override
	public int value() {
		return 20;
	}
}
