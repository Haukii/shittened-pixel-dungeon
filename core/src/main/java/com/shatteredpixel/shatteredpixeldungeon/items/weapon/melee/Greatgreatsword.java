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

package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.Random;

public class Greatgreatsword extends MeleeWeapon {

	{
		image = ItemSpriteSheet.GREATGREATSWORD;
		hitSound = Assets.Sounds.HIT_SLASH;
		hitSoundPitch = 0.6f;

		tier= 1;
		DLY = 1.5f;
		RCH = 2;

		type = Type.SWORD;
	}

	@Override
	public int max(int lvl) {
		return Random.Int(10*(tier+8),lvl*(tier*4+5));
	}

	@Override
	public int min(int lvl) {
		return Random.Int(tier+20,lvl * 3);
	}

	@Override
	public int STRReq(int lvl) {
		return STRReq(6, lvl) + 5;
	}

}
