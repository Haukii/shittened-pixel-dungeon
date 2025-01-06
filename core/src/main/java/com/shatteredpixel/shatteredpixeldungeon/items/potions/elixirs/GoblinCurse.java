/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2024 Evan Debenham
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

package com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.ToxicImbue;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Goblin;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.effects.CellEmitter;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.PoisonParticle;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.WoolParticle;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.Warriorium;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfCorrosiveGas;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class GoblinCurse extends Elixir {
	
	{
		image = ItemSpriteSheet.GOBLIN_CURSE;
	}
	
	@Override
	public void apply(Hero hero) {
		hero.sprite.emitter().burst(PoisonParticle.SPLASH, 10);
		int size = Dungeon.level.width() * Dungeon.level.height();
		try {
			for (int i = 0; i < 5 + Dungeon.depth + Dungeon.hero.lvl; i++) {
				Goblin goblin = Goblin.random();
				goblin.pos = Dungeon.level.randomRespawnCell(goblin);
				goblin.state = goblin.WANDERING;
				GameScene.add(goblin);
				if (Random.Float() > 0.3f) {
					goblin.beckon(Dungeon.hero.pos);
				}
				if (Dungeon.hero.fieldOfView[goblin.pos]) {
					CellEmitter.get(goblin.pos).burst(WoolParticle.FACTORY, 5);
					Sample.INSTANCE.play(Assets.Sounds.VINEBOOM, 0.5f, Random.Float(0.7f, 1.3f));
				}
			}
		} catch (ArrayIndexOutOfBoundsException AAAH) {
			GLog.w(Messages.get(this, "error"));
		}
	}
	
	public static class Recipe extends com.shatteredpixel.shatteredpixeldungeon.items.Recipe.SimpleRecipe {
		
		{
			inputs =  new Class[]{PotionOfCorrosiveGas.class, Warriorium.class};
			inQuantity = new int[]{1,1};
			
			cost = 4;
			
			output = GoblinCurse.class;
			outQuantity = 1;
		}
		
	}
	
}
