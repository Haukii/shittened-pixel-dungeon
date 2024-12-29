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

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.Blob;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.CorrosiveGas;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.ParalyticGas;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Amok;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Dread;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Paralysis;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Sleep;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Terror;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Vertigo;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.LootBag;
import com.shatteredpixel.shatteredpixeldungeon.mechanics.LootGenerator;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.GlassBoxSprite;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class Glassbox extends Mob {

	{
		spriteClass = GlassBoxSprite.class;

		HP = HT = 7;

		EXP = 0;

		properties.add(Property.INORGANIC);
		properties.add(Property.IMMOVABLE);

		state = PASSIVE;
		alignment = Alignment.NEUTRAL;
	}

	@Override
	protected boolean act() {
		alerted = false;
		spend(1f);
		super.act();

		return true;
	}

	@Override
	public void damage(int dmg, Object src) {
		super.damage(dmg, src);
	}

	@Override
	public void beckon(int cell) {
		//do nothing
	}

	@Override
	public void move(int step, boolean travelling) {
		//do nothing
	}

	@Override
	public boolean interact(Char c) {
		return true;
	}

	@Override
	public void die(Object cause) {
		Sample.INSTANCE.play(Assets.Sounds.SHATTER, 2f, Random.Float(0.9f, 1.1f));

		if (Random.Float() > 0.2f) {
			Dungeon.level.drop(new LootBag(), pos).sprite.drop();
		} else {
			Dungeon.level.drop(LootGenerator.rollItem(), pos).sprite.drop();
			GameScene.add(Blob.seed(pos, 5, CorrosiveGas.class).setStrength(8));
			GameScene.add(Blob.seed(pos, 5, ParalyticGas.class));
		}

		super.die(cause);


	}

	private static final String ALIGNMENT = "alignment";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(ALIGNMENT, alignment);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		alignment = bundle.getEnum(ALIGNMENT, Alignment.class);
	}

	{
		immunities.add( Paralysis.class );
		immunities.add( Amok.class );
		immunities.add( Sleep.class );
		immunities.add( Terror.class );
		immunities.add( Dread.class );
		immunities.add( Vertigo.class );
	}

}
