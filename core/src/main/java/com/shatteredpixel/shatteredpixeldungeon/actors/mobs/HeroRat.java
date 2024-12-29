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
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Slow;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Sugar;
import com.shatteredpixel.shatteredpixeldungeon.sprites.HeroRatSprite;
import com.watabou.utils.Random;

public class HeroRat extends Rat {

	{
		spriteClass = HeroRatSprite.class;
		
		HP = HT = 22;
		EXP = 3;
		baseSpeed = 2f;
		
		loot = Random.oneOf(Generator.Category.ARTIFACT, Generator.Category.WEP_T2);
		lootChance = 0.25f;
	}
	
	@Override
	public int attackProc( Char enemy, int damage ) {
		damage = super.attackProc( enemy, damage );
		if (Random.Int( 3 ) == 0) {
			Buff.affect( enemy, Slow.class, 3f);
		}
		
		return damage;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 2, 5 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 10;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(1, 3);
	}

	@Override
	public void die(Object cause) {
		if (Random.Float() < lootChance * 2) {
			Dungeon.level.drop(new Sugar().quantity(Random.Int(1,4)), pos).sprite.drop();
		}
		super.die(cause);
	}
}
