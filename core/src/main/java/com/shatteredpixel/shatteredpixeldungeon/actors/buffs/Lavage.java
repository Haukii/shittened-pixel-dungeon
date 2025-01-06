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

package com.shatteredpixel.shatteredpixeldungeon.actors.buffs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.ui.BuffIndicator;
import com.watabou.utils.Bundle;
import com.watabou.utils.GameMath;
import com.watabou.utils.Random;

public class Lavage extends Buff {
	//aka suolistohuuhtelu
	{
		type = buffType.POSITIVE;
		announced = true;
	}

	private int healingLeft;
	private int totalHealing;

	public void set( int amount ){
		if (amount > healingLeft) healingLeft = amount;
		totalHealing = healingLeft;
	}
	
	@Override
	public int icon() {
		return BuffIndicator.LAVAGE;
	}

	@Override
	public boolean act() {

			float healAmt = GameMath.gate( 1, target.HT/30f, healingLeft);
			if (Random.Float() < (healAmt % 1)){
				healAmt = (float)Math.ceil(healAmt);
			} else {
				healAmt = (float)Math.floor(healAmt);
			}
			if (target.HP <= target.HT) {
				target.HP += (int) Math.min(healAmt, target.HT - target.HP);
			}
			healingLeft -= (int) healAmt;
			target.sprite.emitter().burst( Speck.factory( Speck.HEALING ), (int) Math.max(3f, healAmt) );

		if (healingLeft <= 0){
			detach();
		} else {
			spend(TICK);
		}
		if (Dungeon.hero.buff(Overstuffed.class) != null) {
			Dungeon.hero.buff(Overstuffed.class).detach();
		}
		return true;
	}

	@Override
	public String iconTextDisplay() {
		return Integer.toString(healingLeft);
	}
	
	@Override
	public String toString() {
		return Messages.get(this, "name");
	}
	
	@Override
	public String desc() {
		return Messages.get(this, "desc", healingLeft);
	}


	private static final String LEFT = "left";
	private static final String TOTAL = "total";

	@Override
	public void storeInBundle( Bundle bundle ) {
		super.storeInBundle( bundle );
		bundle.put( LEFT, healingLeft);
		bundle.put( TOTAL, totalHealing);
	}

	@Override
	public void restoreFromBundle( Bundle bundle ) {
		super.restoreFromBundle( bundle );
		healingLeft = bundle.getInt( LEFT );
		totalHealing = bundle.getInt(TOTAL);
	}
	
}
