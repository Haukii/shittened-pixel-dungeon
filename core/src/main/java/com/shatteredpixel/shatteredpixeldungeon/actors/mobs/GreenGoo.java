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

import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.Challenges;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.Statistics;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Barkskin;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Invisibility;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.LockedFloor;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Ooze;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.DriedRose;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.SkeletonKey;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.GooBlob;
import com.shatteredpixel.shatteredpixeldungeon.mechanics.Ballistica;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.plants.Fadeleaf;
import com.shatteredpixel.shatteredpixeldungeon.plants.Firebloom;
import com.shatteredpixel.shatteredpixeldungeon.plants.Icecap;
import com.shatteredpixel.shatteredpixeldungeon.plants.Starflower;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.GreenGooSprite;
import com.shatteredpixel.shatteredpixeldungeon.ui.BossHealthBar;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.Camera;
import com.watabou.utils.Bundle;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class GreenGoo extends Mob {

	{
		HP = HT = Dungeon.isChallenged(Challenges.STRONGER_BOSSES) ? 160 : 130;
		EXP = 10;
		defenseSkill = 7;
		spriteClass = GreenGooSprite.class;

		properties.add(Property.BOSS);
		properties.add(Property.DEMONIC);
		properties.add(Property.ACIDIC);
	}

	private int pumpedUp = 0;
	private int healInc = 1;

	@Override
	public int damageRoll() {
		int min = 1;
		int max = (HP*2 <= HT) ? 6 : 4;
		if (pumpedUp > 0) {
			pumpedUp = 0;
			if (enemy == Dungeon.hero) {
				Statistics.qualifiedForBossChallengeBadge = false;
				Statistics.bossScores[0] -= 100;
			}
			return Random.NormalIntRange( min*3, max*3 );
		} else {
			return Random.NormalIntRange( min, max );
		}
	}

	@Override
	public int attackSkill( Char target ) {
		int attack = 10;
		if (HP*2 <= HT) attack = 15;
		if (pumpedUp > 0) attack *= 2;
		return attack;
	}

	@Override
	public int defenseSkill(Char enemy) {
		return (int)(super.defenseSkill(enemy) * ((HP*2 <= HT)? 1.5 : 1));
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public boolean act() {

		if ((Dungeon.level.water[pos] || Dungeon.level.flamable[pos]) && HP < HT) {
			if (Random.Int(10) == 0) {
				GooBee bee = new GooBee();
				for (int i = 0; i < PathFinder.NEIGHBOURS8.length; i++) {
					int p = pos + PathFinder.NEIGHBOURS8[i];
					if (Actor.findChar( p ) == null && (Dungeon.level.passable[p] || Dungeon.level.avoid[p])) {
						bee.pos = p;
						GameScene.add(bee);
						break;
					}
				}
			}
			HP += healInc;
			Statistics.bossScores[0] -= 10;
			Statistics.qualifiedForBossChallengeBadge = false;

			LockedFloor lock = Dungeon.hero.buff(LockedFloor.class);
			if (lock != null) lock.removeTime(healInc*2);

			if (Dungeon.level.heroFOV[pos] ){
				sprite.emitter().burst( Speck.factory( Speck.HEALING ), healInc * 3 );
				sprite.emitter().burst( Speck.factory( Speck.HEART ), healInc );
			}
			if (Dungeon.isChallenged(Challenges.STRONGER_BOSSES) && healInc < 3) {
				healInc++;
			}
			if (HP*2 > HT) {
				BossHealthBar.bleed(false);
				((GreenGooSprite)sprite).spray(false);
				HP = Math.min(HP, HT);
			}
		} else {
			healInc = 1;
		}
		
		if (state != SLEEPING){
			Dungeon.level.seal();
		}

		return super.act();
	}

	@Override
	protected boolean canAttack( Char enemy ) {
		if (pumpedUp > 0){
			//we check both from and to in this case as projectile logic isn't always symmetrical.
			//this helps trim out BS edge-cases
			return Dungeon.level.distance(enemy.pos, pos) <= 2
						&& new Ballistica( pos, enemy.pos, Ballistica.PROJECTILE).collisionPos == enemy.pos
						&& new Ballistica( enemy.pos, pos, Ballistica.PROJECTILE).collisionPos == pos;
		} else {
			return super.canAttack(enemy);
		}
	}

	@Override
	public int attackProc( Char enemy, int damage ) {
		damage = super.attackProc( enemy, damage );
		if (Random.Int( 3 ) == 0) {
			Buff.affect( enemy, Ooze.class ).set( Ooze.DURATION / 2f );
			Buff.affect( enemy, Barkskin.class ).set(4,5);
			enemy.sprite.burst( 0x77d13d, 5 );
		}

		if (pumpedUp > 0) {
			Camera.main.shake( 3, 0.2f );
		}

		return damage;
	}

	@Override
	public void updateSpriteState() {
		super.updateSpriteState();

		if (pumpedUp > 0){
			((GreenGooSprite)sprite).pumpUp( pumpedUp );
		}
	}

	@Override
	protected boolean doAttack( Char enemy ) {
		if (pumpedUp == 1) {
			pumpedUp++;
			((GreenGooSprite)sprite).pumpUp( pumpedUp );

			spend( attackDelay() );

			return true;
		} else if (pumpedUp >= 2 || Random.Int( (HP*2 <= HT) ? 2 : 5 ) > 0) {

			boolean visible = Dungeon.level.heroFOV[pos];

			if (visible) {
				if (pumpedUp >= 2) {
					((GreenGooSprite) sprite).pumpAttack();
				} else {
					sprite.attack(enemy.pos);
				}
			} else {
				if (pumpedUp >= 2){
					((GreenGooSprite)sprite).triggerEmitters();
				}
				attack( enemy );
				spend( attackDelay() );
			}

			return !visible;

		} else {

			pumpedUp++;
			if (Dungeon.isChallenged(Challenges.STRONGER_BOSSES)){
				pumpedUp++;
			}

			((GreenGooSprite)sprite).pumpUp( pumpedUp );

			if (Dungeon.level.heroFOV[pos]) {
				sprite.showStatus( CharSprite.NEGATIVE, Messages.get(this, "!!!") );
				GLog.n( Messages.get(this, "pumpup") );
			}

			spend( attackDelay() );

			return true;
		}
	}

	@Override
	public boolean attack( Char enemy, float dmgMulti, float dmgBonus, float accMulti ) {
		boolean result = super.attack( enemy, dmgMulti, dmgBonus, accMulti );
		if (pumpedUp > 0) {
			pumpedUp = 0;
			if (enemy == Dungeon.hero) {
				Statistics.qualifiedForBossChallengeBadge = false;
				Statistics.bossScores[0] -= 100;
			}
		}
		return result;
	}

	@Override
	protected boolean getCloser( int target ) {
		if (pumpedUp != 0) {
			pumpedUp = 0;
			sprite.idle();
		}
		return super.getCloser( target );
	}

	@Override
	public void damage(int dmg, Object src) {
		if (!BossHealthBar.isAssigned()){
			BossHealthBar.assignBoss( this );
			Dungeon.level.seal();
		}
		boolean bleeding = (HP*2 <= HT);
		super.damage(dmg, src);
		if ((HP*2 <= HT) && !bleeding){
			BossHealthBar.bleed(true);
			sprite.showStatus(CharSprite.NEGATIVE, Messages.get(this, "enraged"));
			((GreenGooSprite)sprite).spray(true);
			yell(Messages.get(this, "gluuurp"));
		}
		LockedFloor lock = Dungeon.hero.buff(LockedFloor.class);
		if (lock != null) lock.addTime(dmg*2);
	}

	@Override
	public void die( Object cause ) {
		
		super.die( cause );
		
		Dungeon.level.unseal();
		
		GameScene.bossSlain();
		Dungeon.level.drop( new SkeletonKey( Dungeon.depth ), pos ).sprite.drop();
		
		//60% chance of 2 blobs, 30% chance of 3, 10% chance for 4. Average of 2.5
		int blobs = Random.chances(new float[]{0, 0, 6, 3, 1});
		for (int i = 0; i < blobs; i++){
			int ofs;
			do {
				ofs = PathFinder.NEIGHBOURS8[Random.Int(8)];
			} while (!Dungeon.level.passable[pos + ofs]);
			Dungeon.level.drop( new GooBlob(), pos + ofs ).sprite.drop( pos );
		}
		Dungeon.level.drop( Random.oneOf(new Firebloom.Seed(), new Fadeleaf.Seed(), new Starflower.Seed(), new Icecap.Seed()), pos ).sprite.drop( pos );
		
		Badges.validateBossSlain();
		if (Statistics.qualifiedForBossChallengeBadge){
			Badges.validateBossChallengeCompleted();
		}
		Statistics.bossScores[0] += 1050; //Goo has a 50 point gimme
		Statistics.bossScores[0] = Math.min(1000, Statistics.bossScores[0]);
		
		yell( Messages.get(this, "defeated") );
	}
	
	@Override
	public void notice() {
		super.notice();
		if (!BossHealthBar.isAssigned()) {
			BossHealthBar.assignBoss(this);
			Dungeon.level.seal();
			yell(Messages.get(this, "notice"));
			for (Char ch : Actor.chars()){
				if (ch instanceof DriedRose.GhostHero){
					((DriedRose.GhostHero) ch).sayBoss();
				}
			}
		}
	}

	public class GooBee extends Bee {
		{
			HP = HT = 10;
			EXP = 0;
		}

		@Override
		protected boolean act() {
			damage(1,Dungeon.hero);
			return super.act();
		}

		@Override
		protected Char chooseEnemy() {
			if (fieldOfView[Dungeon.hero.pos] && Dungeon.hero.buff(Invisibility.class) == null) {
				return Dungeon.hero;
			}
			return super.chooseEnemy();
		}
	}

	private final String PUMPEDUP = "pumpedup";
	private final String HEALINC = "healinc";

	@Override
	public void storeInBundle( Bundle bundle ) {

		super.storeInBundle( bundle );

		bundle.put( PUMPEDUP , pumpedUp );
		bundle.put( HEALINC, healInc );
	}

	@Override
	public void restoreFromBundle( Bundle bundle ) {

		super.restoreFromBundle( bundle );

		pumpedUp = bundle.getInt( PUMPEDUP );
		if (state != SLEEPING) BossHealthBar.assignBoss(this);
		if ((HP*2 <= HT)) BossHealthBar.bleed(true);

		healInc = bundle.getInt(HEALINC);
	}
	
}
