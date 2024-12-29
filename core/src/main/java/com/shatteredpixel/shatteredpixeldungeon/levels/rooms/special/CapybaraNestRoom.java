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
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Capybara;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Minibara;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.IronKey;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.levels.SewerLevel;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.shatteredpixel.shatteredpixeldungeon.levels.rooms.Room;
import com.shatteredpixel.shatteredpixeldungeon.levels.rooms.standard.entrance.EntranceRoom;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.tiles.CustomTilemap;
import com.watabou.noosa.Tilemap;
import com.watabou.utils.Point;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

public class CapybaraNestRoom extends SpecialRoom {
	@Override
	public void paint(Level level) {

		this.forceSize(4,4);
		Painter.fill( level, this, Terrain.WALL );
		Painter.fill( level, this, 1, Terrain.EMPTY );

		Door door = entrance();
		door.set( Door.Type.LOCKED );
		level.addItemToSpawn( new IronKey( Dungeon.depth ) );

		int rand = Random.Int(2,4);
		for (int i = 0; i < rand; i++) {
			int pos = level.pointToCell(random());
			Mob capybara = Reflection.newInstance(Capybara.random());
			capybara.state = capybara.SLEEPING;
			capybara.pos = pos;
			level.mobs.add( capybara );
		}
		for (int i = 0; i < 5; i++) {
			int pos = level.pointToCell(random());
			Minibara minibara = new Minibara();
			minibara.state = minibara.SLEEPING;
			minibara.pos = pos;
			level.mobs.add( minibara );
		}

		CustomTilemap vis = new NestTiles();
		vis.pos( center().x -1, center().y -1);
		level.customTiles.add(vis);

	}

	@Override
	public boolean connect(Room room) {
		//cannot connect to entrance, otherwise works normally
		if (room instanceof EntranceRoom) return false;
		else                              return super.connect(room);
	}

	public static class NestTiles extends CustomTilemap {

		{
			texture = Assets.Environment.CAPYNEST_SP;

			tileW = 4;
			tileH = 4;
		}

		private static final int[] map = new int[]{
				0, 1, 2,  3,
				4, 5, 6,  7,
				8, 9, 10, 11,
				12, 13, 14, 15
		};

		public String name(int tileX, int tileY) {
			return Messages.get(SewerLevel.class, "nest_name");
		}

		public String desc(int tileX, int tileY) {
			return Messages.get(SewerLevel.class, "nest_desc");
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
