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
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.DM100;
import com.shatteredpixel.shatteredpixeldungeon.effects.Lightning;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.watabou.noosa.TextureFilm;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.PointF;

public class DMS74UNSprite extends MobSprite {

	public DMS74UNSprite() {
		super();
		
		texture( Assets.Sprites.DM100 );
		
		TextureFilm frames = new TextureFilm( texture, 16, 14 );
		
		idle = new Animation( 1, true );
		idle.frames( frames, 16, 17 );

		run = new Animation( 12, true );
		run.frames( frames, 22, 23, 24, 25 );
		
		attack = new Animation( 12, false );
		attack.frames( frames, 18, 19, 20, 16 );

		zap = new Animation( 8, false );
		zap.frames( frames, 21, 21, 17 );

		die = new Animation( 12, false );
		die.frames( frames, 26, 28, 28, 29, 30, 31 );
		
		play( idle );
	}
	
	public void zap( int pos ) {

		Char enemy = Actor.findChar(pos);

		//shoot lightning from eye, not sprite center.
		PointF origin = center();
		if (flipHorizontal){
			origin.y -= 6*scale.y;
			origin.x -= 1*scale.x;
		} else {
			origin.y -= 8*scale.y;
			origin.x += 1*scale.x;
		}
		if (enemy != null) {
			parent.add(new Lightning(origin, enemy.sprite.destinationCenter(), (DM100) ch));
		} else {
			parent.add(new Lightning(origin, pos, (DM100) ch));
		}
		Sample.INSTANCE.play( Assets.Sounds.LIGHTNING );
		
		turnTo( ch.pos, pos );
		flash();
		play( zap );
	}

	@Override
	public void die() {
		emitter().burst( Speck.factory( Speck.WOOL ), 5 );
		super.die();
	}

	@Override
	public void onComplete( Animation anim ) {
		if (anim == zap) {
			idle();
		}
		super.onComplete( anim );
	}

	@Override
	public int blood() {
		return 0xFFFFFF88;
	}
}
