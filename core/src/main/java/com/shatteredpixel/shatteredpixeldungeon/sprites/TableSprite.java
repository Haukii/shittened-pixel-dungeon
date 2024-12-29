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

public class TableSprite extends MobSprite {

	public TableSprite() {
		super();
		
		texture( Assets.Sprites.FURNITURE );
		
		TextureFilm frames = new TextureFilm( texture, 16, 16 );
		
		idle = new Animation( 2, true );
		idle.frames( frames, 32, 32, 32, 32, 39);
		
		run = new Animation( 12, false );
		run.frames( frames, 39, 40, 41, 42, 43, 44, 43);
		
		attack = new Animation( 12, false );
		attack.frames( frames, 33, 34, 35, 36, 37, 38 );
		
		die = new Animation( 12, false );
		die.frames( frames, 45, 46, 47 );
		
		play( idle );
	}
}
