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

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.AscensionChallenge;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.DwarfKing;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ImpSprite;
import com.watabou.utils.Bundle;

public class ImpShopkeeper extends Shopkeeper {

	{
		spriteClass = ImpSprite.class;
	}
	
	private boolean seenBefore = false;

	private int messages = 1;
	
	@Override
	protected boolean act() {

		if (!seenBefore && Dungeon.level.heroFOV[pos]) {
			if (Dungeon.hero.buff(AscensionChallenge.class) == null) {
				if (DwarfKing.getKing() == null || !DwarfKing.getKing().isAlive()) {
					talk(Messages.get(this, "greetings", Dungeon.hero.name()) + " Wait, why is everyone screaming...?");
				} else if (messages > 7) {
					yell(Messages.get(this, "greetingsbad", Dungeon.hero.name()));
				} else {
					talk(Messages.get(this, "greetings", Dungeon.hero.name()));
				}
			} else {
				yell(Messages.get(this, "greetings_ascent", Dungeon.hero.name()));
			}
			seenBefore = true;
		}

		if (Dungeon.level.heroFOV[pos] && (DwarfKing.getKing() == null || !DwarfKing.getKing().isAlive())) {
			yell(Messages.get(this, "kingisdead"));
			flee();
		}
		if (Dungeon.hero.pos < 160 && messages == 1) {
			yell(Messages.get(this, "danger1"));
			messages++;
			return super.act();
		}
		if (Dungeon.hero.pos > 170 && messages == 2) {
			talk(Messages.get(this, "danger2"));
			messages++;
			return super.act();
		}
		if (Dungeon.hero.pos < 160 && messages == 3) {
			yell(Messages.get(this, "danger3"));
			messages++;
			return super.act();
		}
		if (Dungeon.hero.pos > 170 && messages == 4) {
			yell(Messages.get(this, "danger4"));
			messages++;
			return super.act();
		}
		if (Dungeon.hero.pos < 160 && messages == 5) {
			yell(Messages.get(this, "danger5"));
			messages++;
			return super.act();
		}
		if (Dungeon.hero.pos > 170 && messages == 6) {
			yell(Messages.get(this, "danger6"));
			messages++;
			return super.act();
		}
		if (Dungeon.hero.pos > 230 && messages == 7) {
			yell(Messages.get(this, "danger7"));
			messages++;
			return super.act();
		}
		if (Dungeon.hero.pos < 160 && messages == 8) {
			yell(Messages.get(this, "danger8"));
			messages++;
			return super.act();
		}

		return super.act();
	}

	private static final String MESSAGES = "messages";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		if (messages > 7) {
			bundle.put( MESSAGES, 10 );
		} else {
			bundle.put( MESSAGES, -1 );
		}
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		messages = bundle.getInt(MESSAGES);
	}
}
