package com.shatteredpixel.shatteredpixeldungeon.items.albums;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class HogAlbum extends Album {

    {
        image = ItemSpriteSheet.ALBUM_HOG;

        songs.put("Epic Hog", Assets.Music.HOG_EPIC);
        songs.put("Phonk Hog", Assets.Music.HOG_PHONK);
        songs.put("Ride the Hog", Assets.Music.RIDE_THE_HOG);
    }
}
