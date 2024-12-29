package com.shatteredpixel.shatteredpixeldungeon.items.albums;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class FinnishAlbum extends Album {

    {
        image = ItemSpriteSheet.ALBUM_FINNISH;

        songs.put("Ysiluokkalaiset", Assets.Music.YSILUOKKALAISET);
        songs.put("Missa mun twingo?", Assets.Music.MISSA_TWINGO);
        songs.put("Mokkitie", Assets.Music.MOKKITIE);
    }
}