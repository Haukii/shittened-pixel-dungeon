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
import com.watabou.noosa.Game;
import com.watabou.noosa.TextureFilm;

public class RGBCrabSprite extends MobSprite {

	public RGBCrabSprite() {
		super();

		texture( Assets.Sprites.CRAB );

		TextureFilm frames = new TextureFilm( texture, 16, 16 );

		idle = new Animation( 5, true );
		idle.frames( frames, 48, 49, 48, 50 );

		run = new Animation( 10, true );
		run.frames( frames, 51, 52, 53, 54 );

		attack = new Animation( 12, false );
		attack.frames( frames, 55, 56, 57 );

		die = new Animation( 12, false );
		die.frames( frames, 58, 59, 60, 61 );

		play( idle );
	}

	@Override
	public int blood() {
		return 0xFFFFEA80;
	}

	@Override
	public void update() {
		float interval = (Game.timeTotal % 9 ) / 3f;
		tint(interval > 2 ? interval - 2 : Math.max(0, 1 - interval),
				interval > 1 ? Math.max(0, 2-interval): interval,
				interval > 2 ? Math.max(0, 3-interval): interval-1, 0.5f);
		super.update();
	}
}
