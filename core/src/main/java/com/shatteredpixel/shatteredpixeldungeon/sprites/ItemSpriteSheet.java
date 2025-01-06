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

package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.watabou.noosa.TextureFilm;

public class ItemSpriteSheet {

	private static final int WIDTH = 16;
	public static final int SIZE = 16;

	public static TextureFilm film = new TextureFilm( Assets.Sprites.ITEMS, SIZE, SIZE );

	private static int xy(int x, int y){
		x -= 1; y -= 1;
		return x + WIDTH*y;
	}

	private static void assignItemRect( int item, int width, int height ){
		int x = (item % WIDTH) * SIZE;
		int y = (item / WIDTH) * SIZE;
		film.add( item, x, y, x+width, y+height);
	}

	private static final int PLACEHOLDERS   =                               xy(1, 1);   //18 slots
	//SOMETHING is the default item sprite at position 0. May show up ingame if there are bugs.
	public static final int SOMETHING       = PLACEHOLDERS+0;
	public static final int WEAPON_HOLDER   = PLACEHOLDERS+1;
	public static final int ARMOR_HOLDER    = PLACEHOLDERS+2;
	public static final int MISSILE_HOLDER  = PLACEHOLDERS+3;
	public static final int WAND_HOLDER     = PLACEHOLDERS+4;
	public static final int RING_HOLDER     = PLACEHOLDERS+5;
	public static final int ARTIFACT_HOLDER = PLACEHOLDERS+6;
	public static final int TRINKET_HOLDER  = PLACEHOLDERS+7;
	public static final int FOOD_HOLDER     = PLACEHOLDERS+8;
	public static final int BOMB_HOLDER     = PLACEHOLDERS+9;
	public static final int POTION_HOLDER   = PLACEHOLDERS+10;
	public static final int SEED_HOLDER     = PLACEHOLDERS+11;
	public static final int SCROLL_HOLDER   = PLACEHOLDERS+12;
	public static final int STONE_HOLDER    = PLACEHOLDERS+13;
	public static final int ELIXIR_HOLDER   = PLACEHOLDERS+14;
	public static final int SPELL_HOLDER    = PLACEHOLDERS+15;
	public static final int MOB_HOLDER      = PLACEHOLDERS+16;
	public static final int DOCUMENT_HOLDER = PLACEHOLDERS+17;
	static{
		assignItemRect(SOMETHING,       8,  13);
		assignItemRect(WEAPON_HOLDER,   14, 14);
		assignItemRect(ARMOR_HOLDER,    14, 12);
		assignItemRect(MISSILE_HOLDER,  15, 15);
		assignItemRect(WAND_HOLDER,     14, 14);
		assignItemRect(RING_HOLDER,     8,  10);
		assignItemRect(ARTIFACT_HOLDER, 15, 15);
		assignItemRect(TRINKET_HOLDER,  16, 11);
		assignItemRect(FOOD_HOLDER,     15, 11);
		assignItemRect(BOMB_HOLDER,     10, 13);
		assignItemRect(POTION_HOLDER,   12, 14);
		assignItemRect(SEED_HOLDER,     10, 10);
		assignItemRect(SCROLL_HOLDER,   15, 14);
		assignItemRect(STONE_HOLDER,    14, 12);
		assignItemRect(ELIXIR_HOLDER,   12, 14);
		assignItemRect(SPELL_HOLDER,    8,  16);
		assignItemRect(MOB_HOLDER,      15, 14);
		assignItemRect(DOCUMENT_HOLDER, 10, 11);
	}

	private static final int UNCOLLECTIBLE  =                               xy(3, 2);   //14 slots
	public static final int GOLD            = UNCOLLECTIBLE+0;
	public static final int ENERGY          = UNCOLLECTIBLE+1;

	public static final int DEWDROP         = UNCOLLECTIBLE+3;
	public static final int PETAL           = UNCOLLECTIBLE+4;
	public static final int SANDBAG         = UNCOLLECTIBLE+5;
	public static final int SPIRIT_ARROW    = UNCOLLECTIBLE+6;
	
	public static final int TENGU_BOMB      = UNCOLLECTIBLE+8;
	public static final int TENGU_SHOCKER   = UNCOLLECTIBLE+9;
	public static final int GEO_BOULDER     = UNCOLLECTIBLE+10;
	static{
		assignItemRect(GOLD,        15, 13);
		assignItemRect(ENERGY,      16, 16);

		assignItemRect(DEWDROP,     10, 10);
		assignItemRect(PETAL,       8,  8);
		assignItemRect(SANDBAG,     10, 10);
		assignItemRect(SPIRIT_ARROW,11, 11);
		
		assignItemRect(TENGU_BOMB,      10, 8);
		assignItemRect(TENGU_SHOCKER,   11, 11);
		assignItemRect(GEO_BOULDER,     16, 14);
	}

	private static final int CONTAINERS     =                               xy(1, 3);   //16 slots
	public static final int BONES           = CONTAINERS+0;
	public static final int REMAINS         = CONTAINERS+1;
	public static final int TOMB            = CONTAINERS+2;
	public static final int GRAVE           = CONTAINERS+3;
	public static final int CHEST           = CONTAINERS+4;
	public static final int LOCKED_CHEST    = CONTAINERS+5;
	public static final int CRYSTAL_CHEST   = CONTAINERS+6;
	public static final int EBONY_CHEST     = CONTAINERS+7;
	static{
		assignItemRect(BONES,           14, 11);
		assignItemRect(REMAINS,         14, 11);
		assignItemRect(TOMB,            14, 15);
		assignItemRect(GRAVE,           14, 15);
		assignItemRect(CHEST,           16, 14);
		assignItemRect(LOCKED_CHEST,    16, 14);
		assignItemRect(CRYSTAL_CHEST,   16, 14);
		assignItemRect(EBONY_CHEST,     16, 14);
	}

	private static final int MISC_CONSUMABLE =                              xy(1, 4);   //32 slots
	public static final int ANKH            = MISC_CONSUMABLE +0;
	public static final int STYLUS          = MISC_CONSUMABLE +1;
	public static final int SEAL            = MISC_CONSUMABLE +2;
	public static final int TORCH           = MISC_CONSUMABLE +3;
	public static final int BEACON          = MISC_CONSUMABLE +4;
	public static final int HONEYPOT        = MISC_CONSUMABLE +5;
	public static final int SHATTPOT        = MISC_CONSUMABLE +6;
	public static final int IRON_KEY        = MISC_CONSUMABLE +7;
	public static final int GOLDEN_KEY      = MISC_CONSUMABLE +8;
	public static final int CRYSTAL_KEY     = MISC_CONSUMABLE +9;
	public static final int SKELETON_KEY    = MISC_CONSUMABLE +10;
	public static final int MASK            = MISC_CONSUMABLE +11;
	public static final int CROWN           = MISC_CONSUMABLE +12;
	public static final int AMULET          = MISC_CONSUMABLE +13;
	public static final int MASTERY         = MISC_CONSUMABLE +14;
	public static final int KIT             = MISC_CONSUMABLE +15;
	public static final int SEAL_SHARD      = MISC_CONSUMABLE +16;
	public static final int BROKEN_STAFF    = MISC_CONSUMABLE +17;
	public static final int CLOAK_SCRAP     = MISC_CONSUMABLE +18;
	public static final int BOW_FRAGMENT    = MISC_CONSUMABLE +19;
	public static final int BROKEN_HILT     = MISC_CONSUMABLE +20;
	public static final int TRINKET_CATA    = MISC_CONSUMABLE +21;
	public static final int IRONVIPCARD     = MISC_CONSUMABLE +22;
	public static final int GOLDVIPCARD     = MISC_CONSUMABLE +23;
	public static final int CRYSTALVIPCARD  = MISC_CONSUMABLE +24;

	static{
		assignItemRect(ANKH,            10, 16);
		assignItemRect(STYLUS,          12, 13);
		
		assignItemRect(SEAL,            9,  15);
		assignItemRect(TORCH,           12, 15);
		assignItemRect(BEACON,          16, 15);
		
		assignItemRect(HONEYPOT,        14, 12);
		assignItemRect(SHATTPOT,        14, 12);
		assignItemRect(IRON_KEY,        8,  14);
		assignItemRect(GOLDEN_KEY,      8,  14);
		assignItemRect(CRYSTAL_KEY,     8,  14);
		assignItemRect(SKELETON_KEY,    8,  14);
		assignItemRect(MASK,            12,  9);
		assignItemRect(CROWN,           13, 11);
		assignItemRect(AMULET,          16, 16);
		assignItemRect(MASTERY,         13, 16);
		assignItemRect(KIT,             16, 15);

		assignItemRect(SEAL_SHARD,      11, 11);
		assignItemRect(BROKEN_STAFF,    14, 10);
		assignItemRect(CLOAK_SCRAP,      9,  9);
		assignItemRect(BOW_FRAGMENT,    12,  9);
		assignItemRect(BROKEN_HILT,      9,  9);

		assignItemRect(TRINKET_CATA,    12, 11);
		assignItemRect(IRONVIPCARD,     12,  8);
		assignItemRect(GOLDVIPCARD,     12,  8);
		assignItemRect(CRYSTALVIPCARD,  12,  8);
	}
	
	private static final int BOMBS          =                               xy(1, 6);   //16 slots
	public static final int BOMB            = BOMBS+0;
	public static final int DBL_BOMB        = BOMBS+1;
	public static final int FIRE_BOMB       = BOMBS+2;
	public static final int FROST_BOMB      = BOMBS+3;
	public static final int REGROWTH_BOMB   = BOMBS+4;
	public static final int SMOKE_BOMB      = BOMBS+5;
	public static final int FLASHBANG       = BOMBS+6;
	public static final int HOLY_BOMB       = BOMBS+7;
	public static final int WOOLY_BOMB      = BOMBS+8;
	public static final int NOISEMAKER      = BOMBS+9;
	public static final int ARCANE_BOMB     = BOMBS+10;
	public static final int SHRAPNEL_BOMB   = BOMBS+11;
	
	static{
		assignItemRect(BOMB,            10, 13);
		assignItemRect(DBL_BOMB,        14, 13);
		assignItemRect(FIRE_BOMB,       13, 12);
		assignItemRect(FROST_BOMB,      13, 12);
		assignItemRect(REGROWTH_BOMB,   13, 12);
		assignItemRect(SMOKE_BOMB,      13, 12);
		assignItemRect(FLASHBANG,       10, 13);
		assignItemRect(HOLY_BOMB,       10, 13);
		assignItemRect(WOOLY_BOMB,      10, 13);
		assignItemRect(NOISEMAKER,      10, 13);
		assignItemRect(ARCANE_BOMB,     10, 13);
		assignItemRect(SHRAPNEL_BOMB,   10, 13);
	}

	private static final int WEP_TIER1      =                               xy(1, 7);   //8 slots
	public static final int WORN_SHORTSWORD = WEP_TIER1+0;
	public static final int CUDGEL          = WEP_TIER1+1;
	public static final int GLOVES          = WEP_TIER1+2;
	public static final int RAPIER          = WEP_TIER1+3;
	public static final int DAGGER          = WEP_TIER1+4;
	public static final int MAGES_STAFF     = WEP_TIER1+5;
	static{
		assignItemRect(WORN_SHORTSWORD, 13, 13);
		assignItemRect(GLOVES,          12, 16);
		assignItemRect(RAPIER,          13, 14);
		assignItemRect(DAGGER,          12, 13);
		assignItemRect(MAGES_STAFF,     15, 16);
	}

	private static final int WEP_TIER2      =                               xy(9, 7);   //8 slots
	public static final int SHORTSWORD      = WEP_TIER2+0;
	public static final int HAND_AXE        = WEP_TIER2+1;
	public static final int SPEAR           = WEP_TIER2+2;
	public static final int QUARTERSTAFF    = WEP_TIER2+3;
	public static final int DIRK            = WEP_TIER2+4;
	public static final int SICKLE          = WEP_TIER2+5;
	static{
		assignItemRect(SHORTSWORD,      13, 13);
		assignItemRect(HAND_AXE,        12, 14);
		assignItemRect(SPEAR,           16, 16);
		assignItemRect(QUARTERSTAFF,    16, 16);
		assignItemRect(DIRK,            13, 14);
		assignItemRect(SICKLE,          15, 15);
	}

	private static final int WEP_TIER3      =                               xy(1, 8);   //8 slots
	public static final int SWORD           = WEP_TIER3+0;
	public static final int MACE            = WEP_TIER3+1;
	public static final int SCIMITAR        = WEP_TIER3+2;
	public static final int ROUND_SHIELD    = WEP_TIER3+3;
	public static final int SAI             = WEP_TIER3+4;
	public static final int WHIP            = WEP_TIER3+5;
	static{
		assignItemRect(SWORD,           14, 14);
		assignItemRect(MACE,            15, 15);
		assignItemRect(SCIMITAR,        13, 16);
		assignItemRect(ROUND_SHIELD,    16, 16);
		assignItemRect(SAI,             16, 16);
		assignItemRect(WHIP,            14, 14);
	}

	private static final int WEP_TIER4      =                               xy(9, 8);   //8 slots
	public static final int LONGSWORD       = WEP_TIER4+0;
	public static final int BATTLE_AXE      = WEP_TIER4+1;
	public static final int FLAIL           = WEP_TIER4+2;
	public static final int RUNIC_BLADE     = WEP_TIER4+3;
	public static final int ASSASSINS_BLADE = WEP_TIER4+4;
	public static final int CROSSBOW        = WEP_TIER4+5;
	public static final int KATANA          = WEP_TIER4+6;
	static{
		assignItemRect(LONGSWORD,       15, 15);
		assignItemRect(BATTLE_AXE,      16, 16);
		assignItemRect(FLAIL,           14, 14);
		assignItemRect(RUNIC_BLADE,     14, 14);
		assignItemRect(ASSASSINS_BLADE, 14, 15);
		assignItemRect(CROSSBOW,        15, 15);
		assignItemRect(KATANA,          15, 16);
	}

	private static final int WEP_TIER5      =                               xy(1, 9);   //8 slots
	public static final int GREATSWORD      = WEP_TIER5+0;
	public static final int WAR_HAMMER      = WEP_TIER5+1;
	public static final int GLAIVE          = WEP_TIER5+2;
	public static final int GREATAXE        = WEP_TIER5+3;
	public static final int GREATSHIELD     = WEP_TIER5+4;
	public static final int GAUNTLETS       = WEP_TIER5+5;
	public static final int WAR_SCYTHE      = WEP_TIER5+6;
	static{
		assignItemRect(GREATSWORD,  16, 16);
		assignItemRect(WAR_HAMMER,  16, 16);
		assignItemRect(GLAIVE,      16, 16);
		assignItemRect(GREATAXE,    12, 16);
		assignItemRect(GREATSHIELD, 12, 16);
		assignItemRect(GAUNTLETS,   13, 15);
		assignItemRect(WAR_SCYTHE,  14, 15);
	}

	                                                                                    //8 free slots

	private static final int MISSILE_WEP    =                               xy(1, 10);  //16 slots. 3 per tier + bow
	public static final int SPIRIT_BOW      = MISSILE_WEP+0;
	
	public static final int THROWING_SPIKE  = MISSILE_WEP+1;
	public static final int THROWING_KNIFE  = MISSILE_WEP+2;
	public static final int THROWING_STONE  = MISSILE_WEP+3;
	
	public static final int FISHING_SPEAR   = MISSILE_WEP+4;
	public static final int SHURIKEN        = MISSILE_WEP+5;
	public static final int THROWING_CLUB   = MISSILE_WEP+6;
	
	public static final int THROWING_SPEAR  = MISSILE_WEP+7;
	public static final int BOLAS           = MISSILE_WEP+8;
	public static final int KUNAI           = MISSILE_WEP+9;
	
	public static final int JAVELIN         = MISSILE_WEP+10;
	public static final int TOMAHAWK        = MISSILE_WEP+11;
	public static final int BOOMERANG       = MISSILE_WEP+12;
	
	public static final int TRIDENT         = MISSILE_WEP+13;
	public static final int THROWING_HAMMER = MISSILE_WEP+14;
	public static final int FORCE_CUBE      = MISSILE_WEP+15;
	
	static{
		assignItemRect(SPIRIT_BOW,      16, 16);
		
		assignItemRect(THROWING_SPIKE,  11, 10);
		assignItemRect(THROWING_KNIFE,  12, 13);
		assignItemRect(THROWING_STONE,  12, 10);
		
		assignItemRect(FISHING_SPEAR,   11, 11);
		assignItemRect(SHURIKEN,        12, 12);
		assignItemRect(THROWING_CLUB,   12, 12);
		
		assignItemRect(THROWING_SPEAR,  13, 13);
		assignItemRect(BOLAS,           15, 14);
		assignItemRect(KUNAI,           15, 15);
		
		assignItemRect(JAVELIN,         16, 16);
		assignItemRect(TOMAHAWK,        13, 13);
		assignItemRect(BOOMERANG,       14, 14);
		
		assignItemRect(TRIDENT,         16, 16);
		assignItemRect(THROWING_HAMMER, 12, 12);
		assignItemRect(FORCE_CUBE,      11, 12);
	}
	
	public static final int DARTS    =                                      xy(1, 11);  //16 slots
	public static final int DART            = DARTS+0;
	public static final int ROT_DART        = DARTS+1;
	public static final int INCENDIARY_DART = DARTS+2;
	public static final int ADRENALINE_DART = DARTS+3;
	public static final int HEALING_DART    = DARTS+4;
	public static final int CHILLING_DART   = DARTS+5;
	public static final int SHOCKING_DART   = DARTS+6;
	public static final int POISON_DART     = DARTS+7;
	public static final int CLEANSING_DART  = DARTS+8;
	public static final int PARALYTIC_DART  = DARTS+9;
	public static final int HOLY_DART       = DARTS+10;
	public static final int DISPLACING_DART = DARTS+11;
	public static final int BLINDING_DART   = DARTS+12;
	static {
		for (int i = DARTS; i < DARTS+16; i++)
			assignItemRect(i, 15, 15);
	}
	
