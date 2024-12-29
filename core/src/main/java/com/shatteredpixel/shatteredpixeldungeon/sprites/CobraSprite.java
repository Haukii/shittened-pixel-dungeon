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

package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.watabou.noosa.TextureFilm;

public class CobraSprite extends MobSprite {

	public CobraSprite() {
		super();
		
		texture( Assets.Sprites.SNAKE );
		
		TextureFilm frames = new TextureFilm( texture, 12, 11 );
		
		//many frames here as we want the rising/falling to be slow but the tongue to be fast
		idle = new Animation( 10, true );
		idle.frames( frames, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21,
				22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 24, 23, 22, 22);
		
		run = new Animation( 8, true );
		run.frames( frames, 25, 26, 27, 28 );
		
		attack = new Animation( 15, false );
		attack.frames( frames, 29, 30, 31, 29, 21);
		
		die = new Animation( 10, false );
		die.frames( frames, 32, 33, 34 );
		
		play(idle);
	}
	
}
