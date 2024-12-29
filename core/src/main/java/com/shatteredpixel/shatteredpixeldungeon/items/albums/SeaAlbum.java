package com.shatteredpixel.shatteredpixeldungeon.items.albums;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class SeaAlbum extends Album {

    {
        image = ItemSpriteSheet.ALBUM_SEA;

        songs.put("Stormy rock", Assets.Music.STORMY_ROCK);
        songs.put("Sailing on a dream", Assets.Music.SAILING_DREAM);
        songs.put("High Tide, Low Tide", Assets.Music.HIGH_TIDE);
    }
}