	private static final int ARMOR          =                               xy(1, 12);  //16 slots
	public static final int ARMOR_CLOTH     = ARMOR+0;
	public static final int ARMOR_LEATHER   = ARMOR+1;
	public static final int ARMOR_MAIL      = ARMOR+2;
	public static final int ARMOR_SCALE     = ARMOR+3;
	public static final int ARMOR_PLATE     = ARMOR+4;
	public static final int ARMOR_WARRIOR   = ARMOR+5;
	public static final int ARMOR_MAGE      = ARMOR+6;
	public static final int ARMOR_ROGUE     = ARMOR+7;
	public static final int ARMOR_HUNTRESS  = ARMOR+8;
	public static final int ARMOR_DUELIST   = ARMOR+9;
	public static final int ARMOR_MALE  	= ARMOR+10;
	public static final int ARMOR_POST  	= ARMOR+11;
	public static final int PLATE_CARRIER  	= ARMOR+12;
	static{
		assignItemRect(ARMOR_CLOTH,     15, 12);
		assignItemRect(ARMOR_LEATHER,   14, 13);
		assignItemRect(ARMOR_MAIL,      14, 12);
		assignItemRect(ARMOR_SCALE,     14, 11);
		assignItemRect(ARMOR_PLATE,     12, 12);
		assignItemRect(ARMOR_WARRIOR,   12, 12);
		assignItemRect(ARMOR_MAGE,      15, 15);
		assignItemRect(ARMOR_ROGUE,     14, 12);
		assignItemRect(ARMOR_HUNTRESS,  13, 15);
		assignItemRect(ARMOR_DUELIST,   12, 13);
		assignItemRect(ARMOR_MALE,  	14, 12);
		assignItemRect(ARMOR_POST,  	14, 12);
		assignItemRect(PLATE_CARRIER,  	13, 14);
	}

	                                                                                    //16 free slots

	private static final int WANDS              =                           xy(1, 14);  //16 slots
	public static final int WAND_MAGIC_MISSILE  = WANDS+0;
	public static final int WAND_FIREBOLT       = WANDS+1;
	public static final int WAND_FROST          = WANDS+2;
	public static final int WAND_LIGHTNING      = WANDS+3;
	public static final int WAND_DISINTEGRATION = WANDS+4;
	public static final int WAND_PRISMATIC_LIGHT= WANDS+5;
	public static final int WAND_CORROSION      = WANDS+6;
	public static final int WAND_LIVING_EARTH   = WANDS+7;
	public static final int WAND_BLAST_WAVE     = WANDS+8;
	public static final int WAND_CORRUPTION     = WANDS+9;
	public static final int WAND_WARDING        = WANDS+10;
	public static final int WAND_REGROWTH       = WANDS+11;
	public static final int WAND_TRANSFUSION    = WANDS+12;
	static {
		for (int i = WANDS; i < WANDS+16; i++)
			assignItemRect(i, 14, 14);
	}

	private static final int RINGS          =                               xy(1, 15);  //16 slots
	public static final int RING_GARNET     = RINGS+0;
	public static final int RING_RUBY       = RINGS+1;
	public static final int RING_TOPAZ      = RINGS+2;
	public static final int RING_EMERALD    = RINGS+3;
	public static final int RING_ONYX       = RINGS+4;
	public static final int RING_OPAL       = RINGS+5;
	public static final int RING_TOURMALINE = RINGS+6;
	public static final int RING_SAPPHIRE   = RINGS+7;
	public static final int RING_AMETHYST   = RINGS+8;
	public static final int RING_QUARTZ     = RINGS+9;
	public static final int RING_AGATE      = RINGS+10;
	public static final int RING_DIAMOND    = RINGS+11;
	static {
		for (int i = RINGS; i < RINGS+16; i++)
			assignItemRect(i, 8, 10);
	}

	private static final int ARTIFACTS          =                            xy(1, 16);  //24 slots
	public static final int ARTIFACT_CLOAK      = ARTIFACTS+0;
	public static final int ARTIFACT_ARMBAND    = ARTIFACTS+1;
	public static final int ARTIFACT_CAPE       = ARTIFACTS+2;
	public static final int ARTIFACT_TALISMAN   = ARTIFACTS+3;
	public static final int ARTIFACT_HOURGLASS  = ARTIFACTS+4;
	public static final int ARTIFACT_TOOLKIT    = ARTIFACTS+5;
	public static final int ARTIFACT_SPELLBOOK  = ARTIFACTS+6;
	public static final int ARTIFACT_BEACON     = ARTIFACTS+7;
	public static final int ARTIFACT_CHAINS     = ARTIFACTS+8;
	public static final int ARTIFACT_HORN1      = ARTIFACTS+9;
	public static final int ARTIFACT_HORN2      = ARTIFACTS+10;
	public static final int ARTIFACT_HORN3      = ARTIFACTS+11;
	public static final int ARTIFACT_HORN4      = ARTIFACTS+12;
	public static final int ARTIFACT_CHALICE1   = ARTIFACTS+13;
	public static final int ARTIFACT_CHALICE2   = ARTIFACTS+14;
	public static final int ARTIFACT_CHALICE3   = ARTIFACTS+15;
	public static final int ARTIFACT_SANDALS    = ARTIFACTS+16;
	public static final int ARTIFACT_SHOES      = ARTIFACTS+17;
	public static final int ARTIFACT_BOOTS      = ARTIFACTS+18;
	public static final int ARTIFACT_GREAVES    = ARTIFACTS+19;
	public static final int ARTIFACT_ROSE1      = ARTIFACTS+20;
	public static final int ARTIFACT_ROSE2      = ARTIFACTS+21;
	public static final int ARTIFACT_ROSE3      = ARTIFACTS+22;
	static{
		assignItemRect(ARTIFACT_CLOAK,      9,  15);
		assignItemRect(ARTIFACT_ARMBAND,    16, 13);
		assignItemRect(ARTIFACT_CAPE,       16, 14);
		assignItemRect(ARTIFACT_TALISMAN,   15, 13);
		assignItemRect(ARTIFACT_HOURGLASS,  13, 16);
		assignItemRect(ARTIFACT_TOOLKIT,    15, 13);
		assignItemRect(ARTIFACT_SPELLBOOK,  13, 16);
		assignItemRect(ARTIFACT_BEACON,     16, 16);
		assignItemRect(ARTIFACT_CHAINS,     16, 16);
		assignItemRect(ARTIFACT_HORN1,      15, 15);
		assignItemRect(ARTIFACT_HORN2,      15, 15);
		assignItemRect(ARTIFACT_HORN3,      15, 15);
		assignItemRect(ARTIFACT_HORN4,      15, 15);
		assignItemRect(ARTIFACT_CHALICE1,   12, 15);
		assignItemRect(ARTIFACT_CHALICE2,   12, 15);
		assignItemRect(ARTIFACT_CHALICE3,   12, 15);
		assignItemRect(ARTIFACT_SANDALS,    16, 6 );
		assignItemRect(ARTIFACT_SHOES,      16, 6 );
		assignItemRect(ARTIFACT_BOOTS,      16, 9 );
		assignItemRect(ARTIFACT_GREAVES,    16, 14);
		assignItemRect(ARTIFACT_ROSE1,      14, 14);
		assignItemRect(ARTIFACT_ROSE2,      14, 14);
		assignItemRect(ARTIFACT_ROSE3,      14, 14);
	}

	private static final int TRINKETS        =                               xy(9, 17);  //24 slots
	public static final int RAT_SKULL       = TRINKETS+0;
	public static final int PARCHMENT_SCRAP = TRINKETS+1;
	public static final int PETRIFIED_SEED  = TRINKETS+2;
	public static final int EXOTIC_CRYSTALS = TRINKETS+3;
	public static final int MOSSY_CLUMP     = TRINKETS+4;
	public static final int SUNDIAL         = TRINKETS+5;
	public static final int CLOVER          = TRINKETS+6;
	public static final int TRAP_MECHANISM  = TRINKETS+7;
	public static final int MIMIC_TOOTH     = TRINKETS+8;
	public static final int WONDROUS_RESIN  = TRINKETS+9;
	public static final int EYE_OF_NEWT     = TRINKETS+10;
	public static final int SALT_CUBE       = TRINKETS+11;
	public static final int BLOOD_VIAL      = TRINKETS+12;
	public static final int OBLIVION_SHARD  = TRINKETS+13;
	public static final int CHAOTIC_CENSER  = TRINKETS+14;
	static{
		assignItemRect(RAT_SKULL,       16, 11);
		assignItemRect(PARCHMENT_SCRAP, 10, 14);
		assignItemRect(PETRIFIED_SEED,  10, 10);
		assignItemRect(EXOTIC_CRYSTALS, 14, 13);
		assignItemRect(MOSSY_CLUMP,     12, 11);
		assignItemRect(SUNDIAL,         16, 12);
		assignItemRect(CLOVER,          11, 15);
		assignItemRect(TRAP_MECHANISM,  13, 15);
		assignItemRect(MIMIC_TOOTH,     8,  15);
		assignItemRect(WONDROUS_RESIN,  12, 11);
		assignItemRect(EYE_OF_NEWT,     12, 12);
		assignItemRect(SALT_CUBE,       12, 13);
		assignItemRect(BLOOD_VIAL,      6,  15);
		assignItemRect(OBLIVION_SHARD,  7,  14);
		assignItemRect(CHAOTIC_CENSER,  13, 15);
	}

	private static final int SCROLLS        =                               xy(1, 19);  //16 slots
	public static final int SCROLL_KAUNAN   = SCROLLS+0;
	public static final int SCROLL_SOWILO   = SCROLLS+1;
	public static final int SCROLL_LAGUZ    = SCROLLS+2;
	public static final int SCROLL_YNGVI    = SCROLLS+3;
	public static final int SCROLL_GYFU     = SCROLLS+4;
	public static final int SCROLL_RAIDO    = SCROLLS+5;
	public static final int SCROLL_ISAZ     = SCROLLS+6;
	public static final int SCROLL_MANNAZ   = SCROLLS+7;
	public static final int SCROLL_NAUDIZ   = SCROLLS+8;
	public static final int SCROLL_BERKANAN = SCROLLS+9;
	public static final int SCROLL_ODAL     = SCROLLS+10;
	public static final int SCROLL_TIWAZ    = SCROLLS+11;
	public static final int SCROLL_EIHWAZ   = SCROLLS+12;

	public static final int ARCANE_RESIN    = SCROLLS+13;
	static {
		for (int i = SCROLLS; i < SCROLLS+16; i++)
			assignItemRect(i, 15, 14);
		assignItemRect(ARCANE_RESIN   , 12, 11);
	}
	
	private static final int EXOTIC_SCROLLS =                               xy(1, 20);  //16 slots
	public static final int EXOTIC_KAUNAN   = EXOTIC_SCROLLS+0;
	public static final int EXOTIC_SOWILO   = EXOTIC_SCROLLS+1;
	public static final int EXOTIC_LAGUZ    = EXOTIC_SCROLLS+2;
	public static final int EXOTIC_YNGVI    = EXOTIC_SCROLLS+3;
	public static final int EXOTIC_GYFU     = EXOTIC_SCROLLS+4;
	public static final int EXOTIC_RAIDO    = EXOTIC_SCROLLS+5;
	public static final int EXOTIC_ISAZ     = EXOTIC_SCROLLS+6;
	public static final int EXOTIC_MANNAZ   = EXOTIC_SCROLLS+7;
	public static final int EXOTIC_NAUDIZ   = EXOTIC_SCROLLS+8;
	public static final int EXOTIC_BERKANAN = EXOTIC_SCROLLS+9;
	public static final int EXOTIC_ODAL     = EXOTIC_SCROLLS+10;
	public static final int EXOTIC_TIWAZ    = EXOTIC_SCROLLS+11;
	public static final int EXOTIC_EIHWAZ   = EXOTIC_SCROLLS+12;

	static {
		for (int i = EXOTIC_SCROLLS; i < EXOTIC_SCROLLS+16; i++)
			assignItemRect(i, 15, 14);
	}
	
	private static final int STONES             =                           xy(1, 21);  //16 slots
	public static final int STONE_AGGRESSION    = STONES+0;
	public static final int STONE_AUGMENTATION  = STONES+1;
	public static final int STONE_FEAR          = STONES+2;
	public static final int STONE_BLAST         = STONES+3;
	public static final int STONE_BLINK         = STONES+4;
	public static final int STONE_CLAIRVOYANCE  = STONES+5;
	public static final int STONE_SLEEP         = STONES+6;
	public static final int STONE_DETECT        = STONES+7;
	public static final int STONE_ENCHANT       = STONES+8;
	public static final int STONE_FLOCK         = STONES+9;
	public static final int STONE_INTUITION     = STONES+10;
	public static final int STONE_SHOCK         = STONES+11;
	public static final int STONE_REFORGE       = STONES+12;

	static {
		for (int i = STONES; i < STONES+16; i++)
			assignItemRect(i, 14, 12);
	}

	private static final int POTIONS        =                               xy(1, 22);  //16 slots
	public static final int POTION_CRIMSON  = POTIONS+0;
	public static final int POTION_AMBER    = POTIONS+1;
	public static final int POTION_GOLDEN   = POTIONS+2;
	public static final int POTION_JADE     = POTIONS+3;
	public static final int POTION_TURQUOISE= POTIONS+4;
	public static final int POTION_AZURE    = POTIONS+5;
	public static final int POTION_INDIGO   = POTIONS+6;
	public static final int POTION_MAGENTA  = POTIONS+7;
	public static final int POTION_BISTRE   = POTIONS+8;
	public static final int POTION_CHARCOAL = POTIONS+9;
	public static final int POTION_SILVER   = POTIONS+10;
	public static final int POTION_IVORY    = POTIONS+11;
	public static final int POTION_RUSSET   = POTIONS+12;
	public static final int POTION_MAROON   = POTIONS+13;
	public static final int POTION_SEPIA    = POTIONS+14;
	public static final int LIQUID_METAL    = POTIONS+15;
	static {
		for (int i = POTIONS; i < POTIONS+16; i++)
			assignItemRect(i, 12, 14);
		assignItemRect(LIQUID_METAL,    8, 15);
	}
	
	private static final int EXOTIC_POTIONS =                               xy(1, 23);  //16 slots
	public static final int EXOTIC_CRIMSON  = EXOTIC_POTIONS+0;
	public static final int EXOTIC_AMBER    = EXOTIC_POTIONS+1;
	public static final int EXOTIC_GOLDEN   = EXOTIC_POTIONS+2;
	public static final int EXOTIC_JADE     = EXOTIC_POTIONS+3;
	public static final int EXOTIC_TURQUOISE= EXOTIC_POTIONS+4;
	public static final int EXOTIC_AZURE    = EXOTIC_POTIONS+5;
	public static final int EXOTIC_INDIGO   = EXOTIC_POTIONS+6;
	public static final int EXOTIC_MAGENTA  = EXOTIC_POTIONS+7;
	public static final int EXOTIC_BISTRE   = EXOTIC_POTIONS+8;
	public static final int EXOTIC_CHARCOAL = EXOTIC_POTIONS+9;
	public static final int EXOTIC_SILVER   = EXOTIC_POTIONS+10;
	public static final int EXOTIC_IVORY    = EXOTIC_POTIONS+11;
	public static final int EXOTIC_RUSSET   = EXOTIC_POTIONS+12;
	public static final int EXOTIC_MAROON   = EXOTIC_POTIONS+13;
	public static final int EXOTIC_SEPIA    = EXOTIC_POTIONS+14;
	static {
		for (int i = EXOTIC_POTIONS; i < EXOTIC_POTIONS+16; i++)
			assignItemRect(i, 12, 13);
	}

	private static final int SEEDS              =                           xy(1, 24);  //16 slots
	public static final int SEED_ROTBERRY       = SEEDS+0;
	public static final int SEED_FIREBLOOM      = SEEDS+1;
	public static final int SEED_SWIFTTHISTLE   = SEEDS+2;
	public static final int SEED_SUNGRASS       = SEEDS+3;
	public static final int SEED_ICECAP         = SEEDS+4;
	public static final int SEED_STORMVINE      = SEEDS+5;
	public static final int SEED_SORROWMOSS     = SEEDS+6;
	public static final int SEED_MAGEROYAL = SEEDS+7;
	public static final int SEED_EARTHROOT      = SEEDS+8;
	public static final int SEED_STARFLOWER     = SEEDS+9;
	public static final int SEED_FADELEAF       = SEEDS+10;
	public static final int SEED_BLINDWEED      = SEEDS+11;
	public static final int SEED_COFFEE      	= SEEDS+12;
	public static final int SEED_TOMATO    		= SEEDS+13;
	public static final int SEED_POTATO    		= SEEDS+14;
	static{
		for (int i = SEEDS; i < SEEDS+16; i++)
			assignItemRect(i, 10, 10);
	}
	
	private static final int BREWS          =                               xy(1, 25);  //8 slots
	public static final int BREW_INFERNAL   = BREWS+0;
	public static final int BREW_BLIZZARD   = BREWS+1;
	public static final int BREW_SHOCKING   = BREWS+2;
	public static final int BREW_CAUSTIC    = BREWS+3;
	public static final int BREW_AQUA       = BREWS+4;
	public static final int BREW_UNSTABLE   = BREWS+5;
	
	private static final int ELIXIRS        =                               xy(9, 25);  //8 slots
	public static final int ELIXIR_HONEY    = ELIXIRS+0;
	public static final int ELIXIR_AQUA     = ELIXIRS+1;
	public static final int ELIXIR_MIGHT    = ELIXIRS+2;
	public static final int ELIXIR_DRAGON   = ELIXIRS+3;
	public static final int ELIXIR_TOXIC    = ELIXIRS+4;
	public static final int ELIXIR_ICY      = ELIXIRS+5;
	public static final int ELIXIR_ARCANE   = ELIXIRS+6;
	public static final int ELIXIR_FEATHER  = ELIXIRS+7;
	static{
		for (int i = BREWS; i < BREWS+16; i++)
			assignItemRect(i, 12, 14);

		assignItemRect(BREW_AQUA, 9, 11);
	}
	
	                                                                                    //16 free slots
	
	private static final int SPELLS         =                               xy(1, 27);  //16 slots
	public static final int WILD_ENERGY     = SPELLS+0;
	public static final int PHASE_SHIFT     = SPELLS+1;
	public static final int TELE_GRAB       = SPELLS+2;
	public static final int UNSTABLE_SPELL  = SPELLS+3;

	public static final int CURSE_INFUSE    = SPELLS+5;
	public static final int MAGIC_INFUSE    = SPELLS+6;
	public static final int ALCHEMIZE       = SPELLS+7;
	public static final int RECYCLE         = SPELLS+8;

	public static final int RECLAIM_TRAP    = SPELLS+10;
	public static final int RETURN_BEACON   = SPELLS+11;
	public static final int SUMMON_ELE      = SPELLS+12;

	static{
		assignItemRect(WILD_ENERGY,     12, 11);
		assignItemRect(PHASE_SHIFT,     12, 11);
		assignItemRect(TELE_GRAB,       12, 11);
		assignItemRect(UNSTABLE_SPELL,  12, 13);

		assignItemRect(CURSE_INFUSE,    10, 15);
		assignItemRect(MAGIC_INFUSE,    10, 15);
		assignItemRect(ALCHEMIZE,       10, 15);
		assignItemRect(RECYCLE,         10, 15);

		assignItemRect(RECLAIM_TRAP,     8, 16);
		assignItemRect(RETURN_BEACON,    8, 16);
		assignItemRect(SUMMON_ELE,       8, 16);
	}
	
