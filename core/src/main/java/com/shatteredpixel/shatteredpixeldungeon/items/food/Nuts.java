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

package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Gotted;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Satisfied;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Talent;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Random;

public class Nuts extends Food {
	
	public float energy = 30f;
	
	{
		image = ItemSpriteSheet.NUTS;
		carbs = 5f;
		fats = 15f;
		proteins = 3f;
		salt = 0.2f;
	}
	
	@Override
	public void execute( Hero hero, String action ) {

		if (action.equals( AC_EAT )) {
			if (Random.Int(6) == 0) {
				GLog.i( Messages.get(this, "eat_got") );
				GLog.w( Messages.get(this, "got") );
				Buff.affect(hero, Gotted.class, Gotted.DURATION);
				energy += 50;
			} else {
				GLog.i( Messages.get(this, "eat_msg") );
			}
		}
		super.execute( hero, action );
	}

	@Override
	public int value() {
		return 20 * quantity;
	}
}
