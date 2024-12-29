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

package com.shatteredpixel.shatteredpixeldungeon;

public class Assets {

	public static class Effects {
		public static final String EFFECTS      = "effects/effects.png";
		public static final String FIREBALL     = "effects/fireball.png";
		public static final String SPECKS       = "effects/specks.png";
		public static final String SPELL_ICONS  = "effects/spell_icons.png";
		public static final String TEXT_ICONS   = "effects/text_icons.png";
	}

	public static class Environment {
		public static final String TERRAIN_FEATURES = "environment/terrain_features.png";

		public static final String VISUAL_GRID  = "environment/visual_grid.png";
		public static final String WALL_BLOCKING= "environment/wall_blocking.png";

		public static final String TILES_SEWERS = "environment/tiles_sewers.png";
		public static final String TILES_PRISON = "environment/tiles_prison.png";
		public static final String TILES_CAVES  = "environment/tiles_caves.png";
		public static final String TILES_CAVES_CHRISTMAS  = "environment/tiles_caves_christmas.png";
		public static final String TILES_CITY   = "environment/tiles_city.png";
		public static final String TILES_HALLS  = "environment/tiles_halls.png";

		public static final String TILES_CAVES_CRYSTAL  = "environment/tiles_caves_crystal.png";
		public static final String TILES_CAVES_GNOLL    = "environment/tiles_caves_gnoll.png";

		public static final String WATER_SEWERS = "environment/water0.png";
		public static final String WATER_PRISON = "environment/water1.png";
		public static final String WATER_CAVES  = "environment/water2.png";
		public static final String WATER_CITY   = "environment/water3.png";
		public static final String WATER_HALLS  = "environment/water4.png";
		public static final String WATER_ICE  	= "environment/water5.png";

		public static final String WEAK_FLOOR       = "environment/custom_tiles/weak_floor.png";
		public static final String SEWER_BOSS       = "environment/custom_tiles/sewer_boss.png";
		public static final String PRISON_QUEST     = "environment/custom_tiles/prison_quest.png";
		public static final String PRISON_EXIT      = "environment/custom_tiles/prison_exit.png";
		public static final String CAVES_QUEST      = "environment/custom_tiles/caves_quest.png";
		public static final String CAVES_BOSS       = "environment/custom_tiles/caves_boss.png";
		public static final String CITY_BOSS        = "environment/custom_tiles/city_boss.png";
		public static final String HALLS_SP         = "environment/custom_tiles/halls_special.png";
		public static final String BEACH_SP         = "environment/custom_tiles/beach_special.png";
		public static final String RATROOM_SP         = "environment/custom_tiles/ratroom_special.png";
		public static final String CAPYNEST_SP         = "environment/custom_tiles/capybaranest.png";
		public static final String CAVES_BOSS_CHRISTMAS       = "environment/custom_tiles/caves_boss_christmas.png";

	}
	
	//TODO include other font assets here? Some are platform specific though...
	public static class Fonts {
		public static final String PIXELFONT= "fonts/pixel_font.png";
	}

	public static class Interfaces {
		public static final String ARCS_BG  = "interfaces/arcs1.png";
		public static final String ARCS_FG  = "interfaces/arcs2.png";

		public static final String BANNERS  = "interfaces/banners.png";
		public static final String BADGES   = "interfaces/badges.png";
		public static final String LOCKED   = "interfaces/locked_badge.png";

		public static final String CHROME   = "interfaces/chrome.png";
		public static final String ICONS    = "interfaces/icons.png";
		public static final String STATUS   = "interfaces/status_pane.png";
		public static final String MENU     = "interfaces/menu_pane.png";
		public static final String MENU_BTN = "interfaces/menu_button.png";
		public static final String TOOLBAR  = "interfaces/toolbar.png";
		public static final String SHADOW   = "interfaces/shadow.png";
		public static final String BOSSHP   = "interfaces/boss_hp.png";

		public static final String SURFACE  = "interfaces/surface.png";

		public static final String BUFFS_SMALL      = "interfaces/buffs.png";
		public static final String BUFFS_LARGE      = "interfaces/large_buffs.png";

		public static final String TALENT_ICONS     = "interfaces/talent_icons.png";
		public static final String TALENT_BUTTON    = "interfaces/talent_button.png";

		public static final String HERO_ICONS       = "interfaces/hero_icons.png";

		public static final String RADIAL_MENU      = "interfaces/radial_menu.png";
	}

	//these points to resource bundles, not raw asset files
	public static class Messages {
		public static final String ACTORS   = "messages/actors/actors";
		public static final String ITEMS    = "messages/items/items";
		public static final String JOURNAL  = "messages/journal/journal";
		public static final String LEVELS   = "messages/levels/levels";
		public static final String MISC     = "messages/misc/misc";
		public static final String PLANTS   = "messages/plants/plants";
		public static final String SCENES   = "messages/scenes/scenes";
		public static final String UI       = "messages/ui/ui";
		public static final String WINDOWS  = "messages/windows/windows";
	}

	public static class Music {
		public static final String THEME_1              = "music/theme_1.ogg";
		public static final String THEME_2              = "music/theme_2.ogg";
		public static final String THEME_3      		= "music/theme_3.ogg";
		public static final String THEME_FINALE         = "music/theme_finale.ogg";
		public static final String THEME_XMAS   		= "music/theme_xmas.ogg";