	private static final int FOOD       =                                   xy(1, 28);  //16 slots
	public static final int MEAT            = FOOD+0;
	public static final int STEAK           = FOOD+1;
	public static final int STEWED          = FOOD+2;
	public static final int OVERPRICED      = FOOD+3;
	public static final int CARPACCIO       = FOOD+4;
	public static final int RATION          = FOOD+5;
	public static final int PASTY           = FOOD+6;
	public static final int MEAT_PIE        = FOOD+7;
	public static final int BLANDFRUIT      = FOOD+8;
	public static final int BLAND_CHUNKS    = FOOD+9;
	public static final int BERRY           = FOOD+10;
	public static final int PHANTOM_MEAT    = FOOD+11;
	public static final int SUPPLY_RATION   = FOOD+12;
	static{
		assignItemRect(MEAT,            15, 11);
		assignItemRect(STEAK,           15, 11);
		assignItemRect(STEWED,          15, 11);
		assignItemRect(OVERPRICED,      14, 11);
		assignItemRect(CARPACCIO,       15, 11);
		assignItemRect(RATION,          14, 12);
		assignItemRect(PASTY,           16, 11);
		assignItemRect(MEAT_PIE,        16, 12);
		assignItemRect(BLANDFRUIT,      9,  12);
		assignItemRect(BLAND_CHUNKS,    14,  6);
		assignItemRect(BERRY,           9,  11);
		assignItemRect(PHANTOM_MEAT,    15, 11);
		assignItemRect(SUPPLY_RATION,   16, 12);
	}

	private static final int HOLIDAY_FOOD   =                               xy(1, 29);  //16 slots
	public static final int STEAMED_FISH    = HOLIDAY_FOOD+0;
	public static final int FISH_LEFTOVER   = HOLIDAY_FOOD+1;
	public static final int CHOC_AMULET     = HOLIDAY_FOOD+2;
	public static final int EASTER_EGG      = HOLIDAY_FOOD+3;
	public static final int RAINBOW_POTION  = HOLIDAY_FOOD+4;
	public static final int SHATTERED_CAKE  = HOLIDAY_FOOD+5;
	public static final int PUMPKIN_PIE     = HOLIDAY_FOOD+6;
	public static final int VANILLA_CAKE    = HOLIDAY_FOOD+7;
	public static final int CANDY_CANE      = HOLIDAY_FOOD+8;
	public static final int SPARKLING_POTION= HOLIDAY_FOOD+9;
	static{
		assignItemRect(STEAMED_FISH,    16, 12);
		assignItemRect(FISH_LEFTOVER,   16, 12);
		assignItemRect(CHOC_AMULET,     16, 16);
		assignItemRect(EASTER_EGG,      12, 14);
		assignItemRect(RAINBOW_POTION,  12, 14);
		assignItemRect(SHATTERED_CAKE,  14, 13);
		assignItemRect(PUMPKIN_PIE,     16, 12);
		assignItemRect(VANILLA_CAKE,    14, 13);
		assignItemRect(CANDY_CANE,      13, 16);
		assignItemRect(SPARKLING_POTION, 7, 16);
	}

	private static final int QUEST  =                                       xy(1, 30);  //16 slots
	public static final int DUST    = QUEST+1;
	public static final int CANDLE  = QUEST+2;
	public static final int EMBER   = QUEST+3;
	public static final int PICKAXE = QUEST+4;
	public static final int ORE     = QUEST+5;
	public static final int TOKEN   = QUEST+6;
	public static final int BLOB    = QUEST+7;
	public static final int SHARD   = QUEST+8;
	static{
		assignItemRect(DUST,    12, 11);
		assignItemRect(CANDLE,  12, 12);
		assignItemRect(EMBER,   12, 11);
		assignItemRect(PICKAXE, 14, 14);
		assignItemRect(ORE,     15, 15);
		assignItemRect(TOKEN,   12, 12);
		assignItemRect(BLOB,    10,  9);
		assignItemRect(SHARD,    8, 10);
	}

	private static final int BAGS       =                                   xy(1, 31);  //16 slots
	public static final int WATERSKIN   = BAGS+0;
	public static final int BACKPACK    = BAGS+1;
	public static final int POUCH       = BAGS+2;
	public static final int HOLDER      = BAGS+3;
	public static final int BANDOLIER   = BAGS+4;
	public static final int HOLSTER     = BAGS+5;
	public static final int VIAL        = BAGS+6;
	public static final int FOODCRATE   = BAGS+7;
	static{
		assignItemRect(WATERSKIN,   16, 14);
		assignItemRect(BACKPACK,    16, 16);
		assignItemRect(POUCH,       14, 15);
		assignItemRect(HOLDER,      16, 16);
		assignItemRect(BANDOLIER,   15, 16);
		assignItemRect(HOLSTER,     15, 16);
		assignItemRect(VIAL,        12, 12);
		assignItemRect(FOODCRATE,   12, 14);
	}

	private static final int DOCUMENTS  =                                   xy(1, 32);  //16 slots
	public static final int GUIDE_PAGE  = DOCUMENTS+0;
	public static final int ALCH_PAGE   = DOCUMENTS+1;
	public static final int SEWER_PAGE  = DOCUMENTS+2;
	public static final int PRISON_PAGE = DOCUMENTS+3;
	public static final int CAVES_PAGE  = DOCUMENTS+4;
	public static final int CITY_PAGE   = DOCUMENTS+5;
	public static final int HALLS_PAGE  = DOCUMENTS+6;
	static{
		assignItemRect(GUIDE_PAGE,  10, 11);
		assignItemRect(ALCH_PAGE,   10, 11);
		assignItemRect(SEWER_PAGE,  10, 11);
		assignItemRect(PRISON_PAGE, 10, 11);
		assignItemRect(CAVES_PAGE,  10, 11);
		assignItemRect(CITY_PAGE,   10, 11);
		assignItemRect(HALLS_PAGE,  10, 11);
	}

	private static final int PAINTINGS       =                                   xy(1, 33);
	public static final int PAINTING_MANA_LISA 	= PAINTINGS;
	public static final int PAINTING_SCREAM 	= PAINTINGS + 1;
	public static final int PAINTING_NIGHT 		= PAINTINGS + 2;
	public static final int PAINTING_WAVE 		= PAINTINGS + 3;
	public static final int PAINTING_WARRIOR 	= PAINTINGS + 4;
	public static final int PAINTING_ROGUE 		= PAINTINGS + 5;
	public static final int PAINTING_HUNTRESS	= PAINTINGS + 6;
	public static final int PAINTING_MAGE 		= PAINTINGS + 7;
	public static final int PAINTING_HILL 		= PAINTINGS + 8;
	public static final int PAINTING_FLOWER 	= PAINTINGS + 9;
	public static final int PAINTING_BEACH 		= PAINTINGS + 10;
	public static final int PAINTING_MOUNTAIN	= PAINTINGS + 11;
	public static final int PAINTING_DAGGER 	= PAINTINGS + 12;
	public static final int PAINTING_RING 		= PAINTINGS + 13;
	public static final int PAINTING_CANDLE 	= PAINTINGS + 14;
	public static final int PAINTING_MEAT 		= PAINTINGS + 15;
	static{
		for (int i = PAINTINGS; i < PAINTINGS +16; i++)
			assignItemRect(i, 16, 16);
	}

	private static final int FOOD_NEW =                                   xy(1, 34);
	public static final int RATATOUILLE 			= FOOD_NEW;
	public static final int COFFEE_BEAN      		= FOOD_NEW +1;
	public static final int FRIED_RAT      			= FOOD_NEW +2;
	public static final int EGG      				= FOOD_NEW +3;
	public static final int FRIED_EGG      			= FOOD_NEW +4;
	public static final int MILK      				= FOOD_NEW +5;
	public static final int OMELET      			= FOOD_NEW +6;
	public static final int CHEESE      			= FOOD_NEW +7;
	public static final int FLOUR      				= FOOD_NEW +8;
	public static final int PANCAKES      			= FOOD_NEW +9;
	public static final int PANCAKES_CHEESE     	= FOOD_NEW +10;
	//	public static final int EMPTY    			= FOOD_NEW +11;
	public static final int TOMATO    				= FOOD_NEW +12;
	public static final int WHEAT    				= FOOD_NEW +13;
	public static final int BREAD    				= FOOD_NEW +14;
	public static final int OIL    					= FOOD_NEW +15;
	public static final int POTATO    				= FOOD_NEW +16;
	//	public static final int EMPTY    			= FOOD_NEW +17;
	public static final int HASHBROWNS    			= FOOD_NEW +18;
	public static final int COMPLETE_BREAKFAST  	= FOOD_NEW +19;
	public static final int BRUSCHETTA  			= FOOD_NEW +20;
	public static final int PIZZA  					= FOOD_NEW +21;
	public static final int SPAGHETTI  				= FOOD_NEW +22;
	public static final int COFFEE 					= FOOD_NEW +23;
	public static final int TRIPLE_SHOT_ESPRESSO	= FOOD_NEW +24;
	public static final int STIR_FRY				= FOOD_NEW +25;
	public static final int FISH					= FOOD_NEW +26;
	public static final int BAKED_FISH				= FOOD_NEW +27;
	public static final int CRISPY_BASS				= FOOD_NEW +28;
	public static final int BERRY_BALLS				= FOOD_NEW +29;
	public static final int SASHIMI					= FOOD_NEW +30;
	public static final int MEATBALLS				= FOOD_NEW +31;
	public static final int SUGAR					= FOOD_NEW +32;
	public static final int COOKED_WARRIOR			= FOOD_NEW +33;
	public static final int PLATE					= FOOD_NEW +34;
	public static final int PLATE_SMALL				= FOOD_NEW +35;
	public static final int COOKIES					= FOOD_NEW +36;
	public static final int ICE_CREAM				= FOOD_NEW +37;
	public static final int DANISH_PASTRY			= FOOD_NEW +38;
	public static final int CAKE_BASE				= FOOD_NEW +39;
	public static final int BERRY_CAKE				= FOOD_NEW +40;
	public static final int CHOCOLATE_CAKE			= FOOD_NEW +41;
	public static final int BASED_CAKE				= FOOD_NEW +42;
	public static final int CHEESE_SLICE			= FOOD_NEW +43;
	public static final int SMALLMEAT 				= FOOD_NEW +44;
	public static final int SMALLSTEAK 				= FOOD_NEW +45;
	public static final int STEWEDSMALL 			= FOOD_NEW +46;
	public static final int SMALLFROZEN 			= FOOD_NEW +47;
	public static final int GOLDENMEAT 				= FOOD_NEW +48;
	public static final int WAXBAR 					= FOOD_NEW +49;
	public static final int NUTS 					= FOOD_NEW +50;
	public static final int PIETHON 				= FOOD_NEW +51;
	public static final int UNTAXEDFOOD 			= FOOD_NEW +52;
	public static final int TIDEPOD 				= FOOD_NEW +53;


	static {
		assignItemRect(RATATOUILLE, 		16, 12);
		assignItemRect(COFFEE_BEAN, 		10, 11);
		assignItemRect(FRIED_RAT, 			16, 8);
		assignItemRect(EGG, 				10, 12);
		assignItemRect(MILK, 				8,  15);
		assignItemRect(OMELET, 				16, 16);
		assignItemRect(CHEESE, 				15, 11);
		assignItemRect(FLOUR, 				12, 16);
		assignItemRect(PANCAKES, 			16, 16);
		assignItemRect(PANCAKES_CHEESE, 	16, 16);
		assignItemRect(TOMATO, 				11, 13);
		assignItemRect(WHEAT, 				16, 16);
		assignItemRect(BREAD, 				16, 12);
		assignItemRect(OIL, 				12, 14);
		assignItemRect(POTATO, 				14, 12);
		assignItemRect(HASHBROWNS, 			16, 16);
		assignItemRect(COMPLETE_BREAKFAST,	16, 16);
		assignItemRect(BRUSCHETTA,			14, 14);
		assignItemRect(PIZZA,				16, 16);
		assignItemRect(SPAGHETTI,			16, 16);
		assignItemRect(COFFEE, 				11, 12);
		assignItemRect(TRIPLE_SHOT_ESPRESSO,15, 14);
		assignItemRect(STIR_FRY,			16, 16);
		assignItemRect(FISH,				13, 10);
		assignItemRect(BAKED_FISH,			16, 16);
		assignItemRect(CRISPY_BASS,			16, 16);
		assignItemRect(BERRY_BALLS,			16, 16);
		assignItemRect(SASHIMI,				14, 14);
		assignItemRect(MEATBALLS,			16, 16);
		assignItemRect(SUGAR,				12, 13);
		assignItemRect(COOKED_WARRIOR,		14, 14);
		assignItemRect(PLATE,				16, 16);
		assignItemRect(PLATE_SMALL,			14, 14);
		assignItemRect(COOKIES,				14, 14);
		assignItemRect(ICE_CREAM,			9,  15);
		assignItemRect(DANISH_PASTRY,		15, 10);
		assignItemRect(CAKE_BASE,			15, 14);
		assignItemRect(BERRY_CAKE,			15, 16);
		assignItemRect(CHOCOLATE_CAKE,		15, 15);
		assignItemRect(BASED_CAKE,			15, 16);
		assignItemRect(CHEESE_SLICE,		8,  7);
		assignItemRect(SMALLMEAT,   		10, 8);
		assignItemRect(SMALLSTEAK,  		10, 8);
		assignItemRect(STEWEDSMALL, 		10, 8);
		assignItemRect(SMALLFROZEN, 		10, 8);
		assignItemRect(GOLDENMEAT,  		15, 11);
		assignItemRect(WAXBAR,  			6,  8);
		assignItemRect(NUTS,       			10, 8);
		assignItemRect(PIETHON,  			16, 12);
		assignItemRect(UNTAXEDFOOD, 		16, 12);
		assignItemRect(TIDEPOD, 			6,  6);
	}

	private static final int WEAPONS_NEW =                                       xy(1, 40);
	public static final int GREATGREATSWORD = WEAPONS_NEW;
	public static final int SMALLGREATSWORD = WEAPONS_NEW+2;
	public static final int PILE_OF_SAIS    = WEAPONS_NEW+3;
	public static final int SPEARAXE    	= WEAPONS_NEW+4;
	public static final int BRANCH			= WEAPONS_NEW+5;
	public static final int SILVER_KNIFE	= WEAPONS_NEW+6;

	static{
		assignItemRect(GREATGREATSWORD, 32, 32);
		assignItemRect(SMALLGREATSWORD, 11, 11);
		assignItemRect(SPEARAXE,        14, 14);
		assignItemRect(PILE_OF_SAIS,    16, 16);
		assignItemRect(BRANCH,			9, 12);
		assignItemRect(SILVER_KNIFE,	9, 9);
	}

	private static final int ALBUMS =                                       xy(1, 42);
	public static final int ALBUM_EMPTY				= ALBUMS;
	public static final int ALBUM_RAT				= ALBUMS +1;
	public static final int ALBUM_TWINGO			= ALBUMS +2;
	public static final int ALBUM_FINNISH			= ALBUMS +3;
	public static final int ALBUM_SYNTH				= ALBUMS +4;
	public static final int ALBUM_HOG				= ALBUMS +5;
	public static final int ALBUM_REMIX				= ALBUMS +6;
	public static final int ALBUM_CHAIR				= ALBUMS +7;
	public static final int ALBUM_POP				= ALBUMS +8;
	public static final int ALBUM_SEA				= ALBUMS +9;
	public static final int ALBUM_NONSENSE			= ALBUMS +10;
	public static final int ALBUM_BEAUTIFUL			= ALBUMS +11;

	static {
		for (int i = ALBUMS; i < ALBUMS+16; i++)
			assignItemRect(i, 11, 11);
	}

	private static final int EMPTIES =                                       xy(1, 43);
	public static final int EMPTY_SEAL				= EMPTIES;
	public static final int EMPTY_CLOAK				= EMPTIES +1;
	public static final int EMPTY_BOW				= EMPTIES +2;
	public static final int EMPTY_WAND				= EMPTIES +3;
	public static final int EMPTY_LEATHER			= EMPTIES +4;
	public static final int EMPTY_PLATE				= EMPTIES +5;
	public static final int EMPTY_CLOTH				= EMPTIES +6;
	public static final int EMPTY_BOOK				= EMPTIES +7;
	public static final int EMPTY_RUNIC				= EMPTIES +8;
	public static final int EMPTY_LSWORD			= EMPTIES +9;
	public static final int EMPTY_GLAIVE			= EMPTIES +10;
	public static final int EMPTY_AXE				= EMPTIES +11;
	public static final int EMPTY_HAMMER			= EMPTIES +12;
	public static final int EMPTY_SHIELD			= EMPTIES +13;
	public static final int EMPTY_SCIMITAR			= EMPTIES +14;

	static{
		assignItemRect(EMPTY_SEAL,			9, 15);
		assignItemRect(EMPTY_CLOAK,			9, 15);
		assignItemRect(EMPTY_BOW,			16, 16);
		assignItemRect(EMPTY_WAND,			15, 15);
		assignItemRect(EMPTY_LEATHER,		14, 13);
		assignItemRect(EMPTY_PLATE,			12, 12);
		assignItemRect(EMPTY_CLOTH,			15, 12);
		assignItemRect(EMPTY_BOOK,			13, 16);
		assignItemRect(EMPTY_RUNIC,			14, 14);
		assignItemRect(EMPTY_LSWORD,		15, 15);
		assignItemRect(EMPTY_GLAIVE,		16, 16);
		assignItemRect(EMPTY_AXE,			16, 16);
		assignItemRect(EMPTY_HAMMER,		16, 16);
		assignItemRect(EMPTY_SHIELD,		12, 16);
		assignItemRect(EMPTY_SCIMITAR,		13, 16);
	}


