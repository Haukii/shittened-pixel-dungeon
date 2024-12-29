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

package com.shatteredpixel.shatteredpixeldungeon.items.artifacts;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.SPDSettings;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Belongings;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.albums.Album;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.Bag;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.ui.InventoryPane;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndBag;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndOptions;
import com.watabou.noosa.audio.Music;
import com.watabou.noosa.audio.Sample;
import com.watabou.noosa.particles.Emitter;
import com.watabou.utils.Bundlable;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MusicPlayer extends Artifact {

	public static final String AC_PLAY      = "PLAY";
	public static final String AC_STOP      = "STOP";
	public static final String AC_SELECT    = "SELECT";
	public static final String AC_ADD     	= "ADD";
	public static final String SHUFFLE_ALL 	= "Shuffle all";
	public static final String SHUFFLE 		= "Shuffle";

	public static boolean playing = false;

	private List<Album> albums = new ArrayList<>();

	public String selectedSong = null;
	public String selectedSongName = null;

	{
		image = ItemSpriteSheet.ARTIFACT_MP3_PLAYER_1;

		exp = 0;

		levelCap = 10;

		defaultAction = AC_PLAY;

		type = Type.TRINKET;
	}

	@Override
	public ArrayList<String> actions(Hero hero) {
		ArrayList<String> actions = super.actions( hero );
		if (isEquipped(hero)) {
			actions.add(AC_ADD);
			if (albums.size() > 0) {
				actions.add(AC_SELECT);
				if (!playing) {
					actions.add(AC_PLAY);
				}
				else {
					actions.add(AC_STOP);
				}
			}
		}
		return actions;
	}

	public int targetingPos( Hero user, int dst ){
		return dst;
	}

	@Override
	public void execute(Hero hero, String action) {

		super.execute(hero, action);


		switch (action) {
			case AC_PLAY:
				if (selectedSong != null) {
					playing = true;
					Music.musicPlayerActive = true;
					defaultAction = AC_STOP;
					image = ItemSpriteSheet.ARTIFACT_MP3_PLAYER_2;
					updateQuickslot();
					//TODO pressing play doesn't shuffle songs anymore
					Music.INSTANCE.play(selectedSong, true, true);
					Sample.INSTANCE.play(Assets.Sounds.CD_INSERT, 0.8f, Random.Float(0.95f, 1.05f));
					if (SPDSettings.musicVol() == 0 || !SPDSettings.music()) {
						GLog.i(Messages.get(MusicPlayer.class, "disabled"));
					}
				}
				break;
			case AC_STOP:
				playing = false;
				Music.musicPlayerActive = false;
				image = ItemSpriteSheet.ARTIFACT_MP3_PLAYER_1;
				updateQuickslot();
				defaultAction = AC_PLAY;
				Dungeon.level.playLevelMusic();
				Sample.INSTANCE.play(Assets.Sounds.CD_EJECT, 0.8f, Random.Float(0.95f, 1.05f));
				break;
			case AC_SELECT:
				// This selection thing is a catastrophe.
				// I mean it SHOULD work, but it's just a mess.
				// I could try to extract some of the stuff into more readable methods instead of just doing thiAAAAAAAAAAAAAAAAAAAAAAAAAAAA HHHHAAAAAAAAAAAAAAAAAAAHHAHAHH
				List<String> albumNames = new ArrayList<>();
				albumNames.add(SHUFFLE_ALL);
				for (Album album : albums) {
					albumNames.add(album.name());
				}
				//First we select the album.
				GameScene.show(new WndOptions(new ItemSprite(MusicPlayer.this),
						Messages.titleCase(MusicPlayer.this.name()),
						Messages.get(MusicPlayer.class, "selectalbum"),
						albumNames) {

					@Override
					protected void onSelect(int index) {

						//If user selected "Shuffle all" on albums.
						if (index == 0) {
							List<String> songs = new ArrayList<>();
							for (Album album : albums) {
								for (String key : album.songs.keySet()) {
									songs.add(album.songs.get(key));
								}
							}
							Collections.shuffle(songs);

							float[] chances = new float[songs.size()];
							for (int i = 0; i < songs.size(); i++) {
								chances[i] = 1.0f;
							}

							Music.INSTANCE.playTracks(songs.toArray(new String[0]), chances, true, true);
							playing = true;
							Music.musicPlayerActive = true;
							selectedSongName = Messages.get(MusicPlayer.class, "all");
							image = ItemSpriteSheet.ARTIFACT_MP3_PLAYER_2;
							return;
						}


						//If user selected an album.
						List<String> songNames = new ArrayList<>();
						songNames.add(SHUFFLE);
						Album selectedAlbum = null;
						// FIXME the for loop seems to randomly fail when looking for a song. For now we can just try again a few times if it fails, lol.
						int attemps = 0;
						do {
							for (Album album : albums) {
								if (Objects.equals(album.name(), albumNames.get(index))) {
									songNames.addAll(album.songs.keySet());
									selectedAlbum = album;
									break;
								}
							}
							attemps++;
						} while (selectedAlbum == null && attemps < 5);
						if (selectedAlbum == null) {
							GLog.n("AAAAAAAAAAAA!!!!! ALBUM IS EMPTY FOR SOME REASON. THIS IS A BUG, PLEASE REMAIN CALM AND TRY AGAIN.");
							return;
						}
						if (songNames.isEmpty()) {
							GLog.n("AAAAAAAAAAAA BUG BUG!!! DEVELOPER HAS A BUG!!!! ALBUM IS APPARENTLY EMPTY????");
							return;
						}

						//Next we select the song from the album.
						Album finalSelectedAlbum = selectedAlbum;
						GameScene.show(new WndOptions(new ItemSprite(MusicPlayer.this),
								Messages.titleCase(MusicPlayer.this.name()),
								Messages.get(MusicPlayer.class, "selectsong"),
								songNames) {
							@Override
							protected void onSelect(int index) {
								//If user selected shuffle album. this sucks so much aaAAAhH
								if (index == 0) {
									List<String> songs = new ArrayList<>();
									for (String key : finalSelectedAlbum.songs.keySet()) {
										songs.add(finalSelectedAlbum.songs.get(key));
									}
									Collections.shuffle(songs);
									float[] chances = new float[finalSelectedAlbum.songs.size()];
									for (int x = 0; x < finalSelectedAlbum.songs.size(); x++) {
										chances[x] = 1.0f;
									}
									Music.INSTANCE.playTracks(songs.toArray(new String[0]), chances, false, true);
									playing = true;
									Music.musicPlayerActive = true;
									selectedSongName = finalSelectedAlbum.name();
									image = ItemSpriteSheet.ARTIFACT_MP3_PLAYER_2;
									return;
								}

								//If user selected a specific song
								String asset = null;
									if (finalSelectedAlbum.songs.containsKey(songNames.get(index))) {
										asset = finalSelectedAlbum.songs.get(songNames.get(index));
									}
								if (asset == null) {
									GLog.w("DEV IS FUCKING RETARD AND DOESN'T KNOW HOW TO CODE: SONG IS NULL FOR SOME REASON LMAO");
								}
								selectedSong = asset;
								selectedSongName = songNames.get(index);
								Music.INSTANCE.play(selectedSong, true, true);
								playing = true;
								Music.musicPlayerActive = true;
								image = ItemSpriteSheet.ARTIFACT_MP3_PLAYER_2;
							}
						});
					}
				});
				break;
			case AC_ADD:
				GameScene.selectItem(albumSelector);
				break;
		}
	}
	
	@Override
	public String desc() {
		String desc = super.desc();

		if (isEquipped( Dungeon.hero )){
			desc += "\n\n";
			if (cursed)
				desc += Messages.get(this, "desc_cursed");
			else {
				desc += Messages.get(this, "desc_worn");
				if (selectedSongName != null && !selectedSongName.isEmpty()) {
					desc +=  "\n\n"  + Messages.get(this, "song_info", selectedSongName);
				}
			}
		}
		return desc;
	}

	@Override
	public boolean doUnequip(Hero hero, boolean collect, boolean single) {
		if (playing) {
			playing = false;
			Music.musicPlayerActive = false;
			image = ItemSpriteSheet.ARTIFACT_MP3_PLAYER_1;
			Dungeon.level.playLevelMusic();
		}
		return super.doUnequip(hero, collect, single);
	}

	@Override
	public Emitter emitter() {
		if (playing) {
			Emitter emitter = new Emitter();
			emitter.pos(ItemSpriteSheet.film.width(image)/2f, ItemSpriteSheet.film.height(image)/2f - 3f);
			emitter.fillTarget = false;
			emitter.pour(Speck.factory(Speck.NOTE), 1f);
			return emitter;
		}
		return super.emitter();
	}

	private static final String ALBUMS = "ALBUMS";
	private static final String SELECTED = "SELECTED";
	private static final String SELECTEDNAME = "SELECTEDNAME";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(ALBUMS, albums);
		bundle.put(SELECTED, selectedSong);
		bundle.put(SELECTEDNAME, selectedSongName);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		for (Bundlable item : bundle.getCollection(ALBUMS)){
			albums.add( (Album) item );
		}
		selectedSong = bundle.getString(SELECTED);
		selectedSongName = bundle.getString(SELECTEDNAME);
	}

	protected WndBag.ItemSelector albumSelector = new WndBag.ItemSelector() {

		@Override
		public String textPrompt() {
			return  Messages.get(MusicPlayer.class, "album");
		}

		@Override
		public Class<?extends Bag> preferredBag(){
			if (InventoryPane.lastBag != null) return InventoryPane.lastBag.getClass();
			return Belongings.Backpack.class;
		}

		@Override
		public boolean itemSelectable(Item item) {
			return item instanceof Album;
		}

		@Override
		public void onSelect( Item item ) {
			if (itemSelectable(item)) {
				if (albums.size() == 0) GLog.i(Messages.get(MusicPlayer.class, "add_album"));
				else GLog.i(Messages.get(MusicPlayer.class, "add_album_more"));

				Dungeon.hero.sprite.operate(Dungeon.hero.pos);
				Sample.INSTANCE.play(Assets.Sounds.CD_INSERT);
				item.detach(Dungeon.hero.belongings.backpack);
				albums.add((Album) item);
				upgrade(1);
			}
		}
	};

	@Override
	protected ArtifactBuff passiveBuff() {
		return new MusicCharge();
	}

	public class MusicCharge extends ArtifactBuff{
		@Override
		public boolean act() {
			updateQuickslot();

			spend( TICK );

			return true;
		}
	}
}
