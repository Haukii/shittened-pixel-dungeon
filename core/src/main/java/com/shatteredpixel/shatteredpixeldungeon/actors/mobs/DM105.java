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
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLevitation;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLiquidFlame;
import com.shatteredpixel.shatteredpixeldungeon.sprites.DM105Sprite;
import com.watabou.utils.Random;

public class DM105 extends DM100 {

	
	{
		spriteClass = DM105Sprite.class;
		
		HP = HT = 15;
		defenseSkill = 17;
		baseSpeed = 1.5f;
		
		EXP = 7;

		flying = true;

		loot = Generator.Category.SCROLL;
		lootChance = 0.4f;
	}
	
	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 4, 9 );
	}

	@Override
	public void die(Object cause) {

		if (Random.Float(1f) > 0.6f) {
			Dungeon.level.drop( new PotionOfLevitation(), pos ).sprite.drop();
		}
		if (Random.Float(1f) > 0.4f) {
			Dungeon.level.drop(new PotionOfLiquidFlame(), pos).sprite.drop();
		}
		super.die(cause);
	}
}
