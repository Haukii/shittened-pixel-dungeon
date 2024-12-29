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
import com.watabou.noosa.Image;

public class BannerSprites {

	public enum  Type {
		PIXEL_DUNGEON,
		BOSS_SLAIN,
		GAME_OVER,
		SELECT_YOUR_HERO,
		PIXEL_DUNGEON_SIGNS,
		RAT_SLAIN,
		SHIT_SHIT_SHIT,
		TOURIST_FART,
		FUCK_THE_HERO,
		AMBULANCE,
		SSHHIITT,
		I_NEED_BEANS,
		BEANS_SPILLED,
		LEGO,
		PIXEL_DUNGEON_CHRISTMAS,
		PIXEL_DUNGEON_SIGNS_CHRISTMAS,
		PIXEL_DUNGEON_HALLOWEEN,
		PIXEL_DUNGEON_FINNISH,
		PIXEL_DUNGEON_VALENTINE,
		FRIEND_REQUEST,
		SASS_SLAIN,
		SAAB_SLAIN,
		ASS_SLAIN,
		AAAAA_SLAIN,
		ENEMY_FELLED,
		YASS_SLAY,
	}

	public static Image get( Type type ) {
		Image icon = new Image( Assets.Interfaces.BANNERS );
		switch (type) {
			case PIXEL_DUNGEON:
				icon.frame(icon.texture.uvRect(0, 0, 132, 90));
				break;
			case BOSS_SLAIN:
				icon.frame(icon.texture.uvRect(0, 90, 128, 125));
				break;
			case GAME_OVER:
				icon.frame(icon.texture.uvRect(0, 125, 128, 160));
				break;
			case SELECT_YOUR_HERO:
				icon.frame(icon.texture.uvRect(0, 160, 128, 181));
				break;
			case PIXEL_DUNGEON_SIGNS:
				icon.frame(icon.texture.uvRect(132, 0, 256, 90));
				break;
			case RAT_SLAIN:
				icon.frame(icon.texture.uvRect(23, 198, 100, 219));
				break;
			case SHIT_SHIT_SHIT:
				icon.frame(icon.texture.uvRect(128, 136, 243, 222));
				break;
			case TOURIST_FART:
				icon.frame(icon.texture.uvRect(0, 228, 88, 248));
				break;
			case FUCK_THE_HERO:
				icon.frame(icon.texture.uvRect(0, 256, 96, 276));
				break;
			case AMBULANCE:
				icon.frame(icon.texture.uvRect(0, 282, 74, 298));
				break;
			case SSHHIITT:
				icon.frame(icon.texture.uvRect(0, 301, 96, 319));
				break;
			case I_NEED_BEANS:
				icon.frame(icon.texture.uvRect(0, 323, 81, 338));
				break;
			case BEANS_SPILLED:
				icon.frame(icon.texture.uvRect(0, 344, 92, 359));
				break;
			case LEGO:
				icon.frame(icon.texture.uvRect(143, 232, 231, 292));
				break;
			case PIXEL_DUNGEON_CHRISTMAS:
				icon.frame(icon.texture.uvRect(123, 310, 247, 404));
				break;
			case PIXEL_DUNGEON_HALLOWEEN:
				icon.frame(icon.texture.uvRect(121, 411, 245, 500));
				break;
			case PIXEL_DUNGEON_SIGNS_CHRISTMAS:
				icon.frame(icon.texture.uvRect(131, 504, 254, 580));
				break;
			case PIXEL_DUNGEON_FINNISH:
				icon.frame(icon.texture.uvRect(136, 585, 243, 681));
				break;
			case PIXEL_DUNGEON_VALENTINE:
				icon.frame(icon.texture.uvRect(129, 694, 253, 801));
				break;
			case FRIEND_REQUEST:
				icon.frame(icon.texture.uvRect(0, 368, 46, 383));
				break;
			case SASS_SLAIN:
				icon.frame(icon.texture.uvRect(0, 384, 84, 404));
				break;
			case SAAB_SLAIN:
				icon.frame(icon.texture.uvRect(0, 406, 84, 427));
				break;
			case ASS_SLAIN:
				icon.frame(icon.texture.uvRect(0, 429, 71, 449));
				break;
			case AAAAA_SLAIN:
				icon.frame(icon.texture.uvRect(0, 454, 113, 474));
				break;
			case ENEMY_FELLED:
				icon.frame(icon.texture.uvRect(0, 476, 92, 494));
				break;
			case YASS_SLAY:
				icon.frame(icon.texture.uvRect(0, 496, 77, 516));
				break;
		}
		return icon;
	}
}
