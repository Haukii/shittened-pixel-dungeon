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

package com.shatteredpixel.shatteredpixeldungeon.effects;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.scenes.PixelScene;
import com.watabou.noosa.Game;
import com.watabou.noosa.Image;
import com.watabou.noosa.TextureFilm;
import com.watabou.noosa.particles.Emitter;
import com.watabou.utils.ColorMath;
import com.watabou.utils.PointF;
import com.watabou.utils.Random;
import com.watabou.utils.SparseArray;

public class Speck extends Image {

	public static final int HEALING     = 0;
	public static final int STAR        = 1;
	public static final int LIGHT       = 2;
	public static final int QUESTION    = 3;
	public static final int UP          = 4;
	public static final int SCREAM      = 5;
	public static final int BONE        = 6;
	public static final int WOOL        = 7;
	public static final int ROCK        = 8;
	public static final int NOTE        = 9;
	public static final int CHANGE      = 10;
	public static final int HEART       = 11;
	public static final int BUBBLE      = 12;
	public static final int STEAM       = 13;
	public static final int COIN        = 14;
	public static final int WARRIOR     = 15;
	public static final int RING     	= 16;
	public static final int SMALLSPECK 	= 17;
	public static final int BIGSPECK 	= 18;
	public static final int CROWNEFFECT = 19;
	public static final int SHEEP	    = 20;
	public static final int EYE	    	= 21;
	public static final int SNAKE	    = 22;
	public static final int GLOW	    = 23;
	public static final int HUGESPECK 	= 24;
	public static final int BEE 		= 25;
	
	public static final int DISCOVER    = 101;
	public static final int EVOKE       = 102;
	public static final int MASK        = 103;
	public static final int CROWN       = 104;
	public static final int RATTLE      = 105;
	public static final int JET         = 106;
	public static final int TOXIC       = 107;
	public static final int CORROSION   = 108;
	public static final int PARALYSIS   = 109;
	public static final int DUST        = 110;
	public static final int STENCH      = 111;
	public static final int FORGE       = 112;
	public static final int CONFUSION   = 113;
	public static final int RED_LIGHT   = 114;
	public static final int CALM        = 115;
	public static final int SMOKE       = 116;
	public static final int STORM       = 117;
	public static final int INFERNO     = 118;
	public static final int BLIZZARD    = 119;

	public static final int YELLOWSEAL    	= 120;
	public static final int GREENSEAL    	= 121;
	public static final int BLUESEAL    	= 122;
	public static final int PURPLESEAL    	= 123;
	public static final int BLACKSEAL    	= 124;
	public static final int WHITESEAL    	= 125;
	public static final int GRAYSEAL    	= 126;
	public static final int TURQUOISESEAL   = 127;
	public static final int BROWNSEAL    	= 128;
	public static final int PINKSEAL    	= 129;
	public static final int ORANGESEAL    	= 130;

	public static final int WOODSEAL 		= 131;
	public static final int MEATSEAL 		= 132;
	public static final int TRANSPARENTSEAL = 133;
	public static final int HEALINGSEAL 	= 134;
	public static final int CUTSEAL 		= 135;
	public static final int THIEFSEAL 		= 200;
	public static final int COPPERSEAL 		= 201;
	public static final int CUBESEAL 		= 202;

	public static final int RINGSEAL 		= 136;
	public static final int RAINBOWSEAL 	= 137;
	public static final int GOLDSEAL 		= 138;
	public static final int CORPSESEAL 		= 139;
	public static final int HEARTSEAL 		= 140;
	public static final int BURNTSEAL 		= 141;
	public static final int GOOSEAL 		= 142;
	public static final int WATERSEAL 		= 143;
	public static final int WARRIORSEAL 	= 144;
	public static final int COWBOYSEAL 		= 145;
	public static final int HONEYSEAL 		= 203;
	public static final int ICESEAL 		= 204;
	public static final int EYESEAL 		= 205;
	public static final int SNAKESEAL 		= 206;
	public static final int CANDLESEAL 		= 207;
	public static final int BOMBSEAL 		= 208;
	public static final int SHEEPSEAL 		= 209;