	private static final int MISC =                                       xy(1, 45);
	public static final int TENGU_STONE      		= MISC;
	public static final int INSULIN					= MISC +1;
	public static final int CAR						= MISC +2;
	public static final int ARMADILLO				= MISC +3;
	public static final int PILLOW					= MISC +4;
	public static final int WILLOW					= MISC +5;
	public static final int SPARROW					= MISC +6;
	public static final int PUG						= MISC +7;
	public static final int RAT						= MISC +8;
	public static final int SPRAYPAINT				= MISC +9;
	public static final int BIGBAG        			= MISC+10;
	public static final int SMALLBAG        		= MISC+11;
	public static final int SAW   					= MISC+12;
	public static final int GOLDBAR   				= MISC+13;
	public static final int SILVERAMULET   			= MISC+14;
	public static final int GOLDAMULET   			= MISC+15;
	public static final int PINKAMULET   			= MISC+16;
	public static final int STONEAMULET  			= MISC+17;
	public static final int ARTIFACT_MP3_PLAYER_1 	= MISC+18;
	public static final int ARTIFACT_MP3_PLAYER_2   = MISC+19;
	public static final int WARRIORIUM   			= MISC+20;
	public static final int CATALYST   				= MISC+21;
	public static final int GOBLIN_CURSE   			= MISC+22;
	static{
		assignItemRect(TENGU_STONE, 		9,  8);
		assignItemRect(INSULIN,				10, 10);
		assignItemRect(CAR,					16, 8);
		assignItemRect(ARMADILLO,			16, 10);
		assignItemRect(PILLOW,				14, 12);
		assignItemRect(WILLOW,				15, 16);
		assignItemRect(SPARROW,				14, 11);
		assignItemRect(PUG,					15, 15);
		assignItemRect(RAT,					16, 8);
		assignItemRect(SPRAYPAINT,			7, 13);
		assignItemRect(BIGBAG,      		14, 15);
		assignItemRect(SMALLBAG,    		10, 11);
		assignItemRect(SAW,    				16, 15);
		assignItemRect(GOLDBAR,     		16, 14);
		assignItemRect(SILVERAMULET,		12, 14);
		assignItemRect(GOLDAMULET,     		12, 14);
		assignItemRect(PINKAMULET,     		12, 14);
		assignItemRect(STONEAMULET,     	12, 14);
		assignItemRect(ARTIFACT_MP3_PLAYER_1,13, 16);
		assignItemRect(ARTIFACT_MP3_PLAYER_2,13, 16);
		assignItemRect(WARRIORIUM,  		10,  8);
		assignItemRect(CATALYST,  			12,  11);
		assignItemRect(GOBLIN_CURSE,  		12,  13);
	}

	private static final int SKINS       =                  xy(1, 49);
	//Common Seals
	public static final int YELLOWSEAL      	= SKINS;
	public static final int GREENSEAL      		= SKINS +1;
	public static final int BLUESEAL      		= SKINS +2;
	public static final int PURPLESEAL     		= SKINS +3;
	public static final int BLACKSEAL      		= SKINS +4;
	public static final int WHITESEAL      		= SKINS +5;
	public static final int GRAYSEAL      		= SKINS +6;
	public static final int TURQUOISESEAL      	= SKINS +7;
	public static final int BROWNSEAL      		= SKINS +8;
	public static final int PINKSEAL      		= SKINS +9;
	public static final int ORANGESEAL      	= SKINS +10;
	//Rare seals
	public static final int WOODSEAL      		= SKINS +11;
	public static final int MEATSEAL      		= SKINS +12;
	public static final int TRANSPARENTSEAL     = SKINS +13;
	public static final int HEALINGSEAL      	= SKINS +14;
	public static final int CUTSEAL      		= SKINS +15;
	public static final int THIEFSEAL      		= SKINS +16;
	public static final int COPPERSEAL      	= SKINS +17;
	public static final int CUBESEAL      		= SKINS +18;
	//Epic Seals
	public static final int RINGSEAL      		= SKINS +19;
	public static final int RAINBOWSEAL      	= SKINS +20;
	public static final int GOLDSEAL      		= SKINS +21;
	public static final int CORPSESEAL      	= SKINS +22;
	public static final int HEARTSEAL      		= SKINS +23;
	public static final int BURNTSEAL      		= SKINS +24;
	public static final int GOOSEAL      		= SKINS +25;
	public static final int WATERSEAL      		= SKINS +26;
	public static final int WARRIORSEAL      	= SKINS +27;
	public static final int COWBOYSEAL      	= SKINS +28;
	public static final int HONEYSEAL      		= SKINS +29;
	public static final int ICESEAL      		= SKINS +30;
	public static final int EYESEAL      		= SKINS +31;
	public static final int SNAKESEAL      		= SKINS +32;
	public static final int CANDLESEAL      	= SKINS +33;
	public static final int BOMBSEAL      		= SKINS +34;
	public static final int SHEEPSEAL      		= SKINS +35;
	//	Legendary Seals
	public static final int DMSEAL      		= SKINS +40;
	public static final int KINGSEAL      		= SKINS +41;
	public static final int FIERYSEAL      		= SKINS +42;
	public static final int PUREGOLDSEAL      	= SKINS +43;
	public static final int AMULETSEAL      	= SKINS +44;
	public static final int BLOWNUPSEAL      	= SKINS +45;

	//Common Cloaks
	public static final int ORANGECLOAK      	= SKINS +48;
	public static final int YELLOWCLOAK      	= SKINS +49;
	public static final int GREENCLOAK      	= SKINS +50;
	public static final int BLUECLOAK      		= SKINS +51;
	public static final int TURQUOISECLOAK      = SKINS +52;
	public static final int PURPLECLOAK      	= SKINS +53;
	public static final int PINKCLOAK      		= SKINS +54;
	public static final int BROWNCLOAK      	= SKINS +55;
	public static final int BLACKCLOAK      	= SKINS +56;
	public static final int GRAYCLOAK      		= SKINS +57;
	public static final int WHITECLOAK      	= SKINS +58;
	//Rare Cloaks
	public static final int WOODENCLOAK      	= SKINS +59;
	public static final int LEATHERCLOAK 		= SKINS +60;
	public static final int RATIONCLOAK      	= SKINS +61;
	public static final int PINKAMULETCLOAK     = SKINS +62;
	public static final int RAINBOWCLOAK      	= SKINS +63;
	public static final int TINYCLOAK	      	= SKINS +64;
	public static final int WAXCLOAK		    = SKINS +65;
	public static final int CANDYCLOAK	      	= SKINS +66;
	public static final int COOKEDCLOAK	      	= SKINS +67;
	public static final int CHAINMAILCLOAK      = SKINS +68;
	public static final int TACTICALCLOAK       = SKINS +69;
	//Epic Cloaks
	public static final int GOLDENCLOAK      	= SKINS +70;
	public static final int WARRIORCLOAK      	= SKINS +71;
	public static final int METALCLOAK	      	= SKINS +72;
	public static final int BOTTLECLOAK      	= SKINS +73;
	public static final int CHEESECLOAK      	= SKINS +74;
	public static final int PAINTCLOAK      	= SKINS +75;
	public static final int DRACULACLOAK      	= SKINS +76;
	//Legendary Cloaks
	public static final int FIERYCLOAK      	= SKINS +77;
	public static final int TRUEGOLDENCLOAK     = SKINS +78;
	public static final int DARKNESSCLOAK      	= SKINS +79;

	//Common Bows
	public static final int ORANGEBOW      		= SKINS +80;
	public static final int YELLOWBOW      		= SKINS +81;
	public static final int GREENBOW      		= SKINS +82;
	public static final int BLUEBOW      		= SKINS +83;
	public static final int TURQUOISEBOW      	= SKINS +84;
	public static final int PURPLEBOW      		= SKINS +85;
	public static final int PINKBOW      		= SKINS +86;
	public static final int BROWNBOW      		= SKINS +87;
	public static final int BLACKBOW      		= SKINS +88;
	public static final int GRAYBOW      		= SKINS +89;
	public static final int WHITEBOW      		= SKINS +90;
	//Rare Bows
	public static final int WOODENBOW      		= SKINS +91;
	public static final int WALNUTBOW      		= SKINS +92;
	public static final int GOOBOW      		= SKINS +93;
	public static final int CATALYSTBOW 		= SKINS +94;
	public static final int TAXEDBOW      		= SKINS +95;
	public static final int MEATBOW      		= SKINS +96;
	public static final int RAINBOWBOW      	= SKINS +97;
	public static final int LOVEBOW		      	= SKINS +98;
	public static final int EGGBOW      		= SKINS +99;
	//	public static final int BOW      		= SKINS +100;
	//Epic Bows
	public static final int GOLDENBOW      		= SKINS +101;
	public static final int NATUREBOW      		= SKINS +102;
	public static final int METALBOW      		= SKINS +103;
	public static final int ROYALBOW      		= SKINS +104;
	public static final int CROSSBOWBOW      	= SKINS +105;
	public static final int EARTHBOW      		= SKINS +106;
	public static final int TENGUBOW      		= SKINS +107;
	public static final int WILLOWBOW      		= SKINS +108;
	public static final int RINGBOW      		= SKINS +109;
	//Legendary Bows
	public static final int FLAMINGBOW      	= SKINS +110;
//	public static final int BOW      		= SKINS +111;

	//Common Wands
	public static final int ORANGEWAND      	= SKINS +112;
	public static final int YELLOWWAND      	= SKINS +113;
	public static final int GREENWAND      		= SKINS +114;
	public static final int BLUEWAND      		= SKINS +115;
	public static final int TURQUOISEWAND      	= SKINS +116;
	public static final int PURPLEWAND      	= SKINS +117;
	public static final int PINKWAND      		= SKINS +118;
	public static final int BROWNWAND      		= SKINS +119;
	public static final int BLACKWAND      		= SKINS +120;
	public static final int GRAYWAND      		= SKINS +121;
	public static final int WHITEWAND      		= SKINS +122;
	//Rare Wands
	public static final int AMULETWAND      	= SKINS +123;
	public static final int BENTWAND      		= SKINS +124;
	public static final int LOVEWAND      		= SKINS +125;
	public static final int GOOWAND      		= SKINS +126;
	public static final int MISTWAND      		= SKINS +127;
	public static final int MEATWAND      		= SKINS +128;
	//Epic Wands
	public static final int GOLDENWAND      	= SKINS +129;
	public static final int BAGWAND      		= SKINS +130;
	public static final int PICKAXEWAND      	= SKINS +131;
	public static final int ROYALWAND      		= SKINS +132;
	public static final int WALKINGWAND      	= SKINS +133;
	public static final int GUNWAND      		= SKINS +134;
	public static final int SPLITWAND      		= SKINS +135;
	public static final int WARRIORWAND      	= SKINS +136;
	public static final int SNAKEWAND      		= SKINS +137;
	public static final int METALWAND      		= SKINS +138;
	//Legendary Wands
	public static final int TRUEGOLDENWAND      = SKINS +139;
	public static final int FIERYWAND      		= SKINS +140;
	public static final int MADNESSWAND      	= SKINS +141;
	public static final int GANDALFWAND      	= SKINS +142;
	public static final int CLOUDWAND      		= SKINS +143;

	//Arrows
	public static final int ORANGE_ARROW        = SKINS +144;
	public static final int YELLOW_ARROW        = SKINS +145;
	public static final int GREEN_ARROW         = SKINS +146;
	public static final int BLUE_ARROW          = SKINS +147;
	public static final int TURQUOISE_ARROW     = SKINS +148;
	public static final int PURPLE_ARROW        = SKINS +149;
	public static final int PINK_ARROW          = SKINS +150;
	public static final int BROWN_ARROW         = SKINS +151;
	public static final int BLACK_ARROW         = SKINS +152;
	public static final int GRAY_ARROW          = SKINS +153;
	public static final int WHITE_ARROW         = SKINS +154;
	public static final int WOODEN_ARROW        = SKINS +155;
	public static final int WALNUT_ARROW        = SKINS +156;
	public static final int GOO_ARROW           = SKINS +157;
	public static final int CATALYST_ARROW      = SKINS +158;
	public static final int TAXED_ARROW         = SKINS +159;
	public static final int MEAT_ARROW          = SKINS +160;
	public static final int RAINBOW_ARROW       = SKINS +161;
	public static final int LOVE_ARROW		    = SKINS +162;
	public static final int EGG_ARROW      		= SKINS +163;
	//	public static final int _ARROW      		= SKINS +164;
	public static final int GOLDEN_ARROW        = SKINS +165;
	public static final int NATURE_ARROW        = SKINS +166;
	public static final int METAL_ARROW         = SKINS +167;
	public static final int ROYAL_ARROW         = SKINS +168;
	public static final int CROSSBOW_ARROW      = SKINS +169;
	public static final int EARTH_ARROW         = SKINS +170;
	public static final int TENGU_ARROW         = SKINS +171;
	public static final int WILLOW_ARROW      	= SKINS +172;
	public static final int RING_ARROW      	= SKINS +173;
	public static final int FLAMING_ARROW      	= SKINS +174;
//	public static final int _ARROW      		= SKINS +175;

	static {
		//Common Seals
		assignItemRect(YELLOWSEAL		,      	9,  15);
		assignItemRect(GREENSEAL		,      	9,  15);
		assignItemRect(BLUESEAL 		,      	9,  15);
		assignItemRect(PURPLESEAL		,      	9,  15);
		assignItemRect(BLACKSEAL		,      	9,  15);
		assignItemRect(WHITESEAL		,      	9,  15);
		assignItemRect(GRAYSEAL			,      	9,  15);
		assignItemRect(TURQUOISESEAL	,      	9,  15);
		assignItemRect(BROWNSEAL		,      	9,  15);
		assignItemRect(PINKSEAL			,      	9,  15);
		assignItemRect(ORANGESEAL		,      	9,  15);
		//Rare Seals
		assignItemRect(WOODSEAL			,      	9,  15);
		assignItemRect(MEATSEAL			,      	9,  15);
		assignItemRect(TRANSPARENTSEAL	,     	9,  15);
		assignItemRect(HEALINGSEAL		,      	9,  15);
		assignItemRect(CUTSEAL			,      	9,  11);
		assignItemRect(THIEFSEAL		,      	9,  15);
		assignItemRect(COPPERSEAL		,      	9,  15);
		assignItemRect(CUBESEAL			,      	11, 16);
		//Epic Seals
		assignItemRect(RINGSEAL			,      	9,  15);
		assignItemRect(RAINBOWSEAL		,      	9,  15);
		assignItemRect(GOLDSEAL			,      	9,  15);
		assignItemRect(CORPSESEAL		,      	9,  15);
		assignItemRect(HEARTSEAL		,      	9,  15);
		assignItemRect(BURNTSEAL		,      	9,  15);
		assignItemRect(GOOSEAL			,      	9,  15);
		assignItemRect(WATERSEAL		,      	9,  15);
		assignItemRect(WARRIORSEAL		,      	9,  15);
		assignItemRect(COWBOYSEAL		,      	12, 16);
		assignItemRect(HONEYSEAL		,      	9,  15);
		assignItemRect(ICESEAL			,      	9,  16);
		assignItemRect(EYESEAL			,      	9,  14);
		assignItemRect(SNAKESEAL		,      	9,  15);
		assignItemRect(CANDLESEAL		,      	9,  16);
		assignItemRect(BOMBSEAL			,     	10, 16);
		assignItemRect(SHEEPSEAL		,     	10, 15);
		//Legendary Seals
		assignItemRect(DMSEAL			,      	13, 16);
		assignItemRect(KINGSEAL			,      	9,  16);
		assignItemRect(FIERYSEAL		,      	10, 16);
		assignItemRect(PUREGOLDSEAL		,      	9,  15);
		assignItemRect(AMULETSEAL		,      	9,  15);
		assignItemRect(BLOWNUPSEAL		,      	8,  15);

		//Common Cloaks
		assignItemRect(ORANGECLOAK   	,      	9,  15);
		assignItemRect(YELLOWCLOAK   	,      	9,  15);
		assignItemRect(GREENCLOAK    	,      	9,  15);
		assignItemRect(BLUECLOAK     	,      	9,  15);
		assignItemRect(TURQUOISECLOAK	,      	9,  15);
		assignItemRect(PURPLECLOAK   	,      	9,  15);
		assignItemRect(PINKCLOAK     	,      	9,  15);
		assignItemRect(BROWNCLOAK    	,      	9,  15);
		assignItemRect(BLACKCLOAK    	,      	9,  15);
		assignItemRect(GRAYCLOAK     	,      	9,  15);
		assignItemRect(WHITECLOAK    	,      	9,  15);
		//Rare Cloaks
		assignItemRect(WOODENCLOAK    	,      	9,  15);
		assignItemRect(LEATHERCLOAK		,      	9,  15);
		assignItemRect(RATIONCLOAK    	,      	9,  15);
		assignItemRect(PINKAMULETCLOAK	,      	9,  15);
		assignItemRect(RAINBOWCLOAK   	,      	9,  15);
		assignItemRect(TINYCLOAK	  	,      	7,  11);
		assignItemRect(WAXCLOAK		  	,      	9,  15);
		assignItemRect(CANDYCLOAK	  	,      	9,  15);
		assignItemRect(COOKEDCLOAK	  	,      	9,  15);
		assignItemRect(CHAINMAILCLOAK 	,      	9,  15);
		assignItemRect(TACTICALCLOAK 	,      	9,  15);
		//Epic Cloaks
		assignItemRect(GOLDENCLOAK   	,      	9,  15);
		assignItemRect(WARRIORCLOAK   	,      	9,  15);
		assignItemRect(METALCLOAK	   	,      	12, 15);
		assignItemRect(BOTTLECLOAK   	,      	9,  15);
		assignItemRect(CHEESECLOAK   	,      	9,  15);
		assignItemRect(PAINTCLOAK   	,      	11, 16);
		assignItemRect(DRACULACLOAK   	,      	13, 14);
		assignItemRect(FIERYCLOAK   	,      	16, 16);
		assignItemRect(TRUEGOLDENCLOAK  ,      	16, 16);
		assignItemRect(DARKNESSCLOAK   	,      	16, 16);

		//Common Bows
		assignItemRect(ORANGEBOW      	,    	16, 16);
		assignItemRect(YELLOWBOW      	,    	16, 16);
		assignItemRect(GREENBOW       	,    	16, 16);
		assignItemRect(BLUEBOW        	,    	16, 16);
		assignItemRect(TURQUOISEBOW   	,    	16, 16);
		assignItemRect(PURPLEBOW      	,    	16, 16);
		assignItemRect(PINKBOW        	,    	16, 16);
		assignItemRect(BROWNBOW       	,    	16, 16);
		assignItemRect(BLACKBOW       	,    	16, 16);
		assignItemRect(GRAYBOW        	,    	16, 16);
		assignItemRect(WHITEBOW       	,    	16, 16);
		//Rare Bows
		assignItemRect(WOODENBOW        ,    	16, 16);
		assignItemRect(WALNUTBOW        ,    	16, 16);
		assignItemRect(GOOBOW           ,    	16, 16);
		assignItemRect(CATALYSTBOW		,    	16, 16);
		assignItemRect(TAXEDBOW         ,    	16, 16);
		assignItemRect(MEATBOW          ,    	16, 16);
		assignItemRect(RAINBOWBOW       ,    	16, 16);
		assignItemRect(LOVEBOW	       	,    	16, 16);
		assignItemRect(EGGBOW       	,    	16, 16);
//		assignItemRect(BOW       	,    	16, 16);
//		assignItemRect(BOW       	,    	16, 16);
		//Epic Bows
		assignItemRect(GOLDENBOW   		,       16,  16);
		assignItemRect(NATUREBOW     	,       16,  16);
		assignItemRect(METALBOW      	,       16,  16);
		assignItemRect(ROYALBOW      	,       16,  16);
		assignItemRect(CROSSBOWBOW   	,       16,  16);
		assignItemRect(EARTHBOW      	,       16,  16);
		assignItemRect(TENGUBOW      	,       16,  16);
		assignItemRect(WILLOWBOW   		,       16,  16);
//		assignItemRect(BOW   		,        16,  16);
		//Legendary Bows
		assignItemRect(FLAMINGBOW      	,       16,  16);
//		assignItemRect(BOW      	,        16,  16);

		//Common Wands
		assignItemRect(ORANGEWAND   	,     	15, 16);
		assignItemRect(YELLOWWAND   	,     	15, 16);
		assignItemRect(GREENWAND    	,     	15, 16);
		assignItemRect(BLUEWAND     	,     	15, 16);
		assignItemRect(TURQUOISEWAND	,     	15, 16);
		assignItemRect(PURPLEWAND   	,     	15, 16);
		assignItemRect(PINKWAND     	,     	15, 16);
		assignItemRect(BROWNWAND    	,     	15, 16);
		assignItemRect(BLACKWAND    	,     	15, 16);
		assignItemRect(GRAYWAND     	,     	15, 16);
		assignItemRect(WHITEWAND    	,     	15, 16);
		//Rare Wands
		assignItemRect(AMULETWAND		,     	15, 16);
		assignItemRect(BENTWAND  		,     	15, 16);
		assignItemRect(LOVEWAND  		,     	15, 16);
		assignItemRect(GOOWAND   		,     	15, 16);
		assignItemRect(MISTWAND  		,     	16, 16);
		assignItemRect(MEATWAND  		,     	15, 16);
		//Epic Wands
		assignItemRect(GOLDENWAND 		,     	15, 16);
		assignItemRect(BAGWAND    		,     	15, 16);
		assignItemRect(PICKAXEWAND		,     	16, 16);
		assignItemRect(ROYALWAND  		,     	16, 16);
		assignItemRect(WALKINGWAND		,     	12, 16);
		assignItemRect(GUNWAND    		,     	16, 16);
		assignItemRect(SPLITWAND  		,     	14, 16);
		assignItemRect(WARRIORWAND		,     	16, 16);
		assignItemRect(SNAKEWAND  		,     	16, 16);
		assignItemRect(METALWAND  		,     	15, 16);
		//Legendary Wands
		assignItemRect(TRUEGOLDENWAND	,     	15, 16);
		assignItemRect(FIERYWAND     	,     	16, 16);
		assignItemRect(MADNESSWAND   	,     	16, 16);
		assignItemRect(GANDALFWAND   	,     	16, 16);
		assignItemRect(CLOUDWAND     	,     	16, 16);

		//Arrows
		assignItemRect(ORANGE_ARROW     ,     	11, 11);
		assignItemRect(YELLOW_ARROW     ,     	11, 11);
		assignItemRect(GREEN_ARROW      ,     	11, 11);
		assignItemRect(BLUE_ARROW       ,     	11, 11);
		assignItemRect(TURQUOISE_ARROW  ,     	11, 11);
		assignItemRect(PURPLE_ARROW     ,     	11, 11);
		assignItemRect(PINK_ARROW       ,     	11, 11);
		assignItemRect(BROWN_ARROW      ,     	11, 11);
		assignItemRect(BLACK_ARROW      ,     	11, 11);
		assignItemRect(GRAY_ARROW       ,     	11, 11);
		assignItemRect(WHITE_ARROW      ,     	11, 11);
		assignItemRect(WOODEN_ARROW     ,     	11, 11);
		assignItemRect(WALNUT_ARROW     ,     	11, 11);
		assignItemRect(GOO_ARROW        ,     	11, 11);
		assignItemRect(CATALYST_ARROW   ,     	11, 11);
		assignItemRect(TAXED_ARROW      ,     	11, 11);
		assignItemRect(MEAT_ARROW       ,     	11, 11);
		assignItemRect(RAINBOW_ARROW    ,     	11, 11);
		assignItemRect(LOVE_ARROW		,     	13, 13);
		assignItemRect(EGG_ARROW      	,     	9,  11);
//		assignItemRect(_ARROW      	 	,     	11, 11);
		assignItemRect(GOLDEN_ARROW     ,     	11, 11);
		assignItemRect(NATURE_ARROW     ,     	15, 15);
		assignItemRect(METAL_ARROW      ,     	12, 12);
		assignItemRect(ROYAL_ARROW      ,     	11, 11);
		assignItemRect(CROSSBOW_ARROW   ,     	10, 10);
		assignItemRect(EARTH_ARROW      ,     	11, 11);
		assignItemRect(TENGU_ARROW      ,     	16, 16);
		assignItemRect(WILLOW_ARROW     ,     	16, 16);
		assignItemRect(RING_ARROW      	,     	8,  8);
		assignItemRect(FLAMING_ARROW 	,     	16, 16);
//		assignItemRect(_ARROW		 	,     	11, 11);

	}

