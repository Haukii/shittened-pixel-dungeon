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
import com.watabou.noosa.TextureFilm;
import com.watabou.noosa.particles.PixelParticle;
import com.watabou.utils.Random;

public class BruteSprite extends MobSprite {

	private PixelParticle[] confetti = new PixelParticle[] {null,null,null,null,null};
	
	public BruteSprite() {
		super();
		
		texture( Assets.Sprites.BRUTE );
		
		TextureFilm frames = new TextureFilm( texture, 12, 16 );
		
		idle = new Animation( 2, true );
		idle.frames( frames,
				0, 11, 12,13,14,0,12,14,0,13,11,12,13,14,11,13,0,14,
				1, 15,16,1,17,15,
				12,13,11,0,12,14,0,11,14,12,13,11,
				1, 15,16,1,17,15,
				1,17,16,1,15,16);
		
		run = new Animation( 12, true );
		run.frames( frames, 4, 5, 6, 7 );
		
		attack = new Animation( 12, false );
		attack.frames( frames, 2, 3, 0 );
		
		die = new Animation( 12, false );
		die.frames( frames, 8, 9, 10 );
		
		play( idle );
	}
	@Override
	public void onComplete(Animation anim) {
		super.onComplete(anim);
		if (visible) {
			if (confetti[0] == null) {
				for (int i = 0; i < confetti.length; i++) {
					confetti[i] = new PixelParticle();
					parent.add(confetti[i]);
				}
			}
			for (PixelParticle particle : confetti) {

				particle.reset(x + (flipHorizontal ? 0 : 13), y + 3, Random.Int(0x777777, 0xFFFFFF), Random.Float(0.5f, 2f), Random.Float(3f, 8f)); //0xFFFF00
				particle.speed.y = Random.Int(-40, -150);
				if (Random.Int(100) == 0) {
					particle.speed.y = Random.Int(-300, -2000);
				}
				particle.speed.x = Random.Int(-10, 10);
				if (Random.Int(30) == 0) {
					particle.speed.x = Random.Int(-50, 50);
				}
				particle.acc.y = Random.Int(30, 250);
			}
		}
	}
}
