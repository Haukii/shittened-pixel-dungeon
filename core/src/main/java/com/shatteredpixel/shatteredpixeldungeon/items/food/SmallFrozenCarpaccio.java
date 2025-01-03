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

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Barkskin;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Invisibility;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHealing;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Random;

public class SmallFrozenCarpaccio extends Food {

	{
		image = ItemSpriteSheet.SMALLFROZEN;
		energy = Hunger.HUNGRY/4f;
		carbs = 1f;
		fats = 5f;
		proteins = 7f;
		salt = 0.1f;
	}
	
	@Override
	protected void satisfy(Hero hero) {
		super.satisfy(hero);
		effect(hero);
	}
	
	public int value() {
		return 5 * quantity;
	}

	public static void effect(Hero hero){
		switch (Random.Int( 5 )) {
			case 0:
				GLog.i( Messages.get(SmallFrozenCarpaccio.class, "invis") );
				Buff.affect( hero, Invisibility.class, Invisibility.DURATION / 2f );
				break;
			case 1:
				GLog.i( Messages.get(SmallFrozenCarpaccio.class, "hard") );
				Buff.affect( hero, Barkskin.class ).set( hero.HT / 6, 2 );
				break;
			case 2:
				GLog.i( Messages.get(SmallFrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero);
				break;
			case 3:
				GLog.i( Messages.get(SmallFrozenCarpaccio.class, "better") );
				if (hero.HP < hero.HT) {
					hero.HP = Math.min( hero.HP + hero.HT / 6, hero.HT );
					hero.sprite.emitter().burst( Speck.factory( Speck.HEALING ), 1 );
				}
				break;
		}
	}
	
	public static Food cook( SmallMeat ingredient ) {
		SmallFrozenCarpaccio result = new SmallFrozenCarpaccio();
		result.quantity = ingredient.quantity();
		return result;
	}
}