	private static final int SKIN_ARMOR =                  xy(1, 60);

	//Leather armor skins
	public static final int ORANGELEATHER   	= SKIN_ARMOR;
	public static final int YELLOWLEATHER   	= SKIN_ARMOR+1;
	public static final int GREENLEATHER    	= SKIN_ARMOR+2;
	public static final int BLUELEATHER     	= SKIN_ARMOR+3;
	public static final int TURQUOISELEATHER	= SKIN_ARMOR+4;
	public static final int PURPLELEATHER   	= SKIN_ARMOR+5;
	public static final int PINKLEATHER     	= SKIN_ARMOR+6;
	public static final int BROWNLEATHER    	= SKIN_ARMOR+7;
	public static final int BLACKLEATHER    	= SKIN_ARMOR+8;
	public static final int GRAYLEATHER     	= SKIN_ARMOR+9;
	public static final int WHITELEATHER    	= SKIN_ARMOR+10;
	//Plate armor skins
	public static final int METALPLATE    		= SKIN_ARMOR+11;
	public static final int COPPERPLATE    		= SKIN_ARMOR+12;
	public static final int CURSEDPLATE    		= SKIN_ARMOR+13;
	public static final int GOLDPLATE    		= SKIN_ARMOR+14;
	public static final int ROYALPLATE    		= SKIN_ARMOR+15;

	//Common Cloth armor skins
	public static final int ORANGECLOTH    		= SKIN_ARMOR+16;
	public static final int YELLOWCLOTH    		= SKIN_ARMOR+17;
	public static final int GREENCLOTH     		= SKIN_ARMOR+18;
	public static final int BLUECLOTH      		= SKIN_ARMOR+19;
	public static final int TURQUOISECLOTH 		= SKIN_ARMOR+20;
	public static final int PURPLECLOTH    		= SKIN_ARMOR+21;
	public static final int PINKCLOTH      		= SKIN_ARMOR+22;
	public static final int BROWNCLOTH     		= SKIN_ARMOR+23;
	public static final int BLACKCLOTH     		= SKIN_ARMOR+24;
	public static final int GRAYCLOTH      		= SKIN_ARMOR+25;
	public static final int WHITECLOTH     		= SKIN_ARMOR+26;
	//Rare Cloth armor skins
	public static final int LIGHTBROWNCLOTH 	= SKIN_ARMOR+27;
	public static final int REDCLOTH     		= SKIN_ARMOR+28;
	public static final int COFFEECLOTH     	= SKIN_ARMOR+29;
	public static final int CARDINALCLOTH   	= SKIN_ARMOR+30;
	//Epic Cloth armor skins
	public static final int GOLDENCLOTH     	= SKIN_ARMOR+31;

	static {
		//Leather Armors
		assignItemRect(ORANGELEATHER	,		14, 13);
		assignItemRect(YELLOWLEATHER	,		14, 13);
		assignItemRect(GREENLEATHER		,		14, 13);
		assignItemRect(BLUELEATHER		,		14, 13);
		assignItemRect(TURQUOISELEATHER	,		14, 13);
		assignItemRect(PURPLELEATHER	,		14, 13);
		assignItemRect(PINKLEATHER		,		14, 13);
		assignItemRect(BROWNLEATHER		,		14, 13);
		assignItemRect(BLACKLEATHER		,		14, 13);
		assignItemRect(GRAYLEATHER		,		14, 13);
		assignItemRect(WHITELEATHER		,		14, 13);

		//Plate Armors
		assignItemRect(METALPLATE		,		12, 12);
		assignItemRect(COPPERPLATE		,		12, 12);
		assignItemRect(CURSEDPLATE		,		12, 12);
		assignItemRect(GOLDPLATE		,		12, 12);
		assignItemRect(ROYALPLATE		,		12, 12);

		//Cloth armors
		assignItemRect(ORANGECLOTH     	,		15, 12);
		assignItemRect(YELLOWCLOTH     	,		15, 12);
		assignItemRect(GREENCLOTH      	,		15, 12);
		assignItemRect(BLUECLOTH       	,		15, 12);
		assignItemRect(TURQUOISECLOTH  	,		15, 12);
		assignItemRect(PURPLECLOTH     	,		15, 12);
		assignItemRect(PINKCLOTH       	,		15, 12);
		assignItemRect(BROWNCLOTH      	,		15, 12);
		assignItemRect(BLACKCLOTH      	,		15, 12);
		assignItemRect(GRAYCLOTH       	,		15, 12);
		assignItemRect(WHITECLOTH      	,		15, 12);
		assignItemRect(LIGHTBROWNCLOTH  ,		15, 12);
		assignItemRect(REDCLOTH         ,		15, 12);
		assignItemRect(COFFEECLOTH      ,		15, 12);
		assignItemRect(CARDINALCLOTH    ,		15, 12);
		assignItemRect(GOLDENCLOTH    	,		15, 12);
	}

	private static final int SKIN_BOOK =                  xy(1, 62);

	//Common Spellbook skins
	public static final int ORANGEBOOK   	= SKIN_BOOK;
	public static final int YELLOWBOOK   	= SKIN_BOOK+1;
	public static final int GREENBOOK    	= SKIN_BOOK+2;
	public static final int BLUEBOOK     	= SKIN_BOOK+3;
	public static final int TURQUOISEBOOK	= SKIN_BOOK+4;
	public static final int PURPLEBOOK   	= SKIN_BOOK+5;
	public static final int PINKBOOK     	= SKIN_BOOK+6;
	public static final int BROWNBOOK    	= SKIN_BOOK+7;
	public static final int BLACKBOOK    	= SKIN_BOOK+8;
	public static final int GRAYBOOK     	= SKIN_BOOK+9;
	public static final int WHITEBOOK    	= SKIN_BOOK+10;
	//Rare Spellbook skins
	public static final int MASTERYBOOK     = SKIN_BOOK+11;
	public static final int LEATHERBOOK    	= SKIN_BOOK+12;
	public static final int POCKETBOOK    	= SKIN_BOOK+13;
	public static final int BEEBOOK    		= SKIN_BOOK+14;
	public static final int EGGBOOK    		= SKIN_BOOK+15;
	public static final int BAKINGBOOK    	= SKIN_BOOK+16;
	public static final int LONGBOOK    	= SKIN_BOOK+17;
	public static final int TALLBOOK    	= SKIN_BOOK+18;
	public static final int WETBOOK    		= SKIN_BOOK+19;
	public static final int WARRIORBOOK    	= SKIN_BOOK+20;
	public static final int PISSBOOK		= SKIN_BOOK+21;
	public static final int TREEBOOK    	= SKIN_BOOK+22;
	public static final int RAINBOWBOOK    	= SKIN_BOOK+23;
	public static final int CARBOOK    		= SKIN_BOOK+24;
	public static final int WESTERNBOOK    	= SKIN_BOOK+25;
	public static final int FISHBOOK    	= SKIN_BOOK+26;
	public static final int BOWBOOK    		= SKIN_BOOK+27;
	public static final int TOOLBOOK    	= SKIN_BOOK+28;
	public static final int DVDBOOK    		= SKIN_BOOK+29;
//	public static final int BOOK    		= SKIN_BOOK+30;
//	public static final int BOOK    		= SKIN_BOOK+31;
//	public static final int BOOK    		= SKIN_BOOK+32;
//	public static final int BOOK    		= SKIN_BOOK+33;
//	public static final int BOOK    		= SKIN_BOOK+34;
//	public static final int BOOK    		= SKIN_BOOK+35;

	//Epic Spellbook skins
	public static final int RINGBOOK    	= SKIN_BOOK+36;
	public static final int MANIACBOOK    	= SKIN_BOOK+37;
	public static final int INSTRUCTIONBOOK = SKIN_BOOK+38;
	public static final int GOOBOOK 		= SKIN_BOOK+39;
	public static final int GRILLBOOK 		= SKIN_BOOK+40;
	public static final int GOLDBOOK 		= SKIN_BOOK+41;

	static {
		assignItemRect(ORANGEBOOK   	,		13, 16);
		assignItemRect(YELLOWBOOK   	,		13, 16);
		assignItemRect(GREENBOOK    	,		13, 16);
		assignItemRect(BLUEBOOK     	,		13, 16);
		assignItemRect(TURQUOISEBOOK	,		13, 16);
		assignItemRect(PURPLEBOOK   	,		13, 16);
		assignItemRect(PINKBOOK     	,		13, 16);
		assignItemRect(BROWNBOOK    	,		13, 16);
		assignItemRect(BLACKBOOK    	,		13, 16);
		assignItemRect(GRAYBOOK     	,		13, 16);
		assignItemRect(WHITEBOOK    	,		13, 16);
		assignItemRect(MASTERYBOOK  	,		13, 16);
		assignItemRect(LEATHERBOOK  	,		14, 16);
		assignItemRect(POCKETBOOK   	,		9,  11);
		assignItemRect(BEEBOOK      	,		13, 16);
		assignItemRect(EGGBOOK      	,		13, 16);
		assignItemRect(BAKINGBOOK   	,		13, 16);
		assignItemRect(LONGBOOK     	,		16, 14);
		assignItemRect(TALLBOOK     	,		8,  16);
		assignItemRect(WETBOOK      	,		13, 16);
		assignItemRect(WARRIORBOOK  	,		13, 16);
		assignItemRect(PISSBOOK  		,		13, 16);
		assignItemRect(TREEBOOK     	,		13, 16);
		assignItemRect(RAINBOWBOOK     	,		13, 16);
		assignItemRect(CARBOOK         	,		13, 15);
		assignItemRect(WESTERNBOOK     	,		13, 15);
		assignItemRect(FISHBOOK        	,		13, 16);
		assignItemRect(BOWBOOK         	,		13, 16);
		assignItemRect(TOOLBOOK         ,		13, 16);
		assignItemRect(DVDBOOK         	,		14, 16);
//		assignItemRect(BOOK         	,		13, 16);
//		assignItemRect(BOOK         	,		13, 16);
//		assignItemRect(BOOK         	,		13, 16);
//		assignItemRect(BOOK         	,		13, 16);
//		assignItemRect(BOOK         	,		13, 16);
//		assignItemRect(BOOK         	,		13, 16);
		assignItemRect(RINGBOOK         ,		13, 16);
		assignItemRect(MANIACBOOK       ,		13, 16);
		assignItemRect(INSTRUCTIONBOOK  ,		13, 16);
		assignItemRect(GOOBOOK  		,		16, 15);
		assignItemRect(GRILLBOOK  		,		13, 16);
		assignItemRect(GOLDBOOK  		,		13, 16);
	}

	private static final int SKIN_RUNIC =                  xy(1, 65);

	//Common Runic blade skins
	public static final int ORANGERUNIC        	= SKIN_RUNIC;
	public static final int YELLOWRUNIC        	= SKIN_RUNIC +1;
	public static final int GREENRUNIC         	= SKIN_RUNIC +2;
	public static final int BLUERUNIC          	= SKIN_RUNIC +3;
	public static final int TURQUOISERUNIC     	= SKIN_RUNIC +4;
	public static final int PURPLERUNIC        	= SKIN_RUNIC +5;
	public static final int PINKRUNIC          	= SKIN_RUNIC +6;
	public static final int BROWNRUNIC         	= SKIN_RUNIC +7;
	public static final int BLACKRUNIC         	= SKIN_RUNIC +8;
	public static final int GRAYRUNIC          	= SKIN_RUNIC +9;
	public static final int WHITERUNIC         	= SKIN_RUNIC +10;
	//Rare Runic blade skins
	public static final int REDRUNIC        	= SKIN_RUNIC +11;
	public static final int BROKENRUNIC        	= SKIN_RUNIC +12;
	public static final int TIDEPODRUNIC        = SKIN_RUNIC +13;
	public static final int RAINBOWRUNIC        = SKIN_RUNIC +14;
	public static final int OBSIDIANRUNIC       = SKIN_RUNIC +15;
	public static final int CANDLERUNIC        	= SKIN_RUNIC +16;
	public static final int MEATRUNIC        	= SKIN_RUNIC +17;
	public static final int GOORUNIC        	= SKIN_RUNIC +18;
	public static final int METALRUNIC        	= SKIN_RUNIC +19;
	public static final int CHEESERUNIC        	= SKIN_RUNIC +20;
	public static final int RESINRUNIC        	= SKIN_RUNIC +21;
	public static final int CATALYSTRUNIC       = SKIN_RUNIC +22;
	public static final int EMBERRUNIC        	= SKIN_RUNIC +23;
	public static final int RUSTEDRUNIC        	= SKIN_RUNIC +24;
	public static final int SEALRUNIC        	= SKIN_RUNIC +25;
	public static final int LEATHERRUNIC        = SKIN_RUNIC +26;
	//	public static final int RUNIC        		= SKINS_WEAPONS+27;
//	public static final int RUNIC        		= SKINS_WEAPONS+28;
//	public static final int RUNIC        		= SKINS_WEAPONS+29;
//	public static final int RUNIC        		= SKINS_WEAPONS+30;
//	public static final int RUNIC        		= SKINS_WEAPONS+31;
	//Epic Runic blade skins
	public static final int GOLDENRUNIC     	= SKIN_RUNIC +32;
	public static final int INSULINRUNIC    	= SKIN_RUNIC +33;
	public static final int ICERUNIC        	= SKIN_RUNIC +34;
	public static final int SNAKERUNIC        	= SKIN_RUNIC +35;
	public static final int RINGRUNIC        	= SKIN_RUNIC +36;
	public static final int WHEATRUNIC        	= SKIN_RUNIC +37;
	public static final int ICECREAMRUNIC       = SKIN_RUNIC +38;
	public static final int RATRUNIC        	= SKIN_RUNIC +39;
	//	public static final int RUNIC        		= SKINS_WEAPONS+40;
	//Legendary Runic blade skins
	public static final int TRUEGOLDRUNIC       = SKIN_RUNIC +41;
	public static final int AMULETRUNIC        	= SKIN_RUNIC +42;
	public static final int NATURERUNIC        	= SKIN_RUNIC +43;
	public static final int WATERRUNIC        	= SKIN_RUNIC +44;
	public static final int EARTHRUNIC        	= SKIN_RUNIC +45;
	public static final int FIRERUNIC        	= SKIN_RUNIC +46;
	public static final int WINDRUNIC        	= SKIN_RUNIC +47;
	static {
		//Common Runic blades
		assignItemRect(ORANGERUNIC      ,		14, 14);
		assignItemRect(YELLOWRUNIC      ,		14, 14);
		assignItemRect(GREENRUNIC       ,		14, 14);
		assignItemRect(BLUERUNIC        ,		14, 14);
		assignItemRect(TURQUOISERUNIC   ,		14, 14);
		assignItemRect(PURPLERUNIC      ,		14, 14);
		assignItemRect(PINKRUNIC        ,		14, 14);
		assignItemRect(BROWNRUNIC       ,		14, 14);
		assignItemRect(BLACKRUNIC       ,		14, 14);
		assignItemRect(GRAYRUNIC        ,		14, 14);
		assignItemRect(WHITERUNIC       ,		14, 14);
		//Rare Runic blades
		assignItemRect(REDRUNIC         ,		14, 14);
		assignItemRect(BROKENRUNIC      ,		14, 14);
		assignItemRect(TIDEPODRUNIC     ,		14, 14);
		assignItemRect(RAINBOWRUNIC     ,		14, 14);
		assignItemRect(OBSIDIANRUNIC    ,		14, 14);
		assignItemRect(CANDLERUNIC      ,		14, 15);
		assignItemRect(MEATRUNIC        ,		14, 14);
		assignItemRect(GOORUNIC         ,		14, 14);
		assignItemRect(METALRUNIC       ,		14, 14);
		assignItemRect(CHEESERUNIC      ,		14, 14);
		assignItemRect(RESINRUNIC       ,		14, 14);
		assignItemRect(CATALYSTRUNIC    ,		14, 14);
		assignItemRect(EMBERRUNIC       ,		14, 14);
		assignItemRect(RUSTEDRUNIC      ,		14, 14);
		assignItemRect(SEALRUNIC        ,		14, 14);
		assignItemRect(LEATHERRUNIC     ,		14, 14);
//		assignItemRect(RUNIC     		,		14, 14);
//		assignItemRect(RUNIC     		,		14, 14);
//		assignItemRect(RUNIC     		,		14, 14);
//		assignItemRect(RUNIC     		,		14, 14);
//		assignItemRect(RUNIC     		,		14, 14);
		//Epic Runic blades
		assignItemRect(GOLDENRUNIC      ,		14, 14);
		assignItemRect(INSULINRUNIC     ,		14, 14);
		assignItemRect(ICERUNIC         ,		14, 14);
		assignItemRect(SNAKERUNIC       ,		15, 14);
		assignItemRect(RINGRUNIC        ,		14, 14);
		assignItemRect(WHEATRUNIC       ,		16, 15);
		assignItemRect(ICECREAMRUNIC    ,		14, 14);
		assignItemRect(RATRUNIC         ,		15, 14);
//		assignItemRect(RUNIC          	,		14, 14);
		//Legendary Runic blades
		assignItemRect(TRUEGOLDRUNIC    ,		16, 16);
		assignItemRect(AMULETRUNIC      ,		16, 16);
		assignItemRect(NATURERUNIC      ,		16, 16);
		assignItemRect(WATERRUNIC       ,		16, 15);
		assignItemRect(EARTHRUNIC       ,		16, 16);
		assignItemRect(FIRERUNIC        ,		16, 16);
		assignItemRect(WINDRUNIC        ,		15, 14);
	}