		public static final String SEWERS_1             = "music/sewers_1.ogg";
		public static final String SEWERS_2             = "music/sewers_2.ogg";
		public static final String SEWERS_3             = "music/sewers_3.ogg";
		public static final String SEWERS_TENSE         = "music/sewers_tense.ogg";
		public static final String SEWERS_BOSS          = "music/sewers_boss.ogg";

		public static final String PRISON_1             = "music/prison_1.ogg";
		public static final String PRISON_2             = "music/prison_2.ogg";
		public static final String PRISON_3             = "music/prison_3.ogg";
		public static final String PRISON_TENSE         = "music/prison_tense.ogg";
		public static final String PRISON_BOSS          = "music/prison_boss.ogg";

		public static final String CAVES_1              = "music/caves_1.ogg";
		public static final String CAVES_2              = "music/caves_2.ogg";
		public static final String CAVES_3              = "music/caves_3.ogg";
		public static final String CAVES_TENSE          = "music/caves_tense.ogg";
		public static final String CAVES_CHRISTMAS_1    = "music/caves_christmas_1.ogg";
		public static final String CAVES_CHRISTMAS_2    = "music/caves_christmas_2.ogg";
		public static final String CAVES_BOSS_1 		= "music/caves_boss_1.ogg";
		public static final String CAVES_BOSS_2 		= "music/caves_boss_2.ogg";
		public static final String CAVES_BOSS_3 		= "music/caves_boss_3.ogg";
		public static final String CAVES_BOSS_FINALE    = "music/caves_boss_finale.ogg";

		public static final String CITY_1               = "music/city_1.ogg";
		public static final String CITY_2               = "music/city_2.ogg";
		public static final String CITY_3               = "music/city_3.ogg";
		public static final String CITY_TENSE           = "music/city_tense.ogg";
		public static final String CITY_BOSS            = "music/city_boss.ogg";
		public static final String CITY_BOSS_FINALE     = "music/city_boss_finale.ogg";
		public static final String KING_ANGRY   		= "music/king_angry.ogg";
		public static final String KING_DEATH    		= "music/king_death.ogg";
		public static final String KING_VICTORY  		= "music/king_victory.ogg";

		public static final String HALLS_1              = "music/halls_1.ogg";
		public static final String HALLS_2              = "music/halls_2.ogg";
		public static final String HALLS_3              = "music/halls_3.ogg";
		public static final String HALLS_TENSE          = "music/halls_tense.ogg";
		public static final String HALLS_BOSS           = "music/halls_boss.ogg";
		public static final String HALLS_BOSS_FINALE    = "music/halls_boss_finale.ogg";
		public static final String HALLS_SILVER_1      	= "music/halls_silver_1.ogg";
		public static final String HALLS_SILVER_2      	= "music/halls_silver_2.ogg";
		public static final String HALLS_SILVER_3      	= "music/halls_silver_3.ogg";
		public static final String HALLS_SILVER_4      	= "music/halls_silver_4.ogg";
		public static final String HALLS_SILVER_5      	= "music/halls_silver_5.ogg";
		public static final String HALLS_PINK_1      	= "music/halls_pink_1.ogg";
		public static final String HALLS_PINK_2      	= "music/halls_pink_2.ogg";
		public static final String HALLS_PINK_3      	= "music/halls_pink_3.ogg";
		public static final String HALLS_STONE_1    	= "music/halls_stone_1.ogg";
		public static final String HALLS_STONE_2    	= "music/halls_stone_2.ogg";
		public static final String HALLS_STONE_3    	= "music/halls_stone_3.ogg";
		public static final String HALLS_COMPLETE   	= "music/halls_complete.ogg";
		public static final String HALLS_BOSS_SILVER	= "music/halls_boss_silver.ogg";
		public static final String HALLS_BOSS_GOLD  	= "music/halls_boss_gold.ogg";
		public static final String HALLS_BOSS_STONE   	= "music/halls_boss_stone.ogg";
		public static final String HALLS_DEATH  		= "music/halls_death.ogg";

		//TODO. Do something to these. (I came up ascend music first, but now my implementation might be obsolete)
//		public static final String HALLS_ASCEND 		= "music/halls_ascend.ogg";
//		public static final String CITY_ASCEND  		= "music/city_ascend_1.ogg";
//		public static final String CITY_ASCEND_2  		= "music/city_ascend_2.ogg";
//		public static final String CAVES_ASCEND_1  		= "music/caves_ascend_1.ogg";
//		public static final String CAVES_ASCEND_2  		= "music/caves_ascend_2.ogg";
//		public static final String PRISON_ASCEND  		= "music/prison_ascend_1.ogg";
//		public static final String PRISON_ASCEND_2  	= "music/prison_ascend_2.ogg";
//		public static final String SEWERS_ASCEND_1  	= "music/sewer_ascend_1.ogg";
//		public static final String SEWERS_ASCEND_2  	= "music/sewer_ascend_2.ogg";

		public static final String WIN 					= "music/win.ogg";
		public static final String FAREWELL 			= "music/farewell.ogg";
		public static final String STORE 				= "music/store.ogg";
		public static final String SURFACE_DAY 			= "music/surface_day.ogg";
		public static final String SURFACE_NIGHT 		= "music/surface_night.ogg";
		public static final String CHOOSE 				= "music/choose.ogg";
		public static final String BEACH_DAY 			= "music/beach_day.ogg";

