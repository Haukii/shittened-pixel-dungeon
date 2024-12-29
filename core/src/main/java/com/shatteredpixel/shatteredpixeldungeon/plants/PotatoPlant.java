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
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Oiled;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.HeroSubClass;
import com.shatteredpixel.shatteredpixeldungeon.effects.Splash;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Potato;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.PathFinder;

public class PotatoPlant extends FoodPlant {
	
	{
		image = 18;
		seedClass = Seed.class;
	}
	
	@Override
	public void activate( Char ch ) {
		Dungeon.level.drop( new Potato(), pos ).sprite.drop( pos );
		if (ch instanceof Hero && ((Hero) ch).subClass == HeroSubClass.WARDEN ) {
			for( int i : PathFinder.NEIGHBOURS9) {
				if (!Dungeon.level.solid[ch.pos + i]) {
					Splash.at( ch.pos + i, 0x483026, 3);
					Char target = Actor.findChar( ch.pos + i );
					if (target != null && !target.flying && !(target instanceof Hero)){
						Buff.affect(target, Oiled.class).set( Oiled.DURATION );
					}
				}
			}
		} else {
			Buff.affect(ch, Oiled.class, Oiled.DURATION / 2f);
			Splash.at( ch.pos, 0x483026, 3);
		}
		super.activate(ch);
	}
	
	public static class Seed extends Plant.Seed {
		{
			image = ItemSpriteSheet.SEED_POTATO;

			plantClass = PotatoPlant.class;

			bones = true;
		}
	}
}
