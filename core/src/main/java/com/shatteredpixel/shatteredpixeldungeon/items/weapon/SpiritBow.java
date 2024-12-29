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

package com.shatteredpixel.shatteredpixeldungeon.items.weapon;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.Skin;
import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.RevealedArea;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Belongings;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Talent;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.huntress.NaturesPower;
import com.shatteredpixel.shatteredpixeldungeon.effects.Splash;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.LeafParticle;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.Bag;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfSharpshooting;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.MissileWeapon;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.plants.Blindweed;
import com.shatteredpixel.shatteredpixeldungeon.plants.Firebloom;
import com.shatteredpixel.shatteredpixeldungeon.plants.Icecap;
import com.shatteredpixel.shatteredpixeldungeon.plants.Plant;
import com.shatteredpixel.shatteredpixeldungeon.plants.Sorrowmoss;
import com.shatteredpixel.shatteredpixeldungeon.plants.Stormvine;
import com.shatteredpixel.shatteredpixeldungeon.scenes.CellSelector;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.sprites.MissileSprite;
import com.shatteredpixel.shatteredpixeldungeon.ui.InventoryPane;
import com.shatteredpixel.shatteredpixeldungeon.ui.QuickSlotButton;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndBag;
import com.watabou.noosa.audio.Sample;
import com.watabou.noosa.particles.Emitter;
import com.watabou.utils.Callback;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

import java.util.ArrayList;

public class SpiritBow extends Weapon {
	
	public static final String AC_SHOOT		= "SHOOT";
	public static final String AC_PAINT 	= "PAINT";
	
	{
		image = ItemSpriteSheet.SPIRIT_BOW;
		
		defaultAction = AC_SHOOT;
		usesTargeting = true;
		
		unique = true;
		bones = false;

		skinnable = true;
		skin = Skin.BOW;
		type = Type.WOOD;
	}
	
	public boolean sniperSpecial = false;
	public float sniperSpecialBonusDamage = 0f;
	
	@Override
	public ArrayList<String> actions(Hero hero) {
		ArrayList<String> actions = super.actions(hero);
		actions.remove(AC_EQUIP);
		actions.add(AC_SHOOT);
		actions.add(AC_PAINT);
		return actions;
	}
	
	@Override
	public void execute(Hero hero, String action) {
		
		super.execute(hero, action);
		
		if (action.equals(AC_SHOOT)) {
			Sample.INSTANCE.play(Random.oneOf(Assets.Sounds.BOW_STRING_1, Assets.Sounds.BOW_STRING_2, Assets.Sounds.BOW_STRING_3, Assets.Sounds.BOW_STRING_4), 1.3f, Random.Float(0.9f, 1.1f));
			
			curUser = hero;
			curItem = this;
			GameScene.selectCell( shooter );
			
		} else if (action.equals(AC_PAINT)) {
			curItem = this;
			GameScene.selectItem(skinSelector);
		}
	}

	private static Class[] harmfulPlants = new Class[]{
			Blindweed.class, Firebloom.class, Icecap.class, Sorrowmoss.class,  Stormvine.class
	};

	@Override
	public int proc(Char attacker, Char defender, int damage) {

		if (attacker.buff(NaturesPower.naturesPowerTracker.class) != null && !sniperSpecial){

			Actor.add(new Actor() {
				{
					actPriority = VFX_PRIO;
				}

				@Override
				protected boolean act() {

					if (Random.Int(12) < ((Hero)attacker).pointsInTalent(Talent.NATURES_WRATH)){
						Plant plant = (Plant) Reflection.newInstance(Random.element(harmfulPlants));
						plant.pos = defender.pos;
						plant.activate( defender.isAlive() ? defender : null );
					}

					if (!defender.isAlive()){
						NaturesPower.naturesPowerTracker tracker = attacker.buff(NaturesPower.naturesPowerTracker.class);
						if (tracker != null){
							tracker.extend(((Hero) attacker).pointsInTalent(Talent.WILD_MOMENTUM));
						}
					}

					Actor.remove(this);
					return true;
				}
			});

		}

		return super.proc(attacker, defender, damage);
	}