		//Music player
		public static final String RATRATRAT 			= "music/player/ratratrat.ogg";
		public static final String RATTYRAT 			= "music/player/rattyrat.ogg";
		public static final String RAT_NOISES 			= "music/player/rat_noises.ogg";
		public static final String CANTO_TWINGO 		= "music/player/canto_twingo.ogg";
		public static final String TWIGIGIGI 			= "music/player/twigigigi.ogg";
		public static final String TWINGO_TURBO 		= "music/player/twingo_turbo.ogg";
		public static final String YSILUOKKALAISET 		= "music/player/ysiluokkalaiset.ogg";
		public static final String MISSA_TWINGO 		= "music/player/missa_twingo.ogg";
		public static final String MOKKITIE 			= "music/player/mokkitie.ogg";
		public static final String SUNSET 				= "music/player/sunset.ogg";
		public static final String ADVENTURE 			= "music/player/adventure.ogg";
		public static final String WESTERNESS 			= "music/player/westerness.ogg";
		public static final String ON_THE_STREETS		= "music/player/on_the_streets.ogg";
		public static final String HOG_EPIC 			= "music/player/hog_epic.ogg";
		public static final String HOG_PHONK 			= "music/player/hog_phonk.ogg";
		public static final String RIDE_THE_HOG 		= "music/player/ride_the_hog.ogg";
		public static final String REMIX_SEWER 			= "music/player/remix_sewer.ogg";
		public static final String REMIX_SEWER_BOSS 	= "music/player/remix_sewer_boss.ogg";
		public static final String REMIX_PRISON_BOSS	= "music/player/remix_prison_boss.ogg";
		public static final String REMIX_CITY_FINALE	= "music/player/remix_city_finale.ogg";
		public static final String CHAIR				= "music/player/chair.ogg";
		public static final String MY_TABLE				= "music/player/my_table.ogg";
		public static final String STOOL_GONE			= "music/player/stool_gone.ogg";
		public static final String ECHOES				= "music/player/echoes.ogg";
		public static final String SHART_DAY			= "music/player/shart_day.ogg";
		public static final String WOOOOOOH				= "music/player/wooooooh.ogg";
		public static final String DANCE_STARS			= "music/player/dance_stars.ogg";
		public static final String STORMY_ROCK			= "music/player/stormy_rock.ogg";
		public static final String SAILING_DREAM		= "music/player/sailing_dream.ogg";
		public static final String HIGH_TIDE			= "music/player/high_tide.ogg";
		public static final String AFWFSW		 		= "music/player/afwfsw.ogg";
		public static final String WOWOWOWO		 		= "music/player/wowowowo.ogg";
		public static final String PIPIKUKU		 		= "music/player/pipikuku.ogg";
		public static final String UOAUOA		 		= "music/player/uoauoa.ogg";
		public static final String TALE		 			= "music/player/fantasy_tale.ogg";
		public static final String DESTINATION			= "music/player/destination.ogg";
		public static final String FUJI					= "music/player/fuji.ogg";
		public static final String REAWAKENING			= "music/player/reawakening.ogg";
		public static final String FLOW					= "music/player/flow.ogg";
	}

	public static class Sounds {
		public static final String CLICK    = "sounds/click.mp3";
		public static final String BADGE    = "sounds/badge.mp3";
		public static final String GOLD     = "sounds/gold.mp3";

		public static final String OPEN_1     		= "sounds/movement/door_open_1.mp3";
		public static final String OPEN_2     		= "sounds/movement/door_open_2.mp3";
		public static final String OPEN_3     		= "sounds/movement/door_open_3.mp3";
		public static final String OPEN_4     		= "sounds/movement/door_open_4.mp3";
		public static final String CLOSE_1     		= "sounds/movement/door_close_1.mp3";
		public static final String CLOSE_2     		= "sounds/movement/door_close_2.mp3";
		public static final String CLOSE_3     		= "sounds/movement/door_close_3.mp3";
		public static final String CLOSE_4     		= "sounds/movement/door_close_4.mp3";
		public static final String UNLOCK   		= "sounds/unlock.mp3";
		public static final String ITEM     		= "sounds/item.mp3";
		public static final String DEWDROP  		= "sounds/dewdrop.mp3";
		public static final String WATER_1    		= "sounds/movement/water_1.mp3";
		public static final String WATER_2    		= "sounds/movement/water_2.mp3";
		public static final String WATER_3    		= "sounds/movement/water_3.mp3";
		public static final String SPLASH    		= "sounds/movement/splash.mp3";
		public static final String GRASS_1    		= "sounds/movement/grass_1.mp3";
		public static final String GRASS_2    		= "sounds/movement/grass_2.mp3";
		public static final String GRASS_3    		= "sounds/movement/grass_3.mp3";
		public static final String TRAMPLE_1  		= "sounds/movement/trample_1.mp3";
		public static final String TRAMPLE_2  		= "sounds/movement/trample_2.mp3";
		public static final String STEP_1 			= "sounds/movement/step_1.mp3";
		public static final String STEP_2 			= "sounds/movement/step_2.mp3";
		public static final String STEP_3 			= "sounds/movement/step_3.mp3";
		public static final String STEP_4 			= "sounds/movement/step_4.mp3";
		public static final String STEP_5 			= "sounds/movement/step_5.mp3";
		public static final String STEP_6 			= "sounds/movement/step_6.mp3";
		public static final String STEP_7 			= "sounds/movement/step_7.mp3";
		public static final String DIRT_1 			= "sounds/movement/dirt_1.mp3";
		public static final String DIRT_2 			= "sounds/movement/dirt_2.mp3";
		public static final String DIRT_3 			= "sounds/movement/dirt_3.mp3";
		public static final String DIRT_4 			= "sounds/movement/dirt_4.mp3";
		public static final String DIRT_5 			= "sounds/movement/dirt_5.mp3";
		public static final String DIRT_6 			= "sounds/movement/dirt_6.mp3";
		public static final String WOOD_1 			= "sounds/movement/wood_1.mp3";
		public static final String WOOD_2 			= "sounds/movement/wood_2.mp3";
		public static final String WOOD_3 			= "sounds/movement/wood_3.mp3";
		public static final String METAL_1 			= "sounds/movement/metal_1.mp3";
		public static final String METAL_2 			= "sounds/movement/metal_2.mp3";
		public static final String METAL_3 			= "sounds/movement/metal_3.mp3";
		public static final String METAL_4 			= "sounds/movement/metal_4.mp3";
		public static final String SAND_1			= "sounds/movement/sand_1.mp3";
		public static final String SAND_2			= "sounds/movement/sand_2.mp3";
		public static final String SAND_3			= "sounds/movement/sand_3.mp3";
		public static final String SAND_4			= "sounds/movement/sand_4.mp3";
		public static final String SAND_5			= "sounds/movement/sand_5.mp3";
		public static final String STAIRS_1 		= "sounds/movement/stairs_1.mp3";
		public static final String STAIRS_2 		= "sounds/movement/stairs_2.mp3";
		public static final String STAIRS_3 		= "sounds/movement/stairs_3.mp3";

