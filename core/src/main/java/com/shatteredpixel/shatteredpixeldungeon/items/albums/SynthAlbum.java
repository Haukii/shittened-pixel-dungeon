package com.shatteredpixel.shatteredpixeldungeon.items.albums;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class SynthAlbum extends Album {

    {
        image = ItemSpriteSheet.ALBUM_SYNTH;

        songs.put("Into the sunset", Assets.Music.SUNSET);
        songs.put("Adventure", Assets.Music.ADVENTURE);
        songs.put("Westerness", Assets.Music.WESTERNESS);
        songs.put("On the streets", Assets.Music.ON_THE_STREETS);
    }
}
