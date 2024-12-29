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
import com.shatteredpixel.shatteredpixeldungeon.items.food.SmallMeat;
import com.shatteredpixel.shatteredpixeldungeon.sprites.PerchSprite;
import com.watabou.utils.Random;

public class Perch extends Piranha {

	{
		spriteClass = PerchSprite.class;

		baseSpeed = 1f;
	}

	public Perch() {
		super();

		HP = HT = 10 + Dungeon.depth * 3;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange((int) (Dungeon.depth / 2.5f), (int) (4 + Dungeon.depth * 1.5f));
	}
	
	@Override
	public void die( Object cause ) {
		Dungeon.level.drop(new SmallMeat(), pos).sprite.drop();
		super.die( cause );
	}
}
