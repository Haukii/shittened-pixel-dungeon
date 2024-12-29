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
import com.shatteredpixel.shatteredpixeldungeon.mechanics.HairColor;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.HeroSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndOptions;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SprayPaint extends Item {


	{
		image = ItemSpriteSheet.SPRAYPAINT;
		defaultAction = AC_USE;
		stackable = true;
	}

	private final HairColor[] colors  = new HairColor[4];

	public SprayPaint() {
		//the generation is buggy
		generateOptions(Dungeon.hero);
	}

	public static final String AC_USE = "USE";

	public void execute(Hero hero, String action) {

		super.execute(hero, action);

//													Game.runOnRenderThread(new Callback() {
//														@Override
//														public void call() {
//															GameScene.show( new WndBlacksmith( new Blacksmith(), Dungeon.hero ) );
//														}
//													});
//													if (Dungeon.hero != null) return;

		if (action.equals(AC_USE)) {

			if(colors[0] == null) {
				generateOptions(hero);
			}

			GameScene.show(new WndOptions(new ItemSprite(SprayPaint.this),
					Messages.titleCase(SprayPaint.this.name()),
					Messages.get(SprayPaint.class, "choose"),
					colors[0].name(),
					colors[1].name(),
					colors[2].name(),
					colors[3].name(),
					Messages.get(SprayPaint.class, "cancel")){

				@Override
				protected void onSelect(int index) {
					if (index < 4) {
						hero.hairColor(colors[index]);
						 ((HeroSprite)hero.sprite).updateHair(colors[index].ID());
						GLog.p(Messages.get(SprayPaint.class, "painted", colors[index].colorName().toLowerCase(Locale.ROOT)));
						Sample.INSTANCE.play( Assets.Sounds.SPRAY );
						generateOptions(hero);
						detach(hero.belongings.backpack);
					}
				}
			});
		}
	}

	private void generateOptions(Hero hero) {
		List<HairColor> existing = new ArrayList<>();
		if (hero != null)
			existing.add(hero.hairColor());
		else
			existing.add(HairColor.DEFAULT);
		for (int i = 0; i < colors.length; i++) {
			colors[i] = HairColor.random(existing);
			existing.add(colors[i]);
		}
	}

	@Override
	public ArrayList<String> actions(Hero hero) {
		ArrayList<String> actions = super.actions(hero);
		actions.add(AC_USE);
		return actions;
	}

	private static final String COLOR_0 = "COLOR_0";
	private static final String COLOR_1 = "COLOR_1";
	private static final String COLOR_2 = "COLOR_2";
	private static final String COLOR_3 = "COLOR_3";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(COLOR_0, colors[0] );
		bundle.put(COLOR_1, colors[1] );
		bundle.put(COLOR_2, colors[2] );
		bundle.put(COLOR_3, colors[3] );
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		if (bundle.getEnum(COLOR_0, HairColor.class) != null) {
			colors[0] = bundle.getEnum(COLOR_0, HairColor.class);
			colors[1] = bundle.getEnum(COLOR_1, HairColor.class);
			colors[2] = bundle.getEnum(COLOR_2, HairColor.class);
			colors[3] = bundle.getEnum(COLOR_3, HairColor.class);
		}
	}

	@Override
	public int value() {
		return 30;
	}
	
	@Override
	public boolean isUpgradable() {
		return false;
	}
	
	@Override
	public boolean isIdentified() {
		return true;
	}
}
