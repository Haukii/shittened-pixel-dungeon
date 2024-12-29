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

package com.shatteredpixel.shatteredpixeldungeon.items.misc;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.HeroClass;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;


public class Painting extends Item {


	int id;

	{
		image = ItemSpriteSheet.PAINTING_MEAT;
		stackable = false;
	}

	public Painting() {
		id = Random.Int(0,16);
		image = ItemSpriteSheet.PAINTING_MANA_LISA + id;
	}

	@Override
	public String desc() {
		String desc = Messages.get(this, "desc", id);

		switch (id) {
			case 4:
				if (Dungeon.hero.heroClass == HeroClass.WARRIOR) {
					desc += Messages.get(this, "warrior", Dungeon.hero.name());
				}
				break;
			case 5:
				if (Dungeon.hero.heroClass == HeroClass.ROGUE) {
					desc += Messages.get(this, "rogue", Dungeon.hero.name());
				}
				break;
		}

		return desc;
	}

	private static final String ID = "ID";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(ID, id);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		id = bundle.getInt(ID);
		image = ItemSpriteSheet.PAINTING_MANA_LISA + id;
		updateQuickslot();
	}



	@Override
	public int value() {
		switch (id) {
			case 0:
				return 400;
			case 1:
				return 350;
			case 2:
			case 3:
				return 300;
			case 4:
				return 55;
			case 5:
			case 6:
			case 7:
				return 60;
			case 8:
			case 9:
			case 10:
				return 150;
			case 11:
				return 180;
			case 12:
			case 13:
				return 90;
			case 14:
				return 40;
			case 15:
				return 30;
			default:
				return 100 * quantity;
		}
	}
	
	@Override
	public boolean isUpgradable() {
		return false;
	}
	
	@Override
	public boolean isIdentified() {
		return true;
	}
}
