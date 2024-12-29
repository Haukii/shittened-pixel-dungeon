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

package com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic;

import com.badlogic.gdx.utils.IntMap;
import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Dread;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Terror;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.YogDzewa;
import com.shatteredpixel.shatteredpixeldungeon.effects.CellEmitter;
import com.shatteredpixel.shatteredpixeldungeon.effects.Flare;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.EarthParticle;
import com.shatteredpixel.shatteredpixeldungeon.items.Heap;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;
import com.watabou.utils.SparseArray;

public class ScrollOfEnshittification extends ExoticScroll {
	
	{
		icon = ItemSpriteSheet.Icons.SCROLL_ENSHIT;
	}
	
	@Override
	public void doRead() {
		new Flare( 9, 64 ).color( 0x654924, true ).show( curUser.sprite, 1.5f );
		new Flare( 12, 48 ).color( 0x553914, false ).show( curUser.sprite, 1f );
		Sample.INSTANCE.play( Assets.Sounds.READ );

		for (Mob mob : Dungeon.level.mobs.toArray( new Mob[0] )) {
			if (mob.alignment != Char.Alignment.ALLY) {
				if (!mob.isImmune(Dread.class)){
					YogDzewa.Larva shit = shit();
					shit.pos = mob.pos;

					mob.sprite.die();
					mob.destroy();
					GameScene.add(shit);
					CellEmitter.get(mob.pos).burst(EarthParticle.FACTORY, 5 );
				} else {
					Buff.affect( mob, Terror.class, Terror.DURATION ).object = curUser.id();
				}
			}
		}

		SparseArray<Heap> heaps = new SparseArray<>();
		heaps = Dungeon.level.heaps;
		try {
			for (IntMap.Entry<Heap> heapEntry : heaps) {
				if (heapEntry.value == null)
					continue;
				YogDzewa.Larva shit = shit();
				shit.pos = heapEntry.value.pos;
				GameScene.add(shit);
				heapEntry.value.destroy();
			}
		} catch (Exception e) {
			GLog.n("ERROR:" + e + "    " + e.getMessage());
		}

		identify();

		readAnimation();
	}
	private YogDzewa.Larva shit() {
		YogDzewa.Larva shit = new YogDzewa.Larva();
		shit.ally = true;
		shit.alignment = Char.Alignment.ALLY;
		shit.state = shit.WANDERING;
		shit.HP = shit.HT = Dungeon.hero.HT / 2;

		Sample.INSTANCE.play(Assets.Sounds.TURD, 1f, Random.Float(0.8f, 1.1f));

		return shit;
	}
}
