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
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class PileOfSais extends MeleeWeapon {

	{
		image = ItemSpriteSheet.PILE_OF_SAIS;
		hitSound = Assets.Sounds.HIT_PILE;

		tier = 3;
		DLY = 4f; //0.25x speed
		ACC = 0.8f;

		type = Type.TRINKET;
	}

	@Override
	public int max(int lvl) {
		return Random.Int(Math.round(4f*(tier+7)), lvl * Math.round((tier+5)) + Math.round(lvl * 2.5f));
	}

	@Override
	public int min(int lvl) {
		return  0;
	}

	@Override
	public int STRReq(int lvl){
		return STRReq(tier, lvl) + 1;
	}

	@Override
	public int proc( Char attacker, Char defender, int damage ) {

		int dmg = super.proc(attacker, defender, damage);

		if (Random.Int(100) == 69) {
//			Destroy the pile of sais into multiple regular sais, keep (most) upgrades
			int upgradesLeft = this.level();
			for (int i = 0; i < 2 + Math.min(2, this.level() / 2); i++) {
				Sai sai = new Sai();
				sai.prefix = this.prefix;
				if (upgradesLeft > 0) {
					int lvls = Random.Int(1, upgradesLeft + 1);
					sai.upgrade(lvls);
					upgradesLeft -= lvls;
				}
				Dungeon.level.drop(sai, defender.pos).sprite.drop();
			}
			GLog.w(Messages.get(this, "break", this.name()));

			doUnequip(Dungeon.hero, false);
			detachAll(Dungeon.hero.belongings.backpack);
			Sample.INSTANCE.play(Assets.Sounds.HIT_PILE);
			Sample.INSTANCE.playDelayed(Assets.Sounds.HIT_PILE, 0.4f);
			Sample.INSTANCE.playDelayed(Assets.Sounds.HIT_GLANCE, 0.7f);
			return dmg;
		}

		int random = Random.Int(10);
		if (random == 1) {
			doDrop((Hero) attacker);
		} else if (random == 2) {
			doUnequip((Hero) attacker, true);
		} else if (random == 3) {
			dropOnEnemy((Hero) attacker, defender);
		}
		GLog.w( Messages.get(this, "unequip") );

		return dmg;
	}

	public void dropOnEnemy( Hero hero, Char enemy ) {
		doUnequip(hero, false);
		hero.spendAndNext(TIME_TO_DROP);
		int pos = enemy.pos;
		Dungeon.level.drop(detachAll(hero.belongings.backpack), pos).sprite.drop(pos);
	}

}
