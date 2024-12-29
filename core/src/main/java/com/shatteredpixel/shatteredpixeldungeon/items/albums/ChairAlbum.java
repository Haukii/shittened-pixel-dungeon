package com.shatteredpixel.shatteredpixeldungeon.items.albums;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class ChairAlbum extends Album {

    {
        image = ItemSpriteSheet.ALBUM_CHAIR;

        songs.put("Chair", Assets.Music.CHAIR);
        songs.put("My Table", Assets.Music.MY_TABLE);
        songs.put("Stool gone", Assets.Music.STOOL_GONE);
    }
}
