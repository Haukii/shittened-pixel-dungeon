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
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Burning;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Poison;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Roots;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Slow;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Random;

public class SmallMeat extends Food {

	{
		image = ItemSpriteSheet.SMALLMEAT;
		energy = Hunger.HUNGRY/6f;
		carbs = 1f;
		fats = 2f;
		proteins = 4f;
		salt = 0f;
	}

	@Override
	protected void satisfy(Hero hero) {
		super.satisfy(hero);
		effect(hero);
	}

	public static void effect(Hero hero){
		switch (Random.Int( 6 )) {
			case 0:
				GLog.w( Messages.get(SmallMeat.class, "hot") );
				Buff.affect( hero, Burning.class ).reignite( hero );
				break;
			case 1:
				GLog.w( Messages.get(SmallMeat.class, "legs") );
				Buff.prolong( hero, Roots.class, Roots.DURATION );
				break;
			case 2:
				GLog.w( Messages.get(SmallMeat.class, "not_well") );
				Buff.affect( hero, Poison.class ).set( hero.HT / 7f );
				break;
			case 3:
				GLog.w( Messages.get(SmallMeat.class, "stuffed") );
				Buff.prolong( hero, Slow.class, 4f );
				break;
			case 4:
				Dungeon.hero.defecate(4f);
				break;
		}
	}

	@Override
	public int value() {
		return 2 * quantity;
	}
}