	private static final int SKIN_LONGSWORD =                  xy(1, 68);

	//Common Longswords
	public static final int ORANGELSWORD        	= SKIN_LONGSWORD;
	public static final int YELLOWLSWORD        	= SKIN_LONGSWORD +1;
	public static final int GREENLSWORD         	= SKIN_LONGSWORD +2;
	public static final int BLUELSWORD          	= SKIN_LONGSWORD +3;
	public static final int TURQUOISELSWORD     	= SKIN_LONGSWORD +4;
	public static final int PURPLELSWORD        	= SKIN_LONGSWORD +5;
	public static final int PINKLSWORD          	= SKIN_LONGSWORD +6;
	public static final int BROWNLSWORD         	= SKIN_LONGSWORD +7;
	public static final int BLACKLSWORD         	= SKIN_LONGSWORD +8;
	public static final int GRAYLSWORD          	= SKIN_LONGSWORD +9;
	public static final int WHITELSWORD         	= SKIN_LONGSWORD +10;
	public static final int RUSSETLSWORD         	= SKIN_LONGSWORD +11;
	public static final int MAROONLSWORD         	= SKIN_LONGSWORD +12;
	public static final int SEPIALSWORD         	= SKIN_LONGSWORD +13;
	public static final int CARDINALLSWORD         	= SKIN_LONGSWORD +14;
	//Rare Longswords
	public static final int CURSEDLSWORD         	= SKIN_LONGSWORD +15;
	public static final int RUSTYLSWORD         	= SKIN_LONGSWORD +16;
	public static final int COPPERLSWORD         	= SKIN_LONGSWORD +17;
	public static final int RAINBOWLSWORD         	= SKIN_LONGSWORD +18;
	public static final int BENTLSWORD         		= SKIN_LONGSWORD +19;
	public static final int RESINLSWORD         	= SKIN_LONGSWORD +20;
	public static final int CATALYSTLSWORD         	= SKIN_LONGSWORD +21;
	public static final int EMBERLSWORD         	= SKIN_LONGSWORD +22;
	public static final int WOODENLSWORD         	= SKIN_LONGSWORD +23;
	public static final int SEALLSWORD         		= SKIN_LONGSWORD +24;
	//Epic Longswords
	public static final int GOLDLSWORD         		= SKIN_LONGSWORD +25;
	public static final int RINGLSWORD         		= SKIN_LONGSWORD +26;
	public static final int TINYLSWORD         		= SKIN_LONGSWORD +27;
	//	public static final int LSWORD         			= SKIN_LONGSWORD +28;
	//Legendary Longswords
	public static final int TRUEGOLDLSWORD      	= SKIN_LONGSWORD +29;
	static {
		assignItemRect(ORANGELSWORD      ,		15, 15);
		assignItemRect(YELLOWLSWORD      ,		15, 15);
		assignItemRect(GREENLSWORD       ,		15, 15);
		assignItemRect(BLUELSWORD        ,		15, 15);
		assignItemRect(TURQUOISELSWORD   ,		15, 15);
		assignItemRect(PURPLELSWORD      ,		15, 15);
		assignItemRect(PINKLSWORD        ,		15, 15);
		assignItemRect(BROWNLSWORD       ,		15, 15);
		assignItemRect(BLACKLSWORD       ,		15, 15);
		assignItemRect(GRAYLSWORD        ,		15, 15);
		assignItemRect(WHITELSWORD       ,		15, 15);
		assignItemRect(RUSSETLSWORD      ,		15, 15);
		assignItemRect(MAROONLSWORD      ,		15, 15);
		assignItemRect(SEPIALSWORD       ,		15, 15);
		assignItemRect(CARDINALLSWORD    ,		15, 15);

		assignItemRect(CURSEDLSWORD      ,		15, 15);
		assignItemRect(RUSTYLSWORD       ,		15, 15);
		assignItemRect(COPPERLSWORD      ,		15, 15);
		assignItemRect(RAINBOWLSWORD     ,		15, 15);
		assignItemRect(BENTLSWORD        ,		15, 15);
		assignItemRect(RESINLSWORD       ,		15, 15);
		assignItemRect(CATALYSTLSWORD    ,		15, 15);
		assignItemRect(EMBERLSWORD       ,		15, 15);
		assignItemRect(WOODENLSWORD      ,		15, 15);
		assignItemRect(SEALLSWORD      ,		15, 15);

		assignItemRect(GOLDLSWORD      	 ,		15, 15);
		assignItemRect(RINGLSWORD      	 ,		15, 15);
		assignItemRect(TINYLSWORD      	 ,		9,  9);

		assignItemRect(TRUEGOLDLSWORD    ,		16, 16);
	}

	private static final int SKIN_GLAIVE =                  xy(1, 70);

	//Common Glaives
	public static final int ORANGEGLAIVE        	= SKIN_GLAIVE;
	public static final int YELLOWGLAIVE        	= SKIN_GLAIVE +1;
	public static final int GREENGLAIVE         	= SKIN_GLAIVE +2;
	public static final int BLUEGLAIVE          	= SKIN_GLAIVE +3;
	public static final int TURQUOISEGLAIVE     	= SKIN_GLAIVE +4;
	public static final int PURPLEGLAIVE        	= SKIN_GLAIVE +5;
	public static final int PINKGLAIVE          	= SKIN_GLAIVE +6;
	public static final int BROWNGLAIVE         	= SKIN_GLAIVE +7;
	public static final int BLACKGLAIVE         	= SKIN_GLAIVE +8;
	public static final int GRAYGLAIVE          	= SKIN_GLAIVE +9;
	public static final int WHITEGLAIVE         	= SKIN_GLAIVE +10;
	public static final int RUSSETGLAIVE         	= SKIN_GLAIVE +11;
	public static final int MAROONGLAIVE         	= SKIN_GLAIVE +12;
	public static final int SEPIAGLAIVE         	= SKIN_GLAIVE +13;
	public static final int CARDINALGLAIVE         	= SKIN_GLAIVE +14;
	public static final int BERRYGLAIVE         	= SKIN_GLAIVE +15;
	//Rare Glaives
	public static final int METALGLAIVE         	= SKIN_GLAIVE +16;
	public static final int RAINBOWGLAIVE         	= SKIN_GLAIVE +17;
	public static final int FULLRAINBOWGLAIVE       = SKIN_GLAIVE +18;
	public static final int RESINGLAIVE         	= SKIN_GLAIVE +19;
	public static final int CATALYSTGLAIVE         	= SKIN_GLAIVE +20;
	public static final int EMBERGLAIVE         	= SKIN_GLAIVE +21;
	public static final int NUTGLAIVE         		= SKIN_GLAIVE +22;
	public static final int STYLUSGLAIVE 			= SKIN_GLAIVE +23;
	public static final int GOOGLAIVE         		= SKIN_GLAIVE +24;
	public static final int CURSEDGLAIVE         	= SKIN_GLAIVE +25;
	//Epic Glaives
	public static final int ICECREAMGLAIVE         	= SKIN_GLAIVE +26;
	public static final int NATUREGLAIVE         	= SKIN_GLAIVE +27;
	public static final int ARROWGLAIVE         	= SKIN_GLAIVE +28;
	public static final int CHAINGLAIVE         	= SKIN_GLAIVE +29;
	public static final int VEGGIEGLAIVE         	= SKIN_GLAIVE +30;
	public static final int TINYGLAIVE         		= SKIN_GLAIVE +31;
	public static final int FROZENGLAIVE         	= SKIN_GLAIVE +32;
	public static final int SEALGLAIVE         		= SKIN_GLAIVE +33;
	public static final int AXEGLAIVE         		= SKIN_GLAIVE +34;
	public static final int GREATGLAIVE         	= SKIN_GLAIVE +35;
	public static final int GUARDIANGLAIVE 			= SKIN_GLAIVE +36;
	public static final int CLOTHGLAIVE    			= SKIN_GLAIVE +37;
	public static final int GOLDENGLAIVE  			= SKIN_GLAIVE +38;
	public static final int BOMBGLAIVE 				= SKIN_GLAIVE +39;
	public static final int CHARGEGLAIVE         	= SKIN_GLAIVE +40;
	public static final int CDGLAIVE         		= SKIN_GLAIVE +41;
	//Legendary Glaives
	public static final int TRUEGOLDGLAIVE         	= SKIN_GLAIVE +42;
	public static final int BEEGLAIVE 				= SKIN_GLAIVE +43;
	public static final int SNAKEGLAIVE 			= SKIN_GLAIVE +44;
	public static final int SHROUDEDGLAIVE			= SKIN_GLAIVE +45;
	public static final int BLOWNUPGLAIVE 			= SKIN_GLAIVE +46;
	public static final int FIERYGLAIVE				= SKIN_GLAIVE +47;

	static {
		assignItemRect(ORANGEGLAIVE,			16, 16);
		assignItemRect(YELLOWGLAIVE,			16, 16);
		assignItemRect(GREENGLAIVE,				16, 16);
		assignItemRect(BLUEGLAIVE,				16, 16);
		assignItemRect(TURQUOISEGLAIVE,			16, 16);
		assignItemRect(PURPLEGLAIVE,			16, 16);
		assignItemRect(PINKGLAIVE,				16, 16);
		assignItemRect(BROWNGLAIVE,				16, 16);
		assignItemRect(BLACKGLAIVE,				16, 16);
		assignItemRect(GRAYGLAIVE,				16, 16);
		assignItemRect(WHITEGLAIVE,				16, 16);
		assignItemRect(RUSSETGLAIVE,			16, 16);
		assignItemRect(MAROONGLAIVE,			16, 16);
		assignItemRect(SEPIAGLAIVE,				16, 16);
		assignItemRect(CARDINALGLAIVE,			16, 16);
		assignItemRect(BERRYGLAIVE,				16, 16);

		assignItemRect(METALGLAIVE,				16, 16);
		assignItemRect(RAINBOWGLAIVE,			16, 16);
		assignItemRect(FULLRAINBOWGLAIVE,		16, 16);
		assignItemRect(RESINGLAIVE,				16, 16);
		assignItemRect(CATALYSTGLAIVE,			16, 16);
		assignItemRect(EMBERGLAIVE,				16, 16);
		assignItemRect(NUTGLAIVE,				16, 16);
		assignItemRect(STYLUSGLAIVE,			16, 16);
		assignItemRect(GOOGLAIVE,				16, 16);
		assignItemRect(CURSEDGLAIVE,			16, 16);

		assignItemRect(ICECREAMGLAIVE,			16, 16);
		assignItemRect(NATUREGLAIVE,			16, 16);
		assignItemRect(ARROWGLAIVE,				16, 15);
		assignItemRect(CHAINGLAIVE,				13, 16);
		assignItemRect(VEGGIEGLAIVE,			16, 16);
		assignItemRect(TINYGLAIVE,				8,  8);
		assignItemRect(FROZENGLAIVE,			16, 16);
		assignItemRect(SEALGLAIVE,				16, 16);
		assignItemRect(AXEGLAIVE,				16, 16);
		assignItemRect(GREATGLAIVE,				16, 16);
		assignItemRect(GUARDIANGLAIVE,			16, 16);
		assignItemRect(CLOTHGLAIVE,				16, 16);
		assignItemRect(GOLDENGLAIVE,			16, 16);
		assignItemRect(BOMBGLAIVE,				16, 16);
		assignItemRect(CHARGEGLAIVE,			16, 15);
		assignItemRect(CDGLAIVE,				16, 16);

		assignItemRect(TRUEGOLDGLAIVE,			16, 16);
		assignItemRect(BEEGLAIVE,				16, 16);
		assignItemRect(SNAKEGLAIVE ,			16, 16);
		assignItemRect(SHROUDEDGLAIVE,			16, 16);
		assignItemRect(BLOWNUPGLAIVE,			16, 16);
		assignItemRect(FIERYGLAIVE,				16, 16);
	}

	private static final int SKIN_AXE =                  xy(1, 73);

	//Common Axes
	public static final int ORANGEAXE				= SKIN_AXE;
	public static final int YELLOWAXE				= SKIN_AXE +1;
	public static final int GREENAXE				= SKIN_AXE +2;
	public static final int BLUEAXE					= SKIN_AXE +3;
	public static final int TURQUOISEAXE			= SKIN_AXE +4;
	public static final int PURPLEAXE				= SKIN_AXE +5;
	public static final int PINKAXE					= SKIN_AXE +6;
	public static final int BROWNAXE				= SKIN_AXE +7;
	public static final int BLACKAXE				= SKIN_AXE +8;
	public static final int GRAYAXE					= SKIN_AXE +9;
	public static final int WHITEAXE				= SKIN_AXE +10;
	public static final int RUSSETAXE				= SKIN_AXE +11;
	public static final int MAROONAXE				= SKIN_AXE +12;
	public static final int SEPIAAXE				= SKIN_AXE +13;
	public static final int CARDINALAXE				= SKIN_AXE +14;
	public static final int BERRYAXE				= SKIN_AXE +15;
	//Rare Axes
	public static final int COPPERAXE         		= SKIN_AXE +16;
	public static final int RAINBOWAXE         		= SKIN_AXE +17;
	public static final int RESINAXE         		= SKIN_AXE +18;
	public static final int CATALYSTAXE         	= SKIN_AXE +19;
	public static final int EMBERAXE         		= SKIN_AXE +20;
	public static final int NUTAXE         			= SKIN_AXE +21;
	//Epic Axes
	public static final int GOLDAXE         		= SKIN_AXE +22;
	public static final int CHEESEAXE         		= SKIN_AXE +23;
	public static final int NATUREAXE         		= SKIN_AXE +24;
	public static final int COOKIEAXE         		= SKIN_AXE +25;
	public static final int MESSEDAXE         		= SKIN_AXE +26;
	public static final int KINGSAXE         		= SKIN_AXE +27;
	public static final int SPLITTINGAXE         	= SKIN_AXE +28;
	//Legendary Axes
	public static final int TRUEGOLDAXE         	= SKIN_AXE +29;
	public static final int CHAINAXE         		= SKIN_AXE +30;
	public static final int PILEAXE         		= SKIN_AXE +31;

	static {
		assignItemRect(ORANGEAXE,				16, 16);
		assignItemRect(YELLOWAXE,				16, 16);
		assignItemRect(GREENAXE,				16, 16);
		assignItemRect(BLUEAXE,					16, 16);
		assignItemRect(TURQUOISEAXE,			16, 16);
		assignItemRect(PURPLEAXE,				16, 16);
		assignItemRect(PINKAXE,					16, 16);
		assignItemRect(BROWNAXE,				16, 16);
		assignItemRect(BLACKAXE,				16, 16);
		assignItemRect(GRAYAXE,					16, 16);
		assignItemRect(WHITEAXE,				16, 16);
		assignItemRect(RUSSETAXE,				16, 16);
		assignItemRect(MAROONAXE,				16, 16);
		assignItemRect(SEPIAAXE,				16, 16);
		assignItemRect(CARDINALAXE,				16, 16);
		assignItemRect(BERRYAXE,				16, 16);

		assignItemRect(COPPERAXE,				16, 16);
		assignItemRect(RAINBOWAXE,				16, 16);
		assignItemRect(RESINAXE,				16, 16);
		assignItemRect(CATALYSTAXE,				16, 16);
		assignItemRect(EMBERAXE,				16, 16);
		assignItemRect(NUTAXE,					16, 16);

		assignItemRect(GOLDAXE,					16, 16);
		assignItemRect(CHEESEAXE,				16, 16);
		assignItemRect(NATUREAXE,				16, 16);
		assignItemRect(COOKIEAXE,				16, 16);
		assignItemRect(MESSEDAXE,				16, 14);
		assignItemRect(KINGSAXE,				16, 16);
		assignItemRect(SPLITTINGAXE,			16, 13);

		assignItemRect(TRUEGOLDAXE,				16, 16);
		assignItemRect(CHAINAXE,				12, 16);
		assignItemRect(PILEAXE,					16, 16);
	}

