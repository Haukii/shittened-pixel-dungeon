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

package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Blindness;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Invisibility;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.effects.Splash;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Egg extends Food implements Hero.Doom {

	{
		image = ItemSpriteSheet.EGG;
		energy = 30f;
		eatSound = Assets.Sounds.EGG_CRACK;
		carbs = 1f;
		fats = 5f;
		proteins = 6f;
		salt = 0.1f;
	}

	@Override
	public int value() {
		return 2 * quantity;
	}

	@Override
	protected void onThrow(int cell) {
		if (Dungeon.level.pit[cell]){
			super.onThrow( cell );
		} else {
			Char target = Actor.findChar(cell);
			Invisibility.dispel();
			if (target instanceof Mob) {
				target.damage(Random.Int(2,6), this);
				Buff.prolong(target, Blindness.class, 4f);
			}
			Splash.at( cell, 0xffd659, 5 );
			Sample.INSTANCE.play(Assets.Sounds.EGG_CRACK_2, 0.9f, Random.Float(0.9f, 1.1f));
		}
	}

	@Override
	public void onDeath() {
		Dungeon.fail( getClass() );
		GLog.n( Messages.get(this, "ondeath") );
	}
}
