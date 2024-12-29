package com.shatteredpixel.shatteredpixeldungeon.items.albums;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class RatAlbum extends Album {

    {
        image = ItemSpriteSheet.ALBUM_RAT;

        songs.put("Rat rat rat", Assets.Music.RATRATRAT);
        songs.put("Ratty rat", Assets.Music.RATTYRAT);
        songs.put("Rat noises", Assets.Music.RAT_NOISES);
    }
}
