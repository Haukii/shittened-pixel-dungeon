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

package com.shatteredpixel.shatteredpixeldungeon.items.scrolls;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.YogDzewa;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class ScrollOfShit extends Scroll {

	{
		icon = ItemSpriteSheet.Icons.SCROLL_SHIT;
	}

	@Override
	public void doRead() {
		
//		curUser.sprite.centerEmitter().start( Speck.factory( Speck.BIGPARTICLE ), 0.3f, 5 );
		Sample.INSTANCE.play( Assets.Sounds.TURD );

		int spawnedPiecesOfShit = spawnShits(curUser, (int) Math.ceil(Dungeon.depth / 5d));

		if (spawnedPiecesOfShit > 0) {
			identify();
		}

		GLog.i( Messages.get(this, "shit") );

		readAnimation();
	}

	public static int spawnShits(Hero hero, int nShits ){

		ArrayList<Integer> respawnPoints = new ArrayList<>();

		for (int i = 0; i < PathFinder.NEIGHBOURS8.length; i++) {
			int p = hero.pos + PathFinder.NEIGHBOURS8[i];
			if (Actor.findChar( p ) == null && Dungeon.level.passable[p]) {
				respawnPoints.add( p );
			}
		}

		int spawned = 0;
		while (nShits > 0 && respawnPoints.size() > 0) {
			int index = Random.index( respawnPoints );

			YogDzewa.Larva shit = new YogDzewa.Larva();
			shit.ally = true;
			shit.alignment = Char.Alignment.ALLY;
			shit.state = shit.HUNTING;
			shit.HP = shit.HT = hero.HT / 2;
			GameScene.add( shit );
			ScrollOfTeleportation.appear( shit, respawnPoints.get( index ) );

			respawnPoints.remove( index );
			nShits--;
			spawned++;
			if (spawned > 1)
				Sample.INSTANCE.playDelayed( Assets.Sounds.TURD, spawned / 7f, 1f, 1f + spawned / 10f );
		}

		return spawned;
	}
	
	@Override
	public int value() {
		return isKnown() ? 40 * quantity : super.value();
	}
}
