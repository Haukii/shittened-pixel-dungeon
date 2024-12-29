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
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.TickBite;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.HeroSubClass;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Wheat;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.Random;

public class WheatPlant extends FoodPlant {
	
	{
		image = 17;
		seedClass = null;
	}
	
	@Override
	public void activate( Char ch ) {
		if (Random.Float() > 0.5f ) {
			Dungeon.level.drop( new Wheat(), pos ).sprite.drop( pos );
		}

		if (ch instanceof Hero && ((Hero) ch).subClass == HeroSubClass.WARDEN && Random.Float() > 0.5f) {
			Dungeon.level.drop( new Wheat(), pos ).sprite.drop( pos );
		}

		if (ch instanceof Hero && Random.Float() < 0.02f) {
			Buff.affect(Dungeon.hero, TickBite.class);
		}
	}

	public static class Seed extends Plant.Seed {
		{
			image = ItemSpriteSheet.SEED_SWIFTTHISTLE;

			plantClass = WheatPlant.class;

			bones = true;
		}
	}
}