	@Override
	public String info() {
		String info = super.info();
		
		info += "\n\n" + Messages.get( SpiritBow.class, "stats",
				Math.round(augment.damageFactor(min())),
				Math.round(augment.damageFactor(max())),
				STRReq());
		
		if (STRReq() > Dungeon.hero.STR()) {
			info += " " + Messages.get(Weapon.class, "too_heavy");
		} else if (Dungeon.hero.STR() > STRReq()){
			info += " " + Messages.get(Weapon.class, "excess_str", Dungeon.hero.STR() - STRReq());
		}
		
		switch (augment) {
			case SPEED:
				info += "\n\n" + Messages.get(Weapon.class, "faster");
				break;
			case DAMAGE:
				info += "\n\n" + Messages.get(Weapon.class, "stronger");
				break;
			case NONE:
		}

		if (enchantment != null && (cursedKnown || !enchantment.curse())){
			info += "\n\n" + Messages.capitalize(Messages.get(Weapon.class, "enchanted", enchantment.name()));
			if (enchantHardened) info += " " + Messages.get(Weapon.class, "enchant_hardened");
			info += " " + enchantment.desc();
		} else if (enchantHardened){
			info += "\n\n" + Messages.get(Weapon.class, "hardened_no_enchant");
		}
		
		if (cursed && isEquipped( Dungeon.hero )) {
			info += "\n\n" + Messages.get(Weapon.class, "cursed_worn");
		} else if (cursedKnown && cursed) {
			info += "\n\n" + Messages.get(Weapon.class, "cursed");
		} else if (!isIdentified() && cursedKnown){
			info += "\n\n" + Messages.get(Weapon.class, "not_cursed");
		}
		
		info += "\n\n" + Messages.get(MissileWeapon.class, "distance");

		if (skin.rarityTier() != 0) {
			info += skinInfo();
		}

		return info;
	}

	public String name() {
		if (skin != null && skin.rarityTier() >= 4) {
			return skin.skinName() + " Bow";
		}
		return super.name();
	}

	public String skinInfo() {

		String desc = Messages.get(this,"desc_skin",skin.rarity() + " _" + skin.skinName() + "_");
		if (!skin.desc().isEmpty()) {
			desc += "\n\n\"" + skin.desc() + "\"";
		}
		return desc;
	}

	@Override
	public int STRReq(int lvl) {
		return STRReq(1, lvl); //tier 1
	}
	
	@Override
	public int min(int lvl) {
		int dmg = 1 + Dungeon.hero.lvl/5
				+ RingOfSharpshooting.levelDamageBonus(Dungeon.hero)
				+ (curseInfusionBonus ? 1 + Dungeon.hero.lvl/30 : 0);
		return Math.max(0, dmg);
	}
	
	@Override
	public int max(int lvl) {
		int dmg = 6 + (int)(Dungeon.hero.lvl/2.5f)
				+ 2*RingOfSharpshooting.levelDamageBonus(Dungeon.hero)
				+ (curseInfusionBonus ? 2 + Dungeon.hero.lvl/15 : 0);
		return Math.max(0, dmg);
	}

	@Override
	public int targetingPos(Hero user, int dst) {
		return knockArrow().targetingPos(user, dst);
	}
	
	private int targetPos;
	
