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

package com.watabou.noosa.particles;

import com.watabou.glwrap.Blending;
import com.watabou.noosa.Game;
import com.watabou.noosa.Group;
import com.watabou.noosa.Visual;
import com.watabou.utils.PointF;
import com.watabou.utils.Random;

public class Emitter extends Group {

	protected boolean lightMode = false;
	
	public float x;
	public float y;
	public float width;
	public float height;
	
	protected Visual target;
	public boolean fillTarget = true;

	//THESE 5 VARIABLES ARE ALL USED FOR RANDOM SIZE
	public boolean randomSize = false;
	public float randomWidth = 1;
	public float randomHeight = 1;
	public float centerOffsetX = 0;
	public float centerOffsetY = 0;
	//THESE 5 VARIABLES ARE ALL USED FOR RANDOM SIZE
	
	protected float interval;
	protected int quantity;
	
	public boolean on = false;

	private boolean started = false;
	public boolean autoKill = true;
	
	protected int count;
	protected float time;
	
	protected Factory factory;
	
	public void pos( float x, float y ) {
		pos( x, y, 0, 0 );
	}
	
	public void pos( PointF p ) {
		pos( p.x, p.y, 0, 0 );
	}
	
	public void pos( float x, float y, float width, float height ) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		target = null;
	}

	public void pos( Visual target ) {
		this.target = target;
	}

	public void pos( Visual target, float x, float y, float width, float height ) {
		pos(x, y, width, height);
		pos(target);
	}
	
	public void burst( Factory factory, int quantity ) {
		start( factory, 0, quantity );
	}
	
	public void pour( Factory factory, float interval ) {
		start( factory, interval, 0 );
	}

	public void start( Factory factory, float interval, int quantity ) {

		this.factory = factory;
		this.lightMode = factory.lightMode();
		
		this.interval = interval;
		this.quantity = quantity;
		
		count = 0;
		time = Random.Float( interval );
		
		on = true;
		started = true;
	}

	public static boolean freezeEmitters = false;

	protected boolean isFrozen(){
		return Game.timeTotal > 1 && freezeEmitters;
	}
	
	@Override
	public void update() {

		if (isFrozen()){
			return;
		}
		
		if (on) {
			time += Game.elapsed;
			while (time > interval) {
				time -= interval;
				emit( count++ );
				if (quantity > 0 && count >= quantity) {
					on = false;
					break;
				}
			}
		} else if (started && autoKill && countLiving() == 0) {
			kill();
		}
		
		super.update();
	}

	@Override
	public void revive() {
		//ensure certain emitter variables default to true
		started = false;
		visible = true;
		fillTarget = true;
		autoKill = true;
		super.revive();
	}

	protected void emit( int index ) {
		if (randomSize && target == null) { //nice job
			factory.emit(
					this,
					index,
					x + Random.Float(-randomWidth, randomWidth) + centerOffsetX + width / 2,
					y + Random.Float(-randomHeight, randomHeight) + centerOffsetY + height / 2
			);
		} else if (randomSize) {
			factory.emit(
					this,
					index,
					target.x + Random.Float(-randomWidth, randomWidth) + centerOffsetX + target.width / 2,
					target.y + Random.Float(-randomHeight, randomHeight) + centerOffsetY + target.height / 2
			);
		} else if (target == null) {
			factory.emit(
				this,
				index,
				x + Random.Float( width ),
				y + Random.Float( height ) );
		} else {
			if (fillTarget) {
				factory.emit(
						this,
						index,
						target.x + Random.Float( target.width ),
						target.y + Random.Float( target.height ) );
			} else {
				factory.emit(
						this,
						index,
						target.x + x + Random.Float( width ),
						target.y + y + Random.Float( height ) );
			}
		}
	}
	
	@Override
	public void draw() {
		if (lightMode) {
			Blending.setLightMode();
			super.draw();
			Blending.setNormalMode();
		} else {
			super.draw();
		}
	}
	
	abstract public static class Factory {
		
		abstract public void emit( Emitter emitter, int index, float x, float y );
		
		public boolean lightMode() {
			return false;
		}
	}
}
