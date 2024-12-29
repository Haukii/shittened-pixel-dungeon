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

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Amok;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Dread;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Paralysis;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Sleep;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Terror;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Vertigo;
import com.shatteredpixel.shatteredpixeldungeon.items.albums.PopAlbum;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.MusicPlayer;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.levels.rooms.Room;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.BoomboxSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Music;
import com.watabou.utils.Bundle;
import com.watabou.utils.Point;

public class Boombox extends Furniture {

	{
		spriteClass = BoomboxSprite.class;

		HP = HT = 15;

		EXP = 0;

		properties.add(Property.INORGANIC);
		properties.add(Property.IMMOVABLE);

		state = PASSIVE;
		alignment = Alignment.NEUTRAL;
	}

	@Override
	protected boolean act() {
		alerted = false;
		super.act();

		return true;
	}

	@Override
	public void damage(int dmg, Object src) {
		super.damage(dmg, src);
		activate();
	}

	public void activate(){
		alignment = Alignment.ENEMY;
		((BoomboxSprite) sprite).activate();
		if (!Music.musicPlayerActive) {
			Music.INSTANCE.stop();
			Music.INSTANCE.clearQueue();
		}
	}

	@Override
	public CharSprite sprite() {
		BoomboxSprite p = (BoomboxSprite) super.sprite();
		if (alignment != Alignment.NEUTRAL) p.activate();
		return p;
	}

	@Override
	public void beckon(int cell) {
		//do nothing
	}

	@Override
	public String description() {
		if (alignment == Alignment.NEUTRAL){
			return Messages.get(this, "desc_alive");
		} else {
			return Messages.get(this, "desc_dead");
		}
	}

	@Override
	public boolean interact(Char c) {
		return true;
	}

	public static void spawnBoombox(Level level, Room room) {

		Boombox boombox = new Boombox();

		boolean validPos;
		int tries = 0;
		do {
			validPos = true;
			boombox.pos = level.pointToCell(room.random());
			if (boombox.pos == level.entrance()){
				validPos = false;
			}
			for (Point door : room.connected.values()){
				if (level.trueDistance( boombox.pos, level.pointToCell( door ) ) <= 1){
					validPos = false;
				}
			}
			if (level.traps.get(boombox.pos) != null){
				validPos = false;
			}
			if (!level.passable[boombox.pos]) {
				validPos = false;
			}
			tries++;
			if (tries > 200) {
				validPos = true;
				GLog.n("Boombox: AAAAAAAAAAAAAAAAAAARRHHHHGGAAAAAAAAAH!!! RELEASE ME FROM MY SUFFERING!!!!");
			}
		} while (!validPos);
		level.mobs.add( boombox );
	}

	@Override
	public void die(Object cause) {
		MusicPlayer player = Dungeon.hero.belongings.getItem( MusicPlayer.class );
		if (player != null && Dungeon.LimitedDrops.POP_ALBUM.count == 0) {
			Dungeon.level.drop( new PopAlbum(), pos ).sprite.drop();
			Dungeon.LimitedDrops.POP_ALBUM.count++;
		}
		super.die(cause);
	}

	private static final String ALIGNMENT = "alignment";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(ALIGNMENT, alignment);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		alignment = bundle.getEnum(ALIGNMENT, Alignment.class);
	}

	{
		immunities.add( Paralysis.class );
		immunities.add( Amok.class );
		immunities.add( Sleep.class );
		immunities.add( Terror.class );
		immunities.add( Dread.class );
		immunities.add( Vertigo.class );
	}

}