	@Override
	public int damageRoll(Char owner) {
		int damage = augment.damageFactor(super.damageRoll(owner));
		
		if (owner instanceof Hero) {
			int exStr = ((Hero)owner).STR() - STRReq();
			if (exStr > 0) {
				damage += Hero.heroDamageIntRange( 0, exStr );
			}
		}

		if (sniperSpecial){
			damage = Math.round(damage * (1f + sniperSpecialBonusDamage));

			switch (augment){
				case NONE:
					damage = Math.round(damage * 0.667f);
					break;
				case SPEED:
					damage = Math.round(damage * 0.5f);
					break;
				case DAMAGE:
					//as distance increases so does damage, capping at 3x:
					//1.20x|1.35x|1.52x|1.71x|1.92x|2.16x|2.43x|2.74x|3.00x
					int distance = Dungeon.level.distance(owner.pos, targetPos) - 1;
					float multiplier = Math.min(3f, 1.2f * (float)Math.pow(1.125f, distance));
					damage = Math.round(damage * multiplier);
					break;
			}
		}
		
		return damage;
	}
	
	@Override
	protected float baseDelay(Char owner) {
		if (sniperSpecial){
			switch (augment){
				case NONE: default:
					return 0f;
				case SPEED:
					return 1f;
				case DAMAGE:
					return 2f;
			}
		} else{
			return super.baseDelay(owner);
		}
	}

	@Override
	protected float speedMultiplier(Char owner) {
		float speed = super.speedMultiplier(owner);
		if (owner.buff(NaturesPower.naturesPowerTracker.class) != null){
			// +33% speed to +50% speed, depending on talent points
			speed += ((8 + ((Hero)owner).pointsInTalent(Talent.GROWING_POWER)) / 24f);
		}
		return speed;
	}

	@Override
	public int level() {
		int level = Dungeon.hero == null ? 0 : Dungeon.hero.lvl/5;
		if (curseInfusionBonus) level += 1 + level/6;
		return level;
	}

	@Override
	public int buffedLvl() {
		//level isn't affected by buffs/debuffs
		return level();
	}
	
	@Override
	public boolean isUpgradable() {
		return false;
	}

	public SpiritArrow knockArrow(){
		SpiritArrow arrow = new SpiritArrow();
		arrow.changeSkin(skin);
		switch (skin) {
			case ORANGEBOW:
				arrow.image = ItemSpriteSheet.ORANGE_ARROW;
				break;
			case YELLOWBOW:
				arrow.image = ItemSpriteSheet.YELLOW_ARROW;
				break;
			case GREENBOW:
				arrow.image = ItemSpriteSheet.GREEN_ARROW;
				break;
			case BLUEBOW:
				arrow.image = ItemSpriteSheet.BLUE_ARROW;
				break;
			case TURQUOISEBOW:
				arrow.image = ItemSpriteSheet.TURQUOISE_ARROW;
				break;
			case PURPLEBOW:
				arrow.image = ItemSpriteSheet.PURPLE_ARROW;
				break;
			case PINKBOW:
				arrow.image = ItemSpriteSheet.PINK_ARROW;
				break;
			case BROWNBOW:
				arrow.image = ItemSpriteSheet.BROWN_ARROW;
				break;
			case BLACKBOW:
				arrow.image = ItemSpriteSheet.BLACK_ARROW;
				break;
			case GRAYBOW:
				arrow.image = ItemSpriteSheet.GRAY_ARROW;
				break;
			case WHITEBOW:
				arrow.image = ItemSpriteSheet.WHITE_ARROW;
				break;
			case WOODENBOW:
				arrow.image = ItemSpriteSheet.WOODEN_ARROW;
				break;
			case WALNUTBOW:
				arrow.image = ItemSpriteSheet.WALNUT_ARROW;
				break;
			case GOOBOW:
				arrow.image = ItemSpriteSheet.GOO_ARROW;
				break;
			case CATALYSTBOW:
				arrow.image = ItemSpriteSheet.CATALYST_ARROW;
				break;
			case TAXEDBOW:
				arrow.image = ItemSpriteSheet.TAXED_ARROW;
				break;
			case MEATBOW:
				arrow.image = ItemSpriteSheet.MEAT_ARROW;
				break;
			case RAINBOWBOW:
				arrow.image = ItemSpriteSheet.RAINBOW_ARROW;
				break;
			case LOVEBOW:
				arrow.image = ItemSpriteSheet.LOVE_ARROW;
				break;
			case EGGBOW:
				arrow.image = ItemSpriteSheet.EGG_ARROW;
				break;
//			case BOW:
//				arrow.image = ItemSpriteSheet._ARROW;
//				break;
			case GOLDENBOW:
				arrow.image = ItemSpriteSheet.GOLDEN_ARROW;
				break;
			case NATUREBOW:
				arrow.image = ItemSpriteSheet.NATURE_ARROW;
				break;
			case METALBOW:
				arrow.image = ItemSpriteSheet.METAL_ARROW;
				break;
			case ROYALBOW:
				arrow.image = ItemSpriteSheet.ROYAL_ARROW;
				break;
			case CROSSBOWBOW:
				arrow.image = ItemSpriteSheet.CROSSBOW_ARROW;
				break;
			case EARTHBOW:
				arrow.image = ItemSpriteSheet.EARTH_ARROW;
				break;
			case TENGUBOW:
				arrow.image = ItemSpriteSheet.TENGU_ARROW;
				break;
			case WILLOWBOW:
				arrow.image = ItemSpriteSheet.WILLOW_ARROW;
				break;
			case RINGBOW:
				arrow.image = ItemSpriteSheet.RING_ARROW;
				break;
			case FLAMINGBOW:
				arrow.image = ItemSpriteSheet.FLAMING_ARROW;
				break;
//			case BOW:
//				arrow.image = ItemSpriteSheet._ARROW;
//				break;
			default:
				arrow.image = ItemSpriteSheet.SPIRIT_ARROW;

		}
		return arrow;
	}
	
