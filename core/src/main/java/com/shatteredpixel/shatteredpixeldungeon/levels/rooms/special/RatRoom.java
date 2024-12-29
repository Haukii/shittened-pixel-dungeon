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

package com.shatteredpixel.shatteredpixeldungeon.levels.rooms.special;


import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.DemonRat;
import com.shatteredpixel.shatteredpixeldungeon.levels.HallsLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.shatteredpixel.shatteredpixeldungeon.levels.rooms.Room;
import com.shatteredpixel.shatteredpixeldungeon.levels.rooms.standard.entrance.EntranceRoom;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.tiles.CustomTilemap;
import com.watabou.noosa.Tilemap;
import com.watabou.utils.Point;

public class RatRoom extends SpecialRoom {
	@Override
	public void paint(Level level) {

		Painter.fill( level, this, Terrain.WALL );
		Painter.fill( level, this, 1, Terrain.EMPTY );

		Point c = center();
		int cx = c.x;
		int cy = c.y;

		Door door = entrance();
		door.set(Door.Type.UNLOCKED);

		DemonRat rat = new DemonRat();
		rat.state = rat.SLEEPING;
		rat.HP = rat.HT = 200;
		rat.pos = cx + cy * level.width();
		level.mobs.add( rat );

		CustomTilemap vis = new RatTiles();
		vis.pos( center().x -1, center().y -1);
		level.customTiles.add(vis);

	}

	@Override
	public boolean connect(Room room) {
		//cannot connect to entrance, otherwise works normally
		if (room instanceof EntranceRoom) return false;
		else                              return super.connect(room);
	}

	public static class RatTiles extends CustomTilemap {

		{
			texture = Assets.Environment.RATROOM_SP;

			tileW = 3;
			tileH = 3;
		}

		private static final int[] map = new int[]{
				0, 1, 2,
				4, 5, 6,
				8, 9, 10
		};

		public String name(int tileX, int tileY) {
			return Messages.get(HallsLevel.class, "rat");
		}

		public String desc(int tileX, int tileY) {
			return Messages.get(HallsLevel.class, "rat_desc");
		}

		@Override
		public Tilemap create() {
			Tilemap v = super.create();
			updateState();
			return v;
		}

		private void updateState() {
			if (vis != null) {
				int[] data = map.clone();
				vis.map(data, tileW);
			}
		}
	}

	@Override
	public boolean canPlaceTrap(Point p) {
		return false;
	}

	@Override
	public boolean canPlaceWater(Point p) {
		return false;
	}

	@Override
	public boolean canPlaceGrass(Point p) {
		return false;
	}
}