		public static final String HIT              = "sounds/hit.mp3";
		public static final String MISS             = "sounds/miss.mp3";
		public static final String HIT_SLASH        = "sounds/hit_slash.mp3";
		public static final String HIT_STAB         = "sounds/hit_stab.mp3";
		public static final String HIT_CRUSH        = "sounds/hit_crush.mp3";
		public static final String HIT_MAGIC        = "sounds/hit_magic.mp3";
		public static final String HIT_STRONG       = "sounds/hit_strong.mp3";
		public static final String HIT_PARRY        = "sounds/hit_parry.mp3";
		public static final String HIT_ARROW        = "sounds/hit_arrow.mp3";
		public static final String HIT_GLANCE       = "sounds/hit_glance.mp3";
		public static final String HIT_PILE        	= "sounds/hit_pile.mp3";
		public static final String HIT_WHIP        	= "sounds/hit_whip.mp3";
		public static final String ATK_SPIRITBOW    = "sounds/atk_spiritbow.mp3";
		public static final String ATK_CROSSBOW     = "sounds/atk_crossbow.mp3";
		public static final String HEALTH_WARN      = "sounds/health_warn.mp3";
		public static final String HEALTH_CRITICAL  = "sounds/health_critical.mp3";

		public static final String DESCEND  		= "sounds/descend.mp3";
		public static final String DESCEND_ALT  	= "sounds/descend_alt.mp3";
		public static final String EAT      		= "sounds/eat.mp3";
		public static final String READ     		= "sounds/read.mp3";
		public static final String LULLABY  		= "sounds/lullaby.mp3";
		public static final String DRINK    		= "sounds/drink.mp3";
		public static final String SHATTER  		= "sounds/shatter.mp3";
		public static final String ZAP      		= "sounds/zap.mp3";
		public static final String LIGHTNING		= "sounds/lightning.mp3";

		public static final String LEVELUP_1 		= "sounds/levelup_1.mp3";
		public static final String LEVELUP_2 		= "sounds/levelup_2.mp3";
		public static final String LEVELUP_3 		= "sounds/levelup_3.mp3";
		public static final String LEVELUP_4 		= "sounds/levelup_4.mp3";
		public static final String LEVELUP_5 		= "sounds/levelup_5.mp3";
		public static final String LEVELUP_6 		= "sounds/levelup_6.mp3";
		public static final String DEATH_1    		= "sounds/death_1.mp3";
		public static final String DEATH_2    		= "sounds/death_2.mp3";
		public static final String DEATH_3    		= "sounds/death_3.mp3";
		public static final String DEATH_4    		= "sounds/death_4.mp3";
		public static final String DEATH_5    		= "sounds/death_5.mp3";
		public static final String DEATH_6    		= "sounds/death_6.mp3";
		public static final String DEATH_7    		= "sounds/death_7.mp3";
		public static final String DEATH_8    		= "sounds/death_8.mp3";
		public static final String DEATH_9    		= "sounds/death_9.mp3";
		public static final String DEATH_10    		= "sounds/death_10.mp3";
		public static final String DEATH_11    		= "sounds/death_11.mp3";
		public static final String DEATH_12    		= "sounds/death_12.mp3";

