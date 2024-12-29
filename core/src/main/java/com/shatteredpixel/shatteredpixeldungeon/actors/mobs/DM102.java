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
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfInvisibility;
import com.shatteredpixel.shatteredpixeldungeon.sprites.DM102Sprite;
import com.watabou.utils.Random;

public class DM102 extends DM100 {
	
	{
		spriteClass = DM102Sprite.class;
		
		HP = HT = 22;
		
		EXP = 8;
		
		loot = Generator.Category.SCROLL;
		lootChance = 0.8f;

	}

	@Override
	public void die(Object cause) {

		if (Random.Float(1f) > 0.5f) {
			Dungeon.level.drop( new PotionOfInvisibility(), pos ).sprite.drop();
		}

		super.die(cause);
	}
}
