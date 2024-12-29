package com.shatteredpixel.shatteredpixeldungeon.items.albums;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class RemixAlbum extends Album {

    {
        image = ItemSpriteSheet.ALBUM_REMIX;

        songs.put("Main theme - remix", Assets.Music.THEME_3);
        songs.put("Sewers - remix", Assets.Music.REMIX_SEWER);
        songs.put("Sewer boss - remix", Assets.Music.REMIX_SEWER_BOSS);
        songs.put("Prison boss - remix", Assets.Music.REMIX_PRISON_BOSS);
        songs.put("City finale - remix", Assets.Music.REMIX_CITY_FINALE);
    }
}
