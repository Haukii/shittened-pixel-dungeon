package com.shatteredpixel.shatteredpixeldungeon.items.albums;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class BeautifulAlbum extends Album {

    {
        image = ItemSpriteSheet.ALBUM_BEAUTIFUL;

        songs.put("Tale", Assets.Music.TALE);
        songs.put("Destination", Assets.Music.DESTINATION);
        songs.put("Mountain Call", Assets.Music.FUJI);
        songs.put("Reawakening", Assets.Music.REAWAKENING);
        songs.put("Flow", Assets.Music.FLOW);
    }
}
