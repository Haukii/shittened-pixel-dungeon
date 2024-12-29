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

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.ArcaneResin;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.Recipe;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class PinkAmulet extends Item {
	
	{
		image = ItemSpriteSheet.PINKAMULET;
		
		stackable = false;
		unique = true;
	}

	@Override
	public int value() {
		return 120;
	}

	@Override
	public void doDrop(Hero hero) {
		super.doDrop(hero);
		changeMusic();
	}

	@Override
	protected void onThrow(int cell) {
		super.onThrow(cell);
		changeMusic();
	}

	@Override
	public boolean doPickUp(Hero hero, int pos) {
		boolean picked = super.doPickUp(hero, pos);
		if (picked) {
			changeMusic();
		}
		return picked;
	}

	private void changeMusic() {
		if (Dungeon.depth > 19) {
			Dungeon.level.playLevelMusic();
		}
	}

	@Override
	public boolean isUpgradable() {
		return false;
	}
	
	@Override
	public boolean isIdentified() {
		return true;
	}

	public static class Craft extends Recipe.SimpleRecipe{
		{
			inputs =  new Class[]{SilverAmulet.class, ArcaneResin.class};
			inQuantity = new int[]{1, 1};

			cost = 4;

			output = PinkAmulet.class;
			outQuantity = 1;
		}
	}
}
