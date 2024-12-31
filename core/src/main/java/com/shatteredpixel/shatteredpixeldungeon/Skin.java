package com.shatteredpixel.shatteredpixeldungeon;

import com.shatteredpixel.shatteredpixeldungeon.items.Amulet;
import com.shatteredpixel.shatteredpixeldungeon.items.Ankh;
import com.shatteredpixel.shatteredpixeldungeon.items.ArcaneResin;
import com.shatteredpixel.shatteredpixeldungeon.items.BrokenSeal;
import com.shatteredpixel.shatteredpixeldungeon.items.Honeypot;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.KingsCrown;
import com.shatteredpixel.shatteredpixeldungeon.items.LiquidMetal;
import com.shatteredpixel.shatteredpixeldungeon.items.Stylus;
import com.shatteredpixel.shatteredpixeldungeon.items.TengusMask;
import com.shatteredpixel.shatteredpixeldungeon.items.Torch;
import com.shatteredpixel.shatteredpixeldungeon.items.Waterskin;
import com.shatteredpixel.shatteredpixeldungeon.items.albums.NonsenseAlbum;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.ClothArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.DuelistArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.LeatherArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.MageArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.MailArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.PlateArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.PlateCarrier;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.WarriorArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.ChaliceOfBlood;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.CloakOfShadows;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.DriedRose;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.EtherealChains;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.MasterThievesArmband;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.MusicPlayer;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.SandalsOfNature;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.TalismanOfForesight;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.UnstableSpellbook;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.LootBag;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.MagicalHolster;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.Pillow;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.VeggieBag;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.VelvetPouch;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Bomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.FrostBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.WoollyBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Berry;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Bread;
import com.shatteredpixel.shatteredpixeldungeon.items.food.CakeBase;
import com.shatteredpixel.shatteredpixeldungeon.items.food.ChargrilledSmallMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Cheese;
import com.shatteredpixel.shatteredpixeldungeon.items.food.CheeseSlice;
import com.shatteredpixel.shatteredpixeldungeon.items.food.ChocolateCake;
import com.shatteredpixel.shatteredpixeldungeon.items.food.CoffeeBean;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Cookies;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Egg;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Fish;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Food;
import com.shatteredpixel.shatteredpixeldungeon.items.food.GoldenMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.IceCream;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Milk;
import com.shatteredpixel.shatteredpixeldungeon.items.food.MysteryMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Nuts;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Oil;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Pasty;
import com.shatteredpixel.shatteredpixeldungeon.items.food.SmallRation;
import com.shatteredpixel.shatteredpixeldungeon.items.food.StewedMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.TidePod;
import com.shatteredpixel.shatteredpixeldungeon.items.food.WaxBar;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Wheat;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.Car;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.Insulin;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.Painting;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.RatItem;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.Willow;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfFrost;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfInvisibility;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLevitation;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfStrength;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.UnstableBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfDragonsBreath;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfShroudingFog;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfSnapFreeze;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfStormClouds;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.CeremonialCandle;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.CorpseDust;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.DarkGold;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.Embers;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.GoldBar;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.GooBlob;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.MetalShard;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.Pickaxe;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.PinkAmulet;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.Saw;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.SilverAmulet;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.Warriorium;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.Ring;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.ArcaneCatalyst;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.StoneOfFlock;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfBlastWave;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfFireblast;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfFrost;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfLightning;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfLivingEarth;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfMagicMissile;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfPrismaticLight;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfRegrowth;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfTransfusion;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfWarding;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.SpiritBow;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.AssassinsBlade;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.BattleAxe;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Crossbow;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Glaive;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Greataxe;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Greatgreatsword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Greatshield;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Greatsword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Longsword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.MagesStaff;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.PileOfSais;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.RunicBlade;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Scimitar;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.SmallGreatsword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Sword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.WarHammer;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.ForceCube;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.Kunai;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.Shuriken;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.Trident;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.plants.Blindweed;
import com.shatteredpixel.shatteredpixeldungeon.plants.CoffeeBush;
import com.shatteredpixel.shatteredpixeldungeon.plants.Earthroot;
import com.shatteredpixel.shatteredpixeldungeon.plants.Fadeleaf;
import com.shatteredpixel.shatteredpixeldungeon.plants.Firebloom;
import com.shatteredpixel.shatteredpixeldungeon.plants.Icecap;
import com.shatteredpixel.shatteredpixeldungeon.plants.Mageroyal;
import com.shatteredpixel.shatteredpixeldungeon.plants.PotatoPlant;
import com.shatteredpixel.shatteredpixeldungeon.plants.Rotberry;
import com.shatteredpixel.shatteredpixeldungeon.plants.Sorrowmoss;
import com.shatteredpixel.shatteredpixeldungeon.plants.Starflower;
import com.shatteredpixel.shatteredpixeldungeon.plants.Stormvine;
import com.shatteredpixel.shatteredpixeldungeon.plants.Sungrass;
import com.shatteredpixel.shatteredpixeldungeon.plants.Swiftthistle;
import com.shatteredpixel.shatteredpixeldungeon.plants.TomatoPlant;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.Bundlable;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Skin implements Bundlable {

    /*

    RARITY:
    0 = Default
    1 = Common, Only base color changed.
    2 = Rare, Texture colors and/or shape changed.
    3 = Epic, Texture shape, colors (and specks) changed
    4 = Legendary, Texture shape and colors changed. New specks.
    5 = Mythic, Like legendary, but cooler I guess.

     */


    //SEALS
    SEAL                (BrokenSeal.class, ItemSpriteSheet.SEAL,            0, "Red",           new BrokenSeal()),
    YELLOWSEAL          (BrokenSeal.class, ItemSpriteSheet.YELLOWSEAL,      1, "Yellow",        new Swiftthistle.Seed()),
    GREENSEAL           (BrokenSeal.class, ItemSpriteSheet.GREENSEAL,       1, "Green",         new Sungrass.Seed()),
    BLUESEAL            (BrokenSeal.class, ItemSpriteSheet.BLUESEAL,        1, "Blue",          new Icecap.Seed()),
    PURPLESEAL          (BrokenSeal.class, ItemSpriteSheet.PURPLESEAL,      1, "Purple",        new Sorrowmoss.Seed()),
    BLACKSEAL           (BrokenSeal.class, ItemSpriteSheet.BLACKSEAL,       1, "Black",         new Starflower.Seed()),
    WHITESEAL           (BrokenSeal.class, ItemSpriteSheet.WHITESEAL,       1, "White",         new Blindweed.Seed()),
    GRAYSEAL            (BrokenSeal.class, ItemSpriteSheet.GRAYSEAL,        1, "Grey",          new Fadeleaf.Seed()),
    TURQUOISESEAL       (BrokenSeal.class, ItemSpriteSheet.TURQUOISESEAL,   1, "Turquoise",     new Stormvine.Seed()),
    BROWNSEAL           (BrokenSeal.class, ItemSpriteSheet.BROWNSEAL,       1, "Brown",         new Earthroot.Seed()),
    PINKSEAL            (BrokenSeal.class, ItemSpriteSheet.PINKSEAL,        1, "Pink",          new Mageroyal.Seed()),
    ORANGESEAL          (BrokenSeal.class, ItemSpriteSheet.ORANGESEAL,      1, "Orange",        new Firebloom.Seed()),

    WOODSEAL      	    (BrokenSeal.class, ItemSpriteSheet.WOODSEAL,        2, "Wooden",        new SandalsOfNature()),
    MEATSEAL      	    (BrokenSeal.class, ItemSpriteSheet.MEATSEAL,        2, "Meat",          new MysteryMeat()),
    TRANSPARENTSEAL     (BrokenSeal.class, ItemSpriteSheet.TRANSPARENTSEAL, 2, "Transparent",   new PotionOfInvisibility()),
    HEALINGSEAL         (BrokenSeal.class, ItemSpriteSheet.HEALINGSEAL,     2, "Healing",       new PotionOfHealing(), "Violates Geneva conventions."),
    CUTSEAL      	    (BrokenSeal.class, ItemSpriteSheet.CUTSEAL,         2, "Sawn-off",      new Saw(), "To demonstrate the power the Saw, I'm going to cut this seal in half!"),
    THIEFSEAL      	    (BrokenSeal.class, ItemSpriteSheet.THIEFSEAL,       2, "Thief",         new MasterThievesArmband(), "The seal is carrying a _Master Thieves Armband_. Stolen obviously."),
    COPPERSEAL      	(BrokenSeal.class, ItemSpriteSheet.COPPERSEAL,      2, "Copper",        new Pickaxe()),
    CUBESEAL      	    (BrokenSeal.class, ItemSpriteSheet.CUBESEAL,        2, "Cube",          new ForceCube()),

    RINGSEAL         	(BrokenSeal.class, ItemSpriteSheet.RINGSEAL,        3, "Ring",          new Ring()),
    RAINBOWSEAL      	(BrokenSeal.class, ItemSpriteSheet.RAINBOWSEAL,     3, "Rainbow",       new UnstableBrew(), "Not for boring people."),
    GOLDSEAL         	(BrokenSeal.class, ItemSpriteSheet.GOLDSEAL,        3, "Golden",        new GoldBar()),
    CORPSESEAL       	(BrokenSeal.class, ItemSpriteSheet.CORPSESEAL,      3, "Skull",         new CorpseDust()),
    HEARTSEAL        	(BrokenSeal.class, ItemSpriteSheet.HEARTSEAL,       3, "Heart",         new Rotberry.Seed()),
    BURNTSEAL        	(BrokenSeal.class, ItemSpriteSheet.BURNTSEAL,       3, "Burnt",         new Embers()),
    GOOSEAL          	(BrokenSeal.class, ItemSpriteSheet.GOOSEAL,         3, "Goo",           new GooBlob()),
    WATERSEAL        	(BrokenSeal.class, ItemSpriteSheet.WATERSEAL,       3, "Water",         new Waterskin()),
    WARRIORSEAL      	(BrokenSeal.class, ItemSpriteSheet.WARRIORSEAL,     3, "Warriorium",    new Warriorium(), "It consumes all."),
    COWBOYSEAL       	(BrokenSeal.class, ItemSpriteSheet.COWBOYSEAL,      3, "Cowboy",        new TengusMask(), "'Yeehaw' -Tengu."),
    HONEYSEAL       	(BrokenSeal.class, ItemSpriteSheet.HONEYSEAL,       3, "Honey",         new Honeypot()),
    ICESEAL       	    (BrokenSeal.class, ItemSpriteSheet.ICESEAL,         3, "Ice",           new FrostBomb()),
    EYESEAL       	    (BrokenSeal.class, ItemSpriteSheet.EYESEAL,         3, "Eye",           new TalismanOfForesight(), "The Eye is watching."),
    SNAKESEAL       	(BrokenSeal.class, ItemSpriteSheet.SNAKESEAL,       3, "Snake",         new EtherealChains()),
    CANDLESEAL       	(BrokenSeal.class, ItemSpriteSheet.CANDLESEAL,      3, "Candle",        new CeremonialCandle()),
    BOMBSEAL       	    (BrokenSeal.class, ItemSpriteSheet.BOMBSEAL,        3, "Bomb",          new Bomb(), "Be careful."),
    SHEEPSEAL       	(BrokenSeal.class, ItemSpriteSheet.SHEEPSEAL,       3, "Sheep",         new WoollyBomb()),

    DMSEAL       	    (BrokenSeal.class, ItemSpriteSheet.DMSEAL,          4, "Electric",      new MetalShard()),
    KINGSEAL       	    (BrokenSeal.class, ItemSpriteSheet.KINGSEAL,        4, "Royal",         new KingsCrown()),
    FIERYSEAL       	(BrokenSeal.class, ItemSpriteSheet.FIERYSEAL,       5, "Fiery",         new Torch()),
    PUREGOLDSEAL       	(BrokenSeal.class, ItemSpriteSheet.PUREGOLDSEAL,    4, "Pure Gold",     new GoldenMeat()),
    AMULETSEAL       	(BrokenSeal.class, ItemSpriteSheet.AMULETSEAL,      4, "Amulet",        new Amulet()),
    BLOWNUPSEAL       	(BrokenSeal.class, ItemSpriteSheet.BLOWNUPSEAL,     5, "Blown up",      new Torch()),


    //CLOAKS
    CLOAK               (CloakOfShadows.class, ItemSpriteSheet.ARTIFACT_CLOAK,      0, "Dark",          null),
    ORANGECLOAK         (CloakOfShadows.class, ItemSpriteSheet.ORANGECLOAK,         1, "Orange",        new Firebloom.Seed()),
    YELLOWCLOAK         (CloakOfShadows.class, ItemSpriteSheet.YELLOWCLOAK,         1, "Yellow",        new Swiftthistle.Seed()),
    GREENCLOAK          (CloakOfShadows.class, ItemSpriteSheet.GREENCLOAK,          1, "Green",         new Sungrass.Seed()),
    BLUECLOAK           (CloakOfShadows.class, ItemSpriteSheet.BLUECLOAK,           1, "Blue",          new Icecap.Seed()),
    TURQUOISECLOAK      (CloakOfShadows.class, ItemSpriteSheet.TURQUOISECLOAK,      1, "Turquoise",     new Stormvine.Seed()),
    PURPLECLOAK         (CloakOfShadows.class, ItemSpriteSheet.PURPLECLOAK,         1, "Purple",        new Sorrowmoss.Seed()),
    PINKCLOAK           (CloakOfShadows.class, ItemSpriteSheet.PINKCLOAK,           1, "Pink",          new Mageroyal.Seed()),
    BROWNCLOAK          (CloakOfShadows.class, ItemSpriteSheet.BROWNCLOAK,          1, "Brown",         new Earthroot.Seed()),
    BLACKCLOAK          (CloakOfShadows.class, ItemSpriteSheet.BLACKCLOAK,          1, "Black",         new Starflower.Seed()),
    GRAYCLOAK           (CloakOfShadows.class, ItemSpriteSheet.GRAYCLOAK,           1, "Grey",          new Fadeleaf.Seed()),
    WHITECLOAK          (CloakOfShadows.class, ItemSpriteSheet.WHITECLOAK,          1, "White",         new Blindweed.Seed()),

    WOODENCLOAK    	    (CloakOfShadows.class, ItemSpriteSheet.WOODENCLOAK,         2, "Wooden",        new SandalsOfNature()),
    LEATHERCLOAK  	    (CloakOfShadows.class, ItemSpriteSheet.LEATHERCLOAK,        2, "Leather",       new LeatherArmor()),
    RATIONCLOAK    	    (CloakOfShadows.class, ItemSpriteSheet.RATIONCLOAK,         2, "Ration",        new SmallRation()),
    PINKAMULETCLOAK	    (CloakOfShadows.class, ItemSpriteSheet.PINKAMULETCLOAK,     2, "Extra Pink",    new PinkAmulet()),
    RAINBOWCLOAK   	    (CloakOfShadows.class, ItemSpriteSheet.RAINBOWCLOAK,        2, "Rainbow",       new UnstableBrew()),
    TINYCLOAK	  	    (CloakOfShadows.class, ItemSpriteSheet.TINYCLOAK,           2, "Tiny",          new SmallGreatsword(), "What's this? A cloak for ants?"),
    WAXCLOAK		  	(CloakOfShadows.class, ItemSpriteSheet.WAXCLOAK,            2, "Wax",           new WaxBar()),
    CANDYCLOAK	  	    (CloakOfShadows.class, ItemSpriteSheet.CANDYCLOAK,          2, "Candy",         new Pasty()),
    COOKEDCLOAK	  	    (CloakOfShadows.class, ItemSpriteSheet.COOKEDCLOAK,         2, "Cooked",        new StewedMeat(), "High protein"),
    CHAINMAILCLOAK 	    (CloakOfShadows.class, ItemSpriteSheet.CHAINMAILCLOAK,      2, "Chainmail",     new MailArmor(), "Close up you can see it's just a cheap print."),
    TACTICALCLOAK 	    (CloakOfShadows.class, ItemSpriteSheet.TACTICALCLOAK,       2, "Tactical",      new PlateCarrier(), "M05 pattern"),

    GOLDENCLOAK     	(CloakOfShadows.class, ItemSpriteSheet.GOLDENCLOAK,         3, "Golden",        new GoldBar()),
    WARRIORCLOAK    	(CloakOfShadows.class, ItemSpriteSheet.WARRIORCLOAK,        3, "Warrior",       new Warriorium()),
    METALCLOAK	    	(CloakOfShadows.class, ItemSpriteSheet.METALCLOAK,          3, "Metal",         new MetalShard()),
    BOTTLECLOAK     	(CloakOfShadows.class, ItemSpriteSheet.BOTTLECLOAK,         3, "Bottle",        new Waterskin(), "Leaks a little when turned upside down"),
    CHEESECLOAK     	(CloakOfShadows.class, ItemSpriteSheet.CHEESECLOAK,         3, "Cheese",        new Cheese(), "Too cheesy for some people"),
    PAINTCLOAK     	    (CloakOfShadows.class, ItemSpriteSheet.PAINTCLOAK,          3, "Painted",       new Painting()),
    DRACULACLOAK     	(CloakOfShadows.class, ItemSpriteSheet.DRACULACLOAK,        3, "Dracula's",     null), //Halloween special

    FIERYCLOAK         	(CloakOfShadows.class, ItemSpriteSheet.FIERYCLOAK,          4, "Fiery",         new Torch(), "Warms your back nicely"),
    TRUEGOLDENCLOAK    	(CloakOfShadows.class, ItemSpriteSheet.TRUEGOLDENCLOAK,     4, "True Golden",   new GoldenMeat()),
    DARKNESSCLOAK      	(CloakOfShadows.class, ItemSpriteSheet.DARKNESSCLOAK,       4, "Darkness",      new PotionOfShroudingFog()),



    //BOWS
    BOW                 (SpiritBow.class, ItemSpriteSheet.SPIRIT_BOW,       0, "Spirit",        null),
    ORANGEBOW           (SpiritBow.class, ItemSpriteSheet.ORANGEBOW,        1, "Orange",        new Firebloom.Seed()),
    YELLOWBOW           (SpiritBow.class, ItemSpriteSheet.YELLOWBOW,        1, "Yellow",        new Swiftthistle.Seed()),
    GREENBOW            (SpiritBow.class, ItemSpriteSheet.GREENBOW,         1, "Green",         new Sungrass.Seed()),
    BLUEBOW             (SpiritBow.class, ItemSpriteSheet.BLUEBOW,          1, "Blue",          new Icecap.Seed()),
    TURQUOISEBOW        (SpiritBow.class, ItemSpriteSheet.TURQUOISEBOW,     1, "Turquoise",     new Stormvine.Seed()),
    PURPLEBOW           (SpiritBow.class, ItemSpriteSheet.PURPLEBOW,        1, "Purple",        new Sorrowmoss.Seed()),
    BROWNBOW            (SpiritBow.class, ItemSpriteSheet.BROWNBOW,         1, "Brown",         new Earthroot.Seed()),
    PINKBOW             (SpiritBow.class, ItemSpriteSheet.PINKBOW,          1, "Pink",          new Mageroyal.Seed()),
    BLACKBOW            (SpiritBow.class, ItemSpriteSheet.BLACKBOW,         1, "Black",         new Starflower.Seed()),
    GRAYBOW             (SpiritBow.class, ItemSpriteSheet.GRAYBOW,          1, "Grey",          new Fadeleaf.Seed()),
    WHITEBOW            (SpiritBow.class, ItemSpriteSheet.WHITEBOW,         1, "White",         new Blindweed.Seed()),

    WOODENBOW           (SpiritBow.class, ItemSpriteSheet.WOODENBOW,        2, "Wooden",        new SandalsOfNature()),
    WALNUTBOW           (SpiritBow.class, ItemSpriteSheet.WALNUTBOW,        2, "Walnut",        new Nuts()),
    GOOBOW              (SpiritBow.class, ItemSpriteSheet.GOOBOW,           2, "Goo",           new GooBlob()),
    CATALYSTBOW         (SpiritBow.class, ItemSpriteSheet.CATALYSTBOW,      2, "Catalyst",      new ArcaneCatalyst(), "The catalyst has somehow formed a stable substance."),
    TAXEDBOW            (SpiritBow.class, ItemSpriteSheet.TAXEDBOW,         2, "Taxed",         new Food(), "You paid your fair share."),
    MEATBOW             (SpiritBow.class, ItemSpriteSheet.MEATBOW,          2, "Meat",          new MysteryMeat()),
    RAINBOWBOW          (SpiritBow.class, ItemSpriteSheet.RAINBOWBOW,       2, "Rainbow",       new UnstableBrew()),
    LOVEBOW             (SpiritBow.class, ItemSpriteSheet.LOVEBOW,          2, "Love",          new Rotberry.Seed(), "Kill them with love."),
    EGGBOW             (SpiritBow.class, ItemSpriteSheet.EGGBOW,            2, "Egg",           new Egg(), "Shoots eggs instead of arrows!"),


    GOLDENBOW           (SpiritBow.class, ItemSpriteSheet.GOLDENBOW,        3, "Golden",        new GoldBar()),
    NATUREBOW           (SpiritBow.class, ItemSpriteSheet.NATUREBOW,        3, "Nature",        new SandalsOfNature()),
    METALBOW            (SpiritBow.class, ItemSpriteSheet.METALBOW,         3, "Metal",         new MetalShard()),
    ROYALBOW            (SpiritBow.class, ItemSpriteSheet.ROYALBOW,         3, "Royal",         new KingsCrown()),
    CROSSBOWBOW         (SpiritBow.class, ItemSpriteSheet.CROSSBOWBOW,      3, "Crossbow",      new Crossbow()),
    EARTHBOW            (SpiritBow.class, ItemSpriteSheet.EARTHBOW,         3, "Earthen",       new WandOfLivingEarth()),
    TENGUBOW            (SpiritBow.class, ItemSpriteSheet.TENGUBOW,         3, "Western",       new TengusMask()),
    WILLOWBOW           (SpiritBow.class, ItemSpriteSheet.WILLOWBOW,        3, "Willow",        new Willow()),
    RINGBOW             (SpiritBow.class, ItemSpriteSheet.RINGBOW,          3, "Ring",          new Ring()),

    FLAMINGBOW          (SpiritBow.class, ItemSpriteSheet.FLAMINGBOW,       4, "Flaming",       new Torch()),



    //WANDS
    WAND                (MagesStaff.class, ItemSpriteSheet.MAGES_STAFF,     0, "Mage's",        null),
    ORANGEWAND          (MagesStaff.class, ItemSpriteSheet.ORANGEWAND,      1, "Orange",        new Firebloom.Seed()),
    YELLOWWAND          (MagesStaff.class, ItemSpriteSheet.YELLOWWAND,      1, "Yellow",        new Swiftthistle.Seed()),
    GREENWAND           (MagesStaff.class, ItemSpriteSheet.GREENWAND,       1, "Green",         new Sungrass.Seed()),
    BLUEWAND            (MagesStaff.class, ItemSpriteSheet.BLUEWAND,        1, "Blue",          new Icecap.Seed()),
    TURQUOISEWAND       (MagesStaff.class, ItemSpriteSheet.TURQUOISEWAND,   1, "Turquoise",     new Stormvine.Seed()),
    PURPLEWAND          (MagesStaff.class, ItemSpriteSheet.PURPLEWAND,      1, "Purple",        new Sorrowmoss.Seed()),
    PINKWAND            (MagesStaff.class, ItemSpriteSheet.PINKWAND,        1, "Pink",          new Mageroyal.Seed()),
    BROWNWAND           (MagesStaff.class, ItemSpriteSheet.BROWNWAND,       1, "Brown",         new Earthroot.Seed()),
    BLACKWAND           (MagesStaff.class, ItemSpriteSheet.BLACKWAND,       1, "Black",         new Starflower.Seed()),
    GRAYWAND            (MagesStaff.class, ItemSpriteSheet.GRAYWAND,        1, "Grey",          new Fadeleaf.Seed()),
    WHITEWAND           (MagesStaff.class, ItemSpriteSheet.WHITEWAND,       1, "White",         new Blindweed.Seed()),

    AMULETWAND          (MagesStaff.class, ItemSpriteSheet.AMULETWAND,      2, "Amulet",        new SilverAmulet()),
    BENTWAND            (MagesStaff.class, ItemSpriteSheet.BENTWAND,        2, "Bent", null, "Oh crap..."),
    LOVEWAND            (MagesStaff.class, ItemSpriteSheet.LOVEWAND,        2, "Love",          new Rotberry.Seed(), "Poke your loved ones with this"),
    GOOWAND             (MagesStaff.class, ItemSpriteSheet.GOOWAND,         2, "Goo",           new GooBlob()),
    MISTWAND            (MagesStaff.class, ItemSpriteSheet.MISTWAND,        2, "Mist",          new PotionOfLevitation()),
    MEATWAND            (MagesStaff.class, ItemSpriteSheet.MEATWAND,        2, "Meat",          new MysteryMeat()),

    GOLDENWAND          (MagesStaff.class, ItemSpriteSheet.GOLDENWAND,      3, "Golden",        new GoldBar()),
    BAGWAND             (MagesStaff.class, ItemSpriteSheet.BAGWAND,         3, "Bag",           new VelvetPouch(), "Best for concealed carry"),
    PICKAXEWAND         (MagesStaff.class, ItemSpriteSheet.PICKAXEWAND,     3, "Pickaxe",       new Pickaxe()),
    ROYALWAND           (MagesStaff.class, ItemSpriteSheet.ROYALWAND,       3, "Royal",         new KingsCrown(), "It's heavy"),
    WALKINGWAND         (MagesStaff.class, ItemSpriteSheet.WALKINGWAND,     3, "Walking Stick", new TengusMask()),
    GUNWAND             (MagesStaff.class, ItemSpriteSheet.GUNWAND,         3, "Gunstaff",      null, "I may have run out of spells, but I haven't ran out of bullets"),
    SPLITWAND           (MagesStaff.class, ItemSpriteSheet.SPLITWAND,       3, "Split",         new Saw(), "What's better than a wand? Two wands!"),
    WARRIORWAND         (MagesStaff.class, ItemSpriteSheet.WARRIORWAND,     3, "Warrior",       new Warriorium()),
    SNAKEWAND           (MagesStaff.class, ItemSpriteSheet.SNAKEWAND,       3, "Snake",         new EtherealChains(), "It's a smol snek"),
    METALWAND           (MagesStaff.class, ItemSpriteSheet.METALWAND,       3, "Metal",         new MetalShard()),

    TRUEGOLDENWAND      (MagesStaff.class, ItemSpriteSheet.TRUEGOLDENWAND,  4, "True Gold",     new GoldenMeat()),
    FIERYWAND           (MagesStaff.class, ItemSpriteSheet.FIERYWAND,       4, "Fiery",         new PotionOfDragonsBreath()),
    MADNESSWAND         (MagesStaff.class, ItemSpriteSheet.MADNESSWAND,     4, "Madness",       new PotionOfShroudingFog()),
    GANDALFWAND         (MagesStaff.class, ItemSpriteSheet.GANDALFWAND,     4, "Gandalf's",     new Longsword(), "The legendary staff of Gandalf the Grey.\n\n'Cry you fools' -Gandalf the Gay"),
    CLOUDWAND           (MagesStaff.class, ItemSpriteSheet.CLOUDWAND,       5, "Cloud",         new PotionOfStormClouds(), "It feels funny to move your hand through the small clouds"),


    //LEATHER ARMORS
    LEATHER             (LeatherArmor.class, ItemSpriteSheet.ARMOR_LEATHER, 0, "Default",       new LeatherArmor(),     2),
    ORANGELEATHER       (LeatherArmor.class, ItemSpriteSheet.ORANGELEATHER, 1, "Orange",        new Firebloom.Seed(),   10),
    YELLOWLEATHER       (LeatherArmor.class, ItemSpriteSheet.YELLOWLEATHER, 1, "Yellow",        new Swiftthistle.Seed(),11),
    GREENLEATHER        (LeatherArmor.class, ItemSpriteSheet.GREENLEATHER,  1, "Green",         new Sungrass.Seed(),    12),
    BLUELEATHER         (LeatherArmor.class, ItemSpriteSheet.BLUELEATHER,   1, "Blue",          new Icecap.Seed(),      13),
    TURQUOISELEATHER  (LeatherArmor.class, ItemSpriteSheet.TURQUOISELEATHER,1, "Turquoise",     new Stormvine.Seed(),   14),
    PURPLELEATHER       (LeatherArmor.class, ItemSpriteSheet.PURPLELEATHER, 1, "Purple",        new Sorrowmoss.Seed(),  15),
    PINKLEATHER         (LeatherArmor.class, ItemSpriteSheet.PINKLEATHER,   1, "Pink",          new Mageroyal.Seed(),   16),
    BROWNLEATHER        (LeatherArmor.class, ItemSpriteSheet.BROWNLEATHER,  1, "Brown",         new Earthroot.Seed(),   17),
    BLACKLEATHER        (LeatherArmor.class, ItemSpriteSheet.BLACKLEATHER,  1, "Black",         new Starflower.Seed(),  18),
    GRAYLEATHER         (LeatherArmor.class, ItemSpriteSheet.GRAYLEATHER,   1, "Grey",          new Fadeleaf.Seed(),    19),
    WHITELEATHER        (LeatherArmor.class, ItemSpriteSheet.WHITELEATHER,  1, "White",         new Blindweed.Seed(),   20),


    //PLATE ARMORS
    PLATE               (PlateArmor.class, ItemSpriteSheet.ARMOR_PLATE,     0, "Default",       new PlateArmor(),       5),
    METALPLATE          (PlateArmor.class, ItemSpriteSheet.METALPLATE,      1, "Metal" ,        new LiquidMetal(),      21),
    COPPERPLATE         (PlateArmor.class, ItemSpriteSheet.COPPERPLATE,     2, "Copper",        new Pickaxe(),          22),
    CURSEDPLATE         (PlateArmor.class, ItemSpriteSheet.CURSEDPLATE,     2, "Cursed",        new MetalShard(),       23),
    GOLDPLATE           (PlateArmor.class, ItemSpriteSheet.GOLDPLATE,       3, "Golden",        new GoldBar(),          24),
    ROYALPLATE          (PlateArmor.class, ItemSpriteSheet.ROYALPLATE,      3, "Royal",         new KingsCrown(),       25),


    //CLOTH ARMORS
    CLOTH               (ClothArmor.class, ItemSpriteSheet.ARMOR_CLOTH,     0, "Default",       new ClothArmor(),       1 ),
    ORANGECLOTH         (ClothArmor.class, ItemSpriteSheet.ORANGECLOTH,     1, "Orange",        new Firebloom.Seed(),   26),
    YELLOWCLOTH         (ClothArmor.class, ItemSpriteSheet.YELLOWCLOTH,     1, "Yellow",        new Swiftthistle.Seed(),27),
    GREENCLOTH          (ClothArmor.class, ItemSpriteSheet.GREENCLOTH,      1, "Green",         new Sungrass.Seed(),    28),
    BLUECLOTH           (ClothArmor.class, ItemSpriteSheet.BLUECLOTH,       1, "Blue",          new Icecap.Seed(),      29),
    TURQUOISECLOTH      (ClothArmor.class, ItemSpriteSheet.TURQUOISECLOTH,  1, "Turquoise",     new Stormvine.Seed(),   30),
    PURPLECLOTH         (ClothArmor.class, ItemSpriteSheet.PURPLECLOTH,     1, "Purple",        new Sorrowmoss.Seed(),  31),
    PINKCLOTH           (ClothArmor.class, ItemSpriteSheet.PINKCLOTH,       1, "Pink",          new Mageroyal.Seed(),   32),
    BROWNCLOTH          (ClothArmor.class, ItemSpriteSheet.BROWNCLOTH,      1, "Brown",         new Earthroot.Seed(),   33),
    BLACKCLOTH          (ClothArmor.class, ItemSpriteSheet.BLACKCLOTH,      1, "Black",         new Starflower.Seed(),  34),
    GRAYCLOTH           (ClothArmor.class, ItemSpriteSheet.GRAYCLOTH,       1, "Grey",          new Fadeleaf.Seed(),    35),
    WHITECLOTH          (ClothArmor.class, ItemSpriteSheet.WHITECLOTH,      1, "White",         new Blindweed.Seed(),   36),
    LIGHTBROWNCLOTH     (ClothArmor.class, ItemSpriteSheet.LIGHTBROWNCLOTH, 2, "Light Brown",   new PotatoPlant.Seed(), 37),
    REDCLOTH            (ClothArmor.class, ItemSpriteSheet.REDCLOTH,        2, "Red",           new TomatoPlant.Seed(), 38),
    COFFEECLOTH         (ClothArmor.class, ItemSpriteSheet.COFFEECLOTH,     2, "Coffee",        new CoffeeBush.Seed(),  39),
    CARDINALCLOTH       (ClothArmor.class, ItemSpriteSheet.CARDINALCLOTH,   2, "Cardinal Red",  new Rotberry.Seed(),    40),
    GOLDENCLOTH         (ClothArmor.class, ItemSpriteSheet.GOLDENCLOTH,     3, "Golden",        new GoldBar(),          41),

    //SPELLBOOKS
    BOOK                (UnstableSpellbook.class,ItemSpriteSheet.ARTIFACT_SPELLBOOK,0, "Default",               new UnstableSpellbook()),
    ORANGEBOOK          (UnstableSpellbook.class, ItemSpriteSheet.ORANGEBOOK,       1, "Orange",                new Firebloom.Seed()),
    YELLOWBOOK          (UnstableSpellbook.class, ItemSpriteSheet.YELLOWBOOK,       1, "Yellow",                new Swiftthistle.Seed()),
    GREENBOOK           (UnstableSpellbook.class, ItemSpriteSheet.GREENBOOK,        1, "Green",                 new Sungrass.Seed()),
    BLUEBOOK            (UnstableSpellbook.class, ItemSpriteSheet.BLUEBOOK,         1, "Blue",                  new Icecap.Seed()),
    TURQUOISEBOOK       (UnstableSpellbook.class, ItemSpriteSheet.TURQUOISEBOOK,    1, "Turquoise",             new Stormvine.Seed()),
    PURPLEBOOK          (UnstableSpellbook.class, ItemSpriteSheet.PURPLEBOOK,       1, "Purple",                new Sorrowmoss.Seed()),
    PINKBOOK            (UnstableSpellbook.class, ItemSpriteSheet.PINKBOOK,         1, "Pink",                  new Mageroyal.Seed()),
    BROWNBOOK           (UnstableSpellbook.class, ItemSpriteSheet.BROWNBOOK,        1, "Brown",                 new Earthroot.Seed()),
    BLACKBOOK           (UnstableSpellbook.class, ItemSpriteSheet.BLACKBOOK,        1, "Black",                 new Starflower.Seed()),
    GRAYBOOK            (UnstableSpellbook.class, ItemSpriteSheet.GRAYBOOK,         1, "Grey",                  new Fadeleaf.Seed()),
    WHITEBOOK           (UnstableSpellbook.class, ItemSpriteSheet.WHITEBOOK,        1, "White",                 new Blindweed.Seed()),

    MASTERYBOOK         (UnstableSpellbook.class, ItemSpriteSheet.MASTERYBOOK,      2, "Mastery",               new TengusMask()),
    LEATHERBOOK         (UnstableSpellbook.class, ItemSpriteSheet.LEATHERBOOK,      2, "Leather",               new LeatherArmor()),
    POCKETBOOK          (UnstableSpellbook.class, ItemSpriteSheet.POCKETBOOK,       2, "Pocket",                new SmallGreatsword()),
    BEEBOOK             (UnstableSpellbook.class, ItemSpriteSheet.BEEBOOK,          2, "Save the bees!",        new Honeypot()),
    EGGBOOK             (UnstableSpellbook.class, ItemSpriteSheet.EGGBOOK,          2, "Chicken guide",         new Egg()),
    BAKINGBOOK          (UnstableSpellbook.class, ItemSpriteSheet.BAKINGBOOK,       2, "Baking guide",          new ChocolateCake()),
    LONGBOOK            (UnstableSpellbook.class, ItemSpriteSheet.LONGBOOK,         2, "Large",                 new Greatgreatsword()),
    TALLBOOK            (UnstableSpellbook.class, ItemSpriteSheet.TALLBOOK,         2, "Tall",                  new MagicalHolster(), "Not very ergonomic"),
    WETBOOK             (UnstableSpellbook.class, ItemSpriteSheet.WETBOOK,          2, "Slightly wet",          new Waterskin()),
    WARRIORBOOK         (UnstableSpellbook.class, ItemSpriteSheet.WARRIORBOOK,      2, "Cursed",                new Warriorium(), "It seems to have dried blood drops all over it"),
    PISSBOOK            (UnstableSpellbook.class, ItemSpriteSheet.PISSBOOK,         2, "Unstable Bladder",      new ChaliceOfBlood(), "Why the fuck did you take a piss on this rare artifact?"),
    TREEBOOK            (UnstableSpellbook.class, ItemSpriteSheet.TREEBOOK,         2, "Foraging Guide",        new Saw()),
    RAINBOWBOOK         (UnstableSpellbook.class, ItemSpriteSheet.RAINBOWBOOK,      2, "Rainbow",               new UnstableBrew()),
    CARBOOK             (UnstableSpellbook.class, ItemSpriteSheet.CARBOOK,          2, "Car magazine",          new Car()),
    WESTERNBOOK         (UnstableSpellbook.class, ItemSpriteSheet.WESTERNBOOK,      2, "Western magazine",      new TengusMask(), "Featuring the famous Texture Will"),
    FISHBOOK            (UnstableSpellbook.class, ItemSpriteSheet.FISHBOOK,         2, "Fishing guide",         new Fish()),
    BOWBOOK             (UnstableSpellbook.class, ItemSpriteSheet.BOWBOOK,          2, "Archery guide",         new SpiritBow()),
    TOOLBOOK            (UnstableSpellbook.class, ItemSpriteSheet.TOOLBOOK,         2, "DIY guide",             null), //TOOLKIT NOT IN USE. FUCK
    DVDBOOK             (UnstableSpellbook.class, ItemSpriteSheet.DVDBOOK,          2, "DVD storage bag",       new MusicPlayer(), "Conveniently stores up to 20 CDs"),

    RINGBOOK            (UnstableSpellbook.class, ItemSpriteSheet.RINGBOOK,         3, "Book of Rings",         new Ring()),
    MANIACBOOK          (UnstableSpellbook.class, ItemSpriteSheet.MANIACBOOK,       3, "Maniac",                new ArcaneCatalyst()),
    INSTRUCTIONBOOK     (UnstableSpellbook.class, ItemSpriteSheet.INSTRUCTIONBOOK,  3, "Instruction pamphlet",  new TidePod(), "User guide to a washing machine"),
    GOOBOOK             (UnstableSpellbook.class, ItemSpriteSheet.GOOBOOK,          3, "Goobook",               new GooBlob()),
    GRILLBOOK           (UnstableSpellbook.class, ItemSpriteSheet.GRILLBOOK,        3, "Grilling guide",        new ChargrilledSmallMeat()),
    GOLDBOOK            (UnstableSpellbook.class, ItemSpriteSheet.GOLDBOOK,         3, "Golden spellbook",      new GoldBar()),


    RUNIC               (RunicBlade.class, ItemSpriteSheet.RUNIC_BLADE,     0, "Default",       new RunicBlade()),
    ORANGERUNIC         (RunicBlade.class, ItemSpriteSheet.ORANGERUNIC,     1, "Orange",        new Firebloom.Seed()),
    YELLOWRUNIC         (RunicBlade.class, ItemSpriteSheet.YELLOWRUNIC,     1, "Yellow",        new Swiftthistle.Seed()),
    GREENRUNIC          (RunicBlade.class, ItemSpriteSheet.GREENRUNIC,      1, "Green",         new Sungrass.Seed()),
    BLUERUNIC           (RunicBlade.class, ItemSpriteSheet.BLUERUNIC,       1, "Blue",          new Icecap.Seed()),
    TURQUOISERUNIC      (RunicBlade.class, ItemSpriteSheet.TURQUOISERUNIC,  1, "Turquoise",     new Stormvine.Seed()),
    PURPLERUNIC         (RunicBlade.class, ItemSpriteSheet.PURPLERUNIC,     1, "Purple",        new Sorrowmoss.Seed()),
    PINKRUNIC           (RunicBlade.class, ItemSpriteSheet.PINKRUNIC,       1, "Pink",          new Mageroyal.Seed()),
    BROWNRUNIC          (RunicBlade.class, ItemSpriteSheet.BROWNRUNIC,      1, "Brown",         new Earthroot.Seed()),
    BLACKRUNIC          (RunicBlade.class, ItemSpriteSheet.BLACKRUNIC,      1, "Black",         new Starflower.Seed()),
    GRAYRUNIC           (RunicBlade.class, ItemSpriteSheet.GRAYRUNIC,       1, "Grey",          new Fadeleaf.Seed()),
    WHITERUNIC          (RunicBlade.class, ItemSpriteSheet.WHITERUNIC,      1, "White",         new Blindweed.Seed()),

    REDRUNIC            (RunicBlade.class, ItemSpriteSheet.REDRUNIC,        2, "Red",           new Rotberry.Seed()),
    BROKENRUNIC         (RunicBlade.class, ItemSpriteSheet.BROKENRUNIC,     2, "Shattered", null, "Well..."),
    TIDEPODRUNIC        (RunicBlade.class, ItemSpriteSheet.TIDEPODRUNIC,    2, "Tide pod",      new TidePod()),
    RAINBOWRUNIC        (RunicBlade.class, ItemSpriteSheet.RAINBOWRUNIC,    2, "Rainbow",       new UnstableBrew()),
    OBSIDIANRUNIC       (RunicBlade.class, ItemSpriteSheet.OBSIDIANRUNIC,   2, "Obsidian",      new AssassinsBlade()),
    CANDLERUNIC         (RunicBlade.class, ItemSpriteSheet.CANDLERUNIC,     2, "Candle",        new CeremonialCandle()),
    MEATRUNIC           (RunicBlade.class, ItemSpriteSheet.MEATRUNIC,       2, "Meaty",         new MysteryMeat()),
    GOORUNIC            (RunicBlade.class, ItemSpriteSheet.GOORUNIC,        2, "Goo",           new GooBlob()),
    METALRUNIC          (RunicBlade.class, ItemSpriteSheet.METALRUNIC,      2, "Metal",         new MetalShard()),
    CHEESERUNIC         (RunicBlade.class, ItemSpriteSheet.CHEESERUNIC,     2, "Cheese",        new Cheese()),
    RESINRUNIC          (RunicBlade.class, ItemSpriteSheet.RESINRUNIC,      2, "Arcane",        new ArcaneResin()),
    CATALYSTRUNIC       (RunicBlade.class, ItemSpriteSheet.CATALYSTRUNIC,   2, "Catalyst",      new ArcaneCatalyst()),
    EMBERRUNIC          (RunicBlade.class, ItemSpriteSheet.EMBERRUNIC,      2, "Ember",         new Embers()),
    RUSTEDRUNIC         (RunicBlade.class, ItemSpriteSheet.RUSTEDRUNIC,     2, "Oxidized",      new Saw()),
    SEALRUNIC           (RunicBlade.class, ItemSpriteSheet.SEALRUNIC,       2, "Seal",          new BrokenSeal()),
    LEATHERRUNIC        (RunicBlade.class, ItemSpriteSheet.LEATHERRUNIC,    2, "Leather",       new LeatherArmor()),

    GOLDENRUNIC          (RunicBlade.class, ItemSpriteSheet.GOLDENRUNIC,    3, "Golden",        new GoldBar()),
    INSULINRUNIC         (RunicBlade.class, ItemSpriteSheet.INSULINRUNIC,   3, "Insulin",       new Insulin()),
    ICERUNIC             (RunicBlade.class, ItemSpriteSheet.ICERUNIC,       3, "Frozen",        new PotionOfSnapFreeze()),
    SNAKERUNIC           (RunicBlade.class, ItemSpriteSheet.SNAKERUNIC,     3, "Snake",         new EtherealChains()),
    RINGRUNIC            (RunicBlade.class, ItemSpriteSheet.RINGRUNIC,      3, "Ring",          new Ring(), "The blade is made out of thin, razor sharp rings"),
    WHEATRUNIC           (RunicBlade.class, ItemSpriteSheet.WHEATRUNIC,     3, "Wheat",         new Wheat(), "Almost as effective as a pillow"),
    ICECREAMRUNIC        (RunicBlade.class, ItemSpriteSheet.ICECREAMRUNIC,  3, "Ice cream",     new IceCream()),
    RATRUNIC             (RunicBlade.class, ItemSpriteSheet.RATRUNIC,       3, "Rat",           new RatItem(), "Rat."),

    TRUEGOLDRUNIC        (RunicBlade.class, ItemSpriteSheet.TRUEGOLDRUNIC,  4, "True Golden",   new GoldenMeat()),
    AMULETRUNIC          (RunicBlade.class, ItemSpriteSheet.AMULETRUNIC,    4, "Amulet",        new Amulet()),
    NATURERUNIC          (RunicBlade.class, ItemSpriteSheet.NATURERUNIC,    4, "Nature",        new SandalsOfNature()),
    WATERRUNIC           (RunicBlade.class, ItemSpriteSheet.WATERRUNIC,     4, "Water",         new Waterskin()),
    EARTHRUNIC           (RunicBlade.class, ItemSpriteSheet.EARTHRUNIC,     4, "Earth",         new WandOfLivingEarth()),
    FIRERUNIC            (RunicBlade.class, ItemSpriteSheet.FIRERUNIC,      4, "Fire",          new PotionOfDragonsBreath()),
    WINDRUNIC            (RunicBlade.class, ItemSpriteSheet.WINDRUNIC,      4, "Wind",          new PotionOfStormClouds()),


    LSWORD               (Longsword.class, ItemSpriteSheet.LONGSWORD,       0, "Default",       new Longsword()),
    ORANGELSWORD         (Longsword.class, ItemSpriteSheet.ORANGELSWORD,    1, "Orange",        new Firebloom.Seed()),
    YELLOWLSWORD         (Longsword.class, ItemSpriteSheet.YELLOWLSWORD,    1, "Yellow",        new Swiftthistle.Seed()),
    GREENLSWORD          (Longsword.class, ItemSpriteSheet.GREENLSWORD,     1, "Green",         new Sungrass.Seed()),
    BLUELSWORD           (Longsword.class, ItemSpriteSheet.BLUELSWORD,      1, "Blue",          new Icecap.Seed()),
    TURQUOISELSWORD      (Longsword.class, ItemSpriteSheet.TURQUOISELSWORD, 1, "Turquoise",     new Stormvine.Seed()),
    PURPLELSWORD         (Longsword.class, ItemSpriteSheet.PURPLELSWORD,    1, "Purple",        new Sorrowmoss.Seed()),
    PINKLSWORD           (Longsword.class, ItemSpriteSheet.PINKLSWORD,      1, "Pink",          new Mageroyal.Seed()),
    BROWNLSWORD          (Longsword.class, ItemSpriteSheet.BROWNLSWORD,     1, "Brown",         new Earthroot.Seed()),
    BLACKLSWORD          (Longsword.class, ItemSpriteSheet.BLACKLSWORD,     1, "Black",         new Starflower.Seed()),
    GRAYLSWORD           (Longsword.class, ItemSpriteSheet.GRAYLSWORD,      1, "Grey",          new Fadeleaf.Seed()),
    WHITELSWORD          (Longsword.class, ItemSpriteSheet.WHITELSWORD,     1, "White",         new Blindweed.Seed()),
    RUSSETLSWORD         (Longsword.class, ItemSpriteSheet.RUSSETLSWORD,    1, "Russet",        new CoffeeBush.Seed()),
    MAROONLSWORD         (Longsword.class, ItemSpriteSheet.MAROONLSWORD,    1, "Maroon",        new TomatoPlant.Seed()),
    SEPIALSWORD          (Longsword.class, ItemSpriteSheet.SEPIALSWORD,     1, "Sepia",         new PotatoPlant.Seed()),
    CARDINALLSWORD       (Longsword.class, ItemSpriteSheet.CARDINALLSWORD,  1, "Cardinal",      new Rotberry.Seed()),

    CURSEDLSWORD         (Longsword.class, ItemSpriteSheet.CURSEDLSWORD,    2, "Cursed",        new MetalShard()),
    RUSTYLSWORD          (Longsword.class, ItemSpriteSheet.RUSTYLSWORD,     2, "Rusty",         new Saw()),
    COPPERLSWORD         (Longsword.class, ItemSpriteSheet.COPPERLSWORD,    2, "Copper",        new Pickaxe()),
    RAINBOWLSWORD        (Longsword.class, ItemSpriteSheet.RAINBOWLSWORD,   2, "Rainbow",       new UnstableBrew()),
    BENTLSWORD           (Longsword.class, ItemSpriteSheet.BENTLSWORD,      2, "Bent", null, "Well..."),
    RESINLSWORD          (Longsword.class, ItemSpriteSheet.RESINLSWORD,     2, "Resin",         new ArcaneResin()),
    CATALYSTLSWORD       (Longsword.class, ItemSpriteSheet.CATALYSTLSWORD,  2, "Catalyst",      new ArcaneCatalyst()),
    EMBERLSWORD          (Longsword.class, ItemSpriteSheet.EMBERLSWORD,     2, "Ember",         new Embers()),
    WOODENLSWORD         (Longsword.class, ItemSpriteSheet.WOODENLSWORD,    2, "Wooden",        new MagesStaff()),
    SEALLSWORD           (Longsword.class, ItemSpriteSheet.SEALLSWORD,      2, "Seal",          new BrokenSeal()),

    GOLDLSWORD           (Longsword.class, ItemSpriteSheet.GOLDLSWORD,      3, "Golden",        new GoldBar()),
    RINGLSWORD           (Longsword.class, ItemSpriteSheet.RINGLSWORD,      3, "Ring",          new Ring()),
    TINYLSWORD           (Longsword.class, ItemSpriteSheet.TINYLSWORD,      3, "Tiny",          new SmallGreatsword(), "So smol!"),

    TRUEGOLDLSWORD       (Longsword.class, ItemSpriteSheet.TRUEGOLDLSWORD,  4, "True golden",   new GoldenMeat()),


    GLAIVE              (Glaive.class, ItemSpriteSheet.GLAIVE,              0, "Default",       new Glaive()),
    ORANGEGLAIVE        (Glaive.class, ItemSpriteSheet.ORANGEGLAIVE,        1, "Orange",        new Firebloom.Seed()),
    YELLOWGLAIVE        (Glaive.class, ItemSpriteSheet.YELLOWGLAIVE,        1, "Yellow",        new Swiftthistle.Seed()),
    GREENGLAIVE         (Glaive.class, ItemSpriteSheet.GREENGLAIVE,         1, "Green",         new Sungrass.Seed()),
    BLUEGLAIVE          (Glaive.class, ItemSpriteSheet.BLUEGLAIVE,          1, "Blue",          new Icecap.Seed()),
    TURQUOISEGLAIVE     (Glaive.class, ItemSpriteSheet.TURQUOISEGLAIVE,     1, "Turquoise",     new Stormvine.Seed()),
    PURPLEGLAIVE        (Glaive.class, ItemSpriteSheet.PURPLEGLAIVE,        1, "Purple",        new Sorrowmoss.Seed()),
    PINKGLAIVE          (Glaive.class, ItemSpriteSheet.PINKGLAIVE,          1, "Pink",          new Mageroyal.Seed()),
    BROWNGLAIVE         (Glaive.class, ItemSpriteSheet.BROWNGLAIVE,         1, "Brown",         new Earthroot.Seed()),
    BLACKGLAIVE         (Glaive.class, ItemSpriteSheet.BLACKGLAIVE,         1, "Black",         new Starflower.Seed()),
    GRAYGLAIVE          (Glaive.class, ItemSpriteSheet.GRAYGLAIVE,          1, "Grey",          new Fadeleaf.Seed()),
    WHITEGLAIVE         (Glaive.class, ItemSpriteSheet.WHITEGLAIVE,         1, "White",         new Blindweed.Seed()),
    RUSSETGLAIVE        (Glaive.class, ItemSpriteSheet.RUSSETGLAIVE,        1, "Russet",        new CoffeeBush.Seed()),
    MAROONGLAIVE        (Glaive.class, ItemSpriteSheet.MAROONGLAIVE,        1, "Maroon",        new TomatoPlant.Seed()),
    SEPIAGLAIVE         (Glaive.class, ItemSpriteSheet.SEPIAGLAIVE,         1, "Sepia",         new PotatoPlant.Seed()),
    CARDINALGLAIVE      (Glaive.class, ItemSpriteSheet.CARDINALGLAIVE,      1, "Cardinal",      new Rotberry.Seed()),
    BERRYGLAIVE         (Glaive.class, ItemSpriteSheet.BERRYGLAIVE,         1, "Berry",         new Berry()),

    METALGLAIVE         (Glaive.class, ItemSpriteSheet.METALGLAIVE,         2, "Liquid Metal",  new LiquidMetal()),
    RAINBOWGLAIVE       (Glaive.class, ItemSpriteSheet.RAINBOWGLAIVE,       2, "Rainbow",       new UnstableBrew(), "Apply again for even more rainbow."),
    FULLRAINBOWGLAIVE   (Glaive.class, ItemSpriteSheet.FULLRAINBOWGLAIVE,   2, "Extra rainbow", new UnstableBrew()),
    RESINGLAIVE         (Glaive.class, ItemSpriteSheet.RESINGLAIVE,         2, "Resin",         new ArcaneResin()),
    CATALYSTGLAIVE      (Glaive.class, ItemSpriteSheet.CATALYSTGLAIVE,      2, "Catalyst",      new ArcaneCatalyst()),
    EMBERGLAIVE         (Glaive.class, ItemSpriteSheet.EMBERGLAIVE,         2, "Ember",         new Embers()),
    NUTGLAIVE           (Glaive.class, ItemSpriteSheet.NUTGLAIVE,           2, "Peanut",        new Nuts()),
    STYLUSGLAIVE        (Glaive.class, ItemSpriteSheet.STYLUSGLAIVE,        2, "Stylus",        new Stylus()),
    GOOGLAIVE           (Glaive.class, ItemSpriteSheet.GOOGLAIVE,           2, "Goo",           new GooBlob()),
    CURSEDGLAIVE        (Glaive.class, ItemSpriteSheet.CURSEDGLAIVE,        2, "Cursed",        new MetalShard()),

    ICECREAMGLAIVE      (Glaive.class, ItemSpriteSheet.ICECREAMGLAIVE,      3, "Ice cream",     new IceCream()),
    NATUREGLAIVE        (Glaive.class, ItemSpriteSheet.NATUREGLAIVE,        3, "Nature",        new SandalsOfNature()),
    ARROWGLAIVE         (Glaive.class, ItemSpriteSheet.ARROWGLAIVE,         3, "Bolt",          new Crossbow()),
    CHAINGLAIVE         (Glaive.class, ItemSpriteSheet.CHAINGLAIVE,         3, "Chain",         new MailArmor(), "Not very practical."),
    VEGGIEGLAIVE        (Glaive.class, ItemSpriteSheet.VEGGIEGLAIVE,        3, "Veggie",        new VeggieBag()),
    TINYGLAIVE          (Glaive.class, ItemSpriteSheet.TINYGLAIVE,          3, "Tiny",          new SmallGreatsword()),
    FROZENGLAIVE        (Glaive.class, ItemSpriteSheet.FROZENGLAIVE,        3, "Frozen",        new PotionOfFrost()),
    SEALGLAIVE          (Glaive.class, ItemSpriteSheet.SEALGLAIVE,          3, "Seal",          new BrokenSeal()),
    AXEGLAIVE           (Glaive.class, ItemSpriteSheet.AXEGLAIVE,           3, "Axeglaive",     new Greataxe()),
    GREATGLAIVE         (Glaive.class, ItemSpriteSheet.GREATGLAIVE,         3, "Greatglaive",   new Greatsword()),
    GUARDIANGLAIVE      (Glaive.class, ItemSpriteSheet.GUARDIANGLAIVE,      3, "Guardian",      new Greatsword()),
    CLOTHGLAIVE         (Glaive.class, ItemSpriteSheet.CLOTHGLAIVE,         3, "Cloth wrap",    new ClothArmor()),
    GOLDENGLAIVE        (Glaive.class, ItemSpriteSheet.GOLDENGLAIVE,        3, "Golden",        new GoldBar()),
    BOMBGLAIVE          (Glaive.class, ItemSpriteSheet.BOMBGLAIVE,          3, "Bomb",          new Bomb(), "Light up with a torch in a last resort situation."),
    CHARGEGLAIVE        (Glaive.class, ItemSpriteSheet.CHARGEGLAIVE,        3, "CHAAARGE!",     null),
    CDGLAIVE            (Glaive.class, ItemSpriteSheet.CDGLAIVE,            3, "Shattered CD",  new MusicPlayer(), "Warning: Very sharp"),

    TRUEGOLDGLAIVE      (Glaive.class, ItemSpriteSheet.TRUEGOLDGLAIVE,      4, "True golden",   new GoldenMeat()),
    BEEGLAIVE           (Glaive.class, ItemSpriteSheet.BEEGLAIVE,           4, "Honey",         new Honeypot.ShatteredPot()),
    SNAKEGLAIVE 	    (Glaive.class, ItemSpriteSheet.SNAKEGLAIVE,         4, "Snake",         new EtherealChains()),
    SHROUDEDGLAIVE	    (Glaive.class, ItemSpriteSheet.SHROUDEDGLAIVE,      4, "Shrouded",      new PotionOfShroudingFog()),
    BLOWNUPGLAIVE 	    (Glaive.class, ItemSpriteSheet.BLOWNUPGLAIVE,       4, "Blown up",      new Torch()),
    FIERYGLAIVE		    (Glaive.class, ItemSpriteSheet.FIERYGLAIVE,         5, "Fiery",         new Torch()),


    AXE                 (BattleAxe.class, ItemSpriteSheet.BATTLE_AXE,       0, "Default",       new BattleAxe()),
    ORANGEAXE           (BattleAxe.class, ItemSpriteSheet.ORANGEAXE,        1, "Orange",        new Firebloom.Seed()),
    YELLOWAXE           (BattleAxe.class, ItemSpriteSheet.YELLOWAXE,        1, "Yellow",        new Swiftthistle.Seed()),
    GREENAXE            (BattleAxe.class, ItemSpriteSheet.GREENAXE,         1, "Green",         new Sungrass.Seed()),
    BLUEAXE             (BattleAxe.class, ItemSpriteSheet.BLUEAXE,          1, "Blue",          new Icecap.Seed()),
    TURQUOISEAXE        (BattleAxe.class, ItemSpriteSheet.TURQUOISEAXE,     1, "Turquoise",     new Stormvine.Seed()),
    PURPLEAXE           (BattleAxe.class, ItemSpriteSheet.PURPLEAXE,        1, "Purple",        new Sorrowmoss.Seed()),
    PINKAXE             (BattleAxe.class, ItemSpriteSheet.PINKAXE,          1, "Pink",          new Mageroyal.Seed()),
    BROWNAXE            (BattleAxe.class, ItemSpriteSheet.BROWNAXE,         1, "Brown",         new Earthroot.Seed()),
    BLACKAXE            (BattleAxe.class, ItemSpriteSheet.BLACKAXE,         1, "Black",         new Starflower.Seed()),
    GRAYAXE             (BattleAxe.class, ItemSpriteSheet.GRAYAXE,          1, "Grey",          new Fadeleaf.Seed()),
    WHITEAXE            (BattleAxe.class, ItemSpriteSheet.WHITEAXE,         1, "White",         new Blindweed.Seed()),
    RUSSETAXE           (BattleAxe.class, ItemSpriteSheet.RUSSETAXE,        1, "Russet",        new CoffeeBush.Seed()),
    MAROONAXE           (BattleAxe.class, ItemSpriteSheet.MAROONAXE,        1, "Maroon",        new TomatoPlant.Seed()),
    SEPIAAXE            (BattleAxe.class, ItemSpriteSheet.SEPIAAXE,         1, "Sepia",         new PotatoPlant.Seed()),
    CARDINALAXE         (BattleAxe.class, ItemSpriteSheet.CARDINALAXE,      1, "Cardinal",      new Rotberry.Seed()),
    BERRYAXE            (BattleAxe.class, ItemSpriteSheet.BERRYAXE,         1, "Berry",         new Berry()),

    COPPERAXE           (BattleAxe.class, ItemSpriteSheet.COPPERAXE,        2, "Copper",        new Pickaxe()),
    RAINBOWAXE          (BattleAxe.class, ItemSpriteSheet.RAINBOWAXE,       2, "Rainbow",       new UnstableBrew()),
    RESINAXE            (BattleAxe.class, ItemSpriteSheet.RESINAXE,         2, "Resin",         new ArcaneResin()),
    CATALYSTAXE         (BattleAxe.class, ItemSpriteSheet.CATALYSTAXE,      2, "Catalyst",      new ArcaneCatalyst()),
    EMBERAXE            (BattleAxe.class, ItemSpriteSheet.EMBERAXE,         2, "Ember",         new Embers()),
    NUTAXE              (BattleAxe.class, ItemSpriteSheet.NUTAXE,           2, "Nutwood",       new Nuts()),

    GOLDAXE             (BattleAxe.class, ItemSpriteSheet.GOLDAXE,          3, "Golden",        new GoldBar()),
    CHEESEAXE           (BattleAxe.class, ItemSpriteSheet.CHEESEAXE,        3, "Melted Cheese", new CheeseSlice()),
    NATUREAXE           (BattleAxe.class, ItemSpriteSheet.NATUREAXE,        3, "Nature",        new SandalsOfNature()),
    COOKIEAXE           (BattleAxe.class, ItemSpriteSheet.COOKIEAXE,        3, "Cookie cutter", new Cookies()),
    MESSEDAXE           (BattleAxe.class, ItemSpriteSheet.MESSEDAXE,        3, "Messed up",     new NonsenseAlbum()),
    KINGSAXE            (BattleAxe.class, ItemSpriteSheet.KINGSAXE,         3, "King's",        new KingsCrown()),
    SPLITTINGAXE        (BattleAxe.class, ItemSpriteSheet.SPLITTINGAXE,     3, "Splitting Axe",     new Saw()),

    TRUEGOLDAXE         (BattleAxe.class, ItemSpriteSheet.TRUEGOLDAXE,      4, "True Golden",   new GoldenMeat()),
    CHAINAXE            (BattleAxe.class, ItemSpriteSheet.CHAINAXE,         4, "Chainaxe",      new MailArmor()),
    PILEAXE             (BattleAxe.class, ItemSpriteSheet.PILEAXE,          4, "Pileaxe",       new PileOfSais()),


    HAMMER              (WarHammer.class, ItemSpriteSheet.WAR_HAMMER,       0, "Default",       new WarHammer()),
    ORANGEHAMMER        (WarHammer.class, ItemSpriteSheet.ORANGEHAMMER,     1, "Orange",        new Firebloom.Seed()),
    YELLOWHAMMER        (WarHammer.class, ItemSpriteSheet.YELLOWHAMMER,     1, "Yellow",        new Swiftthistle.Seed()),
    GREENHAMMER         (WarHammer.class, ItemSpriteSheet.GREENHAMMER,      1, "Green",         new Sungrass.Seed()),
    BLUEHAMMER          (WarHammer.class, ItemSpriteSheet.BLUEHAMMER,       1, "Blue",          new Icecap.Seed()),
    TURQUOISEHAMMER     (WarHammer.class, ItemSpriteSheet.TURQUOISEHAMMER,  1, "Turquoise",     new Stormvine.Seed()),
    PURPLEHAMMER        (WarHammer.class, ItemSpriteSheet.PURPLEHAMMER,     1, "Purple",        new Sorrowmoss.Seed()),
    PINKHAMMER          (WarHammer.class, ItemSpriteSheet.PINKHAMMER,       1, "Pink",          new Mageroyal.Seed()),
    BROWNHAMMER         (WarHammer.class, ItemSpriteSheet.BROWNHAMMER,      1, "Brown",         new Earthroot.Seed()),
    BLACKHAMMER         (WarHammer.class, ItemSpriteSheet.BLACKHAMMER,      1, "Black",         new Starflower.Seed()),
    GRAYHAMMER          (WarHammer.class, ItemSpriteSheet.GRAYHAMMER,       1, "Grey",          new Fadeleaf.Seed()),
    WHITEHAMMER         (WarHammer.class, ItemSpriteSheet.WHITEHAMMER,      1, "White",         new Blindweed.Seed()),
    RUSSETHAMMER        (WarHammer.class, ItemSpriteSheet.RUSSETHAMMER,     1, "Russet",        new CoffeeBush.Seed()),
    MAROONHAMMER        (WarHammer.class, ItemSpriteSheet.MAROONHAMMER,     1, "Maroon",        new TomatoPlant.Seed()),
    SEPIAHAMMER         (WarHammer.class, ItemSpriteSheet.SEPIAHAMMER,      1, "Sepia",         new PotatoPlant.Seed()),
    CARDINALHAMMER      (WarHammer.class, ItemSpriteSheet.CARDINALHAMMER,   1, "Cardinal",      new Rotberry.Seed()),
    BERRYHAMMER         (WarHammer.class, ItemSpriteSheet.BERRYHAMMER,      1, "Berry",         new Berry()),

    OTSUCHIHAMMER       (WarHammer.class, ItemSpriteSheet.OTSUCHIHAMMER,    2, "Otsuchi",       new Kunai()),
    SHEEPHAMMER         (WarHammer.class, ItemSpriteSheet.SHEEPHAMMER,      2, "Sheep",         new StoneOfFlock(), "Baaa!"),
    BREADHAMMER         (WarHammer.class, ItemSpriteSheet.BREADHAMMER,      2, "Bread",         new Bread(), "Stale bread makes for an excellent blunt weapon."),
    FREEDOMHAMMER       (WarHammer.class, ItemSpriteSheet.FREEDOMHAMMER,    2, "MURICAHAMMER!!",new Oil(), "*gunshots* THEY'VE GOT OIL!!! *eagle scream*"),
    NUTHAMMER           (WarHammer.class, ItemSpriteSheet.NUTHAMMER,        2, "Nut",           new Nuts()),
    BLASTHAMMER         (WarHammer.class, ItemSpriteSheet.BLASTHAMMER,      2, "Blast",         new WandOfBlastWave()),
    ARCANEHAMMER        (WarHammer.class, ItemSpriteSheet.ARCANEHAMMER,     2, "Arcane",        new ArcaneCatalyst()),
    RESINHAMMER         (WarHammer.class, ItemSpriteSheet.RESINHAMMER,      2, "Resin",         new ArcaneResin()),
    EMBERHAMMER         (WarHammer.class, ItemSpriteSheet.EMBERHAMMER,      2, "Ember",         new Embers()),
    INVISIBLEHAMMER     (WarHammer.class, ItemSpriteSheet.INVISIBLEHAMMER,  2, "Invisible",     new PotionOfInvisibility()),
    CAKEBASEHAMMER      (WarHammer.class, ItemSpriteSheet.CAKEBASEHAMMER,   2, "Cake base",     new CakeBase(), "Add a coffee bean to make a chocolate cake."),
    OREHAMMER           (WarHammer.class, ItemSpriteSheet.OREHAMMER,        2, "Gold ore",      new DarkGold()),

    GOLDHAMMER          (WarHammer.class, ItemSpriteSheet.GOLDHAMMER,       3, "Golden",        new GoldBar()),
    ROYALHAMMER         (WarHammer.class, ItemSpriteSheet.ROYALHAMMER,      3, "Royal",         new KingsCrown()),
    NAILHAMMER          (WarHammer.class, ItemSpriteSheet.NAILHAMMER,       3, "Regular",       new Saw()),
    AXEHAMMER           (WarHammer.class, ItemSpriteSheet.AXEHAMMER,        3, "Axehammer",     new BattleAxe()),
    STAMPHAMMER         (WarHammer.class, ItemSpriteSheet.STAMPHAMMER,      3, "Seal stamp",    new BrokenSeal()),
    PAINTHAMMER         (WarHammer.class, ItemSpriteSheet.PAINTHAMMER,      3, "Painting",      new Painting()),
    FROZENHAMMER        (WarHammer.class, ItemSpriteSheet.FROZENHAMMER,     3, "Frozen",        new PotionOfFrost()),
    NATUREHAMMER        (WarHammer.class, ItemSpriteSheet.NATUREHAMMER,     3, "Nature",        new SandalsOfNature()),
    BAGHAMMER           (WarHammer.class, ItemSpriteSheet.BAGHAMMER,        3, "Baghammer",     new LootBag()),
    CHOCOHAMMER         (WarHammer.class, ItemSpriteSheet.CHOCOHAMMER,      3, "Chocolate",     new CoffeeBean(), "Add milk for a layer of cream."),
    BITTENHAMMER        (WarHammer.class, ItemSpriteSheet.BITTENHAMMER,     3, "Bitten",        null, "MMMMMM... Tasty!"), //Player has to eat the hammer
    FISHHAMMER          (WarHammer.class, ItemSpriteSheet.FISHHAMMER,       3, "Fishwhacker",   new Fish()),

    TRUEGOLDHAMMER      (WarHammer.class, ItemSpriteSheet.TRUEGOLDHAMMER,   4, "True gold",     new GoldenMeat()),
    AMULETHAMMER        (WarHammer.class, ItemSpriteSheet.AMULETHAMMER,     4, "Amulet",        new Amulet()),
    CREAMHAMMER         (WarHammer.class, ItemSpriteSheet.CREAMHAMMER,      4, "Cream cake",    new Milk(), "A berry on the top would make this perfect..."),

    GOOLDENHAMMER       (WarHammer.class, ItemSpriteSheet.GOOLDENHAMMER,    5, "Goolden",       new GooBlob()),
    CAKEHAMMER          (WarHammer.class, ItemSpriteSheet.CAKEHAMMER,       5, "Perfect cake",  new Berry(), "It looks so tasty!"),


    SHIELD              (Greatshield.class, ItemSpriteSheet.GREATSHIELD,      0, "Default",         new Greatshield()),
    ORANGESHIELD        (Greatshield.class, ItemSpriteSheet.ORANGESHIELD,     1, "Orange",          new Firebloom.Seed()),
    YELLOWSHIELD        (Greatshield.class, ItemSpriteSheet.YELLOWSHIELD,     1, "Yellow",          new Swiftthistle.Seed()),
    GREENSHIELD         (Greatshield.class, ItemSpriteSheet.GREENSHIELD,      1, "Green",           new Sungrass.Seed()),
    BLUESHIELD          (Greatshield.class, ItemSpriteSheet.BLUESHIELD,       1, "Blue",            new Icecap.Seed()),
    TURQUOISESHIELD     (Greatshield.class, ItemSpriteSheet.TURQUOISESHIELD,  1, "Turquoise",       new Stormvine.Seed()),
    PURPLESHIELD        (Greatshield.class, ItemSpriteSheet.PURPLESHIELD,     1, "Purple",          new Sorrowmoss.Seed()),
    PINKSHIELD          (Greatshield.class, ItemSpriteSheet.PINKSHIELD,       1, "Pink",            new Mageroyal.Seed()),
    BROWNSHIELD         (Greatshield.class, ItemSpriteSheet.BROWNSHIELD,      1, "Brown",           new Earthroot.Seed()),
    BLACKSHIELD         (Greatshield.class, ItemSpriteSheet.BLACKSHIELD,      1, "Black",           new Starflower.Seed()),
    GRAYSHIELD          (Greatshield.class, ItemSpriteSheet.GRAYSHIELD,       1, "Grey",            new Fadeleaf.Seed()),
    WHITESHIELD         (Greatshield.class, ItemSpriteSheet.WHITESHIELD,      1, "White",           new Blindweed.Seed()),
    RUSSETSHIELD        (Greatshield.class, ItemSpriteSheet.RUSSETSHIELD,     1, "Russet",          new CoffeeBush.Seed()),
    MAROONSHIELD        (Greatshield.class, ItemSpriteSheet.MAROONSHIELD,     1, "Maroon",          new TomatoPlant.Seed()),
    SEPIASHIELD         (Greatshield.class, ItemSpriteSheet.SEPIASHIELD,      1, "Sepia",           new PotatoPlant.Seed()),
    CARDINALSHIELD      (Greatshield.class, ItemSpriteSheet.CARDINALSHIELD,   1, "Cardinal",        new Rotberry.Seed()),
    BERRYSHIELD         (Greatshield.class, ItemSpriteSheet.BERRYSHIELD,      1, "Berry",           new Berry()),

    ANKHSHIELD          (Greatshield.class, ItemSpriteSheet.ANKHSHIELD,       2, "Ankh",            new Ankh()),
    SWORDSHIELD         (Greatshield.class, ItemSpriteSheet.SWORDSHIELD,      2, "Sword",           new Sword()),
    SEALSHIELD          (Greatshield.class, ItemSpriteSheet.SEALSHIELD,       2, "Seal",            new BrokenSeal()),
    MEATSHIELD          (Greatshield.class, ItemSpriteSheet.MEATSHIELD,       2, "Meaty",           new MysteryMeat()),
    HOLESHIELD          (Greatshield.class, ItemSpriteSheet.HOLESHIELD,       2, "Peephole",        new Shuriken()),
    GOOSHIELD           (Greatshield.class, ItemSpriteSheet.GOOSHIELD,        2, "Goo",             new GooBlob()),
    METALSHIELD         (Greatshield.class, ItemSpriteSheet.METALSHIELD,      2, "Cursed metal",    new MetalShard()),
    CHEESESHIELD        (Greatshield.class, ItemSpriteSheet.CHEESESHIELD,     2, "Cheeshield",      new CheeseSlice(), "Very cheesy..."),
    AMULETSHIELD        (Greatshield.class, ItemSpriteSheet.AMULETSHIELD,     2, "Amulet",          new Amulet()),
    MISSILESHIELD       (Greatshield.class, ItemSpriteSheet.MISSILESHIELD,    2, "Missile",         new WandOfMagicMissile()),
    FIRESHIELD          (Greatshield.class, ItemSpriteSheet.FIRESHIELD,       2, "Fire pattern",    new WandOfFireblast()),
    ICESHIELD           (Greatshield.class, ItemSpriteSheet.ICESHIELD,        2, "Ice",             new WandOfFrost(), "Has a translucent surface."),
    LIGHTNINGSHIELD     (Greatshield.class, ItemSpriteSheet.LIGHTNINGSHIELD,  2, "Lightning",       new WandOfLightning()),
    EARTHSHIELD         (Greatshield.class, ItemSpriteSheet.EARTHSHIELD,      2, "Earth",           new WandOfLivingEarth()),
    SHATTEREDSHIELD     (Greatshield.class, ItemSpriteSheet.SHATTEREDSHIELD,  2, "Shattered",       new Greataxe(), "Even the greatest shields have limits."),
    TRIDENTSHIELD       (Greatshield.class, ItemSpriteSheet.TRIDENTSHIELD,    2, "Tridented",       new Trident()),
    LIQUIDSHIELD        (Greatshield.class, ItemSpriteSheet.LIQUIDSHIELD,     2, "Liquidated",      new LiquidMetal()),
    CAMOSHIELD          (Greatshield.class, ItemSpriteSheet.CAMOSHIELD,       2, "Multicam",        new PlateCarrier()),
    
    GOLDSHIELD          (Greatshield.class, ItemSpriteSheet.GOLDSHIELD,       3, "Golden",          new GoldBar()),
    CANDLESHIELD        (Greatshield.class, ItemSpriteSheet.CANDLESHIELD,     3, "Candle",          new CeremonialCandle()),
    EGGSHIELD           (Greatshield.class, ItemSpriteSheet.EGGSHIELD,        3, "Egged",           new Egg()),
    LIGHTSHIELD         (Greatshield.class, ItemSpriteSheet.LIGHTSHIELD,      3, "Shield of Light", new WandOfPrismaticLight()),
    NATURESHIELD        (Greatshield.class, ItemSpriteSheet.NATURESHIELD,     3, "Nature",          new SandalsOfNature()),
    GRASSSHIELD         (Greatshield.class, ItemSpriteSheet.GRASSSHIELD,      3, "Shield of Growth",new WandOfRegrowth()),
    FUSIONSHIELD        (Greatshield.class, ItemSpriteSheet.FUSIONSHIELD,     3, "Shield of Transfusion",   new WandOfTransfusion()),
    SHIELDSHIELD        (Greatshield.class, ItemSpriteSheet.SHIELDSHIELD,     3, "Shield of Warding",       new WandOfWarding()),

    TRUEGOLDSHIELD      (Greatshield.class, ItemSpriteSheet.TRUEGOLDSHIELD,   4, "True Golden Shield",      new GoldenMeat()),


    SCIMITAR            (Scimitar.class, ItemSpriteSheet.SCIMITAR,          0, "Default",       new Greatshield()),
    ORANGESCIMITAR      (Scimitar.class, ItemSpriteSheet.ORANGESCIMITAR,    1, "Orange",        new Firebloom.Seed()),
    YELLOWSCIMITAR      (Scimitar.class, ItemSpriteSheet.YELLOWSCIMITAR,    1, "Yellow",        new Swiftthistle.Seed()),
    GREENSCIMITAR       (Scimitar.class, ItemSpriteSheet.GREENSCIMITAR,     1, "Green",         new Sungrass.Seed()),
    BLUESCIMITAR        (Scimitar.class, ItemSpriteSheet.BLUESCIMITAR,      1, "Blue",          new Icecap.Seed()),
    TURQUOISESCIMITAR   (Scimitar.class, ItemSpriteSheet.TURQUOISESCIMITAR, 1, "Turquoise",     new Stormvine.Seed()),
    PURPLESCIMITAR      (Scimitar.class, ItemSpriteSheet.PURPLESCIMITAR,    1, "Purple",        new Sorrowmoss.Seed()),
    PINKSCIMITAR        (Scimitar.class, ItemSpriteSheet.PINKSCIMITAR,      1, "Pink",          new Mageroyal.Seed()),
    BROWNSCIMITAR       (Scimitar.class, ItemSpriteSheet.BROWNSCIMITAR,     1, "Brown",         new Earthroot.Seed()),
    BLACKSCIMITAR       (Scimitar.class, ItemSpriteSheet.BLACKSCIMITAR,     1, "Black",         new Starflower.Seed()),
    GRAYSCIMITAR        (Scimitar.class, ItemSpriteSheet.GRAYSCIMITAR,      1, "Grey",          new Fadeleaf.Seed()),
    WHITESCIMITAR       (Scimitar.class, ItemSpriteSheet.WHITESCIMITAR,     1, "White",         new Blindweed.Seed()),
    RUSSETSCIMITAR      (Scimitar.class, ItemSpriteSheet.RUSSETSCIMITAR,    1, "Russet",        new CoffeeBush.Seed()),
    MAROONSCIMITAR      (Scimitar.class, ItemSpriteSheet.MAROONSCIMITAR,    1, "Maroon",        new TomatoPlant.Seed()),
    SEPIASCIMITAR       (Scimitar.class, ItemSpriteSheet.SEPIASCIMITAR,     1, "Sepia",         new PotatoPlant.Seed()),
    CARDINALSCIMITAR    (Scimitar.class, ItemSpriteSheet.CARDINALSCIMITAR,  1, "Cardinal",      new Rotberry.Seed()),
    BERRYSCIMITAR       (Scimitar.class, ItemSpriteSheet.BERRYSCIMITAR,     1, "Berry",         new Berry()),

    BIGSCIMITAR         (Scimitar.class, ItemSpriteSheet.BIGSCIMITAR,       2, "Bigitar",       new PotionOfStrength(), "Damn boi it thicc."),
    CUTSCIMITAR         (Scimitar.class, ItemSpriteSheet.CUTSCIMITAR,       2, "Cut",           new Saw()),
    MEATSCIMITAR        (Scimitar.class, ItemSpriteSheet.MEATSCIMITAR,      2, "Meatimitar",    new MysteryMeat()),
    GOOSCIMITAR         (Scimitar.class, ItemSpriteSheet.GOOSCIMITAR,       2, "Gooitar",       new GooBlob()),
    ICESCIMITAR         (Scimitar.class, ItemSpriteSheet.ICESCIMITAR,       2, "Icemitar",      new PotionOfFrost()),

    GOLDSCIMITAR        (Scimitar.class, ItemSpriteSheet.GOLDSCIMITAR,      3, "Gold",          new GoldBar()),
    BENTSCIMITAR        (Scimitar.class, ItemSpriteSheet.BENTSCIMITAR,      3, "Curved",        null),
    RINGSCIMITAR        (Scimitar.class, ItemSpriteSheet.RINGSCIMITAR,      3, "Ringitar",      new Ring()),
    DUELISTSCIMITAR     (Scimitar.class, ItemSpriteSheet.DUELISTSCIMITAR,   3, "Duelist",       new DuelistArmor(), "Looks like a miniature version of you."),
    WARRIORSCIMITAR     (Scimitar.class, ItemSpriteSheet.WARRIORSCIMITAR,   3, "Warrior",       new WarriorArmor(), "As heroic as you."),
    MAGESCIMITAR        (Scimitar.class, ItemSpriteSheet.MAGESCIMITAR,      3, "Mage",          new MageArmor(), "It even knows how to cast firebolt!"),
    RIPOSTESCIMITAR     (Scimitar.class, ItemSpriteSheet.RIPOSTESCIMITAR,   3, "Riposte",       new DriedRose()),

    TRUEGOLDSCIMITAR    (Scimitar.class, ItemSpriteSheet.TRUEGOLDSCIMITAR,  4, "True Gold",     new GoldenMeat()),
    FEATHERSCIMITAR     (Scimitar.class, ItemSpriteSheet.FEATHERSCIMITAR,   4, "Feather",       new Pillow()),
    ;

    public static final String DEFAULT = "Default";
    public static final String COMMON = "åCommonå";
    public static final String RARE = "ÅRareÅ";
    public static final String EPIC = "öEpicö";
    public static final String LEGENDARY = "ÖLegendaryÖ";
    public static final String MYTHIC = "äMythicä";


    private Class<? extends Item> skinFor;
    private int sprite;
    private int rarity;
    private String name;
    private Item ingridient;
    private String desc;
    private int ID;

    Skin(Class<? extends Item> skinFor, int sprite, int rarity, String name, Item ingridient) {
        this.skinFor = skinFor;
        this.sprite = sprite;
        this.rarity = rarity;
        this.name = name;
        this.ingridient = ingridient;
        this.desc = "";
        this.ID = 0;
    }

    Skin(Class<? extends Item> skinFor, int sprite, int rarity, String name, Item ingridient, String desc) {
        this.skinFor = skinFor;
        this.sprite = sprite;
        this.rarity = rarity;
        this.name = name;
        this.ingridient = ingridient;
        this.desc = desc;
        this.ID = 0;
    }

    Skin(Class<? extends Item> skinFor, int sprite, int rarity, String name, Item ingridient, int ID) {
        this.skinFor = skinFor;
        this.sprite = sprite;
        this.rarity = rarity;
        this.name = name;
        this.ingridient = ingridient;
        this.desc = "";
        this.ID = ID;
    }
    Skin(Class<? extends Item> skinFor, int sprite, int rarity, String name, Item ingridient, String desc, int ID) {
        this.skinFor = skinFor;
        this.sprite = sprite;
        this.rarity = rarity;
        this.name = name;
        this.ingridient = ingridient;
        this.desc = desc;
        this.ID = ID;
    }

    public Class<? extends Item> skinFor() {
        return skinFor;
    }

    public int sprite() {
        return sprite;
    }

    public String skinName() {
        return name;
    }

    public String desc() {
        return desc;
    }

    public int ID() {
        return ID;
    }

    public String rarity() {
        switch (this.rarity) {
            case 1:
                return COMMON;
            case 2:
                return RARE;
            case 3:
                return EPIC;
            case 4:
                return LEGENDARY;
            case 5:
                return MYTHIC;
            default:
                return DEFAULT;
        }
    }

    public String fullRarity() {
        switch (this.rarity) {
            case 1:
                return "a " + COMMON;
            case 2:
                return "a " + RARE;
            case 3:
                return "an " + EPIC;
            case 4:
                return "a " + LEGENDARY;
            case 5:
                return "a " + MYTHIC;
            default:
                return "the " + DEFAULT;
        }
    }

    public String rarityChar() {
        switch (this.rarity) {
            case 1:
                return "å";
            case 2:
                return "Å";
            case 3:
                return "ö";
            case 4:
                return "Ö";
            case 5:
                return "ä";
            default:
                return "";
        }
    }

    public int rarityTier() {
        return rarity;
    }

    public static List<Skin> all() {
        return new ArrayList<>(Arrays.asList(
                SEAL,
                YELLOWSEAL,
                GREENSEAL,
                BLUESEAL,
                PURPLESEAL,
                BLACKSEAL,
                WHITESEAL,
                GRAYSEAL,
                TURQUOISESEAL,
                BROWNSEAL,
                PINKSEAL,
                ORANGESEAL,
                WOODSEAL,
                MEATSEAL,
                TRANSPARENTSEAL,
                HEALINGSEAL,
                CUTSEAL,
                THIEFSEAL,
                COPPERSEAL,
                CUBESEAL,
                RINGSEAL,
                RAINBOWSEAL,
                GOLDSEAL,
                CORPSESEAL,
                HEARTSEAL,
                BURNTSEAL,
                GOOSEAL,
                WATERSEAL,
                WARRIORSEAL,
                COWBOYSEAL,
                HONEYSEAL,
                ICESEAL,
                EYESEAL,
                SNAKESEAL,
                CANDLESEAL,
                BOMBSEAL,
                SHEEPSEAL,
                DMSEAL,
                KINGSEAL,
                FIERYSEAL,
                PUREGOLDSEAL,
                AMULETSEAL,
                BLOWNUPSEAL,

                CLOAK,
                ORANGECLOAK,
                YELLOWCLOAK,
                GREENCLOAK,
                BLUECLOAK,
                TURQUOISECLOAK,
                PURPLECLOAK,
                PINKCLOAK,
                BROWNCLOAK,
                BLACKCLOAK,
                GRAYCLOAK,
                WHITECLOAK,
                WOODENCLOAK,
                LEATHERCLOAK,
                RATIONCLOAK,
                PINKAMULETCLOAK,
                RAINBOWCLOAK,
                TINYCLOAK,
                WAXCLOAK,
                CANDYCLOAK,
                COOKEDCLOAK,
                CHAINMAILCLOAK,
                TACTICALCLOAK,
                GOLDENCLOAK,
                WARRIORCLOAK,
                METALCLOAK,
                BOTTLECLOAK,
                CHEESECLOAK,
                PAINTCLOAK,
                FIERYCLOAK,
                TRUEGOLDENCLOAK,
                DARKNESSCLOAK,

                BOW,
                ORANGEBOW,
                YELLOWBOW,
                GREENBOW,
                BLUEBOW,
                TURQUOISEBOW,
                PURPLEBOW,
                BROWNBOW,
                BLACKBOW,
                GRAYBOW,
                WHITEBOW,
                WOODENBOW,
                WALNUTBOW,
                GOOBOW,
                CATALYSTBOW,
                TAXEDBOW,
                MEATBOW,
                RAINBOWBOW,
                PINKBOW,
                LOVEBOW,
                EGGBOW,
                GOLDENBOW,
                NATUREBOW,
                METALBOW,
                ROYALBOW,
                CROSSBOWBOW,
                EARTHBOW,
                TENGUBOW,
                WILLOWBOW,
                RINGBOW,
                FLAMINGBOW,

                WAND,
                ORANGEWAND,
                YELLOWWAND,
                GREENWAND,
                BLUEWAND,
                TURQUOISEWAND,
                PURPLEWAND,
                PINKWAND,
                BROWNWAND,
                BLACKWAND,
                GRAYWAND,
                WHITEWAND,
                AMULETWAND,
                BENTWAND,
                LOVEWAND,
                GOOWAND,
                MISTWAND,
                MEATWAND,
                GOLDENWAND,
                BAGWAND,
                PICKAXEWAND,
                ROYALWAND,
                WALKINGWAND,
                GUNWAND,
                SPLITWAND,
                WARRIORWAND,
                SNAKEWAND,
                METALWAND,
                TRUEGOLDENWAND,
                FIERYWAND,
                MADNESSWAND,
                GANDALFWAND,
                CLOUDWAND,

                LEATHER,
                ORANGELEATHER,
                YELLOWLEATHER,
                GREENLEATHER,
                BLUELEATHER,
                TURQUOISELEATHER,
                PURPLELEATHER,
                PINKLEATHER,
                BROWNLEATHER,
                BLACKLEATHER,
                GRAYLEATHER,
                WHITELEATHER,

                PLATE,
                METALPLATE,
                COPPERPLATE,
                CURSEDPLATE,
                GOLDPLATE,
                ROYALPLATE,

                BOOK,
                ORANGEBOOK,
                YELLOWBOOK,
                GREENBOOK,
                BLUEBOOK,
                TURQUOISEBOOK,
                PURPLEBOOK,
                PINKBOOK,
                BROWNBOOK,
                BLACKBOOK,
                GRAYBOOK,
                WHITEBOOK,
                MASTERYBOOK,
                LEATHERBOOK,
                POCKETBOOK,
                BEEBOOK,
                EGGBOOK,
                BAKINGBOOK,
                LONGBOOK,
                TALLBOOK,
                WETBOOK,
                WARRIORBOOK,
                PISSBOOK,
                TREEBOOK,
                RAINBOWBOOK,
                CARBOOK,
                WESTERNBOOK,
                FISHBOOK,
                BOWBOOK,
                TOOLBOOK,
                DVDBOOK,
                RINGBOOK,
                MANIACBOOK,
                INSTRUCTIONBOOK,
                GOOBOOK,
                GRILLBOOK,
                GOLDBOOK,

                CLOTH,
                ORANGECLOTH,
                YELLOWCLOTH,
                GREENCLOTH,
                BLUECLOTH,
                TURQUOISECLOTH,
                PURPLECLOTH,
                PINKCLOTH,
                BROWNCLOTH,
                BLACKCLOTH,
                GRAYCLOTH,
                WHITECLOTH,
                LIGHTBROWNCLOTH,
                REDCLOTH,
                COFFEECLOTH,
                CARDINALCLOTH,
                GOLDENCLOTH,

                RUNIC,
                ORANGERUNIC,
                YELLOWRUNIC,
                GREENRUNIC,
                BLUERUNIC,
                TURQUOISERUNIC,
                PURPLERUNIC,
                PINKRUNIC,
                BROWNRUNIC,
                BLACKRUNIC,
                GRAYRUNIC,
                WHITERUNIC,
                REDRUNIC,
                BROKENRUNIC,
                TIDEPODRUNIC,
                RAINBOWRUNIC,
                OBSIDIANRUNIC,
                CANDLERUNIC,
                MEATRUNIC,
                GOORUNIC,
                METALRUNIC,
                CHEESERUNIC,
                RESINRUNIC,
                CATALYSTRUNIC,
                EMBERRUNIC,
                RUSTEDRUNIC,
                SEALRUNIC,
                LEATHERRUNIC,
                GOLDENRUNIC,
                INSULINRUNIC,
                ICERUNIC,
                SNAKERUNIC,
                RINGRUNIC,
                WHEATRUNIC,
                ICECREAMRUNIC,
                RATRUNIC,
                TRUEGOLDRUNIC,
                AMULETRUNIC,
                NATURERUNIC,
                WATERRUNIC,
                EARTHRUNIC,
                FIRERUNIC,
                WINDRUNIC,

                LSWORD,
                ORANGELSWORD,
                YELLOWLSWORD,
                GREENLSWORD,
                BLUELSWORD,
                TURQUOISELSWORD,
                PURPLELSWORD,
                PINKLSWORD,
                BROWNLSWORD,
                BLACKLSWORD,
                GRAYLSWORD,
                WHITELSWORD,
                RUSSETLSWORD,
                MAROONLSWORD,
                SEPIALSWORD,
                CARDINALLSWORD,
                CURSEDLSWORD,
                RUSTYLSWORD,
                COPPERLSWORD,
                RAINBOWLSWORD,
                BENTLSWORD,
                RESINLSWORD,
                CATALYSTLSWORD,
                EMBERLSWORD,
                WOODENLSWORD,
                SEALLSWORD,
                GOLDLSWORD,
                RINGLSWORD,
                TINYLSWORD,
                TRUEGOLDLSWORD,

                GLAIVE,
                ORANGEGLAIVE,
                YELLOWGLAIVE,
                GREENGLAIVE,
                BLUEGLAIVE,
                TURQUOISEGLAIVE,
                PURPLEGLAIVE,
                PINKGLAIVE,
                BROWNGLAIVE,
                BLACKGLAIVE,
                GRAYGLAIVE,
                WHITEGLAIVE,
                RUSSETGLAIVE,
                MAROONGLAIVE,
                SEPIAGLAIVE,
                CARDINALGLAIVE,
                BERRYGLAIVE,
                METALGLAIVE,
                RAINBOWGLAIVE,
                FULLRAINBOWGLAIVE,
                RESINGLAIVE,
                CATALYSTGLAIVE,
                EMBERGLAIVE,
                NUTGLAIVE,
                STYLUSGLAIVE,
                GOOGLAIVE,
                CURSEDGLAIVE,
                ICECREAMGLAIVE,
                NATUREGLAIVE,
                ARROWGLAIVE,
                CHAINGLAIVE,
                VEGGIEGLAIVE,
                TINYGLAIVE,
                FROZENGLAIVE,
                SEALGLAIVE,
                AXEGLAIVE,
                GREATGLAIVE,
                GUARDIANGLAIVE,
                CLOTHGLAIVE,
                GOLDENGLAIVE,
                BOMBGLAIVE,
                CHARGEGLAIVE,
                CDGLAIVE,
                TRUEGOLDGLAIVE,
                BEEGLAIVE,
                SNAKEGLAIVE,
                SHROUDEDGLAIVE,
                BLOWNUPGLAIVE,
                FIERYGLAIVE,

                AXE,
                ORANGEAXE,
                YELLOWAXE,
                GREENAXE,
                BLUEAXE,
                TURQUOISEAXE,
                PURPLEAXE,
                PINKAXE,
                BROWNAXE,
                BLACKAXE,
                GRAYAXE,
                WHITEAXE,
                RUSSETAXE,
                MAROONAXE,
                SEPIAAXE,
                CARDINALAXE,
                BERRYAXE,
                COPPERAXE,
                RAINBOWAXE,
                RESINAXE,
                CATALYSTAXE,
                EMBERAXE,
                NUTAXE,
                GOLDAXE,
                CHEESEAXE,
                NATUREAXE,
                COOKIEAXE,
                MESSEDAXE,
                KINGSAXE,
                SPLITTINGAXE,
                TRUEGOLDAXE,
                CHAINAXE,
                PILEAXE,

                HAMMER,
                ORANGEHAMMER,
                YELLOWHAMMER,
                GREENHAMMER,
                BLUEHAMMER,
                TURQUOISEHAMMER,
                PURPLEHAMMER,
                PINKHAMMER,
                BROWNHAMMER,
                BLACKHAMMER,
                GRAYHAMMER,
                WHITEHAMMER,
                RUSSETHAMMER,
                MAROONHAMMER,
                SEPIAHAMMER,
                CARDINALHAMMER,
                BERRYHAMMER,
                OTSUCHIHAMMER,
                SHEEPHAMMER,
                BREADHAMMER,
                FREEDOMHAMMER,
                NUTHAMMER,
                BLASTHAMMER,
                ARCANEHAMMER,
                RESINHAMMER,
                EMBERHAMMER,
                INVISIBLEHAMMER,
                CAKEBASEHAMMER,
                OREHAMMER,
                GOLDHAMMER,
                ROYALHAMMER,
                NAILHAMMER,
                AXEHAMMER,
                STAMPHAMMER,
                PAINTHAMMER,
                FROZENHAMMER,
                NATUREHAMMER,
                BAGHAMMER,
                CHOCOHAMMER,
                BITTENHAMMER,
                FISHHAMMER,
                TRUEGOLDHAMMER,
                AMULETHAMMER,
                CREAMHAMMER,
                GOOLDENHAMMER,
                CAKEHAMMER,

                SHIELD,
                ORANGESHIELD,
                YELLOWSHIELD,
                GREENSHIELD,
                BLUESHIELD,
                TURQUOISESHIELD,
                PURPLESHIELD,
                PINKSHIELD,
                BROWNSHIELD,
                BLACKSHIELD,
                GRAYSHIELD,
                WHITESHIELD,
                RUSSETSHIELD,
                MAROONSHIELD,
                SEPIASHIELD,
                CARDINALSHIELD,
                BERRYSHIELD,
                ANKHSHIELD,
                SWORDSHIELD,
                SEALSHIELD,
                MEATSHIELD,
                HOLESHIELD,
                GOOSHIELD,
                METALSHIELD,
                CHEESESHIELD,
                AMULETSHIELD,
                MISSILESHIELD,
                FIRESHIELD,
                ICESHIELD,
                LIGHTNINGSHIELD,
                EARTHSHIELD,
                SHATTEREDSHIELD,
                TRIDENTSHIELD,
                LIQUIDSHIELD,
                CAMOSHIELD,
                GOLDSHIELD,
                CANDLESHIELD,
                EGGSHIELD,
                LIGHTSHIELD,
                NATURESHIELD,
                GRASSSHIELD,
                FUSIONSHIELD,
                SHIELDSHIELD,
                TRUEGOLDSHIELD,

                SCIMITAR,
                ORANGESCIMITAR,
                YELLOWSCIMITAR,
                GREENSCIMITAR,
                BLUESCIMITAR,
                TURQUOISESCIMITAR,
                PURPLESCIMITAR,
                PINKSCIMITAR,
                BROWNSCIMITAR,
                BLACKSCIMITAR,
                GRAYSCIMITAR,
                WHITESCIMITAR,
                RUSSETSCIMITAR,
                MAROONSCIMITAR,
                SEPIASCIMITAR,
                CARDINALSCIMITAR,
                BERRYSCIMITAR,
                BIGSCIMITAR,
                CUTSCIMITAR,
                MEATSCIMITAR,
                GOOSCIMITAR,
                ICESCIMITAR,
                GOLDSCIMITAR,
                BENTSCIMITAR,
                RINGSCIMITAR,
                DUELISTSCIMITAR,
                WARRIORSCIMITAR,
                MAGESCIMITAR,
                RIPOSTESCIMITAR,
                TRUEGOLDSCIMITAR,
                FEATHERSCIMITAR
        ));
    }


    public static List<Item> ingredients(Class<? extends Item> skinFor) {
        List<Item> ingridientList = new ArrayList<>();
        for (Skin skin : Skin.all()) {
            if (skin.skinFor == skinFor) {
                ingridientList.add(skin.ingridient);
            }
        }
        return ingridientList;
    }

    //getclassgetclassgetclassgetclassgetclassgetclassgetclassgetclassgetclassgetclassgetclass
    public static boolean containsIngredient(Item item, Class<? extends Item> skinFor) {
        for (Item ingredient : Skin.ingredients(skinFor)) {
            if (ingredient != null && ingredient.getClass() == item.getClass()) {
                return true;
            }
        }
        return false;
    }

    public static Skin fromIngredient(Item ingredient, Class<? extends Item> skinFor) {
        for (Skin skin : Skin.all()) {
            if (skin.ingridient != null && skin.ingridient.getClass() == ingredient.getClass() && skin.skinFor == skinFor) {
                return skin;
            }
        }
        return null;
    }

    public static Skin random(Class<? extends Item> itemClass) {
        Skin skin;
        do {
            skin = Skin.all().get(Random.Int(Skin.all().size()));
        } while (skin.skinFor() != itemClass);
        return skin;
    }

    public static Skin random(Class<? extends Item> itemClass, int rarity) {
        Skin skin;
        do {
            skin = Skin.all().get(Random.Int(Skin.all().size()));
        } while (skin.skinFor() != itemClass || skin.rarityTier() != rarity);
        return skin;
    }

    public static List<Skin> allFor(Class<? extends Item> itemClass) {
        List<Skin> skins = new ArrayList<>();
        for (Skin skin : all()) {
            if (skin.skinFor == itemClass) {
                skins.add(skin);
            }
        }
        return skins;
    }

    public String fullSkinName() {
        //Only if there was a way to avoid using 50 if statements...
        String skinName = Messages.titleCase(skinName().toLowerCase());

        if (skinFor() == BrokenSeal.class) {
            if (skinName().toLowerCase().contains("seal"))
                return skinName;
            skinName += " Seal";
        } else if (skinFor() == CloakOfShadows.class) {
            if (skinName().toLowerCase().contains("cloak"))
                return skinName;
            skinName += " Cloak";
        } else if (skinFor() == SpiritBow.class) {
            if (skinName().toLowerCase().contains("bow"))
                return skinName;
            skinName += " Bow";
        } else if (skinFor() == MagesStaff.class) {
            if (skinName().toLowerCase().contains("staff") || skinName().toLowerCase().contains("wand"))
                return skinName;
            skinName += " Wand";
        } else if (skinFor() == LeatherArmor.class) {
            skinName += " Leather Armor";
        } else if (skinFor() == PlateArmor.class) {
            skinName += " Plate Armor";
        } else if (skinFor() == UnstableSpellbook.class) {
            if (skinName().toLowerCase().contains("book"))
                return skinName;
            skinName += " Spellbook";
        } else if (skinFor() == ClothArmor.class) {
            skinName += " Cloth Armor";
        } else if (skinFor() == RunicBlade.class) {
            if (skinName().toLowerCase().contains("blade") || skinName().toLowerCase().contains("runic"))
                return skinName;
            skinName += " Runic Blade";
        } else if (skinFor() == Longsword.class) {
            if (skinName().toLowerCase().contains("sword"))
                return skinName;
            skinName += " Longsword";
        } else if (skinFor() == Glaive.class) {
            if (skinName().toLowerCase().contains("glaive"))
                return skinName;
            skinName += " Glaive";
        } else if (skinFor() == BattleAxe.class) {
            if (skinName().toLowerCase().contains("axe"))
                return skinName;
            skinName += " Battleaxe";
        } else if (skinFor() == WarHammer.class) {
            if (skinName().toLowerCase().contains("war") || skinName().toLowerCase().contains("hammer"))
                return skinName;
            skinName += " Warhammer";
        } else if (skinFor() == Greatshield.class) {
            if (skinName().toLowerCase().contains("shield"))
                return skinName;
            skinName += " Shield";
        } else if (skinFor() == Scimitar.class) {
            if (skinName().toLowerCase().contains("itar"))
                return skinName;
            skinName += " Scimitar";
        }
        return skinName;
    }

    public int spriteOutline() {
        if (skinFor() == BrokenSeal.class) {
            return ItemSpriteSheet.EMPTY_SEAL;
        } else if (skinFor() == CloakOfShadows.class) {
            return ItemSpriteSheet.EMPTY_CLOAK;
        } else if (skinFor() == SpiritBow.class) {
            return ItemSpriteSheet.EMPTY_BOW;
        } else if (skinFor() == MagesStaff.class) {
            return ItemSpriteSheet.EMPTY_WAND;
        } else if (skinFor() == LeatherArmor.class) {
            return ItemSpriteSheet.EMPTY_LEATHER;
        } else if (skinFor() == PlateArmor.class) {
            return ItemSpriteSheet.EMPTY_PLATE;
        } else if (skinFor() == UnstableSpellbook.class) {
            return ItemSpriteSheet.EMPTY_BOOK;
        } else if (skinFor() == ClothArmor.class) {
            return ItemSpriteSheet.EMPTY_CLOTH;
        } else if (skinFor() == RunicBlade.class) {
            return ItemSpriteSheet.EMPTY_RUNIC;
        } else if (skinFor() == Longsword.class) {
            return ItemSpriteSheet.EMPTY_LSWORD;
        } else if (skinFor() == Glaive.class) {
            return ItemSpriteSheet.EMPTY_GLAIVE;
        } else if (skinFor() == BattleAxe.class) {
            return ItemSpriteSheet.EMPTY_AXE;
        } else if (skinFor() == WarHammer.class) {
            return ItemSpriteSheet.EMPTY_HAMMER;
        } else if (skinFor() == Greatshield.class) {
            return ItemSpriteSheet.EMPTY_SHIELD;
        } else if (skinFor() == Scimitar.class) {
            return ItemSpriteSheet.EMPTY_SCIMITAR;
        }
        return ItemSpriteSheet.SOMETHING;
    }


    //TODO these might be useless

    private static final String SKINFOR     = "FOR";
    private static final String SPRITE      = "SPRITE";
    private static final String RARITY      = "RARITY";
    private static final String NAME        = "NAME";
    private static final String INGRIDIENT  = "INGRIDIENT";
    private static final String DESC        = "DESC";
    private static final String IDENTIFIER  = "ID";

    @Override
    public void storeInBundle(Bundle bundle) {
        if (skinName() != null) {
            bundle.put(SKINFOR, skinFor);
            bundle.put(SPRITE, sprite);
            bundle.put(RARITY, rarity);
            bundle.put(NAME, name);
            bundle.put(INGRIDIENT, ingridient.getClass());
            bundle.put(DESC, desc);
            bundle.put(IDENTIFIER, ID);
        }
    }

    @Override
    public void restoreFromBundle(Bundle bundle) {
        if (bundle.getString(NAME) != null) {
            skinFor = (Class<? extends Item>) bundle.getClass(SKINFOR);
            sprite = bundle.getInt(SPRITE);
            rarity = bundle.getInt(RARITY);
            name = bundle.getString(NAME);
            ingridient = (Item) Reflection.newInstance(bundle.getClass(INGRIDIENT));
            desc = bundle.getString(DESC);
            ID = bundle.getInt(IDENTIFIER);
        }
    }
}
