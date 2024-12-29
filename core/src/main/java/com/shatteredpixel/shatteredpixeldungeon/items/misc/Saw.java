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

package com.shatteredpixel.shatteredpixeldungeon.items.misc;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.noosa.audio.Sample;

public class Saw extends Item {
	
	{
		image = ItemSpriteSheet.SAW;
		stackable = false;
	}
	
	@Override
	public boolean isUpgradable() {
		return false;
	}
	
	@Override
	public boolean isIdentified() {
		return true;
	}
	
	@Override
	public int value() {
		return quantity * 90;
	}

	@Override
	public void doDrop(Hero hero) {
		if (hero.pos == 201 && Dungeon.depth == 0) {
//			GLog.p("IT WAS CUT!");
			Sample.INSTANCE.play(Assets.Sounds.HIT_STAB, 0.6f);
			Level.set(111, Terrain.UNLOCKED_EXIT);
			GameScene.updateMap( 111 );
		}
		super.doDrop(hero);
	}

//	@Override
//	protected void onThrow(int cell) {
//		if (cell == 201 && Dungeon.depth == 0) {
////			GLog.p("IT WAS CUT!");
//			Sample.INSTANCE.play(Assets.Sounds.HIT_STAB, 0.6f);
//			Level.set(111, Terrain.UNLOCKED_EXIT);
//			SurfaceLevel level = (SurfaceLevel) Dungeon.level;
//			level.fenceBroken  = true;
//			GameScene.updateMap( 111 );
//		}
//		super.onThrow(cell);
//	}
}
