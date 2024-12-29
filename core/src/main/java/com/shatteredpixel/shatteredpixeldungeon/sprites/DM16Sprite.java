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
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.DM100;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.DM16;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.DM200;
import com.shatteredpixel.shatteredpixeldungeon.effects.Gunshot;
import com.shatteredpixel.shatteredpixeldungeon.effects.Lightning;
import com.shatteredpixel.shatteredpixeldungeon.effects.MagicMissile;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.TextureFilm;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Callback;
import com.watabou.utils.PointF;

public class DM16Sprite extends MobSprite {

	public DM16Sprite() {
		super();

		texture( Assets.Sprites.DM200 );

		TextureFilm frames = new TextureFilm( texture, 21, 18 );

		int c = 24;

		idle = new Animation( 2, true );
		idle.frames( frames, c+0, c+1 );

		run = new Animation( 10, true );
		run.frames( frames, c+2, c+3 );

		attack = new Animation( 15, false );
		attack.frames( frames, c+4, c+5, c+6 );

		zap = new Animation( 15, false );
		zap.frames( frames, c+7, c+8, c+8, c+7 );

		die = new Animation( 8, false );
		die.frames( frames, c+9, c+10, c+11 );

		play( idle );
	}

	public void zap( int pos ) {

		Char enemy = Actor.findChar(pos);

		PointF origin = center();

		if (enemy != null) {
			parent.add(new Gunshot(origin, enemy.sprite.destinationCenter(), (DM16) ch));
		} else {
			parent.add(new Gunshot(origin, pos, (DM16) ch));
		}
		Sample.INSTANCE.play( Assets.Sounds.GUN );

		super.zap( ch.pos );
		flash();
	}

	@Override
	public void place(int cell) {
		if (parent != null) parent.bringToFront(this);
		super.place(cell);
	}

	@Override
	public void die() {
		emitter().burst( Speck.factory( Speck.SMOKE ), 8 );
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
