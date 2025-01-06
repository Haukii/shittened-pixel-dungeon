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
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Bleeding;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Branch extends MeleeWeapon {

	{
		image = ItemSpriteSheet.BRANCH;
		hitSound = Assets.Sounds.HIT_SLASH;
		hitSoundPitch = 1.3f;

		tier = 1;

		bones = false;

		type = Type.LEATHER;
	}

	public Branch() {
		super();
	}

	@Override
	public int proc(Char attacker, Char defender, int damage) {
		if (Random.Float() < 0.1f) {
			Buff.affect(defender, Bleeding.class).set(level());
		}

		if (level() <= 0 && Random.Float() < 0.2f) {
			Sample.INSTANCE.play(Assets.Sounds.STICK_SNAP, 1f, Random.Float(0.9f, 1.1f));
			if (level() <= -2) {
				this.detach(Dungeon.hero.belongings.backpack);
				GLog.n(Messages.get(Branch.class, "break"));
			} else {
				degrade();
				GLog.w(Messages.get(Branch.class, "snap"));
			}
		}
		return super.proc(attacker, defender, damage);
	}

	@Override
	public int max(int lvl) {

		return trueMax(Random.Int(tier + 4,tier+1));
	}

	@Override
	public int value() {
		return super.value() / 2;
	}
}
