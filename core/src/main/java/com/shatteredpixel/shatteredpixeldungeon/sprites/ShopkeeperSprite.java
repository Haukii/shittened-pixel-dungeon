/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2024 Evan Debenham
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
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.watabou.noosa.TextureFilm;
import com.watabou.noosa.particles.PixelParticle;
import com.watabou.utils.Random;

public class ShopkeeperSprite extends MobSprite {
	
	private PixelParticle coin;
	
	public ShopkeeperSprite() {
		super();
		
		texture( Assets.Sprites.KEEPER );
		TextureFilm film = new TextureFilm( texture, 14, 14 );

		int off = 0;
		float random = Random.Float();
		idle = new Animation( 10, true );
		if (random < 0.1f) {
			off = 2;
		} else if (random < 0.2f) {
			off = 4;
		}
		if (Dungeon.depth == 11) {
			off = 6;
		}
		idle.frames( film, 1 + off, 1+ off, 1+ off, 1+ off, 1+ off, off, off, off, off );

		die = new Animation( 20, false );
		die.frames( film, 0 );

		run = idle.clone();

		attack = idle.clone();
		
		idle();
	}
	
	@Override
	public void onComplete( Animation anim ) {
		super.onComplete( anim );
		
		if (visible && anim == idle) {
			if (coin == null) {
				coin = new PixelParticle();
				parent.add( coin );
			}
			coin.reset( x + (flipHorizontal ? 0 : 13), y + 7, 0xFFFF00,  1, 4f ); //0xFFFF00
			coin.speed.y = Random.Int(-40, -150);
			if (Random.Int(100) == 0) {
				coin.speed.y = Random.Int(-300, -2000);
			}
			coin.speed.x = Random.Int(-10,10);
			if (Random.Int(30) == 0) {
				coin.speed.x = Random.Int(-50,50);
			}
			coin.acc.y = Random.Int(30, 250);
		}
	}
}