		public static final String CHALLENGE		= "sounds/challenge.mp3";
		public static final String CURSED   		= "sounds/cursed.mp3";
		public static final String TRAP     		= "sounds/trap.mp3";
		public static final String EVOKE    		= "sounds/evoke.mp3";
		public static final String TOMB     		= "sounds/tomb.mp3";
		public static final String ALERT    		= "sounds/alert.mp3";
		public static final String MELD     		= "sounds/meld.mp3";
		public static final String BOSS     		= "sounds/boss.mp3";
		public static final String BOSSOB     		= "sounds/bossob.mp3";
		public static final String BLAST    		= "sounds/blast.mp3";
		public static final String BLAST_LARGE    	= "sounds/blast_large.mp3";
		public static final String PLANT    		= "sounds/plant.mp3";
		public static final String RAY      		= "sounds/ray.mp3";
		public static final String BEACON   		= "sounds/beacon.mp3";
		public static final String TELEPORT 		= "sounds/teleport.mp3";
		public static final String CHARMS   		= "sounds/charms.mp3";
		public static final String MASTERY  		= "sounds/mastery.mp3";
		public static final String PUFF     		= "sounds/puff.mp3";
		public static final String ROCKS    		= "sounds/rocks.mp3";
		public static final String BURNING  		= "sounds/burning.mp3";
		public static final String FALLING  		= "sounds/falling.mp3";
		public static final String CHASM1  			= "sounds/movement/chasm_1.mp3";
		public static final String CHASM2  			= "sounds/movement/chasm_2.mp3";
		public static final String CHASM3  			= "sounds/movement/chasm_3.mp3";
		public static final String GHOST    		= "sounds/ghost.mp3";
		public static final String SECRET   		= "sounds/secret.mp3";
		public static final String BONES    		= "sounds/bones.mp3";
		public static final String BEE      		= "sounds/bee.mp3";
		public static final String DEGRADE  		= "sounds/degrade.mp3";
		public static final String MIMIC    		= "sounds/mimic.mp3";
		public static final String DEBUFF   		= "sounds/debuff.mp3";
		public static final String CHARGEUP 		= "sounds/chargeup.mp3";
		public static final String GAS      		= "sounds/gas.mp3";
		public static final String GAS_GAS_GAS      = "sounds/gas_gas_gas.mp3";
		public static final String CHAINS   		= "sounds/chains.mp3";
		public static final String SCAN     		= "sounds/scan.mp3";
		public static final String SHEEP    		= "sounds/sheep.mp3";

		public static final String OOF   		 	= "sounds/oof.mp3";
		public static final String AWAKE    		= "sounds/awake.mp3";
		public static final String MINE_TRIGGER 	= "sounds/mine_trigger.mp3";
		public static final String CRAB_RAVE 		= "sounds/crab_rave.mp3";
		public static final String CRAB_01 			= "sounds/crab_01.mp3";
		public static final String CRAB_02 			= "sounds/crab_02.mp3";
		public static final String CRAB_03 			= "sounds/crab_03.mp3";
		public static final String CRAB_04 			= "sounds/crab_04.mp3";
		public static final String CRAB_05 			= "sounds/crab_05.mp3";
		public static final String CRAB_06 			= "sounds/crab_06.mp3";
		public static final String FREE_RAT 		= "sounds/free_rat.mp3";
		public static final String CAPYBARA 		= "sounds/capybara.mp3";
		public static final String VINEBOOM 		= "sounds/vineboom.mp3";
		public static final String GUN 				= "sounds/gun.mp3";
		public static final String M1911 			= "sounds/m1911.mp3";
		public static final String WINCHESTER 		= "sounds/winchester.mp3";
		public static final String BAR 				= "sounds/bar.mp3";
		public static final String TURD 			= "sounds/turd.mp3";
		public static final String GOD 				= "sounds/god.mp3";
		public static final String GODWARNING 		= "sounds/godwarning.mp3";
		public static final String SAUL 			= "sounds/saul.mp3";
		public static final String CORRUPT 			= "sounds/corrupt.mp3";
		public static final String IMPACT_DEATH 	= "sounds/impact_death.mp3";
		public static final String PITFALL 			= "sounds/pitfall.mp3";
		public static final String BAT 				= "sounds/bat.mp3";
		public static final String CLOCK 			= "sounds/clock.mp3";
		public static final String NIGHT 			= "sounds/night.mp3";
		public static final String LOCKED_DOOR_1 	= "sounds/locked_door_1.mp3";
		public static final String LOCKED_DOOR_2 	= "sounds/locked_door_2.mp3";
		public static final String LOCKED_DOOR_3 	= "sounds/locked_door_3.mp3";
		public static final String RISER 			= "sounds/riser.mp3";
		public static final String SIGN 			= "sounds/sign.mp3";

		public static final String POPUP 	 		= "sounds/popup.mp3";
		public static final String CALL 			= "sounds/call.mp3";
		public static final String CALL_CROWS 		= "sounds/call_crows.mp3";
		public static final String CALL_BING 		= "sounds/call_bing.mp3";
		public static final String CALL_SEPTIMUS 	= "sounds/call_septimus.mp3";
		public static final String CALL_BROKEN 		= "sounds/call_broken.mp3";
		public static final String DEJA_VU 			= "sounds/dejavu.mp3";
		public static final String NUTS 			= "sounds/food/nuts.mp3";
		public static final String PAPER_RIP 		= "sounds/paper_rip.mp3";
		public static final String GATE_UNLOCK 		= "sounds/gate_unlock.mp3";

