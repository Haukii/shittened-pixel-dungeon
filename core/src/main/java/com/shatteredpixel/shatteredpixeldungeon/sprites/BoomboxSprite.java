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
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.BlastParticle;
import com.watabou.noosa.TextureFilm;
import com.watabou.noosa.audio.Sample;

public class BoomboxSprite extends MobSprite {

	private Animation death;

	public BoomboxSprite() {
		super();

		renderShadow = false;

		texture( Assets.Sprites.BOOMBOX );

		TextureFilm frames = new TextureFilm( texture, 11, 13 );

		idle = new Animation( 2, true );
		idle.frames( frames, 0, 1 );

		death = new Animation( 3, true );
		death.frames( frames, 2, 3 );

		run = idle.clone();

		attack = idle.clone();

		die = new Animation( 3, true );
		die.frames( frames, 2, 3 );

		play( idle );
	}

//	@Override
//	public void link(Char ch) {
//		super.link(ch);
//		if (ch instanceof Pylon && ch.alignment == Char.Alignment.ENEMY){
//			activate();
//		}
//		renderShadow = false;
//	}

	@Override
	public void place(int cell) {
		if (parent != null) parent.bringToFront(this);
		super.place(cell);
	}

	public void activate(){
		idle = death.clone();
		idle();
	}

	@Override
	public void play(Animation anim) {
		if (anim == die){
			turnTo(ch.pos, ch.pos+1); //always face right to merge with custom tiles
			emitter().burst(BlastParticle.FACTORY, 20);
			Sample.INSTANCE.play(Assets.Sounds.BLAST);
		}
		super.play(anim);
	}

	@Override
	public void onComplete(Animation anim) {
		if (anim == attack){
			flash();
		}
		super.onComplete(anim);
	}

	@Override
	public int blood() {
		return 0xFFFFFF88;
	}
}
