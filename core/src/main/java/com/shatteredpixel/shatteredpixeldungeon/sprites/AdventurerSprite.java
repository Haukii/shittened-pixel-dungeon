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

public abstract class AdventurerSprite extends MobSprite {

	protected abstract int texOffset();

	public AdventurerSprite() {
		super();

		int c = texOffset();

		texture( Assets.Sprites.ADVENTURER );
		
		TextureFilm frames = new TextureFilm( texture, 12, 15 );
		
		idle = new Animation( 2, true );
		idle.frames( frames, c+0, c+0, c+0, c+0, c+1 );
		
		run = new Animation( 10, true );
		run.frames( frames, c+2, c+3, c+4, c+5, c+6, c+7 );

		die = new Animation( 10, false );
		die.frames( frames, c+8, c+9, c+10, c+11, c+12 );

		attack = new Animation( 15, false );
		attack.frames( frames, c+13, c+14, c+15);

		play( idle );
	}

	public static class Blond extends AdventurerSprite {
		@Override
		protected int texOffset() {
			return 0;
		}
	}

	public static class Red extends AdventurerSprite {
		@Override
		protected int texOffset() {
			return 16;
		}
	}

	public static class Black extends AdventurerSprite {
		@Override
		protected int texOffset() {
			return 32;
		}
	}

	public static class Wheat extends AdventurerSprite {
		@Override
		protected int texOffset() {
			return 48;
		}
	}

	public static class Brown extends AdventurerSprite {
		@Override
		protected int texOffset() {
			return 64;
		}
	}

	public static class Dark extends AdventurerSprite {
		@Override
		protected int texOffset() {
			return 80;
		}
	}

	public static class Grey extends AdventurerSprite {
		@Override
		protected int texOffset() {
			return 96;
		}
	}
}