		public static final String UPGRAGE_WEAPON 	= "sounds/equipment/upgrade_weapon.mp3";
		public static final String UPGRAGE_ARMOR 	= "sounds/equipment/upgrade_armor.mp3";
		public static final String UPGRAGE_WAND 	= "sounds/equipment/upgrade_wand.mp3";
		public static final String UPGRAGE_WAND_ALT = "sounds/equipment/upgrade_wand_alt.mp3";
		public static final String UPGRAGE_RING 	= "sounds/equipment/upgrade_ring.mp3";
		public static final String EQUIP_SWORD 		= "sounds/equipment/equip_sword.mp3";
		public static final String EQUIP_DAGGER 	= "sounds/equipment/equip_dagger.mp3";
		public static final String EQUIP_AXE 		= "sounds/equipment/equip_axe.mp3";
		public static final String EQUIP_CLOTH 		= "sounds/equipment/equip_cloth.mp3";
		public static final String EQUIP_LEATHER 	= "sounds/equipment/equip_leather.mp3";
		public static final String EQUIP_CHAIN 		= "sounds/equipment/equip_chain.mp3";
		public static final String EQUIP_SCALE 		= "sounds/equipment/equip_scale.mp3";
		public static final String EQUIP_STEEL 		= "sounds/equipment/equip_steel.mp3";
		public static final String EQUIP_TRINKET 	= "sounds/equipment/equip_trinket.mp3";
		public static final String EQUIP_WOOD 		= "sounds/equipment/equip_wood.mp3";
		public static final String EQUIP_PAPER 		= "sounds/equipment/equip_paper.mp3";
		public static final String UNEQUIP_SWORD 	= "sounds/equipment/unequip_sword.mp3";
		public static final String UNEQUIP_DAGGER 	= "sounds/equipment/unequip_dagger.mp3";
		public static final String UNEQUIP_AXE 		= "sounds/equipment/unequip_axe.mp3";
		public static final String UNEQUIP_CLOTH 	= "sounds/equipment/unequip_cloth.mp3";
		public static final String UNEQUIP_LEATHER 	= "sounds/equipment/unequip_leather.mp3";
		public static final String UNEQUIP_CHAIN 	= "sounds/equipment/unequip_chain.mp3";
		public static final String UNEQUIP_SCALE 	= "sounds/equipment/unequip_scale.mp3";
		public static final String UNEQUIP_STEEL 	= "sounds/equipment/unequip_steel.mp3";
		public static final String UNEQUIP_TRINKET 	= "sounds/equipment/unequip_trinket.mp3";
		public static final String UNEQUIP_PAPER 	= "sounds/equipment/unequip_paper.mp3";
		public static final String GUN_RELOAD 		= "sounds/equipment/gun_reload.mp3";
		public static final String GUN_RELOAD_FULL 	= "sounds/equipment/gun_reload_full.mp3";
		public static final String BOLAS 			= "sounds/equipment/bolas.mp3";
		public static final String BOW_STRING_1 	= "sounds/equipment/bow_string_1.mp3";
		public static final String BOW_STRING_2 	= "sounds/equipment/bow_string_2.mp3";
		public static final String BOW_STRING_3 	= "sounds/equipment/bow_string_3.mp3";
		public static final String BOW_STRING_4 	= "sounds/equipment/bow_string_4.mp3";
		public static final String STICK_SNAP	 	= "sounds/equipment/stick_snap.mp3";

		public static final String NOTE 			= "sounds/note.mp3";
		public static final String HARVEST 			= "sounds/harvest.mp3";
		public static final String EGG 				= "sounds/food/egg.mp3";
		public static final String EGG_CRACK 		= "sounds/food/egg_crack.mp3";
		public static final String EGG_CRACK_2 		= "sounds/food/egg_crack_2.mp3";
		public static final String FLOUR 			= "sounds/food/flour.mp3";
		public static final String CARRIER_HIT 		= "sounds/carrier_hit.mp3";
		public static final String HORN 			= "sounds/horn.mp3";
		public static final String INCEPTION 		= "sounds/inception.mp3";
		public static final String CD_INSERT 		= "sounds/cd_insert.mp3";
		public static final String CD_EJECT 		= "sounds/cd_eject.mp3";
		public static final String SPRAY 			= "sounds/spray.mp3";
		public static final String SHEEP_1 			= "sounds/sheep_1.mp3";
		public static final String SHEEP_2 			= "sounds/sheep_2.mp3";
		public static final String SHEEP_3 			= "sounds/sheep_3.mp3";
		public static final String SHEEP_4 			= "sounds/sheep_4.mp3";
		public static final String WIN_SMALL 		= "sounds/win_small.mp3";
		public static final String WIN_MEDIUM 		= "sounds/win_medium.mp3";
		public static final String WIN_LARGE 		= "sounds/win_large.mp3";
		public static final String SLOT_TICK 		= "sounds/slot_tick.mp3";
		public static final String MINE    			= "sounds/mine.mp3";