	private static final int SKIN_HAMMER =                  xy(1, 75);

	//Common Hammers
	public static final int ORANGEHAMMER			= SKIN_HAMMER    ;
	public static final int YELLOWHAMMER			= SKIN_HAMMER  +1;
	public static final int GREENHAMMER				= SKIN_HAMMER  +2;
	public static final int BLUEHAMMER				= SKIN_HAMMER  +3;
	public static final int TURQUOISEHAMMER			= SKIN_HAMMER  +4;
	public static final int PURPLEHAMMER			= SKIN_HAMMER  +5;
	public static final int PINKHAMMER				= SKIN_HAMMER  +6;
	public static final int BROWNHAMMER				= SKIN_HAMMER  +7;
	public static final int BLACKHAMMER				= SKIN_HAMMER  +8;
	public static final int GRAYHAMMER				= SKIN_HAMMER  +9;
	public static final int WHITEHAMMER				= SKIN_HAMMER +10;
	public static final int RUSSETHAMMER			= SKIN_HAMMER +11;
	public static final int MAROONHAMMER			= SKIN_HAMMER +12;
	public static final int SEPIAHAMMER				= SKIN_HAMMER +13;
	public static final int CARDINALHAMMER			= SKIN_HAMMER +14;
	public static final int BERRYHAMMER				= SKIN_HAMMER +15;
	//Rare Hammers
	public static final int OTSUCHIHAMMER			= SKIN_HAMMER +16;
	public static final int SHEEPHAMMER				= SKIN_HAMMER +17;
	public static final int BREADHAMMER				= SKIN_HAMMER +18;
	public static final int FREEDOMHAMMER			= SKIN_HAMMER +19;
	public static final int NUTHAMMER				= SKIN_HAMMER +20;
	public static final int BLASTHAMMER				= SKIN_HAMMER +21;
	public static final int ARCANEHAMMER			= SKIN_HAMMER +22;
	public static final int RESINHAMMER				= SKIN_HAMMER +23;
	public static final int EMBERHAMMER				= SKIN_HAMMER +24;
	public static final int INVISIBLEHAMMER			= SKIN_HAMMER +25;
	public static final int CAKEBASEHAMMER			= SKIN_HAMMER +26;
	public static final int OREHAMMER				= SKIN_HAMMER +27;
	//Epic Hammers
	public static final int GOLDHAMMER				= SKIN_HAMMER +28;
	public static final int ROYALHAMMER				= SKIN_HAMMER +29;
	public static final int NAILHAMMER				= SKIN_HAMMER +30;
	public static final int AXEHAMMER				= SKIN_HAMMER +31;
	public static final int STAMPHAMMER				= SKIN_HAMMER +32;
	public static final int PAINTHAMMER				= SKIN_HAMMER +33;
	public static final int FROZENHAMMER			= SKIN_HAMMER +34;
	public static final int NATUREHAMMER			= SKIN_HAMMER +35;
	public static final int BAGHAMMER				= SKIN_HAMMER +36;
	public static final int CHOCOHAMMER				= SKIN_HAMMER +37;
	public static final int BITTENHAMMER			= SKIN_HAMMER +38;
	public static final int FISHHAMMER				= SKIN_HAMMER +39;
	//Legendary Hammers
	public static final int TRUEGOLDHAMMER			= SKIN_HAMMER +40;
	public static final int AMULETHAMMER			= SKIN_HAMMER +41;
	public static final int CREAMHAMMER				= SKIN_HAMMER +42;
	//	public static final int HAMMER				= SKIN_HAMMER +43;
//	public static final int HAMMER				= SKIN_HAMMER +44;
//	public static final int HAMMER				= SKIN_HAMMER +45;
	//Mythic Hammers
	public static final int GOOLDENHAMMER			= SKIN_HAMMER +46;
	public static final int CAKEHAMMER				= SKIN_HAMMER +47;

	static {
		assignItemRect(ORANGEHAMMER,			16, 16);
		assignItemRect(YELLOWHAMMER,			16, 16);
		assignItemRect(GREENHAMMER,				16, 16);
		assignItemRect(BLUEHAMMER,				16, 16);
		assignItemRect(TURQUOISEHAMMER,			16, 16);
		assignItemRect(PURPLEHAMMER,			16, 16);
		assignItemRect(PINKHAMMER,				16, 16);
		assignItemRect(BROWNHAMMER,				16, 16);
		assignItemRect(BLACKHAMMER,				16, 16);
		assignItemRect(GRAYHAMMER,				16, 16);
		assignItemRect(WHITEHAMMER,				16, 16);
		assignItemRect(RUSSETHAMMER,			16, 16);
		assignItemRect(MAROONHAMMER,			16, 16);
		assignItemRect(SEPIAHAMMER,				16, 16);
		assignItemRect(CARDINALHAMMER,			16, 16);
		assignItemRect(BERRYHAMMER,				16, 16);

		assignItemRect(OTSUCHIHAMMER,			16, 16);
		assignItemRect(SHEEPHAMMER,				16, 16);
		assignItemRect(BREADHAMMER,				16, 16);
		assignItemRect(FREEDOMHAMMER,			16, 16);
		assignItemRect(NUTHAMMER,				16, 16);
		assignItemRect(BLASTHAMMER,				16, 16);
		assignItemRect(ARCANEHAMMER,			16, 16);
		assignItemRect(RESINHAMMER,				16, 16);
		assignItemRect(EMBERHAMMER,				16, 16);
		assignItemRect(INVISIBLEHAMMER,			16, 16);
		assignItemRect(CAKEBASEHAMMER,			16, 16);
		assignItemRect(OREHAMMER,				16, 16);

		assignItemRect(GOLDHAMMER,				16, 16);
		assignItemRect(ROYALHAMMER,				16, 16);
		assignItemRect(NAILHAMMER,				16, 15);
		assignItemRect(AXEHAMMER,				16, 16);
		assignItemRect(STAMPHAMMER,				16, 16);
		assignItemRect(PAINTHAMMER,				16, 16);
		assignItemRect(FROZENHAMMER,			16, 16);
		assignItemRect(NATUREHAMMER,			16, 16);
		assignItemRect(BAGHAMMER,				16, 16);
		assignItemRect(CHOCOHAMMER,				16, 16);
		assignItemRect(BITTENHAMMER,			16, 16);
		assignItemRect(FISHHAMMER,				16, 16);

		assignItemRect(TRUEGOLDHAMMER,			16, 16);
		assignItemRect(AMULETHAMMER,			16, 16);
		assignItemRect(CREAMHAMMER,				16, 16);

		assignItemRect(GOOLDENHAMMER,			16, 16);
		assignItemRect(CAKEHAMMER,				16, 16);
	}

	private static final int SKIN_SHIELD =                  xy(1, 78);

	//Common Shields
	public static final int ORANGESHIELD			= SKIN_SHIELD    ;
	public static final int YELLOWSHIELD			= SKIN_SHIELD  +1;
	public static final int GREENSHIELD				= SKIN_SHIELD  +2;
	public static final int BLUESHIELD				= SKIN_SHIELD  +3;
	public static final int TURQUOISESHIELD			= SKIN_SHIELD  +4;
	public static final int PURPLESHIELD			= SKIN_SHIELD  +5;
	public static final int PINKSHIELD				= SKIN_SHIELD  +6;
	public static final int BROWNSHIELD				= SKIN_SHIELD  +7;
	public static final int BLACKSHIELD				= SKIN_SHIELD  +8;
	public static final int GRAYSHIELD				= SKIN_SHIELD  +9;
	public static final int WHITESHIELD				= SKIN_SHIELD +10;
	public static final int RUSSETSHIELD			= SKIN_SHIELD +11;
	public static final int MAROONSHIELD			= SKIN_SHIELD +12;
	public static final int SEPIASHIELD				= SKIN_SHIELD +13;
	public static final int CARDINALSHIELD			= SKIN_SHIELD +14;
	public static final int BERRYSHIELD				= SKIN_SHIELD +15;
	//Rare Shields
	public static final int ANKHSHIELD				= SKIN_SHIELD +16;
	public static final int SWORDSHIELD				= SKIN_SHIELD +17;
	public static final int SEALSHIELD				= SKIN_SHIELD +18;
	public static final int MEATSHIELD				= SKIN_SHIELD +19;
	public static final int HOLESHIELD				= SKIN_SHIELD +20;
	public static final int GOOSHIELD				= SKIN_SHIELD +21;
	public static final int METALSHIELD				= SKIN_SHIELD +22;
	public static final int CHEESESHIELD			= SKIN_SHIELD +23;
	public static final int AMULETSHIELD			= SKIN_SHIELD +24;
	public static final int MISSILESHIELD			= SKIN_SHIELD +25;
	public static final int FIRESHIELD				= SKIN_SHIELD +26;
	public static final int ICESHIELD				= SKIN_SHIELD +27;
	public static final int LIGHTNINGSHIELD			= SKIN_SHIELD +28;
	public static final int EARTHSHIELD				= SKIN_SHIELD +29;
	public static final int SHATTEREDSHIELD			= SKIN_SHIELD +30;
	public static final int TRIDENTSHIELD			= SKIN_SHIELD +31;
	public static final int LIQUIDSHIELD			= SKIN_SHIELD +32;
	public static final int CAMOSHIELD				= SKIN_SHIELD +33;
	//Epic Shields
	public static final int GOLDSHIELD				= SKIN_SHIELD +34;
	public static final int CANDLESHIELD			= SKIN_SHIELD +35;
	public static final int EGGSHIELD				= SKIN_SHIELD +36;
	public static final int LIGHTSHIELD				= SKIN_SHIELD +37;
	public static final int NATURESHIELD			= SKIN_SHIELD +38;
	public static final int GRASSSHIELD				= SKIN_SHIELD +39;
	public static final int FUSIONSHIELD			= SKIN_SHIELD +40;
	public static final int SHIELDSHIELD 			= SKIN_SHIELD +41;
	//	public static final int SHIELD					= SKIN_SHIELD +42;
	//Legendary Shields
	public static final int TRUEGOLDSHIELD 			= SKIN_SHIELD +43;
//	public static final int SHIELD 			= SKIN_SHIELD +44;
//	public static final int SHIELD 			= SKIN_SHIELD +45;
//	public static final int SHIELD 			= SKIN_SHIELD +46;
//	public static final int SHIELD 			= SKIN_SHIELD +47;

	static {
		assignItemRect(ORANGESHIELD,			12, 16);
		assignItemRect(YELLOWSHIELD,			12, 16);
		assignItemRect(GREENSHIELD,				12, 16);
		assignItemRect(BLUESHIELD,				12, 16);
		assignItemRect(TURQUOISESHIELD,			12, 16);
		assignItemRect(PURPLESHIELD,			12, 16);
		assignItemRect(PINKSHIELD,				12, 16);
		assignItemRect(BROWNSHIELD,				12, 16);
		assignItemRect(BLACKSHIELD,				12, 16);
		assignItemRect(GRAYSHIELD,				12, 16);
		assignItemRect(WHITESHIELD,				12, 16);
		assignItemRect(RUSSETSHIELD,			12, 16);
		assignItemRect(MAROONSHIELD,			12, 16);
		assignItemRect(SEPIASHIELD,				12, 16);
		assignItemRect(CARDINALSHIELD,			12, 16);
		assignItemRect(BERRYSHIELD,				12, 16);

		assignItemRect(ANKHSHIELD,				12, 16);
		assignItemRect(SWORDSHIELD,				12, 16);
		assignItemRect(SEALSHIELD,				12, 16);
		assignItemRect(MEATSHIELD,				12, 16);
		assignItemRect(HOLESHIELD,				12, 16);
		assignItemRect(GOOSHIELD,				12, 16);
		assignItemRect(METALSHIELD,				12, 16);
		assignItemRect(CHEESESHIELD,			12, 16);
		assignItemRect(AMULETSHIELD,			12, 16);
		assignItemRect(MISSILESHIELD,			12, 16);
		assignItemRect(FIRESHIELD,				12, 16);
		assignItemRect(ICESHIELD,				12, 16);
		assignItemRect(LIGHTNINGSHIELD,			12, 16);
		assignItemRect(EARTHSHIELD,				12, 16);
		assignItemRect(SHATTEREDSHIELD,			14, 16);
		assignItemRect(TRIDENTSHIELD,			12, 16);
		assignItemRect(LIQUIDSHIELD,			12, 16);
		assignItemRect(CAMOSHIELD,				12, 16);

		assignItemRect(GOLDSHIELD,				12, 16);
		assignItemRect(CANDLESHIELD,			12, 15);
		assignItemRect(EGGSHIELD,				12, 16);
		assignItemRect(LIGHTSHIELD,				16, 16);
		assignItemRect(NATURESHIELD,			15, 16);
		assignItemRect(GRASSSHIELD,				12, 16);
		assignItemRect(FUSIONSHIELD,			12, 16);
		assignItemRect(SHIELDSHIELD,			14, 16);

		assignItemRect(TRUEGOLDSHIELD,			16, 16);
	}

	private static final int SKIN_SCIMITAR =						xy(1, 81);
	//Common Scimitars
	public static final int ORANGESCIMITAR				= SKIN_SCIMITAR    ;
	public static final int YELLOWSCIMITAR				= SKIN_SCIMITAR  +1;
	public static final int GREENSCIMITAR				= SKIN_SCIMITAR  +2;
	public static final int BLUESCIMITAR				= SKIN_SCIMITAR  +3;
	public static final int TURQUOISESCIMITAR			= SKIN_SCIMITAR  +4;
	public static final int PURPLESCIMITAR				= SKIN_SCIMITAR  +5;
	public static final int PINKSCIMITAR				= SKIN_SCIMITAR  +6;
	public static final int BROWNSCIMITAR				= SKIN_SCIMITAR  +7;
	public static final int BLACKSCIMITAR				= SKIN_SCIMITAR  +8;
	public static final int GRAYSCIMITAR				= SKIN_SCIMITAR  +9;
	public static final int WHITESCIMITAR				= SKIN_SCIMITAR +10;
	public static final int RUSSETSCIMITAR				= SKIN_SCIMITAR +11;
	public static final int MAROONSCIMITAR				= SKIN_SCIMITAR +12;
	public static final int SEPIASCIMITAR				= SKIN_SCIMITAR +13;
	public static final int CARDINALSCIMITAR			= SKIN_SCIMITAR +14;
	public static final int BERRYSCIMITAR				= SKIN_SCIMITAR +15;
	//Rare Scimitars
	public static final int BIGSCIMITAR					= SKIN_SCIMITAR +16;
	public static final int CUTSCIMITAR					= SKIN_SCIMITAR +17;
	public static final int MEATSCIMITAR				= SKIN_SCIMITAR +18;
	public static final int GOOSCIMITAR					= SKIN_SCIMITAR +19;
	public static final int ICESCIMITAR					= SKIN_SCIMITAR +20;
//	public static final int SCIMITAR					= SKIN_SCIMITAR +21;
	//Epic Scimitars
	public static final int GOLDSCIMITAR				= SKIN_SCIMITAR +22;
	public static final int BENTSCIMITAR				= SKIN_SCIMITAR +23;
	public static final int RINGSCIMITAR				= SKIN_SCIMITAR +24;
	public static final int DUELISTSCIMITAR				= SKIN_SCIMITAR +25;
	public static final int WARRIORSCIMITAR				= SKIN_SCIMITAR +26;
	public static final int MAGESCIMITAR				= SKIN_SCIMITAR +27;
	public static final int RIPOSTESCIMITAR				= SKIN_SCIMITAR +28;
	//Legendary Scimitars
	public static final int TRUEGOLDSCIMITAR			= SKIN_SCIMITAR +29;
	public static final int FEATHERSCIMITAR				= SKIN_SCIMITAR +30;

	static {
		assignItemRect(ORANGESCIMITAR, 			13, 16);
		assignItemRect(YELLOWSCIMITAR, 			13, 16);
		assignItemRect(GREENSCIMITAR, 			13, 16);
		assignItemRect(BLUESCIMITAR, 			13, 16);
		assignItemRect(TURQUOISESCIMITAR, 		13, 16);
		assignItemRect(PURPLESCIMITAR, 			13, 16);
		assignItemRect(PINKSCIMITAR, 			13, 16);
		assignItemRect(BROWNSCIMITAR, 			13, 16);
		assignItemRect(BLACKSCIMITAR, 			13, 16);
		assignItemRect(GRAYSCIMITAR, 			13, 16);
		assignItemRect(WHITESCIMITAR, 			13, 16);
		assignItemRect(RUSSETSCIMITAR, 			13, 16);
		assignItemRect(MAROONSCIMITAR, 			13, 16);
		assignItemRect(SEPIASCIMITAR, 			13, 16);
		assignItemRect(CARDINALSCIMITAR, 		13, 16);
		assignItemRect(BERRYSCIMITAR, 			13, 16);

		assignItemRect(BIGSCIMITAR, 			13, 16);
		assignItemRect(CUTSCIMITAR, 			10, 16);
		assignItemRect(MEATSCIMITAR, 			13, 16);
		assignItemRect(GOOSCIMITAR, 			13, 16);
		assignItemRect(ICESCIMITAR, 			13, 16);
//		assignItemRect(SCIMITAR, 			13, 16);
		assignItemRect(GOLDSCIMITAR, 			13, 16);
		assignItemRect(BENTSCIMITAR, 			11, 16);
		assignItemRect(RINGSCIMITAR, 			13, 16);
		assignItemRect(DUELISTSCIMITAR, 		13, 16);
		assignItemRect(WARRIORSCIMITAR, 		13, 16);
		assignItemRect(MAGESCIMITAR, 			14, 16);
		assignItemRect(RIPOSTESCIMITAR, 		14, 14);

		assignItemRect(TRUEGOLDSCIMITAR, 		16, 16);
		assignItemRect(FEATHERSCIMITAR, 		14, 16);


	}

	//for smaller 8x8 icons that often accompany an item sprite
	public static class Icons {

		private static final int WIDTH = 16;
		public static final int SIZE = 8;

		public static TextureFilm film = new TextureFilm( Assets.Sprites.ITEM_ICONS, SIZE, SIZE );

		private static int xy(int x, int y){
			x -= 1; y -= 1;
			return x + WIDTH*y;
		}

