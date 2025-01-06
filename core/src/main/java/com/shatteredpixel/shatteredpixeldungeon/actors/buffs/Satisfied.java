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
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.ui.BuffIndicator;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Bundle;

public class Satisfied extends Buff {

	public static final float DURATION_MILD		= 100f;
	public static final float DURATION_MODERATE	= 200f;
	public static final float DURATION_PLENTY	= 400f;

	private static final float MAX_BOOST_PERCENTAGE = 20;

	{
		type = buffType.POSITIVE;
	}

	private float left;
	private Satisfaction satisfaction;

	@Override
	public boolean act() {
		left--;
		spend(TICK);


		if (left <= 0) {
			detach();
		}
		if ((satisfaction == Satisfaction.MODERATELYSATISFIED && left < DURATION_MILD)
				|| (satisfaction == Satisfaction.PLENTYSATISFIED  && left < DURATION_MODERATE)) {
			setSatisfaction(left);
		}
		if (Dungeon.hero.buff(Lavage.class) != null) {
			left -= 5f;
		}
		return true;
	}

	public void apply(Char ch, float duration) {
		float total = 0;
		if (ch.buff(Satisfied.class) != null) {
			total += ch.buff(Satisfied.class).left;
		}
		total += duration;

		if (total > 450) {
			Buff.affect(ch, Overstuffed.class, Math.min(100f, total - 450f));
		}

		left = Math.min(DURATION_PLENTY, total);

		setSatisfaction(left);
	}

	private void setSatisfaction(float left) {
		if (left <= DURATION_MILD) {
			satisfaction = Satisfaction.MILDLYSATISFIED;
		} else if (left <= DURATION_MODERATE) {
			satisfaction = Satisfaction.MODERATELYSATISFIED;
		} else if (left <= DURATION_PLENTY) {
			satisfaction = Satisfaction.PLENTYSATISFIED;
		}
		BuffIndicator.refreshHero();
	}

	public float statBoost() {
        return Math.round(((MAX_BOOST_PERCENTAGE * left / DURATION_PLENTY) + 0.05f) * 100f) / 100f;
	}

	private static final String LEFT	= "left";

	@Override
	public void storeInBundle( Bundle bundle ) {
		super.storeInBundle( bundle );
		bundle.put( LEFT, left );
	}

	@Override
	public void restoreFromBundle( Bundle bundle ) {
		super.restoreFromBundle(bundle);
		left = bundle.getFloat( LEFT );
		setSatisfaction(left);
	}
	
	@Override
	public int icon() {
		switch (satisfaction) {
			case MILDLYSATISFIED: default:
				return BuffIndicator.MILDYSAT;
			case MODERATELYSATISFIED:
				return BuffIndicator.MEDIUMSAT;
			case PLENTYSATISFIED:
				return BuffIndicator.FULLYSAT;
		}
	}

	@Override
	public float iconFadePercent() {
		switch (satisfaction) {
			case MILDLYSATISFIED: default:
				return Math.max(0, (DURATION_MILD - left) / DURATION_MILD);
			case MODERATELYSATISFIED:
				return Math.max(0, (DURATION_MODERATE - left) / (DURATION_MODERATE - DURATION_MILD));
			case PLENTYSATISFIED:
				return Math.max(0, (DURATION_PLENTY - left) / (DURATION_PLENTY - DURATION_MODERATE));
		}
	}
	
	@Override
	public String name() {
		switch (satisfaction) {
			case MILDLYSATISFIED: default:
				return Messages.get(this, "name_mild");
			case MODERATELYSATISFIED:
				return Messages.get(this, "name_moderate");
			case PLENTYSATISFIED:
				return Messages.get(this, "name_plenty");
		}
	}

	@Override
	public String desc() {
		switch (satisfaction) {
			case MILDLYSATISFIED: default:
				return Messages.get(this, "desc_mild", statBoost());
			case MODERATELYSATISFIED:
				return Messages.get(this, "desc_moderate", statBoost());
			case PLENTYSATISFIED:
				return Messages.get(this, "desc_plenty", statBoost());
		}
	}

	public enum Satisfaction
	{
		MILDLYSATISFIED,
		MODERATELYSATISFIED,
		PLENTYSATISFIED
	}
}
