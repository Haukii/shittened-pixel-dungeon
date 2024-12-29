package com.shatteredpixel.shatteredpixeldungeon.items.albums;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class NonsenseAlbum extends Album {

    {
        image = ItemSpriteSheet.ALBUM_NONSENSE;

        songs.put("Afwfsw", Assets.Music.AFWFSW);
        songs.put("Wowowowo", Assets.Music.WOWOWOWO);
        songs.put("Pipikuku", Assets.Music.PIPIKUKU);
        songs.put("Uoauoa", Assets.Music.UOAUOA);
    }
}
