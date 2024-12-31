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

package com.shatteredpixel.shatteredpixeldungeon.journal;

import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.Skin;
import com.shatteredpixel.shatteredpixeldungeon.items.BrokenSeal;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.ClothArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.LeatherArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.PlateArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.CloakOfShadows;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.UnstableSpellbook;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.SpiritBow;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.BattleAxe;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Glaive;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Greatshield;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Longsword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.MagesStaff;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.RunicBlade;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Scimitar;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.WarHammer;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

public enum SkinCatalog {
	//SKINS
	SEALS,
	CLOAKS,
	BOWS,
	WANDS,
	ARMORS,
	BOOKS,
	RUNICS,
	LSWORDS,
	GLAIVES,
	AXES,
	HAMMERS,
	SHIELDS,
	SCIMITARS
	;

	//tracks whether an skin has been applied
	private final LinkedHashMap<Skin, Boolean> seen = new LinkedHashMap<>();
	//tracks times skin has been applied
	private final LinkedHashMap<Skin, Integer> applyCount = new LinkedHashMap<>();

	public Collection<Skin> skins(){
		return seen.keySet();
	}

	private void addSkins(List<Skin> skins){
		for (Skin skin : skins){
			seen.put(skin, false);
			applyCount.put(skin, 0);
		}
	}

	public String title(){
		return Messages.get(this, name() + ".title");
	}

	public int totalSkins(){
		int total = seen.size();
		for (Skin skin : seen.keySet()) {
			if (skin.rarityTier() == 0)
				total--;
		}
		return total;
	}

	public int totalSeen(){
		int seenTotal = 0;
		for (boolean skinSeen : seen.values()){
			if (skinSeen) seenTotal++;
		}
		return seenTotal;
	}

	static {

		SEALS.addSkins(Skin.allFor(BrokenSeal.class));

		CLOAKS.addSkins(Skin.allFor(CloakOfShadows.class));

		BOWS.addSkins(Skin.allFor(SpiritBow.class));

		WANDS.addSkins(Skin.allFor(MagesStaff.class));

		ARMORS.addSkins(Skin.allFor(ClothArmor.class));
		ARMORS.addSkins(Skin.allFor(LeatherArmor.class));
		ARMORS.addSkins(Skin.allFor(PlateArmor.class));

		BOOKS.addSkins(Skin.allFor(UnstableSpellbook.class));

		RUNICS.addSkins(Skin.allFor(RunicBlade.class));

		LSWORDS.addSkins(Skin.allFor(Longsword.class));

		GLAIVES.addSkins(Skin.allFor(Glaive.class));

		AXES.addSkins(Skin.allFor(BattleAxe.class));

		HAMMERS.addSkins(Skin.allFor(WarHammer.class));

		SHIELDS.addSkins(Skin.allFor(Greatshield.class));

		SCIMITARS.addSkins(Skin.allFor(Scimitar.class));

	}

	//old badges for pre-2.5
	public static LinkedHashMap<SkinCatalog, Badges.Badge> catalogBadges = new LinkedHashMap<>();
	static {
		catalogBadges.put(SEALS, 	Badges.Badge.ALL_SEAL_SKINS);
		catalogBadges.put(CLOAKS, 	Badges.Badge.ALL_CLOAK_SKINS);
		catalogBadges.put(BOWS, 	Badges.Badge.ALL_BOW_SKINS);
		catalogBadges.put(WANDS, 	Badges.Badge.ALL_WAND_SKINS);
		catalogBadges.put(ARMORS, 	Badges.Badge.ALL_ARMOR_SKINS);
		catalogBadges.put(BOOKS, 	Badges.Badge.ALL_BOOK_SKINS);
		catalogBadges.put(RUNICS, 	Badges.Badge.ALL_RUNIC_SKINS);
		catalogBadges.put(LSWORDS, 	Badges.Badge.ALL_LSWORD_SKINS);
		catalogBadges.put(GLAIVES, 	Badges.Badge.ALL_GLAIVE_SKINS);
		catalogBadges.put(AXES, 	Badges.Badge.ALL_AXE_SKINS);
		catalogBadges.put(HAMMERS, 	Badges.Badge.ALL_HAMMER_SKINS);
	}

