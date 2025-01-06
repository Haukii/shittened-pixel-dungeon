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
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Adrenaline;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Invisibility;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Talent;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.items.Recipe;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.GoldBar;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class GoldenMeat extends TastyFood {

	{
		image = ItemSpriteSheet.GOLDENMEAT;
		energy = Hunger.HUNGRY/1.5f;
		carbs = 25f;
		fats = 4.3f;
		proteins = 59f;
		salt = 2.9f;
	}
	
	@Override
	public int value() {
		return 90 * quantity;
	}

	@Override
	protected void satisfy(Hero hero) {
		super.satisfy(hero);
		effect(hero);
	}

	public static class Craft extends Recipe.SimpleRecipe{
		{
			inputs =  new Class[]{MysteryMeat.class, GoldBar.class};
			inQuantity = new int[]{1, 2};

			cost = 5;

			output = GoldenMeat.class;
			outQuantity = 1;
		}
	}

	@Override
	protected float eatingTime(){
		if (Dungeon.hero.hasTalent(Talent.IRON_STOMACH)
				|| Dungeon.hero.hasTalent(Talent.ENERGIZING_MEAL)
				|| Dungeon.hero.hasTalent(Talent.MYSTICAL_MEAL)
				|| Dungeon.hero.hasTalent(Talent.INVIGORATING_MEAL)){
			return 3;
		} else {
			return 6;
		}
	}


	public static void effect(Hero hero){
		PotionOfHealing.cure(hero);
		hero.sprite.emitter().start( Speck.factory( Speck.HEART ), 0.2f, 1 );
		hero.sprite.emitter().start( Speck.factory( Speck.HEALING ), 0.2f, 3 );
		Buff.prolong(hero, Invisibility.class, 10f + TIME_TO_EAT);
		Buff.prolong(hero, Adrenaline.class, 5f + TIME_TO_EAT);
		hero.HP += hero.HT / 2;
	}
}
