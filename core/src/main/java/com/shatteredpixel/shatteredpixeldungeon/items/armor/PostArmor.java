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

package com.shatteredpixel.shatteredpixeldungeon.items.armor;

import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class PostArmor extends Armor {

	{
		image = ItemSpriteSheet.ARMOR_POST;

		type = Type.PAPER;
	}

	int addressId;

	public PostArmor() {
		super( 3, 8 );
		addressId = Random.Int(0,6);
	}

	@Override
	public String desc() {
		return Messages.get(this, "desc", address());
	}

	public String address() {
		switch (addressId) {
			case 0:
				return "15 Gnollfruit Street, Torchtown";
			case 1:
				return "119 Shortsword Boulevard, Dinktown";
			case 2:
				return "2 Shattered Street, Texas";
			case 3:
				return "2509 Gort Street, Disco Caves";
			case 4:
				return "125 Scrollway Street, Mage Valley";
			case 5:
				return "59 Daggerpath, Dinktown";
			default:
				return "";
		}
	}

	String address = "ADDRESS";

	@Override
	public void storeInBundle(Bundle bundle) {
		bundle.put(address, addressId);
		super.storeInBundle(bundle);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		addressId = bundle.getInt(address);
	}
}
