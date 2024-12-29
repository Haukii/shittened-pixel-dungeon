package com.shatteredpixel.shatteredpixeldungeon.items.albums;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class PopAlbum extends Album {

    {
        image = ItemSpriteSheet.ALBUM_POP;

        songs.put("Echoes of the Night", Assets.Music.ECHOES);
        songs.put("The Day I Rise (ft. Shart)", Assets.Music.SHART_DAY);
        songs.put("woooooooh", Assets.Music.WOOOOOOH);
        songs.put("Dance in the Stars", Assets.Music.DANCE_STARS);
    }
}