	public static final int DMSEAL 			= 146;
	public static final int KINGSEAL 		= 147;
	public static final int FIERYSEAL 		= 148;
	public static final int PUREGOLDSEAL 	= 149;
	public static final int AMULETSEAL 		= 150;
	public static final int BLOWNUPSEAL 	= 151;



	public static final int SNOW 			= 300;
	public static final int PAPER			= 301;
	public static final int KETCHUP			= 302;
	public static final int KETCHUPSTORM	= 303;
	public static final int FUELGAS			= 304;
	public static final int BEES			= 305;
	public static final int BULLET_TRAIL	= 306;
	public static final int TOMATO			= 307;
	
	private static final int SIZE = 7;
	
	private int type;
	private float lifespan;
	private float left;
	
	private static TextureFilm film;
	
	private static SparseArray<Emitter.Factory> factories = new SparseArray<>();
	
	public Speck() {
		super();
		
		texture( Assets.Effects.SPECKS );
		if (film == null) {
			film = new TextureFilm( texture, SIZE, SIZE );
		}
		
		origin.set( SIZE / 2f );
	}

	public Speck image( int type ){
		reset(0, 0, 0, type);

		left = lifespan = Float.POSITIVE_INFINITY;
		this.type = -1;

		resetColor();
		scale.set( 1 );
		speed.set( 0 );
		acc.set( 0 );
		angle = 0;
		angularSpeed = 0;

		return this;
	}