		public static final String[] all = new String[]{
				CLICK, BADGE, GOLD,

				OPEN_1, OPEN_2, OPEN_3, OPEN_4, CLOSE_1, CLOSE_2, CLOSE_3, CLOSE_4,
				STAIRS_1, STAIRS_2, STAIRS_3, GRASS_1, GRASS_2, GRASS_3, UNLOCK, ITEM, DEWDROP,
				TRAMPLE_1, TRAMPLE_2, WATER_1, WATER_2, WATER_3, DIRT_1, DIRT_2, DIRT_3, DIRT_4,
				DIRT_5, DIRT_6, STEP_1, STEP_2, STEP_3, STEP_4, STEP_5, STEP_6, STEP_7,
				WOOD_1, WOOD_2, WOOD_3, METAL_1, METAL_2, METAL_3, METAL_4, SPLASH, SAND_1, SAND_2,
				SAND_3, SAND_4, SAND_5,

				HIT, MISS, HIT_SLASH, HIT_STAB, HIT_CRUSH, HIT_MAGIC, HIT_STRONG, HIT_PARRY, HIT_GLANCE,
				HIT_ARROW, ATK_SPIRITBOW, ATK_CROSSBOW, HEALTH_WARN, HEALTH_CRITICAL, HIT_PILE, HIT_WHIP,
				EQUIP_SWORD, EQUIP_DAGGER, EQUIP_AXE, EQUIP_CLOTH, EQUIP_LEATHER, EQUIP_CHAIN, EQUIP_SCALE,
				EQUIP_STEEL, EQUIP_TRINKET, EQUIP_WOOD, EQUIP_PAPER,
				UNEQUIP_SWORD, UNEQUIP_DAGGER, UNEQUIP_AXE, UNEQUIP_CLOTH, UNEQUIP_LEATHER, UNEQUIP_CHAIN,
				UNEQUIP_SCALE, UNEQUIP_STEEL, UNEQUIP_TRINKET, UNEQUIP_PAPER,
				GUN_RELOAD, GUN_RELOAD_FULL, BOLAS, BOW_STRING_1, BOW_STRING_2, BOW_STRING_3, BOW_STRING_4,
				STICK_SNAP,


				DESCEND, DESCEND_ALT, EAT, READ, LULLABY, DRINK, SHATTER, ZAP, LIGHTNING,
				LEVELUP_1, LEVELUP_2, LEVELUP_3, LEVELUP_4, LEVELUP_5, LEVELUP_6, DEATH_1, DEATH_2,
				DEATH_3, DEATH_4, DEATH_5, DEATH_6, DEATH_7, DEATH_8, DEATH_9, DEATH_10, DEATH_11, DEATH_12,
				CHALLENGE, CURSED, TRAP, EVOKE, TOMB, ALERT, MELD, BOSS, BLAST, PLANT, RAY, BEACON,
				TELEPORT, CHARMS, MASTERY, PUFF, ROCKS, BURNING, FALLING, GHOST, SECRET, BONES,
				BEE, DEGRADE, MIMIC, DEBUFF, CHARGEUP, GAS, CHAINS, SCAN, SHEEP, OOF, AWAKE,
				MINE_TRIGGER, CRAB_RAVE, CRAB_01, CRAB_02, CRAB_03, CRAB_04, CRAB_05, CRAB_06,
				FREE_RAT, CAPYBARA, VINEBOOM, GUN, M1911, WINCHESTER, BAR, TURD, GOD, GODWARNING,
				SAUL, CORRUPT, CHASM1, CHASM2, CHASM3, IMPACT_DEATH, PITFALL, BAT, CLOCK, NIGHT,
				LOCKED_DOOR_1, LOCKED_DOOR_2, LOCKED_DOOR_3, RISER, SIGN, POPUP, CALL, CALL_CROWS,
				CALL_BING, CALL_SEPTIMUS, CALL_BROKEN, DEJA_VU, GAS_GAS_GAS, NUTS,
				UPGRAGE_WEAPON, UPGRAGE_ARMOR, UPGRAGE_WAND, UPGRAGE_WAND_ALT, UPGRAGE_RING,
				PAPER_RIP, GATE_UNLOCK, NOTE, HARVEST, EGG, EGG_CRACK, EGG_CRACK_2, FLOUR,
				CARRIER_HIT, BLAST_LARGE, BOSSOB, HORN, INCEPTION, CD_INSERT, CD_EJECT, SPRAY,
				SHEEP_1, SHEEP_2, SHEEP_3, SHEEP_4, WIN_SMALL, WIN_MEDIUM, WIN_LARGE, SLOT_TICK, MINE,
		};
	}

	public static class Splashes {
		public static final String WARRIOR  = "splashes/warrior.jpg";
		public static final String MAGE     = "splashes/mage.jpg";
		public static final String ROGUE    = "splashes/rogue.jpg";
		public static final String HUNTRESS = "splashes/huntress.jpg";
		public static final String DUELIST  = "splashes/duelist.jpg";

		public static final String SEWERS   = "splashes/sewers.jpg";
		public static final String PRISON   = "splashes/prison.jpg";
		public static final String CAVES    = "splashes/caves.jpg";
		public static final String CITY     = "splashes/city.jpg";
		public static final String HALLS    = "splashes/halls.jpg";
	}

	public static class Sprites {
		public static final String ITEMS        = "sprites/items.png";
		public static final String ITEM_ICONS   = "sprites/item_icons.png";
		public static final String PREFIX_ICONS  = "sprites/prefix_icons.png";

		public static final String WARRIOR  = "sprites/warrior.png";
		public static final String MAGE     = "sprites/mage.png";
		public static final String ROGUE    = "sprites/rogue.png";
		public static final String HUNTRESS = "sprites/huntress.png";
		public static final String DUELIST  = "sprites/duelist.png";
		public static final String AVATARS  = "sprites/avatars.png";
		public static final String PET      = "sprites/pet.png";
		public static final String AMULET   = "sprites/amulet.png";

