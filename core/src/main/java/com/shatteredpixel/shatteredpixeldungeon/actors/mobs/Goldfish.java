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

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.Gold;
import com.shatteredpixel.shatteredpixeldungeon.sprites.GoldfishSprite;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class Goldfish extends Piranha {

	{
		spriteClass = GoldfishSprite.class;

		baseSpeed = 1f;
		loot = Generator.Category.EXOTIC;
		WANDERING = new Wandering();
		HUNTING = new Hunting();
	}

	public Goldfish() {
		super();

		HP = HT = 15 + Dungeon.depth * 6;
	}

	@Override
	protected boolean act() {

		if (!Dungeon.level.water[pos]) {
			damage(Random.Int(4), Dungeon.hero);
		}
		return super.act();
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange((int) (Dungeon.depth / 2.5f), (int) (4 + Dungeon.depth * 1.5f));
	}
	
	@Override
	public void die( Object cause ) {
		//											Why are we rounding this exactly? \/
		Dungeon.level.drop(new Gold().quantity(Math.round(Random.Int(20,300) / 50f) * 50), pos).sprite.drop();
		super.die( cause );
	}

	@Override
	protected boolean getCloser( int target ) {
		// too done with this to fix it

		if (rooted) {
			return false;
		}
		int tries = 0;
		int waterLocation;
		do {
			waterLocation = pos + PathFinder.NEIGHBOURS9[Random.Int( tries )];
			tries++;
			if (tries == 8) {
				waterLocation = -1;
				break;
			}
		} while (!Dungeon.level.water[waterLocation]);

		boolean nextToHero = false;
		for (int i = 0; i < 8; i++) {
			if (Dungeon.hero.pos == pos + PathFinder.NEIGHBOURS8[i]) {
				nextToHero = true;
				break;
			}
		}

		if (distance(Dungeon.hero) > 4 && !nextToHero) {
			state = WANDERING;
		}

		int step = -1;
		if (waterLocation > 0 && !Dungeon.level.water[pos] && state == WANDERING) {
			step = Dungeon.findStep( this, waterLocation, Dungeon.level.water, fieldOfView, true );
//			talk("going towards water");
		} else if (state == HUNTING) {
			step = Dungeon.findStep( this, target, Dungeon.level.passable, fieldOfView, true );
//			talk("going towards player");
		}


		if (step != -1) {
			move( step );
			return true;
		} else {
			return false;
		}
	}

	private class Wandering extends Mob.Wandering{
		@Override
		public boolean act(boolean enemyInFOV, boolean justAlerted) {
			if (enemyInFOV) {
				PathFinder.buildDistanceMap(enemy.pos, Dungeon.level.water, viewDistance);
				enemyInFOV = PathFinder.distance[pos] != Integer.MAX_VALUE;
			}
//			talk("wandering");

			return super.act(enemyInFOV, justAlerted);
		}
	}

	private class Hunting extends Mob.Hunting{

		@Override
		public boolean act(boolean enemyInFOV, boolean justAlerted) {
			if (enemyInFOV) {
				PathFinder.buildDistanceMap(enemy.pos, Dungeon.level.passable, viewDistance);
				enemyInFOV = PathFinder.distance[pos] != Integer.MAX_VALUE;
			}

			return super.act(enemyInFOV, justAlerted);
		}
	}
}
