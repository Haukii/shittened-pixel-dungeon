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
import com.shatteredpixel.shatteredpixeldungeon.items.EnergyCrystal;
import com.shatteredpixel.shatteredpixeldungeon.items.albums.NonsenseAlbum;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.MusicPlayer;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.GlitchRatSprite;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

import java.util.Arrays;
import java.util.List;

public class GlitchRat extends Rat {

	{
		spriteClass = GlitchRatSprite.class;

		HP = HT = 25;
		defenseSkill = 6;

		EXP = 4;
		maxLvl = 24;
		
		loot = null;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 4, 16 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 20;
	}

	@Override
	public String description() {
		StringBuilder desc = new StringBuilder();

		List<String> letters = Arrays.asList("a", "a", "e", "e", "i", "i", "o", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
		"l","m","n","o","p","q","r","s","t","w","v","y","z"," ", " ", " ", " ");

		int i = Random.Int(20, 200);
		while (i > 0) {
			desc.append(letters.get(Random.Int(0, letters.size())));
			if (Random.Int(80) == 38) {
				desc.append(". ");
			}

			i--;
		}
		return Messages.capitalize(desc.toString());
	}

	@Override
	public void die(Object cause) {
		super.die(cause);
		Sample.INSTANCE.play(Assets.Sounds.all[Random.Int(Assets.Sounds.all.length)], 1f, Random.Float(0.4f, 0.8f));
		Dungeon.level.drop(new EnergyCrystal(Dungeon.depth / 4 + Random.Int(0,4)), pos).sprite.drop();
		MusicPlayer player = Dungeon.hero.belongings.getItem( MusicPlayer.class );
		if (player != null && Dungeon.LimitedDrops.NONSENSE_ALBUM.count == 0) {
			Dungeon.level.drop( new NonsenseAlbum(), pos ).sprite.drop();
			Dungeon.LimitedDrops.NONSENSE_ALBUM.count++;
		}
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 8);
	}
}