		private static void assignIconRect( int item, int width, int height ){
			int x = (item % WIDTH) * SIZE;
			int y = (item / WIDTH) * SIZE;
			film.add( item, x, y, x+width, y+height);
		}

		private static final int RINGS          =                            xy(1, 1);  //16 slots
		public static final int RING_ACCURACY   = RINGS+0;
		public static final int RING_ARCANA     = RINGS+1;
		public static final int RING_ELEMENTS   = RINGS+2;
		public static final int RING_ENERGY     = RINGS+3;
		public static final int RING_EVASION    = RINGS+4;
		public static final int RING_FORCE      = RINGS+5;
		public static final int RING_FUROR      = RINGS+6;
		public static final int RING_HASTE      = RINGS+7;
		public static final int RING_MIGHT      = RINGS+8;
		public static final int RING_SHARPSHOOT = RINGS+9;
		public static final int RING_TENACITY   = RINGS+10;
		public static final int RING_WEALTH     = RINGS+11;
		static {
			assignIconRect( RING_ACCURACY,      7, 7 );
			assignIconRect( RING_ARCANA,        7, 7 );
			assignIconRect( RING_ELEMENTS,      7, 7 );
			assignIconRect( RING_ENERGY,        7, 5 );
			assignIconRect( RING_EVASION,       7, 7 );
			assignIconRect( RING_FORCE,         5, 6 );
			assignIconRect( RING_FUROR,         7, 6 );
			assignIconRect( RING_HASTE,         6, 6 );
			assignIconRect( RING_MIGHT,         7, 7 );
			assignIconRect( RING_SHARPSHOOT,    7, 7 );
			assignIconRect( RING_TENACITY,      6, 6 );
			assignIconRect( RING_WEALTH,        7, 6 );
		}

		                                                                                //16 free slots

		private static final int SCROLLS        =                            xy(1, 3);  //16 slots
		public static final int SCROLL_UPGRADE  = SCROLLS+0;
		public static final int SCROLL_IDENTIFY = SCROLLS+1;
		public static final int SCROLL_REMCURSE = SCROLLS+2;
		public static final int SCROLL_MIRRORIMG= SCROLLS+3;
		public static final int SCROLL_RECHARGE = SCROLLS+4;
		public static final int SCROLL_TELEPORT = SCROLLS+5;
		public static final int SCROLL_LULLABY  = SCROLLS+6;
		public static final int SCROLL_MAGICMAP = SCROLLS+7;
		public static final int SCROLL_RAGE     = SCROLLS+8;
		public static final int SCROLL_RETRIB   = SCROLLS+9;
		public static final int SCROLL_TERROR   = SCROLLS+10;
		public static final int SCROLL_TRANSMUTE= SCROLLS+11;
		public static final int SCROLL_SHIT		= SCROLLS+12;
		static {
			assignIconRect( SCROLL_UPGRADE,     7, 7 );
			assignIconRect( SCROLL_IDENTIFY,    4, 7 );
			assignIconRect( SCROLL_REMCURSE,    7, 7 );
			assignIconRect( SCROLL_MIRRORIMG,   7, 5 );
			assignIconRect( SCROLL_RECHARGE,    7, 5 );
			assignIconRect( SCROLL_TELEPORT,    7, 7 );
			assignIconRect( SCROLL_LULLABY,     7, 6 );
			assignIconRect( SCROLL_MAGICMAP,    7, 7 );
			assignIconRect( SCROLL_RAGE,        6, 6 );
			assignIconRect( SCROLL_RETRIB,      5, 6 );
			assignIconRect( SCROLL_TERROR,      5, 7 );
			assignIconRect( SCROLL_TRANSMUTE,   7, 7 );
			assignIconRect( SCROLL_SHIT,   		7, 4 );
		}

		private static final int EXOTIC_SCROLLS =                            xy(1, 4);  //16 slots
		public static final int SCROLL_ENCHANT  = EXOTIC_SCROLLS+0;
		public static final int SCROLL_DIVINATE = EXOTIC_SCROLLS+1;
		public static final int SCROLL_ANTIMAGIC= EXOTIC_SCROLLS+2;
		public static final int SCROLL_PRISIMG  = EXOTIC_SCROLLS+3;
		public static final int SCROLL_MYSTENRG = EXOTIC_SCROLLS+4;
		public static final int SCROLL_PASSAGE  = EXOTIC_SCROLLS+5;
		public static final int SCROLL_SIREN    = EXOTIC_SCROLLS+6;
		public static final int SCROLL_FORESIGHT= EXOTIC_SCROLLS+7;
		public static final int SCROLL_CHALLENGE= EXOTIC_SCROLLS+8;
		public static final int SCROLL_PSIBLAST = EXOTIC_SCROLLS+9;
		public static final int SCROLL_DREAD    = EXOTIC_SCROLLS+10;
		public static final int SCROLL_METAMORPH= EXOTIC_SCROLLS+11;
		public static final int SCROLL_ENSHIT   = EXOTIC_SCROLLS+12;
		static {
			assignIconRect( SCROLL_ENCHANT,     7, 7 );
			assignIconRect( SCROLL_DIVINATE,    7, 6 );
			assignIconRect( SCROLL_ANTIMAGIC,   7, 7 );
			assignIconRect( SCROLL_PRISIMG,     5, 7 );
			assignIconRect( SCROLL_MYSTENRG,    7, 5 );
			assignIconRect( SCROLL_PASSAGE,     5, 7 );
			assignIconRect( SCROLL_SIREN,       7, 6 );
			assignIconRect( SCROLL_FORESIGHT,   7, 5 );
			assignIconRect( SCROLL_CHALLENGE,   7, 7 );
			assignIconRect( SCROLL_PSIBLAST,    5, 6 );
			assignIconRect( SCROLL_DREAD,       5, 7 );
			assignIconRect( SCROLL_METAMORPH,   7, 7 );
			assignIconRect( SCROLL_METAMORPH,   8, 8 );
		}

		                                                                                //16 free slots

		private static final int POTIONS        =                            xy(1, 6);  //16 slots
		public static final int POTION_STRENGTH = POTIONS+0;
		public static final int POTION_HEALING  = POTIONS+1;
		public static final int POTION_MINDVIS  = POTIONS+2;
		public static final int POTION_FROST    = POTIONS+3;
		public static final int POTION_LIQFLAME = POTIONS+4;
		public static final int POTION_TOXICGAS = POTIONS+5;
		public static final int POTION_HASTE    = POTIONS+6;
		public static final int POTION_INVIS    = POTIONS+7;
		public static final int POTION_LEVITATE = POTIONS+8;
		public static final int POTION_PARAGAS  = POTIONS+9;
		public static final int POTION_PURITY   = POTIONS+10;
		public static final int POTION_EXP      = POTIONS+11;
		public static final int POTION_ACC      = POTIONS+12;
		public static final int POTION_KET      = POTIONS+13;
		public static final int POTION_FUEL     = POTIONS+14;
		static {
			assignIconRect( POTION_STRENGTH,    7, 7 );
			assignIconRect( POTION_HEALING,     6, 7 );
			assignIconRect( POTION_MINDVIS,     7, 5 );
			assignIconRect( POTION_FROST,       7, 7 );
			assignIconRect( POTION_LIQFLAME,    5, 7 );
			assignIconRect( POTION_TOXICGAS,    7, 7 );
			assignIconRect( POTION_HASTE,       6, 6 );
			assignIconRect( POTION_INVIS,       5, 7 );
			assignIconRect( POTION_LEVITATE,    6, 7 );
			assignIconRect( POTION_PARAGAS,     7, 7 );
			assignIconRect( POTION_PURITY,      5, 7 );
			assignIconRect( POTION_EXP,         7, 7 );
			assignIconRect( POTION_ACC,         7, 6 );
			assignIconRect( POTION_KET,         7, 2 );
			assignIconRect( POTION_FUEL,        5, 7 );
		}

		private static final int EXOTIC_POTIONS =                            xy(1, 7);  //16 slots
		public static final int POTION_MASTERY  = EXOTIC_POTIONS+0;
		public static final int POTION_SHIELDING= EXOTIC_POTIONS+1;
		public static final int POTION_MAGISIGHT= EXOTIC_POTIONS+2;
		public static final int POTION_SNAPFREEZ= EXOTIC_POTIONS+3;
		public static final int POTION_DRGBREATH= EXOTIC_POTIONS+4;
		public static final int POTION_CORROGAS = EXOTIC_POTIONS+5;
		public static final int POTION_STAMINA  = EXOTIC_POTIONS+6;
		public static final int POTION_SHROUDFOG= EXOTIC_POTIONS+7;
		public static final int POTION_STRMCLOUD= EXOTIC_POTIONS+8;
		public static final int POTION_EARTHARMR= EXOTIC_POTIONS+9;
		public static final int POTION_CLEANSE  = EXOTIC_POTIONS+10;
		public static final int POTION_DIVINE   = EXOTIC_POTIONS+11;
		public static final int POTION_FUROR 	= EXOTIC_POTIONS+12;
		public static final int POTION_KET_STORM= EXOTIC_POTIONS+13;
		public static final int POTION_FUMES	= EXOTIC_POTIONS+14;
		static {
			assignIconRect( POTION_MASTERY,     7, 7 );
			assignIconRect( POTION_SHIELDING,   6, 6 );
			assignIconRect( POTION_MAGISIGHT,   7, 5 );
			assignIconRect( POTION_SNAPFREEZ,   7, 7 );
			assignIconRect( POTION_DRGBREATH,   7, 7 );
			assignIconRect( POTION_CORROGAS,    7, 7 );
			assignIconRect( POTION_STAMINA,     6, 6 );
			assignIconRect( POTION_SHROUDFOG,   7, 7 );
			assignIconRect( POTION_STRMCLOUD,   7, 7 );
			assignIconRect( POTION_EARTHARMR,   6, 6 );
			assignIconRect( POTION_CLEANSE,     7, 7 );
			assignIconRect( POTION_DIVINE,      7, 7 );
			assignIconRect( POTION_FUROR,       7, 6 );
			assignIconRect( POTION_FUROR,       7, 7 );
			assignIconRect( POTION_FUMES,       7, 7 );
		}

		                                                                                //16 free slots


		private static final int MISC_ICONS =                            xy(1, 9);
		public static final int ALT_MAP_1 	= MISC_ICONS;
		public static final int ALT_MAP_2 	= MISC_ICONS+1;
		public static final int ALT_MAP_3 	= MISC_ICONS+2;
		public static final int ALT_MAP_4 	= MISC_ICONS+3;
		public static final int ALT_TELE 	= MISC_ICONS+4;
		public static final int ALT_LULLABY = MISC_ICONS+5;
		public static final int LOSS 		= MISC_ICONS+6;
		public static final int SUS 		= MISC_ICONS+7;
		public static final int ALT_EVA_1   = MISC_ICONS+8;
		public static final int ALT_EVA_2   = MISC_ICONS+9;
		public static final int ALT_EVA_3   = MISC_ICONS+10;
		public static final int ALT_EVA_4   = MISC_ICONS+11;

		static {
			assignIconRect(ALT_MAP_1,     7, 7 );
			assignIconRect(ALT_MAP_2,     7, 7 );
			assignIconRect(ALT_MAP_3,     7, 7 );
			assignIconRect(ALT_MAP_4,     7, 7 );
			assignIconRect(ALT_TELE,  7, 7 );
			assignIconRect(ALT_LULLABY,  7, 7 );
			assignIconRect(LOSS,  7, 7 );
			assignIconRect(SUS,  6, 7 );
			assignIconRect(ALT_EVA_1,  6, 7 );
			assignIconRect(ALT_EVA_2,  5, 5 );
			assignIconRect(ALT_EVA_3,  8, 8 );
			assignIconRect(ALT_EVA_4,  5, 5 );
		}
	}

	public static class Prefix {

		private static final int WIDTH = 16;
		public static final int SIZE = 8;

		public static TextureFilm film = new TextureFilm(Assets.Sprites.PREFIX_ICONS, SIZE, SIZE);

		private static int xy(int x, int y) {
			x -= 1;
			y -= 1;
			return x + WIDTH * y;
		}

		private static void assignIconRect(int item, int width, int height) {
			int x = (item % WIDTH) * SIZE;
			int y = (item / WIDTH) * SIZE;
			film.add(item, x, y, x + width, y + height);
		}

		private static final int PREFIXES = xy(1, 1);
		public static final int ANNOYING 		= PREFIXES + 0;
		public static final int LONG 			= PREFIXES + 1;
		public static final int MUSICAL 		= PREFIXES + 2;
		public static final int FEARSOME 		= PREFIXES + 3;
		public static final int DULL 			= PREFIXES + 4;
		public static final int BORING 			= PREFIXES + 5;
		public static final int CATASTROPHIC 	= PREFIXES + 6;
		public static final int SLOW 			= PREFIXES + 7;
		public static final int WEIGHTLESS 		= PREFIXES + 8;
		public static final int SILENT 			= PREFIXES + 9;
		public static final int LOUD 			= PREFIXES + 10;
		public static final int BOLD 			= PREFIXES + 11;
		public static final int CONSTRUCTIVE 	= PREFIXES + 12;
		public static final int QUICK 			= PREFIXES + 13;
		public static final int UNSTOPPABLE 	= PREFIXES + 14;
		public static final int MASTERFUL		= PREFIXES + 15;
		public static final int SCREAMING		= PREFIXES + 16;
		public static final int MUTED 			= PREFIXES + 17;
		public static final int BLAND 			= PREFIXES + 18;
		public static final int HINDERED 		= PREFIXES + 19;
		public static final int EXCITED 		= PREFIXES + 20;
		public static final int CARELESS 		= PREFIXES + 21;
		public static final int AWKWARD 		= PREFIXES + 22;
		public static final int HURTFUL 		= PREFIXES + 23;
		public static final int DEAD 			= PREFIXES + 24;
		public static final int FLIMSY 			= PREFIXES + 25;
		public static final int FAITHFUL 		= PREFIXES + 26;
		public static final int SPIKED 			= PREFIXES + 27;
		public static final int HEROIC 			= PREFIXES + 28;
		public static final int RUTHLESS 		= PREFIXES + 29;
		public static final int THUNDERING 		= PREFIXES + 30;
		public static final int GLISTERING 		= PREFIXES + 31;
		public static final int CELESTIAL 		= PREFIXES + 32;
		public static final int VENOMOUS 		= PREFIXES + 33;
		public static final int ETERNAL 		= PREFIXES + 34;
		public static final int SAVAGE 			= PREFIXES + 35;
		public static final int JAGGED 			= PREFIXES + 36;
		public static final int FRUSTRATING 	= PREFIXES + 37;
		public static final int SOOTHING 		= PREFIXES + 38;
		public static final int LUMINOUS 		= PREFIXES + 39;
		public static final int ELUSIVE 		= PREFIXES + 40;
		public static final int WORN 			= PREFIXES + 41;
		public static final int CRYING 			= PREFIXES + 42;
		public static final int GARGANTUAN 		= PREFIXES + 43;
		public static final int PROTECTIVE 		= PREFIXES + 44;
		public static final int STEADFAST 		= PREFIXES + 45;
		public static final int VOLATILE 		= PREFIXES + 46;
		public static final int SINISTER 		= PREFIXES + 47;
		public static final int ABYSMAL 		= PREFIXES + 48;
		public static final int KNOCKOFF 		= PREFIXES + 49;
		public static final int PLASTIC 		= PREFIXES + 50;
		public static final int BENT 			= PREFIXES + 51;
		public static final int STICKY 			= PREFIXES + 52;
		public static final int HUMBLE 			= PREFIXES + 53;
		public static final int BULKY 			= PREFIXES + 54;
		public static final int WOBBLY 			= PREFIXES + 55;
		public static final int DUSTY 			= PREFIXES + 56;
		public static final int SHATTERED 		= PREFIXES + 57;
		static {
			assignIconRect(ANNOYING 	, 				8, 8);
			assignIconRect(LONG 		, 				8, 8);
			assignIconRect(MUSICAL 		, 				8, 8);
			assignIconRect(FEARSOME 	, 				8, 8);
			assignIconRect(DULL 		, 				8, 8);
			assignIconRect(BORING 		, 				8, 8);
			assignIconRect(CATASTROPHIC	, 				8, 8);
			assignIconRect(SLOW 		, 				8, 8);
			assignIconRect(WEIGHTLESS 	, 				8, 8);
			assignIconRect(SILENT 		, 				8, 8);
			assignIconRect(LOUD 		, 				8, 8);
			assignIconRect(BOLD 		, 				8, 8);
			assignIconRect(CONSTRUCTIVE	, 				8, 8);
			assignIconRect(QUICK 		, 				8, 8);
			assignIconRect(UNSTOPPABLE 	, 				8, 8);
			assignIconRect(MASTERFUL	, 				8, 8);
			assignIconRect(SCREAMING	, 				8, 8);
			assignIconRect(MUTED 		, 				8, 8);
			assignIconRect(BLAND 		, 				8, 8);
			assignIconRect(HINDERED 	, 				8, 8);
			assignIconRect(EXCITED 		, 				8, 8);
			assignIconRect(CARELESS 	, 				8, 8);
			assignIconRect(AWKWARD 		, 				8, 8);
			assignIconRect(HURTFUL 		, 				8, 8);
			assignIconRect(DEAD 		, 				8, 8);
			assignIconRect(FLIMSY 		, 				8, 8);
			assignIconRect(FAITHFUL 	, 				8, 8);
			assignIconRect(SPIKED 		, 				8, 8);
			assignIconRect(HEROIC 		, 				8, 8);
			assignIconRect(RUTHLESS 	, 				8, 8);
			assignIconRect(THUNDERING 	, 				8, 8);
			assignIconRect(GLISTERING 	, 				8, 8);
			assignIconRect(CELESTIAL 	, 				8, 8);
			assignIconRect(VENOMOUS 	, 				8, 8);
			assignIconRect(ETERNAL 		, 				8, 8);
			assignIconRect(SAVAGE 		, 				8, 8);
			assignIconRect(JAGGED 		, 				8, 8);
			assignIconRect(FRUSTRATING 	, 				8, 8);
			assignIconRect(SOOTHING 	, 				8, 8);
			assignIconRect(LUMINOUS 	, 				8, 8);
			assignIconRect(ELUSIVE 		, 				8, 8);
			assignIconRect(WORN 		, 				8, 8);
			assignIconRect(CRYING 		, 				8, 8);
			assignIconRect(GARGANTUAN 	, 				8, 8);
			assignIconRect(PROTECTIVE 	, 				8, 8);
			assignIconRect(STEADFAST 	, 				8, 8);
			assignIconRect(VOLATILE 	, 				8, 8);
			assignIconRect(SINISTER 	, 				8, 8);
			assignIconRect(ABYSMAL 		, 				8, 8);
			assignIconRect(KNOCKOFF 	, 				8, 8);
			assignIconRect(PLASTIC 		, 				8, 8);
		}
	}

}
