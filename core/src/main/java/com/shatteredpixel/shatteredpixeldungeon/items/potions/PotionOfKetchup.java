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

package com.shatteredpixel.shatteredpixeldungeon.items.potions;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.Blob;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.KetchupGas;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Ketchup;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;

public class PotionOfKetchup extends Potion {
	
	{
		icon = ItemSpriteSheet.Icons.POTION_KET;
	}
	
	@Override
	public void apply(Hero hero) {
		identify();
		
		GLog.w( Messages.get(this, "tasty") );
		Buff.prolong( hero, Ketchup.class, Ketchup.DURATION);
		Buff.affect(hero, Hunger.class).satisfy(50f);
	}


	@Override
	public void shatter( int cell ) {

		if (Dungeon.level.heroFOV[cell]) {
			identify();

			splash( cell );
			Sample.INSTANCE.play( Assets.Sounds.SHATTER );
			Sample.INSTANCE.play( Assets.Sounds.GAS, 0.8f );
			Sample.INSTANCE.play( Assets.Sounds.TURD, 0.7f );
		}

		GameScene.add( Blob.seed( cell, 500, KetchupGas.class ) );

	}

	@Override
	public String desc() {
		if (color.equalsIgnoreCase("maroon") || color.equalsIgnoreCase("crimson")) {
			return Messages.get(PotionOfKetchup.class, "desc_red");
		}
		return super.desc();
	}

	@Override
	public int value() {
		return isKnown() ? 30 * quantity : super.value();
	}
}
