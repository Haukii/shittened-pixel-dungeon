/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2024 Evan Debenham
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
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.GoblinMode;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Gotted;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Nuts;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.GoblinSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.MindGoblinSprite;
import com.watabou.utils.Random;

public class MindGoblin extends Goblin {

	{
		spriteClass = MindGoblinSprite.class;
		
		HP = HT = 12;
		defenseSkill = 2;

		EXP = 1;
		maxLvl = 5;
	}

	@Override
	protected boolean act() {
		return super.act();
    }

	@Override
	public void die(Object cause) {
		yell(Messages.get(this, "nuts"));
		Dungeon.level.drop(new Nuts(), pos);
		for (Mob mob: Dungeon.level.mobs) {
			if (mob.fieldOfView[pos]) {
				Buff.affect(mob, GoblinMode.class, GoblinMode.DURATION);
			}
		}
		Buff.affect(Dungeon.hero, Gotted.class, Gotted.DURATION);
		super.die(cause);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 3, 5 );
	}
	
	@Override
	public int attackSkill( Char target ) {
		return 9;
	}
	
	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 1);
	}
}
