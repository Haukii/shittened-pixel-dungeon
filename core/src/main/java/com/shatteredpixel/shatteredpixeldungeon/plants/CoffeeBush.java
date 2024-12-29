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

package com.shatteredpixel.shatteredpixeldungeon.plants;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.CaffeineRush;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.HeroSubClass;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Coffee;
import com.shatteredpixel.shatteredpixeldungeon.items.food.CoffeeBean;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class CoffeeBush extends FoodPlant {
	
	{
		image = 15;
		seedClass = Seed.class;
	}
	
	@Override
	public void activate( Char ch ) {
		super.activate(ch);
		for (int i = 0; i < 5; i++){
			int ofs;
			do {
				ofs = PathFinder.NEIGHBOURS9[Random.Int(9)];
			} while (!Dungeon.level.passable[pos + ofs]);
			if (ch instanceof Hero && ((Hero) ch).subClass == HeroSubClass.WARDEN && Random.Float() > 0.8f) {
				Dungeon.level.drop( new Coffee(), pos + ofs ).sprite.drop( pos );
			} else {
				Dungeon.level.drop( new CoffeeBean(), pos + ofs ).sprite.drop( pos );
			}
		}
		if (ch instanceof Hero && ((Hero) ch).subClass == HeroSubClass.WARDEN) {
			Buff.affect(ch, CaffeineRush.class, 50f);
		}
	}
	
	public static class Seed extends Plant.Seed {
		{
			image = ItemSpriteSheet.SEED_COFFEE;

			plantClass = CoffeeBush.class;

			bones = true;
		}
	}
}