	public class SpiritArrow extends MissileWeapon {
		
		{
			image = ItemSpriteSheet.SPIRIT_ARROW;

			hitSound = Assets.Sounds.HIT_ARROW;
		}

		@Override
		public Emitter emitter() {
			if (Dungeon.hero.buff(NaturesPower.naturesPowerTracker.class) != null && !sniperSpecial){
				Emitter e = new Emitter();
				e.pos(5, 5);
				e.fillTarget = false;
				e.pour(LeafParticle.GENERAL, 0.01f);
				return e;
			} else {
				return super.emitter();
			}
		}

		@Override
		public int damageRoll(Char owner) {
			return SpiritBow.this.damageRoll(owner);
		}
		
		@Override
		public boolean hasEnchant(Class<? extends Enchantment> type, Char owner) {
			return SpiritBow.this.hasEnchant(type, owner);
		}
		
		@Override
		public int proc(Char attacker, Char defender, int damage) {
			return SpiritBow.this.proc(attacker, defender, damage);
		}
		
		@Override
		public float delayFactor(Char user) {
			return SpiritBow.this.delayFactor(user);
		}
		
		@Override
		public float accuracyFactor(Char owner, Char target) {
			if (sniperSpecial && SpiritBow.this.augment == Augment.DAMAGE){
				return Float.POSITIVE_INFINITY;
			} else {
				return super.accuracyFactor(owner, target);
			}
		}
		
		@Override
		public int STRReq(int lvl) {
			return SpiritBow.this.STRReq();
		}

