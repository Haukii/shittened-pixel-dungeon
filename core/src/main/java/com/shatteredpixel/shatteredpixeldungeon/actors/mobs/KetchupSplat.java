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
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.KetchupStorm;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Ketchup;
import com.shatteredpixel.shatteredpixeldungeon.sprites.KetchupSplatSprite;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class KetchupSplat extends Mob {

	{
		spriteClass = KetchupSplatSprite.class;
		defenseSkill = 3 + Dungeon.depth / 4;
		
		EXP = 0;
		alignment = Alignment.ALLY;
		immunities.add(Ketchup.class);
		immunities.add(KetchupStorm.class);
	}

	int damage;

	public KetchupSplat() {
		this.damage = Dungeon.depth / 4;
		HP = HT = Math.min(Dungeon.depth * 2, 20);
	}

	public KetchupSplat(int health, int damage) {
		HP = HT = (int) (health * 0.75f);
		this.damage = damage / 3;
	}

	@Override
	protected boolean act() {
		return super.act();
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( damage, damage * 3 );
	}
	
	@Override
	public int attackSkill( Char target ) {
		return 8 + Dungeon.depth / 3;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 1 + Dungeon.depth / 5);
	}

	private static final String DAMAGE = "DAMAGE";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(DAMAGE, damage);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		damage = bundle.getInt(DAMAGE);
	}
}
