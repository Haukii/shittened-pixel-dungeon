package com.shatteredpixel.shatteredpixeldungeon.items.albums;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class TwingoAlbum extends Album {

    {
        image = ItemSpriteSheet.ALBUM_TWINGO;

        songs.put("Cantonese Twingo", Assets.Music.CANTO_TWINGO);
        songs.put("Twigigigi", Assets.Music.TWIGIGIGI);
        songs.put("Twingo Turbo", Assets.Music.TWINGO_TURBO);
    }
}