		@Override
		protected void onThrow( int cell ) {
			Char enemy = Actor.findChar( cell );
			int color = 0xCC99FFFF;
			int amount = 1;

			if (skin != null) {
				switch (skin) {
					case ORANGEBOW:
						color = 0xCCffc34d;
						break;
					case YELLOWBOW:
						color = 0xCCdfff40;
						break;
					case GREENBOW:
						color = 0xCC99ff34;
						break;
					case BLUEBOW:
						color = 0xCCb2f2ff;
						break;
					case TURQUOISEBOW:
						color = 0xCC5a86b3;
						break;
					case PURPLEBOW:
						color = 0xCCee99ff;
						break;
					case PINKBOW:
						color = 0xCCffa6e1;
						break;
					case BROWNBOW:
						color = 0xCC998f5c;
						break;
					case BLACKBOW:
						color = 0xCC595959;
						break;
					case GRAYBOW:
						color = 0xCCb5bfbf;
						break;
					case WHITEBOW:
						color = 0xCCffffff;
						break;
					case WOODENBOW:
						color = 0xCC866647;
						break;
					case WALNUTBOW:
						color = 0xCC73512f;
						break;
					case GOOBOW:
						color = 0xCC262626;
						break;
					case CATALYSTBOW:
						color = 0xCCc48400;
						break;
					case MEATBOW:
						color = 0xCCff9d33;
						break;
					case RAINBOWBOW:
						color = Random.oneOf(0xCCd6680a,0xCCffe859,0xCC00ff3a,0xCC01e9ff,0xCC01e9ff,0xCC7500ff,0xCCff01b0);
						break;
					case LOVEBOW:
						color = 0xCCd95374;
						amount = 2;
						break;
					case EGGBOW:
						color = Random.oneOf(0xCCfbe9a3,0xCCad5d20);
						break;
//			case BOW:
//				color = 0xCC;
//				break;
					case GOLDENBOW:
						if (Random.Float() > 0.2f) {
							color = 0xCCfdf55f;
							amount = 3;
						} else {
							color = 0xCCfffde0;
						}
						break;
					case NATUREBOW:
						color = Random.oneOf(0xCC8e8f4f,0xCC6b6b3c,0xCC829040);
						amount = 3;
						break;
					case METALBOW:
						color = 0xCCaaaaa3;
						break;
					case ROYALBOW:
						if (Random.Float() > 0.2f) {
							color = 0xCCffe940;
							amount = 2;
						} else {
							color = 0xCCdd0024;
						}
						break;
					case CROSSBOWBOW:
						color = 0xCC9e9e9e;
						break;
					case EARTHBOW:
						if (Random.Float() > 0.2f) {
							color = 0xCC805500;
						} else {
							color = 0xCCfff568;
						}
						break;
					case TENGUBOW:
						color = 0xCCb46b30;
						break;
					case WILLOWBOW:
						color = 0xCC538e49;
						break;
					case RINGBOW:
						color = 0xCCfa9c13;
						break;
					case FLAMINGBOW:
						Sample.INSTANCE.play(Assets.Sounds.BURNING);
						amount = 3;
						color = Random.oneOf(0xCCff5500,0xCCffe566,0xCCffffff,0xCCff9d33);
						break;
//			case BOW:
//				color = 0xCC;
//				break;
				}
			}

			if (enemy == null || enemy == curUser) {
				parent = null;
				if (skin == Skin.FLAMINGBOW) {
					for (int i = 0; i < 15; i++) {
						Splash.FUCK(cell, Random.oneOf(0xCCff5500,0xCCffe566,0xCCffffff,0xCCff9d33), 1, Random.Float(0.1f,4f));
					}
				}
				Splash.at(cell, color, amount);
			} else {
				if (!curUser.shoot( enemy, this )) {
					if (skin == Skin.FLAMINGBOW) {

					}
					Splash.at(cell, color, amount);
				}
				if (sniperSpecial && SpiritBow.this.augment != Augment.SPEED) sniperSpecial = false;
			}
		}

		@Override
		public void throwSound() {
			Sample.INSTANCE.play( Assets.Sounds.ATK_SPIRITBOW, 1, Random.Float(0.87f, 1.15f) );
		}

		int flurryCount = -1;
		Actor flurryActor = null;