	public void reset( int index, float x, float y, int type ) {
		revive();

		float randomEffectChance = Random.Float();

		this.type = type;
		switch (type) {
			case DISCOVER:
			case RED_LIGHT:
			case YELLOWSEAL:
			case GREENSEAL:
			case BLUESEAL:
			case PURPLESEAL:
			case BLACKSEAL:
			case WHITESEAL:
			case GRAYSEAL:
			case TURQUOISESEAL:
			case BROWNSEAL:
			case PINKSEAL:
			case ORANGESEAL:
			case WOODSEAL:
			case MEATSEAL:
			case TRANSPARENTSEAL:
			case HEALINGSEAL:
			case CUTSEAL:
			case RAINBOWSEAL:
			case GOLDSEAL:
			case GOOSEAL:
			case THIEFSEAL:
			case COPPERSEAL:
			case CUBESEAL:
			case KINGSEAL:
				frame(film.get(LIGHT));
				break;
			case ICESEAL:
				if (randomEffectChance > 0.1f) {
					frame(film.get(SMALLSPECK));
				} else {
					frame(film.get(LIGHT));
				}
				break;
			case SNAKESEAL:
				if (randomEffectChance > 0.05f) {
					frame(film.get(RING));
				} else {
					frame(film.get(SNAKE));
				}
				break;
			case PUREGOLDSEAL:
				if (randomEffectChance < 0.1f) {
					frame(film.get(LIGHT));
				} else {
					frame(film.get(SMALLSPECK));
				}
				break;
			case AMULETSEAL:
				frame(film.get(BIGSPECK));
				break;
			case RINGSEAL:
				frame(film.get(RING));
				break;
			case HEARTSEAL:
				frame(film.get(HEART));
				break;
			case WARRIORSEAL:
				frame(film.get(WARRIOR));
				break;
			case DMSEAL:
			case BOMBSEAL:
			case SNOW:
			case BULLET_TRAIL:
			case TOMATO:
				frame(film.get(SMALLSPECK));
				break;
			case CANDLESEAL:
				if (randomEffectChance < 0.05f) {
					frame(film.get(GLOW));
				} else {
					frame(film.get(SMALLSPECK));
				}
				break;
			case FIERYSEAL:
			case WATERSEAL:
			case HONEYSEAL:
			case PAPER:
				if (Random.Float() > 0.6f) {
					frame(film.get(BIGSPECK));
				} else {
					frame(film.get(SMALLSPECK));
				}
				break;
			case SHEEPSEAL:
				frame(film.get(SHEEP));
				break;
			case EYESEAL:
				frame(film.get(EYE));
				break;
			case EVOKE:
			case MASK:
			case CROWN:
			case FORGE:
				frame(film.get(STAR));
				break;
			case RATTLE:
			case CORPSESEAL:
				frame(film.get(BONE));
				break;
			case JET:
			case TOXIC:
			case CORROSION:
			case PARALYSIS:
			case STENCH:
			case CONFUSION:
			case STORM:
			case DUST:
			case SMOKE:
			case BLIZZARD:
			case INFERNO:
			case BURNTSEAL:
			case COWBOYSEAL:
			case BLOWNUPSEAL:
			case FUELGAS:
				frame(film.get(STEAM));
				break;
			case CALM:
				frame(film.get(SCREAM));
				break;
			case KETCHUP:
			case KETCHUPSTORM:
				frame(film.get(HUGESPECK));
				break;
			case BEES:
				frame(film.get(BEE));
				break;
			default:
				frame(film.get(type));
		}

		this.x = x - origin.x;
		this.y = y - origin.y;

		resetColor();
		scale.set( 1 );
		speed.set( 0 );
		acc.set( 0 );
		angle = 0;
		angularSpeed = 0;

		switch (type) {

			case HEALING:
				speed.set(0, -20);
				lifespan = 1f;
				break;

			case STAR:
				speed.polar(Random.Float(2 * 3.1415926f), Random.Float(128));
				acc.set(0, 128);
				angle = Random.Float(360);
				angularSpeed = Random.Float(-360, +360);
				lifespan = 1f;
				break;

			case FORGE:
				speed.polar(Random.Float(-3.1415926f), Random.Float(64));
				acc.set(0, 128);
				angle = Random.Float(360);
				angularSpeed = Random.Float(-360, +360);
				lifespan = 0.51f;
				break;

			case EVOKE:
				speed.polar(Random.Float(-3.1415926f), 50);
				acc.set(0, 50);
				angle = Random.Float(360);
				angularSpeed = Random.Float(-180, +180);
				lifespan = 1f;
				break;

			case MASK:
				speed.polar(index * 3.1415926f / 5, 50);
				acc.set(-speed.x, -speed.y);
				angle = index * 36;
				angularSpeed = 360;
				lifespan = 1f;
				break;

			case CROWN:
				acc.set(index % 2 == 0 ? Random.Float(-512, -256) : Random.Float(+256, +512), 0);
				angularSpeed = acc.x < 0 ? -180 : +180;
				//acc.set( -speed.x, 0 );
				lifespan = 0.5f;
				break;

			case RED_LIGHT:
				tint(0xFFCC0000);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case YELLOWSEAL:
				tint(0xFFdfff40);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case GREENSEAL:
				tint(0xFF2ee62e);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case BLUESEAL:
				tint(0xFF66b3ff);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case PURPLESEAL:
				tint(0xFFa15ce5);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case BLACKSEAL:
			case CUBESEAL:
				tint(0xFF404040);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case WHITESEAL:
				tint(0xFFd9d9d9);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case GRAYSEAL:
				tint(0xFF919999);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case TURQUOISESEAL:
				tint(0xFF195d80);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case BROWNSEAL:
				tint(0xFF67583d);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case PINKSEAL:
				tint(0xFFff4cd2);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case ORANGESEAL:
				tint(0xFFff7f00);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case WOODSEAL:
				tint(0xFF866646);
				angle = Random.Float(60);
				angularSpeed = 30;
				lifespan = 1f;
				break;
			case MEATSEAL:
				tint(0xFFe04949);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case TRANSPARENTSEAL:
				tint(0x99880000);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case HEALINGSEAL:
				tint(0xFFa52828);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case CUTSEAL:
				tint(0xFF880000);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case THIEFSEAL:
				if (Random.Float() < 0.95f) {
					tint(0xFF2b2340);
				} else {
					tint(0xFFde0e0e);
				}
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case COPPERSEAL:
				tint(0xFFbc6e4b);
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case RINGSEAL:
				if (Random.Float() > 0.7) {
					tint(0xFFfa9c13);
				} else {
					tint(0xFFffd64d);
				}
				angle = Random.Float(360);
				angularSpeed = 120;
				lifespan = 1f;
				break;
			case RAINBOWSEAL:
				switch (Random.Int(9)) {
					case 0:
						tint(0xFFdfff40);
						break;
					case 1:
						tint(0xFF2ee62e);
						break;
					case 2:
						tint(0xFF66b3ff);
						break;
					case 3:
						tint(0xFFa15ce5);
						break;
					case 4:
						tint(0xFFd9d9d9);
						break;
					case 5:
						tint(0xFF195d80);
						break;
					case 6:
						tint(0xFFff4cd2);
						break;
					case 7:
						tint(0xFFff7f00);
						break;
					case 8:
						tint(0xFFCC0000);
						break;
				}
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;
			case GOLDSEAL:
				float random = Random.Float();
				if (random < 0.6f) {
					tint(0xFFfad64a);
					lifespan = 0.5f;
				} else if (random < 0.8f) {
					tint(0xFFfdf55f);
					lifespan = 0.5f;
				} else {
					tint(0xFFfffde0);
					angularSpeed = 120;
					lifespan = 0.3f;
				}
				angle = Random.Float(360);
				angularSpeed = 90;
				break;
			case GOOSEAL:
				tint(0xFF262626);
				angle = Random.Float(360);
				speed.set(0, Random.Float(-0.5f, 2f));
				angularSpeed = 15;
				lifespan = 3f;
				break;
			case WATERSEAL:
				tint(Random.Int(0xFF4a7561, 0xFF385d4c));
				angle = Random.Float(360);
				angularSpeed = 90;
				speed.set(Random.Float(-3, 3), 10);
				lifespan = 0.5f;
				break;
			case WARRIORSEAL:
				angle = Random.Float(360);
				angularSpeed = 150;
				speed.set(Random.Float(-10, 10), Random.Float(-10, 10));
				lifespan = 2.5f;
				break;
			case COWBOYSEAL:
				tint(0xFF944b11);
				angle = Random.Float(360);
				speed.set(Random.Float(-5, 5), 0);
				angularSpeed = speed.x * 50;
				lifespan = 2f;
				break;
			case HONEYSEAL:
				tint(0xFFffff33);
				angle = Random.Float(360);
				angularSpeed = Random.Float(-50, 50);
				speed.set(Random.Float(-0.5f, 0.5f), Random.Float(2f, 4f));
				acc.set(0, -speed.y / 3f);
				lifespan = 2f;
				break;
			case ICESEAL:
				tint(0xFF77b4f2);
				angle = Random.Float(360);
				if (randomEffectChance < 0.1f) {
					angularSpeed = 30;
					lifespan = 0.7f;
					speed.set(Random.Float(-2, 2), 10);
					acc.set(0, 100);
				} else {
					angularSpeed = 15;
					lifespan = 2f;
				}
				break;
			case EYESEAL:
				angle = Random.Float(360);
				angularSpeed = Random.Float(60, 90);
				speed.set(Random.Float(-2, 2), Random.Float(-2, 2));
				acc.set(Random.Float(0, 25), Random.Float(0, 25));
				speed.polar(Random.Float(3f), 24 / lifespan + Random.Float(5f));
				lifespan = 1.3f;
				break;
			case SNAKESEAL:
				if (randomEffectChance < 0.05f) {
					tint(0xFFcc1313);
					speed.set(Random.Float(-5, 5) * 6, Random.Float(-5, 5) * 6);
					angle = (float) Math.toDegrees(Math.atan2(speed.y, speed.x)) - 90;
					lifespan = 0.5f;
				} else {
					tint(ColorMath.random(0xFF002700, 0xFF45c445));
					angle = Random.Float(360);
					lifespan = 0.8f;
					angularSpeed = Random.Float(90, 250);
				}
				break;
			case CANDLESEAL:
				if (randomEffectChance < 0.05f) {
					tint(ColorMath.random(0xAAffffff, 0xAAffffd1));
					lifespan = 1.5f;
				} else {
					angularSpeed = Random.Float(-200, 200);
					speed.set(Random.Float(-4, 4), Random.Float(-30, -20));
					acc.set(Random.Float(-20, 20), Random.Float(20, 60));
					lifespan = 0.5f;
					tint(Random.oneOf(0xFFffe566, 0xFFff5500, 0xFFff9d33, 0xFFffc852, 0xFFffeeb0));
				}
				angle = Random.Float(360);
				break;
			case BOMBSEAL:
				tint(Random.oneOf(0xFFffe566, 0xFFff5500, 0xFFff9d33, 0xFFffc852, 0xFFffeeb0));
				angle = Random.Float(360);
				angularSpeed = Random.Float(-200, 200);
				speed.set(Random.Float(-4, 4), Random.Float(-30, -20));
				acc.set(Random.Float(-20, 20), Random.Float(20, 60));
				lifespan = 0.5f;
				break;
			case SHEEPSEAL:
				speed.set(Random.Float(-5, 5), Random.Float(-5, 5));
				angle = (float) Math.toDegrees(Math.atan2(speed.y, speed.x));
				acc.set(-speed.x * 0.7f, -speed.y * 0.7f);
				angularSpeed = Random.Float(-10, 10);
				lifespan = 2f;
				break;
			case DMSEAL:
				tint(Random.oneOf(0xFF4488ff, 0xFF56bc9, 0xFFFFFFFF, 0xFF66b3ff));
				speed.set(Random.Float(-80, 80), Random.Float(-80, 80));
				angle = Random.Float(360);
				lifespan = Random.Float(0.03f, 0.1f);
				break;
			case KINGSEAL:
				if (randomEffectChance > 0.03f) {
					tint(Random.oneOf(0xFFffe940, 0xFFff9a03, 0xFFffc72d));
					angularSpeed = 50;
					lifespan = 0.4f;
					angle = Random.Float(360);
				} else {
					angularSpeed = 0;
					speed.set(0, -3);
					lifespan = 4f;
					frame(film.get(CROWNEFFECT));
				}
				break;
			case FIERYSEAL:
				if (Random.Float() < 0.95f) {
					tint(Random.oneOf(0xFFffe566, 0xFFff5500, 0xFFff9d33, 0xFFffc852, 0xFFffeeb0));
					speed.set(Random.IntRange(-5, 5), Random.Float(-32, -20));
					lifespan = Random.Float(0.07f, 0.35f);
				} else {
					//smoke
					tint(ColorMath.random(0xFF222222, 0xFFBBBBBB));
					speed.set(Random.IntRange(-5, 5), Random.Float(-20, -10));
					lifespan = Random.Float(0.3f, 0.8f);
				}
				angle = Random.Float(360);
				angularSpeed = Random.Float(-55, 55);
				acc.set(0, speed.y * 1.5f);
				break;
			case PUREGOLDSEAL:
				if (randomEffectChance < 0.1f) {
					tint(0xFFfdf55f);
					angularSpeed = 90;
					lifespan = 0.7f;
				} else {
					tint(ColorMath.random(0xFFfdf55f, 0xFFfad64a));
					angularSpeed = 130;
					lifespan = 0.2f;
				}
				angle = Random.Float(360);
				break;
			case AMULETSEAL:
				if (randomEffectChance < 0.25f) {
					tint(ColorMath.random(0xFFc2a3ff, 0xFF7759b3));
				} else if (randomEffectChance < 0.5f) {
					tint(ColorMath.random(0xFF9df0e2, 0xFF59b3a4));
				} else if (randomEffectChance < 0.75f) {
					tint(ColorMath.random(0xFFffa3b2, 0xFFb35968));
				} else {
					tint(ColorMath.random(0xFFd4f09d, 0xFF95b359));
				}
				angularSpeed = 90;
				lifespan = 0.7f;
				angle = Random.Float(360);
				break;
			case BLOWNUPSEAL:
				tint(ColorMath.random(0xFF23221f, 0xFF585848));
				angularSpeed = Random.Float(-50, 80);
				speed.set(Random.Float(-5, 5), Random.Float(-15, -25));
				acc.set(Random.Float(0, 15), Random.Float(-10, 0));
				lifespan = 1.7f;
				angle = Random.Float(360);
				break;

			case SNOW:
				angularSpeed = Random.Float(-50, 80);
				speed.set(Random.Float(-5, 5), Random.Float(15, 30));
				lifespan = Random.Float(5f, 10f);
				acc.set(Random.Float(0, 25), Random.Float(0, 10));
				angle = Random.Float(360);
				break;
			case PAPER:
				angularSpeed = Random.Float(-50, 80);
				speed.set(Random.Float(-10, 10), Random.Float(20, 30));
				lifespan = Random.Float(0.2f, 0.5f);
				tint(0xFFDEC77E);
				acc.set(Random.Float(-50, 50), 0);
				angle = Random.Float(360);
				break;
			case LIGHT:
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 1f;
				break;

			case DISCOVER:
				angle = Random.Float(360);
				angularSpeed = 90;
				lifespan = 0.5f;
				am = 0;
				break;

			case QUESTION:
				lifespan = 0.8f;
				break;

			case UP:
				speed.set(0, -20);
				lifespan = 1f;
				break;

			case CALM:
				color(0, 1, 1);
			case SCREAM:
				lifespan = 0.9f;
				break;

			case BONE:
				lifespan = 0.2f;
				speed.polar(Random.Float(2 * 3.1415926f), 24 / lifespan);
				acc.set(0, 128);
				angle = Random.Float(360);
				angularSpeed = 360;
				break;
			case CORPSESEAL:
				lifespan = 0.5f;
				speed.polar(Random.Float(2f), 10 / lifespan);
				acc.set(Random.Float(0, 10), Random.Float(10, 30));
				angle = Random.Float(360);
				angularSpeed = Random.Float(60, 200);
				break;

			case RATTLE:
				lifespan = 0.5f;
				speed.set(0, -100);
				acc.set(0, -2 * speed.y / lifespan);
				angle = Random.Float(360);
				angularSpeed = 360;
				break;

			case WOOL:
				lifespan = 0.5f;
				speed.set(0, -50);
				angle = Random.Float(360);
				angularSpeed = Random.Float(-360, +360);
				break;

			case ROCK:
				angle = Random.Float(360);
				angularSpeed = Random.Float(-360, +360);
				scale.set(Random.Float(1, 2));
				speed.set(0, 64);
				lifespan = 0.2f;
				this.y -= speed.y * lifespan;
				break;

			case NOTE:
				angularSpeed = Random.Float(-30, +30);
				speed.polar((angularSpeed - 90) * PointF.G2R, 30);
				lifespan = 1f;
				break;

			case CHANGE:
				angle = Random.Float(360);
				speed.polar((angle - 90) * PointF.G2R, Random.Float(4, 12));
				lifespan = 1.5f;
				break;

			case HEART:
				speed.set(Random.IntRange(-10, +10), -40);
				angularSpeed = Random.Float(-45, +45);
				lifespan = 1f;
				break;

			case HEARTSEAL:
				speed.set(Random.IntRange(-5, +5), -20);
				angularSpeed = Random.Float(-45, +45);
				lifespan = 1f;
				break;

			case BUBBLE:
				speed.set(0, -15);
				scale.set(Random.Float(0.8f, 1));
				lifespan = Random.Float(0.8f, 1.5f);
				break;

			case STEAM:
				speed.y = -Random.Float(10, 15);
				angularSpeed = Random.Float(+180);
				angle = Random.Float(360);
				lifespan = 1f;
				break;

			case JET:
				speed.y = +32;
				acc.y = -64;
				angularSpeed = Random.Float(180, 360);
				angle = Random.Float(360);
				lifespan = 0.5f;
				break;

			case TOXIC:
				hardlight(0x50FF60);
				angularSpeed = 30;
				angle = Random.Float(360);
				lifespan = Random.Float(1f, 3f);
				break;

			case CORROSION:
				hardlight(0xAAAAAA);
				angularSpeed = 30;
				angle = Random.Float(360);
				lifespan = Random.Float(1f, 3f);
				break;

			case PARALYSIS:
				hardlight(0xFFFF66);
				angularSpeed = -30;
				angle = Random.Float(360);
				lifespan = Random.Float(1f, 3f);
				break;

			case STENCH:
				hardlight(0x003300);
				angularSpeed = -30;
				angle = Random.Float(360);
				lifespan = Random.Float(1f, 3f);
				break;

			case CONFUSION:
				hardlight(Random.Int(0x1000000) | 0x000080);
				angularSpeed = Random.Float(-20, +20);
				angle = Random.Float(360);
				lifespan = Random.Float(1f, 3f);
				break;

			case STORM:
				hardlight(0x8AD8D8);
				angularSpeed = Random.Float(-20, +20);
				angle = Random.Float(360);
				lifespan = Random.Float(1f, 3f);
				break;

			case FUELGAS:
				hardlight(0x483026);
				angularSpeed = 30;
				angle = Random.Float(360);
				lifespan = Random.Float(0.7f, 2.5f);
				break;

			case INFERNO:
				hardlight(0xEE7722);
				angularSpeed = Random.Float(200, 300) * (Random.Int(2) == 0 ? -1 : 1);
				angle = Random.Float(360);
				lifespan = Random.Float(1f, 3f);
				break;

			case BLIZZARD:
				hardlight(0xFFFFFF);
				angularSpeed = Random.Float(200, 300) * (Random.Int(2) == 0 ? -1 : 1);
				angle = Random.Float(360);
				lifespan = Random.Float(1f, 3f);
				break;

			case SMOKE:
				hardlight(0x000000);
				angularSpeed = 30;
				angle = Random.Float(360);
				lifespan = Random.Float(1f, 1.5f);
				break;
			case BURNTSEAL:
				hardlight(0x000000);
				speed.y = Random.Float(-3, -10);
				angularSpeed = 30;
				angle = Random.Float(360);
				lifespan = Random.Float(1f, 1.5f);
				break;

			case DUST:
				hardlight(0xFFFF66);
				angle = Random.Float(360);
				speed.polar(Random.Float(2 * 3.1415926f), Random.Float(16, 48));
				lifespan = 0.5f;
				break;

			case COIN:
				speed.polar(-PointF.PI * Random.Float(0.3f, 0.7f), Random.Float(48, 96));
				acc.y = 256;
				lifespan = -speed.y / acc.y * 2;
				break;

			case KETCHUP:
				hardlight(0xe21818);
				//angularSpeed = -30;
				angle = Random.Float(360);
				lifespan = Random.Float(4f, 7f);
				break;
			case KETCHUPSTORM:
				hardlight(0xe21818);
				angularSpeed = Random.Float(30, 110);
				angle = Random.Float(360);
				lifespan = Random.Float(0.8f, 3f);
				break;
			case BEES:
				speed.polar(Random.Float(2 * 3.1415926f), Random.Float(16, 24));
				acc.set( Random.Int(-20, 20), Random.Int(-20, 20) );
				angle = (float) Math.toDegrees(Math.atan2(speed.y, speed.x));
				lifespan = Random.Float(0.8f, 2f);
				randomXrot = Random.Float() - 0.5f;
				randomYrot = Random.Float() - 0.5f;
				break;
			case BULLET_TRAIL:
				hardlight(0x666666);
				lifespan = Random.Float(0.1f, 0.2f);
				angularSpeed = 30;
				break;
			case TOMATO:
				hardlight(0xe21818);
				lifespan = Random.Float(0.2f, 0.4f);
				angle = Random.Float(360);
				angularSpeed = 70;
				break;
		}

		left = lifespan;
	}

