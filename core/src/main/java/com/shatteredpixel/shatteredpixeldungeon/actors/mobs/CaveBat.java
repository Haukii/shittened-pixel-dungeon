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

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.CellEmitter;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.items.food.SmallMeat;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CaveBatSprite;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class CaveBat extends Bat {

	{
		spriteClass = CaveBatSprite.class;

		HP = HT = 15;

		baseSpeed = 2.5f;

		EXP = 4;

		loot = new SmallMeat();
		lootChance = 0.3f;
	}

	private int calloutCooldown = 0;

	public boolean summoned;

	@Override
	protected boolean act() {
		calloutCooldown--;
		if (EXP == 0 && !summoned) summoned = true;
		if (summoned && lootChance > 0f) {
			lootChance = 0f;
			EXP = 0;
		}
		return super.act();
	}

	@Override
	public int attackProc(Char enemy, int damage) {


		int batAmount = 0;
		for (Mob mob : Dungeon.level.mobs) {
			if (mob instanceof CaveBat) {
				batAmount++;
			}
		}

		if (Random.Int(3) == 0 && calloutCooldown <= 0 && enemy instanceof Hero) {
			CellEmitter.center( pos ).start( Speck.factory( Speck.SCREAM ), 0.1f, 4 );
			Sample.INSTANCE.play(Assets.Sounds.BAT, 1f, Random.Float(0.8f, 1.2f));

			//I fear that infinite bats will be a frustrating end to some runs.
			if (batAmount < 4) {
				CaveBat bat = new CaveBat();
				bat.EXP = 0;
				bat.summoned = true;
				Dungeon.level.spawnMob(8, bat);
			}

			for (Mob mob: Dungeon.level.mobs) {
				if (mob instanceof CaveBat) {
					mob.beckon(Dungeon.hero.pos);
				}
			}

			calloutCooldown = 10;
		}
		return super.attackProc(enemy, damage);
	}

	@Override
	public String description() {
		String desc = super.description();

		if (summoned) {
			desc += Messages.get(this, "summoned");
		}

		return desc;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 5, 10 );
	}

	private static final String SUMMONED = "summoned";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		if (summoned) bundle.put(SUMMONED, true);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		if (bundle.contains(SUMMONED)) summoned = true;
	}
}