	public static ArrayList<SkinCatalog> skinCatalogs = new ArrayList<>();
	static {
		skinCatalogs.add(SEALS);
		skinCatalogs.add(CLOAKS);
		skinCatalogs.add(BOWS);
		skinCatalogs.add(WANDS);
		skinCatalogs.add(ARMORS);
		skinCatalogs.add(BOOKS);
		skinCatalogs.add(RUNICS);
		skinCatalogs.add(LSWORDS);
		skinCatalogs.add(GLAIVES);
		skinCatalogs.add(AXES);
		skinCatalogs.add(HAMMERS);
		skinCatalogs.add(SHIELDS);
		skinCatalogs.add(SCIMITARS);
	}
	
	public static boolean isSeen(Skin skin){
		for (SkinCatalog cat : values()) {
			if (skin.rarityTier() == 0 ) {
				return true;
			}

			if (cat.seen.containsKey(skin)) {
				return cat.seen.get(skin);
			}
		}
		return false;
	}
	
	public static void setSeen(Skin skin){
		for (SkinCatalog cat : values()) {
			if (cat.seen.containsKey(skin) && !cat.seen.get(skin)) {
				cat.seen.put(skin, true);
				Journal.saveNeeded = true;
			}
		}
//		Badges.validateCatalogBadges(); //TODO
	}

	public static int applyCount(Skin skin){
		for (SkinCatalog cat : values()) {
			if (cat.applyCount.containsKey(skin)) {
				return cat.applyCount.get(skin);
			}
		}
		return 0;
	}

	public static void countApply(Skin skin){
		countApplies(skin, 1);
	}

	public static void countApplies(Skin skin, int uses){
		for (SkinCatalog cat : values()) {
			if (cat.applyCount.containsKey(skin) && cat.applyCount.get(skin) != Integer.MAX_VALUE) {
				cat.applyCount.put(skin, cat.applyCount.get(skin)+uses);
				if (cat.applyCount.get(skin) < -1_000_000_000){ //to catch cases of overflow
					cat.applyCount.put(skin, Integer.MAX_VALUE);
				}
				Journal.saveNeeded = true;
			}
		}
	}

	private static final String CATALOG_SKINS = "skincatalog_skins";
	private static final String CATALOG_SEEN    = "skincatalog_seen";
	private static final String CATALOG_APPLIES = "skincatalog_applies";
	
	public static void store( Bundle bundle ){

		ArrayList<String> skinnames = new ArrayList<>();
		ArrayList<Boolean> seen = new ArrayList<>();
		ArrayList<Integer> uses = new ArrayList<>();
		
		for (SkinCatalog cat : values()) {
			for (Skin skin : cat.skins()) {
				if (cat.seen.get(skin) || cat.applyCount.get(skin) > 0){
					skinnames.add(skin.name());
					seen.add(cat.seen.get(skin));
					uses.add(cat.applyCount.get(skin));
				}
			}
		}

		String[] storeSkins = new String[skinnames.size()];
		boolean[] storeSeen = new boolean[seen.size()];
		int[] storeUses = new int[uses.size()];

		for (int i = 0; i < storeSkins.length; i++){
			storeSkins[i] = skinnames.get(i);
			storeSeen[i] = seen.get(i);
			storeUses[i] = uses.get(i);
		}
		
		bundle.put(CATALOG_SKINS, storeSkins);
		bundle.put(CATALOG_SEEN, storeSeen );
		bundle.put(CATALOG_APPLIES, storeUses );
		
	}

	public static void restore( Bundle bundle ){

		if (bundle.contains(CATALOG_SKINS)){
			String[] savedSkinNames = bundle.getStringArray(CATALOG_SKINS);
			List<Skin> seenSkins = new ArrayList<>();
			for (String savedSkinName : savedSkinNames) {
				seenSkins.add(Skin.valueOf(savedSkinName));
			}

			boolean[] seen = bundle.getBooleanArray(CATALOG_SEEN);
			int[] uses = bundle.getIntArray(CATALOG_APPLIES);

			for (int i = 0; i < seenSkins.size(); i++){
				for (SkinCatalog cat : values()) {
					if (cat.seen.containsKey(seenSkins.get(i))) {
						cat.seen.put(seenSkins.get(i), seen[i]);
						cat.applyCount.put(seenSkins.get(i), uses[i]);
					}
				}

			}
		}

	}
	
}
