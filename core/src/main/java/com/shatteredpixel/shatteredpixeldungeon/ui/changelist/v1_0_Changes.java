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

package com.shatteredpixel.shatteredpixeldungeon.ui.changelist;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.ChangesScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.ui.Icons;
import com.shatteredpixel.shatteredpixeldungeon.ui.Window;
import com.watabou.noosa.Image;
import com.watabou.utils.PointF;

import java.util.ArrayList;

public class v1_0_Changes {

	public static void addAllChanges( ArrayList<ChangeInfo> changeInfos ){
		add_Coming_Soon(changeInfos);
		add_v1_3_Changes(changeInfos);
	}

	public static void add_Coming_Soon( ArrayList<ChangeInfo> changeInfos ) {

		ChangeInfo changes = new ChangeInfo("Coming Soon", true, "");
		changes.hardlight(0xCCCCCC);
		changeInfos.add(changes);

		changes.addButton( new ChangeButton(Icons.get(Icons.SHIT), "Overview",
				"I have no idea what the fuck I've done. Good luck waiting for the next update."));
	}

	public static void add_v1_3_Changes( ArrayList<ChangeInfo> changeInfos ) {
		ChangeInfo changes = new ChangeInfo("v1.0", true, "");
		changes.hardlight(Window.TITLE_COLOR);
		changeInfos.add(changes);

		changes = new ChangeInfo("v1.0", false, null);
		changes.hardlight(Window.TITLE_COLOR);
		changeInfos.add(changes);


		changes.addButton( new ChangeButton(Icons.get(Icons.INFO), "A little context",
				"Most of the stuff is made when I was bored, angry or just feeling creative. A lot of the changes are completely unneccessary or " +
						"make the game overall worse. Sometimes I enjoyed making serious changes, sometimes just wanted to fuck up the player, sometimes wanted to add fun stuff.\n\n" +
						"Many things changes seem really random and weird. But to give some context, I tried to make each area of the dungeon have it's own theme." +
						" Here's the themes as it's probably not very clear without explaining:\nSewers = Fake fantasy adventure RPG\nPrison = Western\nCaves = Party/Disco??" +
						"\nCity = Actual functioning dwarven city with a respected business king.\nHalls = Lair of the True Warrior"));

		changes.addButton( new ChangeButton(new Image(Assets.Sprites.WARRIOR, 0, 0, 12, 15), "Warriorism",
				"Warrior is everywhere. Warrior is everything."));

		changes.addButton( new ChangeButton(new ItemSprite(ItemSpriteSheet.ARMOR_HUNTRESS), "Sprites have been fucked",
				"I randomized many of the sprites. Have fun wondering why your character has Doom debuff icon.\n\nAlso Added warriors to many sprites"));

		changes.addButton(new ChangeButton(Icons.get(Icons.AUDIO), "AUDIO HAS BEEN FUCKED",
				"I added a ton of copyrighted music without permission. Also the audio files take probably like +100MB." +
						"\n\nThere will be a lot of music you'll never get to hear because you will stop playing after dying to a crab rave crab" +
						"\n\nAlso replaced many of the existing sounds"));

		changes.addButton(new ChangeButton(new ItemSprite(ItemSpriteSheet.PILE_OF_SAIS),"Stuff",
				"Here's a list of random stuff added:\n\n" +
						"- Added a bunch of _Adventurers_ to Sewers\n" +
						"- _Rats_ now randomly play parts of Free Bird by Lynyrd Skynyrd\n" +
						"- _Crabs_ now plays parts of Crab Rave for some reason\n" +
						"- _Armored statues_ are now impostors with guns\n" +
						"- Added _Capybaras_ \n" +
						"- Added _Capybara pile_ as a uncommon variant of Capybara\n" +
						"- New _DM-100_ variants. Added _DM-102_, _DM-102A2_, _DM-105_ and _DMS-74UN_ \n" +
						"- Added _Maskless Shamans_ as a rare variant of Shamans \n" +
						"- _Cave spinner_ is slightly bigger now\n" +
						"- There's a VERY LOW chance for the hero to randomly shit. \n" +
						"- There's a VERY VERY LOW chance for the hero to randomly step on a lego \n" +
						"- I'm running out of motivation to write patch notes in readable quality"
				));

		changes.addButton(new ChangeButton(new ItemSprite(ItemSpriteSheet.FIERYSEAL),"Stuff 2",
				"- Made random changes to a lot of sprites, characters and environments\n" +
						"- Added Foods: _Ratatouille_, _Small mystery meat_ including cooked, stewed and frozen versions, _Golden meat_ and _Wax bar_. \n" +
						"- Added _Pile of Sais_, _Saw_, _Gold bar_, _Silver Amulet_ (+ 3 variants of it), _Food Crate_, " +
						"3 real guns, The One Ring, Spearaxe, Small Greatsword,\n" +
						"- Added fucking skins to this game. Just for _Warrior's seal_ right now. 42 options to choose from!\n" +
						"- Added the option to go to surface without amulet.\n" +
						"- Added Evan Debenham, the developer of Shattered Pixel Dungeon. He may buff or nerf your run.\n" +
						"- 'Reworked' the visuals for most environments and many enemies.\n" +
						"- Added new rat variants.\n" +
						"- Wandmaker is now John Browning, an american gun designer.\n" +
						"- Snakes, swarms, fish, bats, crabs, and eyes have some rare variants now.\n" +
						"- Improved hero splash arts.\n" +
						"- Amulet of yendorwhatever has windows colors now in end scene.\n" +
						"- The sad ghost is now the depressed ghost. He also hates you in particular."
		));

		changes.addButton(new ChangeButton(new ItemSprite(ItemSpriteSheet.SILVERAMULET),"Stuff 3",
				"- Random changes to many in game texts\n" +
				"- Any text has a possibility of being fucked up\n" +
				"- Added several hilarous and funy banners which show up in certain situations\n" +
				"- Turned grass in surface scene into warriors\n" +
				"- You can now receive friend requests. This cannot be disabled.\n" +
				"- Added several new badges.\n" +
				"- Added new main menus for seasonal events. Events are: halloween, christmas, valentine's day, and obviously the independence day\n" +
				"- Removed Herobrine\n" +
				"- Caves now have christmas textures during christmas.\n" +
				"- Credits scene now has daily pieces of wisdom\n" +
				"- You can call people with the amulet now??? idk either.\n" +
				"\n"
		));

		changes.addButton( new ChangeButton(new Image(Assets.Sprites.TENGU, 140, 2, 15, 14), "\"Reworked\" (at least some of the) bossfights",
				"You thought bossfights were fun, challenging and interesting? Well no more. You're welcome\n" +
						"- Goo has green variant now? (red in progress)\n" +
						"- Added living Furniture for Tengu fight \n" +
						"- Made cave boss fight go hard. (gameplay literally the same lmao) \n" +
						"- Dwarf king behaves like an actual king now. Murder is no longer cool. \n"
		));

		changes.addButton( new ChangeButton(Icons.get(Icons.AUDIO), "Added music and sounds, A LOT OF THEM",
				"- Added a lot of new music to each region, bossfight and to other places and situations. Everything is uncredited! yayy!\n" +
				"- Added some VERY COOL :sunglasses: music for ascension challenge. Every area will have their unique songs! (stolen without credit, of course)\n" +
				"- Added a lot of new sound effects all around the game. Some try to actually improve the audio of this game, and some are just 'funny'.\n" +
				"- The total amount of songs is like 3.5x more than originally, and the amount of sound effects is increased from 66 to 160 (as of writing, mid development)"
		));

//		changes.addButton(new ChangeButton(new Image(Assets.Sprites.ADVENTURER, 12, 30, 12, 15),"List of new mobs",
//				"_SPOILER WARNING!_\n\nCapybara, Capybara pile, Boombox, Adventurer, Cave bat, Chair, Cobra, Cursed eye, DM102, DM102a2, DM105, DMS74UN, Evan, Evolved swarm, Goldfish" +
//						", Green Goo, Hero Enemy, Hero rat, Normal rat, Perch, Pink Crab, Ratatouille, Rave bat, Stool, Table"
//		));

		Image bugImage = new Image(Assets.Sprites.SPINNER, 32, 0, 64, 16);
		bugImage.scale = new PointF(0.25f, 1f);
		bugImage.angularSpeed = 0.1f;
		changes.addButton(new ChangeButton(bugImage, "Bugs",
				"Added bugs"));


		changes = new ChangeInfo(Messages.get(ChangesScene.class, "nerfs"), false, null);
		changes.hardlight(CharSprite.NEGATIVE);
		changeInfos.add(changes);

		changes.addButton( new ChangeButton(new ItemSprite(ItemSpriteSheet.ARMOR_WARRIOR), "Yes", "Nerfs have been made (this game is unplayable)"));
	}
}