		public static final String RAT      = "sprites/rat.png";
		public static final String BRUTE    = "sprites/brute.png";
		public static final String SPINNER  = "sprites/spinner.png";
		public static final String DM300    = "sprites/dm300.png";
		public static final String WRAITH   = "sprites/wraith.png";
		public static final String UNDEAD   = "sprites/undead.png";
		public static final String KING     = "sprites/king.png";
		public static final String PIRANHA  = "sprites/piranha.png";
		public static final String EYE      = "sprites/eye.png";
		public static final String GNOLL    = "sprites/gnoll.png";
		public static final String CRAB     = "sprites/crab.png";
		public static final String GOO      = "sprites/goo.png";
		public static final String SWARM    = "sprites/swarm.png";
		public static final String SKELETON = "sprites/skeleton.png";
		public static final String SHAMAN   = "sprites/shaman.png";
		public static final String THIEF    = "sprites/thief.png";
		public static final String TENGU    = "sprites/tengu.png";
		public static final String SHEEP    = "sprites/sheep.png";
		public static final String KEEPER   = "sprites/shopkeeper.png";
		public static final String BAT      = "sprites/bat.png";
		public static final String ELEMENTAL= "sprites/elemental.png";
		public static final String MONK     = "sprites/monk.png";
		public static final String WARLOCK  = "sprites/warlock.png";
		public static final String GOLEM    = "sprites/golem.png";
		public static final String STATUE   = "sprites/statue.png";
		public static final String SUCCUBUS = "sprites/succubus.png";
		public static final String SCORPIO  = "sprites/scorpio.png";
		public static final String FISTS    = "sprites/yog_fists.png";
		public static final String YOG      = "sprites/yog.png";
		public static final String LARVA    = "sprites/larva.png";
		public static final String GHOST    = "sprites/ghost.png";
		public static final String MAKER    = "sprites/wandmaker.png";
		public static final String TROLL    = "sprites/blacksmith.png";
		public static final String IMP      = "sprites/demon.png";
		public static final String RATKING  = "sprites/ratking.png";
		public static final String BEE      = "sprites/bee.png";
		public static final String MIMIC    = "sprites/mimic.png";
		public static final String ROT_LASH = "sprites/rot_lasher.png";
		public static final String ROT_HEART= "sprites/rot_heart.png";
		public static final String GUARD    = "sprites/guard.png";
		public static final String WARDS    = "sprites/wards.png";
		public static final String GUARDIAN = "sprites/guardian.png";
		public static final String SLIME    = "sprites/slime.png";
		public static final String SNAKE    = "sprites/snake.png";
		public static final String NECRO    = "sprites/necromancer.png";
		public static final String GHOUL    = "sprites/ghoul.png";
		public static final String RIPPER   = "sprites/ripper.png";
		public static final String SPAWNER  = "sprites/spawner.png";
		public static final String DM100    = "sprites/dm100.png";
		public static final String PYLON    = "sprites/pylon.png";
		public static final String DM200    = "sprites/dm200.png";
		public static final String LOTUS    = "sprites/lotus.png";
		public static final String NINJA_LOG        = "sprites/ninja_log.png";
		public static final String SPIRIT_HAWK      = "sprites/spirit_hawk.png";
		public static final String RED_SENTRY       = "sprites/red_sentry.png";
		public static final String CRYSTAL_WISP     = "sprites/crystal_wisp.png";
		public static final String CRYSTAL_GUARDIAN = "sprites/crystal_guardian.png";
		public static final String CRYSTAL_SPIRE    = "sprites/crystal_spire.png";
		public static final String GNOLL_GUARD      = "sprites/gnoll_guard.png";
		public static final String GNOLL_SAPPER     = "sprites/gnoll_sapper.png";
		public static final String GNOLL_GEOMANCER  = "sprites/gnoll_geomancer.png";
		public static final String FUNGAL_SPINNER   = "sprites/fungal_spinner.png";
		public static final String FUNGAL_SENTRY    = "sprites/fungal_sentry.png";
		public static final String FUNGAL_CORE      = "sprites/fungal_core.png";
		public static final String CAPYBARA= "sprites/capybara.png";
		public static final String BOOMBOX= "sprites/boombox.png";
		public static final String EVAN = "sprites/evan.png";
		public static final String FURNITURE = "sprites/furniture.png";
		public static final String ADVENTURER = "sprites/adventurer.png";
		public static final String GLASSBOX = "sprites/glass_box.png";
		public static final String RAVEN = "sprites/raven.png";
		public static final String TOKMANNI = "sprites/tokmanni.png";
		public static final String BUCKET = "sprites/bucket.png";
		public static final String TWINGO = "sprites/twingo.png";
		public static final String KETCHUPSPLAT = "sprites/ketchupsplat.png";
		public static final String HERO = "sprites/hero.png";
		public static final String ARMOR = "sprites/armor.png";
		public static final String ARMOR_DARK = "sprites/armor_dark.png";
		public static final String WARRIOR_HEAD  = "sprites/warrior_head.png";
		public static final String MAGE_HEAD     = "sprites/mage_head.png";
		public static final String ROGUE_HEAD    = "sprites/rogue_head.png";
		public static final String HUNTRESS_HEAD = "sprites/huntress_head.png";
		public static final String DUELIST_HEAD = "sprites/duelist_head.png";
		public static final String SLOTMACHINE = "sprites/slotmachine.png";
	}
}
