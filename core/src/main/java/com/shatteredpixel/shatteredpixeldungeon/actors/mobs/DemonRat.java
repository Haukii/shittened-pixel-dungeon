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

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.sprites.DemonRatSprite;
import com.watabou.utils.Random;

public class DemonRat extends Rat {

	{
		spriteClass = DemonRatSprite.class;

		HP = HT = 250;
		defenseSkill = 20;
		viewDistance = 15;

		EXP = 12;
		maxLvl = 29;
		
		loot = Generator.Category.EXOTIC;
		lootChance = 1f;
		properties.add(Property.DEMONIC);
		properties.add(Property.MINIBOSS);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 25, 30 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 40;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 10);
	}
}
