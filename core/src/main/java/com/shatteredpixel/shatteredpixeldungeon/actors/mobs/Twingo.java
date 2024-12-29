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
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Blindness;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.items.albums.TwingoAlbum;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.MusicPlayer;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.Car;
import com.shatteredpixel.shatteredpixeldungeon.sprites.TwingoSprite;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Twingo extends Mob {

	{
		spriteClass = Random.oneOf(TwingoSprite.Yellow.class,TwingoSprite.Green.class,TwingoSprite.Blue.class);
		
		HP = HT = 60;
		defenseSkill = 9;

		EXP = 7;
		maxLvl = 15;
		properties.add(Property.INORGANIC);
	}

	@Override
	protected boolean act() {
		return super.act();
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 6, 12 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 14;
	}

	@Override
	public int attackProc(Char enemy, int damage) {
		Buff.affect(enemy, Blindness.class, 2f);
		Sample.INSTANCE.play(Assets.Sounds.HORN, 1f, Random.Float(0.85f, 1.15f));
		return super.attackProc(enemy, damage);
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 4);
	}

	@Override
	public void die(Object cause) {
		MusicPlayer player = Dungeon.hero.belongings.getItem( MusicPlayer.class );
		if (player != null && Dungeon.LimitedDrops.TWINGO_ALBUM.count == 0) {
			Dungeon.level.drop( new TwingoAlbum(), pos ).sprite.drop();
			Dungeon.LimitedDrops.TWINGO_ALBUM.count++;
		}
		if (Random.Int(15) == 2) {
			Dungeon.level.drop( new Car(), pos ).sprite.drop();
		}
		super.die(cause);
	}

	public static class YellowTwingo extends Twingo {
		{
			spriteClass = TwingoSprite.Yellow.class;
		}
	}

	public static class BlueTwingo extends Twingo {
		{
			spriteClass = TwingoSprite.Blue.class;
		}
	}

	public static class GreenTwingo extends Twingo {
		{
			spriteClass = TwingoSprite.Green.class;
		}
	}

	public static Class<? extends Twingo> random() {
		return Random.oneOf(YellowTwingo.class, BlueTwingo.class, GreenTwingo.class);
	}
}