		@Override
		public void cast(final Hero user, final int dst) {
			final int cell = throwPos( user, dst );
			SpiritBow.this.targetPos = cell;
			if (sniperSpecial && SpiritBow.this.augment == Augment.SPEED){
				if (flurryCount == -1) flurryCount = 3;
				
				final Char enemy = Actor.findChar( cell );
				
				if (enemy == null){
					if (user.buff(Talent.LethalMomentumTracker.class) != null){
						user.buff(Talent.LethalMomentumTracker.class).detach();
						user.next();
					} else {
						user.spendAndNext(castDelay(user, dst));
					}
					sniperSpecial = false;
					flurryCount = -1;

					if (flurryActor != null){
						flurryActor.next();
						flurryActor = null;
					}
					return;
				}

				QuickSlotButton.target(enemy);
				
				user.busy();
				
				throwSound();

				user.sprite.zap(cell);
				((MissileSprite) user.sprite.parent.recycle(MissileSprite.class)).
						reset(user.sprite,
								cell,
								this,
								new Callback() {
									@Override
									public void call() {
										if (enemy.isAlive()) {
											curUser = user;
											onThrow(cell);
										}

										flurryCount--;
										if (flurryCount > 0){
											Actor.add(new Actor() {

												{
													actPriority = VFX_PRIO-1;
												}

												@Override
												protected boolean act() {
													flurryActor = this;
													int target = QuickSlotButton.autoAim(enemy, SpiritArrow.this);
													if (target == -1) target = cell;
													cast(user, target);
													Actor.remove(this);
													return false;
												}
											});
											curUser.next();
										} else {
											if (user.buff(Talent.LethalMomentumTracker.class) != null){
												user.buff(Talent.LethalMomentumTracker.class).detach();
												user.next();
											} else {
												user.spendAndNext(castDelay(user, dst));
											}
											sniperSpecial = false;
											flurryCount = -1;
										}

										if (flurryActor != null){
											flurryActor.next();
											flurryActor = null;
										}
									}
								});
				
			} else {

				if (user.hasTalent(Talent.SEER_SHOT)
						&& user.buff(Talent.SeerShotCooldown.class) == null){
					int shotPos = throwPos(user, dst);
					if (Actor.findChar(shotPos) == null) {
						RevealedArea a = Buff.affect(user, RevealedArea.class, 5 * user.pointsInTalent(Talent.SEER_SHOT));
						a.depth = Dungeon.depth;
						a.branch = Dungeon.branch;
						a.pos = shotPos;
						Buff.affect(user, Talent.SeerShotCooldown.class, 20f);
					}
				}

				super.cast(user, dst);
			}
		}
	}
	
	private CellSelector.Listener shooter = new CellSelector.Listener() {
		@Override
		public void onSelect( Integer target ) {
			if (target != null) {
				knockArrow().cast(curUser, target);
			}
		}
		@Override
		public String prompt() {
			return Messages.get(SpiritBow.class, "prompt");
		}
	};

	protected static WndBag.ItemSelector skinSelector = new WndBag.ItemSelector() {

		@Override
		public String textPrompt() {
			return  Messages.get(SpiritBow.class, "skin");
		}

		@Override
		public Class<?extends Bag> preferredBag(){
			if (InventoryPane.lastBag != null) return InventoryPane.lastBag.getClass();
			return Belongings.Backpack.class;
		}

		@Override
		public boolean itemSelectable(Item item) {
			return Skin.containsIngredient(item, SpiritBow.class) && item.isIdentified();
		}

		@Override
		public void onSelect( Item item ) {
			if (item != null && itemSelectable(item)) {
				Skin skin = Skin.fromIngredient(item, SpiritBow.class);
				if (skin == null) {
					//WE'VE FUCKED UP IF THIS HAPPENS
					GLog.n("OH FUCK OH SHIT! THE SKIN IS NULL!!! (dev fucked up bad)");
					return;
				}

				GLog.p(Messages.get(SpiritBow.class, "applyskin"));
				Dungeon.hero.sprite.operate(Dungeon.hero.pos);
				Sample.INSTANCE.play(Assets.Sounds.EQUIP_WOOD);
				((SpiritBow) curItem).changeSkin(skin);
			}
		}
	};
}
