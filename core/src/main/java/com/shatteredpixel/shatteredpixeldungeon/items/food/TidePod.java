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

import com.badlogic.gdx.utils.Timer;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Adrenaline;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Healing;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Poison;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.plants.Firebloom;
import com.shatteredpixel.shatteredpixeldungeon.plants.Icecap;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Random;

public class TidePod extends Food {
	
	{
		image = ItemSpriteSheet.TIDEPOD;
		energy = Hunger.HUNGRY/2f;
		carbs = 0f;
		fats = 0f;
		proteins = 0f;
		salt = 5.2f;
	}

	@Override
	protected void satisfy(Hero hero) {
		super.satisfy(hero);
		effect(hero);
	}

	public static void effect(Hero hero){
		if (Random.Float() > 0.5f) {
			Buff.affect(hero, Adrenaline.class, 15f);
			Buff.affect(hero, Healing.class).increaseHeal(hero.HT / 5);
			GLog.p( Messages.get(TidePod.class, "eat_positive") );
			hero.HT += 5;
		} else {
			Buff.affect(hero, Poison.class).set(Random.Float(4f,6f));
			GLog.n( Messages.get(TidePod.class, "eat_negative") );
			hero.HT -= 5;
			Timer.schedule(new Timer.Task(){
				@Override
				public void run(){
					GLog.n( Messages.get(TidePod.class, "damage") );
				}
			}, 5f);
		}
	}

	@Override
	public int value() {
		return quantity;
	}

	public static class Recipe extends com.shatteredpixel.shatteredpixeldungeon.items.Recipe.SimpleRecipe{

		{
			inputs =  new Class[]{WaxBar.class, Icecap.Seed.class, Firebloom.Seed.class};
			inQuantity = new int[]{1,1,1};
			
			cost = 2;
			
			output = TidePod.class;
			outQuantity = 2;
		}
	}
}
