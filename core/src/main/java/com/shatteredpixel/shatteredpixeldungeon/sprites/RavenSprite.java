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

public class RavenSprite extends MobSprite {

	public Animation die_fly;
	public Animation ascend;
	public Animation descend;

	public RavenSprite() {
		super();
		
		texture( Assets.Sprites.RAVEN );
		
		TextureFilm frames = new TextureFilm( texture, 11, 13 );
		
		idle = new Animation( 2, true );
		idle.frames( frames, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1 );

		ascend = new Animation( 10, true );
		ascend.frames( frames, 6, 7, 8, 9, 10 );

		descend = new Animation( 10, true );
		descend.frames( frames, 10, 9, 8, 7, 6 );

		run = new Animation( 10, true );
		run.frames( frames, 11, 12, 13, 14, 15 );
		
		attack = new Animation( 15, false );
		attack.frames( frames, 2, 3, 4, 5, 0 );
		
		die_fly = new Animation( 10, false );
		die_fly.frames( frames, 16, 17, 18, 19, 20 );

		die = new Animation( 10, false );
		die.frames( frames, 21, 22, 23, 24, 25, 26, 27);
		
		play( idle );
	}

	public void ascend(){
		play( ascend );
	}

	public void descend(){
		play( descend );
	}
}
