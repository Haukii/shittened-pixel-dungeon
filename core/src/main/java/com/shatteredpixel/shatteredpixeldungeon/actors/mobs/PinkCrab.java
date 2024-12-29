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
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.food.MysteryMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.SmallMeat;
import com.shatteredpixel.shatteredpixeldungeon.sprites.PinkCrabSprite;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class PinkCrab extends Crab {

	{
		spriteClass = PinkCrabSprite.class;
		
		HP = HT = 11;
		defenseSkill = 7;
		baseSpeed = 1.5f;
		
		EXP = 5;
		
		loot = new MysteryMeat().quantity(Random.Int(1,4));
		lootChance = 0.25f;
	}

	@Override
	public void die(Object cause) {
		int spot;
		do {
			spot = PathFinder.NEIGHBOURS8[Random.Int(8)];
		} while (!Dungeon.level.passable[pos + spot]);
		Dungeon.level.drop( new SmallMeat(), pos + spot ).sprite.drop( pos );
		super.die(cause);
	}

	@Override
	public int attackSkill( Char target ) {
		return 10;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 5);
	}
}
