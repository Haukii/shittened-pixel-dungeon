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
import com.watabou.utils.Random;

public class GlitchRatSprite extends MobSprite {

	public GlitchRatSprite() {
		super();
		
		texture( Assets.Sprites.RAT );
		
		TextureFilm frames = new TextureFilm( texture, 16, 15 );

		idle = new Animation( 2, true );
		idle.frames( frames, 112, 112, 112, 113 );

		run = new Animation( 10, true );
		run.frames( frames, 118, Random.Int(112, 127), 120, 121, Random.Int(112, 127) );

		attack = new Animation( 30, false );
		attack.frames( frames, 114, 115, Random.Int(112, 127), Random.Int(112, 127), 112, Random.Int(112, 127), 121, 122, Random.Int(112, 127), 113 );

		die = new Animation( 10, false );
		die.frames( frames, Random.Int(0, 95), Random.Int(0, 95), Random.Int(0, 95), Random.Int(0, 95), Random.Int(0, 95), Random.Int(0, 95), 126 );
		
		play( idle );
	}
}
