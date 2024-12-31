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
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.NPC;
import com.shatteredpixel.shatteredpixeldungeon.effects.CellEmitter;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.SmokeParticle;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.VeggieBag;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Milk;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.AdventurerSprite;
import com.watabou.noosa.audio.Sample;
import com.watabou.noosa.particles.Emitter;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class Adventurer extends NPC {

	{
		defenseSkill = 4;
		
		maxLvl = 5;
		alignment = Alignment.NEUTRAL;
		baseSpeed = 0.8f;
		state = WANDERING;
		properties.add(Property.HUMAN);
		//Default texture for instantiatiaing from class
		spriteClass = AdventurerSprite.Blond.class;
	}

	int stateTime = 0;
	int allyTime = 0;

//	boolean questgiver;

//	Adventurer() {
//		if (Random.Float() < 0.2f) {
//			questgiver = true;
//		}
//	}

	@Override
	protected boolean act() {

		if (pos == Dungeon.level.exit() && Dungeon.hero.fieldOfView != null && Dungeon.hero.fieldOfView[pos]) {
			Sample.INSTANCE.play(Assets.Sounds.STAIRS_1, 0.7f);
			Emitter e = CellEmitter.get(pos);
			e.burst( SmokeParticle.FACTORY, 20 );
			sprite.kill();
			remove(this);
		}

		if (stateTime == 0) {
			if (Random.Int(15) == 5) {
				alignment = Alignment.ALLY;
				stateTime += 10;
			} else {
				alignment = Alignment.NEUTRAL;
				stateTime += 15;
			}
		}
		if (stateTime > 0) {
			stateTime--;
		}


		if (Random.Int(30) == 12) {
			spend(5f);
		}

		if (state == WANDERING && Dungeon.hero.fieldOfView != null && Dungeon.hero.fieldOfView[pos] && Random.Int(30) == 15) {
			talk(Messages.get(Adventurer.class, "mumble_" + Random.Int(28)));
		}

		if (alignment == Alignment.ALLY) {
			allyTime--;
			if (allyTime == 0) {
				alignment = Alignment.NEUTRAL;
			}
		}

		return super.act();
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 1, 4 );
	}
	
	@Override
	public int attackSkill( Char target ) {
		return 8;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 1);
	}

	@Override
	public void damage(int dmg, Object src) {
		super.damage(dmg, src);
		if (HP <= 0) return;
		if (src == Dungeon.hero && HP <= HT / 2) {
			stateTime = dmg;
			alignment = Alignment.ENEMY;
			yell(Messages.get(Adventurer.class, "damage_" + Random.Int(4)));
		} else if (src == Dungeon.hero) {
			yell(Messages.get(Adventurer.class, "pain_" + Random.Int(4)));
		}
		if (src != Dungeon.hero) {
			alignment = Alignment.ALLY;
			allyTime = dmg;
		}
	}

	@Override
	protected Char chooseEnemy() {
		if (Random.Float() > 0.7f || HP <= HT - 5) {
			return super.chooseEnemy();
		}
		return null;
	}

	private static final String STATE_TIME = "STATE_TIME";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(STATE_TIME, stateTime);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		stateTime = bundle.getInt(STATE_TIME);
	}

	@Override
	public void die(Object cause) {
		super.die(cause);
		if (Dungeon.hero.fieldOfView[pos]) {
			talk(Messages.get(Adventurer.class, "die_" + Random.Int(5)));
		}
		if (Random.Float() < 0.4f) {
			Dungeon.level.drop( new Milk(), pos).sprite.drop( pos );
		}
		if (Random.Float() < 0.4f) {
			Dungeon.level.drop( new VeggieBag(), pos).sprite.drop( pos );
		}
	}

	int timesInteracted = 0;

	@Override
	public boolean interact(Char c) {
		sprite.turnTo(pos, Dungeon.hero.pos);

		sprite.idle();

//		Game.runOnRenderThread(new Callback() {
//			@Override
//			public void call() {
//				GameScene.show( new WndQuest( Adventurer.this,
//						"TAUU") {
//
//					@Override
//					public void onBackPressed() {
//						super.onBackPressed();
//					}
//				} );
//			}
//		});

		if (c != Dungeon.hero) {
			return true;
		}
		if (timesInteracted < 11) {
			talk(Messages.get(Adventurer.class, "interact_" + Random.Int(30)));
		} else {
			talk(Messages.get(Adventurer.class, "bored_" + Random.Int(5)));
		}

		timesInteracted += Random.Int(1,4);

		return true;
	}

	public static class BlondAdventurer extends Adventurer {
		{
			spriteClass = AdventurerSprite.Blond.class;
			HP = HT = 20;
		}
	}

	public static class RedAdventurer extends Adventurer {
		{
			spriteClass = AdventurerSprite.Red.class;
			HP = HT = 15;
		}
	}

	public static class BlackAdventurer extends Adventurer {
		{
			spriteClass = AdventurerSprite.Black.class;
			HP = HT = 13;
		}
	}

	public static class WheatAdventurer extends Adventurer {
		{
			spriteClass = AdventurerSprite.Wheat.class;
			HP = HT = 17;
		}
	}

	public static class BrownAdventurer extends Adventurer {
		{
			spriteClass = AdventurerSprite.Brown.class;
			HP = HT = 18;
		}
	}

	public static class DarkAdventurer extends Adventurer {
		{
			spriteClass = AdventurerSprite.Dark.class;
			HP = HT = 22;
		}
	}

	public static class GreyAdventurer extends Adventurer {
		{
			spriteClass = AdventurerSprite.Grey.class;
			HP = HT = 12;
		}
	}

	public static Class<? extends Adventurer> random() {
		return Random.oneOf(BlondAdventurer.class, RedAdventurer.class,
				BlackAdventurer.class, WheatAdventurer.class, BrownAdventurer.class,
				DarkAdventurer.class, GreyAdventurer.class);
	}
}


