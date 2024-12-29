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

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.Statistics;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Haste;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.Ratmogrify;
import com.shatteredpixel.shatteredpixeldungeon.items.albums.RatAlbum;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.MusicPlayer;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.RatSprite;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class Rat extends Mob {

	{
		spriteClass = RatSprite.class;
		
		HP = HT = 8;
		defenseSkill = 2;

		maxLvl = 5;
	}

	@Override
	protected boolean act() {
		if (Dungeon.level.heroFOV[pos] && Dungeon.hero.armorAbility instanceof Ratmogrify){
			alignment = Alignment.ALLY;
			if (state == SLEEPING) state = WANDERING;
		}
		if (Dungeon.level.heroFOV[pos] && Random.Int(90) == 1 && state == HUNTING) {
			Buff.affect(this, Haste.class,1f);
			Sample.INSTANCE.playForDuration( Assets.Sounds.FREE_RAT, Random.NormalFloat(0.2f, Random.Float(1f,4f)) );
		}
		return super.act();
	}

	@Override
	public void die(Object cause) {
		super.die(cause);
		Statistics.ratsSlain++;
		Badges.validateRats();
		if (Random.Int(0,18) == 2) {
			GameScene.ratSlain();
		}
		MusicPlayer player = Dungeon.hero.belongings.getItem( MusicPlayer.class );
		if (player != null && Dungeon.LimitedDrops.RAT_ALBUM.count == 0 && Random.Int(10) == 5) {
			Dungeon.level.drop( new RatAlbum(), pos ).sprite.drop();
			Dungeon.LimitedDrops.RAT_ALBUM.count++;
		}
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 1, 4 );
	}
	
	@Override
	public int attackSkill( Char target ) {
		return 8;
	}
	
	@Override
	public int drRoll() {
		return super.drRoll() + Random.NormalIntRange(0, 1);
	}

	private static final String RAT_ALLY = "rat_ally";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		if (alignment == Alignment.ALLY) bundle.put(RAT_ALLY, true);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		if (bundle.contains(RAT_ALLY)) alignment = Alignment.ALLY;
	}

	public static Class<? extends Rat> random(int depth) {
		float roll = Random.Float();
		if (roll < 0.05f && depth > 10) {
			return GlitchRat.class;
		}
		if (roll < 0.92f) {
			return Rat.class;
		} else if (roll < 0.95f) {
			return NormalRat.class;
		} else if (roll < 0.98f) {
			return Ratatouille.class;
		} else {
			return HeroRat.class;
		}
	}
}
