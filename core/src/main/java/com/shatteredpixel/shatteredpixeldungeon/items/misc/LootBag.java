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
import com.shatteredpixel.shatteredpixeldungeon.effects.Flare;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.Armor;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.Ring;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.Wand;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.MeleeWeapon;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.MissileWeapon;
import com.shatteredpixel.shatteredpixeldungeon.mechanics.LootGenerator;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.tiles.DungeonTilemap;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.List;

public class LootBag extends Item {

	{
		image = ItemSpriteSheet.BIGBAG;

		defaultAction = AC_OPEN;
		stackable = true;
	}

	@Override
	public boolean isIdentified() {
		return true;
	}

	public static final String AC_OPEN = "OPEN";

	public void execute(Hero hero, String action) {

		super.execute(hero, action);

		if (action.equals(AC_OPEN)) {
			detach(hero.belongings.backpack);
			List<Item> items = new ArrayList<>();
			try {
				items = LootGenerator.rollItems(Random.Int(2,6));
			} catch (Exception e) {
				Messages.get(this, "error", e);
			}

			StringBuilder nameBuilder = new StringBuilder();
			for (Item item : items) {
				int attempts = 30;
				int pos;
				do {
					pos = Dungeon.hero.pos + PathFinder.NEIGHBOURS9[Random.Int(9)];
					attempts--;
				} while (!(Dungeon.level.passable[pos] || Dungeon.level.pit[pos]) || attempts > 1);
				if (attempts == 0) pos = Dungeon.hero.pos;

				if (item instanceof MeleeWeapon || item instanceof Armor
						|| item instanceof MissileWeapon || item instanceof Ring || item instanceof Wand) {
					if (Random.Float() > 0.6f) {
						item.upgrade();
						Flare flare = new Flare(6, 15);
						flare.color(0x2ee62e);
						if (Random.Float() > 0.7f) {
							item.upgrade();
							flare.color(0xa15ce5);
							if (Random.Float() > 0.8f) {
								item.upgrade();
								flare.color(0xdfff40);
								if (Random.Float() > 0.8f) {
									item.upgrade(Random.Int(1,3));
									flare.color(0xe40f0f);
									flare.angularSpeed += 30f;
								}
							}
						}
						flare.show(Dungeon.hero.sprite.parent, DungeonTilemap.tileCenterToWorld(pos), 1.5f);
					}
				}

				Dungeon.level.drop( item, pos ).sprite.drop();
				nameBuilder.append(item.name()).append(", ");
			}
			if (nameBuilder.length() > 0) {
				String itemNames = nameBuilder.substring(0, nameBuilder.length() - 2);
				GLog.p(Messages.get(this, "open", itemNames));
			} else {
				GLog.n(Messages.get(this, "empty"));
			}

		}
	}


	@Override
	public ArrayList<String> actions(Hero hero) {
		ArrayList<String> actions = super.actions(hero);
		actions.add(AC_OPEN);
		return actions;
	}

	@Override
	public int value() {
		return 50;
	}
}
