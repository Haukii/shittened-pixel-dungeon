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

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.albums.SynthAlbum;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.MusicPlayer;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.UnstableBrew;
import com.shatteredpixel.shatteredpixeldungeon.sprites.RGBCrabSprite;
import com.watabou.utils.Random;

public class RGBCrab extends Crab {

	{
		spriteClass = RGBCrabSprite.class;
		
		HP = HT = 12;
		defenseSkill = 6;
		baseSpeed = 1.5f;
		
		EXP = 3;
		
		loot = UnstableBrew.class;
		lootChance = 0.5f;
	}

	@Override
	public void die(Object cause) {
		MusicPlayer player = Dungeon.hero.belongings.getItem( MusicPlayer.class );
		if (player != null && Dungeon.LimitedDrops.SYNTH_ALBUM.count == 0) {
			Dungeon.level.drop( new SynthAlbum(), pos ).sprite.drop();
			Dungeon.LimitedDrops.SYNTH_ALBUM.count++;
		}
		super.die(cause);
	}

	@Override
	public int attackSkill( Char target ) {
		return 14;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 5);
	}
}
