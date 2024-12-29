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

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.SlotMachineSprite;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndSlotMachine;
import com.watabou.noosa.Game;
import com.watabou.utils.Callback;

public class SlotMachine extends NPC {

	{
		spriteClass = SlotMachineSprite.class;

		properties.add(Property.INORGANIC);
		properties.add(Property.IMMOVABLE);

		state = PASSIVE;
		alignment = Alignment.NEUTRAL;
	}

	@Override
	protected boolean act() {
		return super.act();
	}

	@Override
	public boolean interact(Char c) {

		Game.runOnRenderThread(new Callback() {
			@Override
			public void call() {
				GameScene.show(new WndSlotMachine(SlotMachine.this));
			}
		});
		return true;
	}
}