	float randomYrot = 0;
	float randomXrot = 0;

	@Override
	public void update() {
		super.update();

		left -= Game.elapsed;
		if (left <= 0) {

			kill();

		} else {

			float p = 1 - left / lifespan;	// 0 -> 1

			switch (type) {

				case STAR:
				case FORGE:
					scale.set(1 - p);
					am = p < 0.2f ? p * 5f : (1 - p) * 1.25f;
					break;

				case MASK:
				case CROWN:
					am = 1 - p * p;
					break;

				case EVOKE:

				case HEALING:
					am = p < 0.5f ? 1 : 2 - p * 2;
					break;

				case RED_LIGHT:
				case YELLOWSEAL:
				case GREENSEAL:
				case BLUESEAL:
				case PURPLESEAL:
				case BLACKSEAL:
				case WHITESEAL:
				case GRAYSEAL:
				case TURQUOISESEAL:
				case BROWNSEAL:
				case PINKSEAL:
				case ORANGESEAL:
				case WOODSEAL:
				case MEATSEAL:
				case TRANSPARENTSEAL:
				case HEALINGSEAL:
				case CUTSEAL:
				case RINGSEAL:
				case RAINBOWSEAL:
				case GOLDSEAL:
				case HEARTSEAL:
				case BURNTSEAL:
				case GOOSEAL:
				case WATERSEAL:
				case WARRIORSEAL:
				case COWBOYSEAL:
				case FIERYSEAL:
				case KINGSEAL:
				case LIGHT:
				case THIEFSEAL:
				case COPPERSEAL:
				case CUBESEAL:
				case HONEYSEAL:
				case ICESEAL:
				case CANDLESEAL:
				case EYESEAL:
				case SNAKESEAL:
				case BOMBSEAL:
				case SHEEPSEAL:
				case PUREGOLDSEAL:
				case AMULETSEAL:
				case BLOWNUPSEAL:
					//Fades in and out
					am = scale.set(p < 0.2f ? p * 5f : (1 - p) * 1.25f).x;
					break;
				case SNOW:
				case PAPER:
				case BULLET_TRAIL:
					//Only fades out
					am = scale.set((1 - p) * 1.25f).x;
					break;
				case BEES:
					//Changes rotation and movement direction, only fades out.
					am = scale.set((1 - p) * 1.25f).x;
					acc.set(acc.x + randomXrot, acc.y + randomYrot);
					angle = (float) Math.toDegrees(Math.atan2(speed.y,speed.x));
					break;
				case DISCOVER:
					am = 1 - p;
					scale.set((p < 0.5f ? p : 1 - p) * 2);
					break;

				case QUESTION:
					scale.set((float) (Math.sqrt(p < 0.5f ? p : 1 - p) * 3));
					break;

				case UP:
					scale.set((float) (Math.sqrt(p < 0.5f ? p : 1 - p) * 2));
					break;

				case CALM:
				case SCREAM:
					am = (float) Math.sqrt((p < 0.5f ? p : 1 - p) * 2f);
					scale.set(p * 7);
					break;

				case BONE:
				case RATTLE:
				case CORPSESEAL:
				case TOMATO:
					am = p < 0.9f ? 1 : (1 - p) * 10;
					break;

				case ROCK:
					am = p < 0.2f ? p * 5 : 1;
					break;

				case NOTE:
					am = 1 - p * p;
					break;

				case WOOL:
					scale.set(1 - p);
					break;

				case CHANGE:
					am = (float) Math.sqrt((p < 0.5f ? p : 1 - p) * 2);
					scale.y = (1 + p) * 0.5f;
					scale.x = scale.y * (float) Math.cos(left * 15);
					break;

				case HEART:
					scale.set(1 - p);
					am = 1 - p * p;
					break;

				case BUBBLE:
					am = p < 0.2f ? p * 5 : 1;
					break;

				case STEAM:
				case TOXIC:
				case PARALYSIS:
				case CONFUSION:
				case STORM:
				case BLIZZARD:
				case INFERNO:
				case DUST:
				case KETCHUP:
				case KETCHUPSTORM:
				case FUELGAS:
					am = (float) Math.sqrt((p < 0.5f ? p : 1 - p) * 0.5f);
					scale.set(1 + p);
					break;

				case CORROSION:
					hardlight(ColorMath.interpolate(0xAAAAAA, 0xFF8800, p));
				case STENCH:
				case SMOKE:
					am = (float) Math.sqrt((p < 0.5f ? p : 1 - p));
					scale.set(1 + p);
					break;

				case JET:
					am = (p < 0.5f ? p : 1 - p) * 2;
					scale.set(p * 1.5f);
					break;

				case COIN:
					scale.x = (float) Math.cos(left * 5);
					rm = gm = bm = (Math.abs(scale.x) + 1) * 0.5f;
					am = p < 0.9f ? 1 : (1 - p) * 10;
					break;
			}
		}
	}

	public static Emitter.Factory factory( final int type ) {
		return factory( type, false );
	}

	public static Emitter.Factory factory( final int type, final boolean lightMode ) {

		Emitter.Factory factory = factories.get( type );

		if (factory == null) {
			factory = new Emitter.Factory() {
				@Override
				public void emit ( Emitter emitter, int index, float x, float y ) {
					Speck p = (Speck)emitter.recycle( Speck.class );
					p.reset( index, x, y, type );
				}
				@Override
				public boolean lightMode() {
					return lightMode;
				}
			};
			factories.put( type, factory );
		}

		return factory;
	}
}
