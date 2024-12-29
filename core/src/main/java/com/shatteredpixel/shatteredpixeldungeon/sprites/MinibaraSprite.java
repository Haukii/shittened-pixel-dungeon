package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.watabou.noosa.TextureFilm;

public class MinibaraSprite extends MobSprite {

    public MinibaraSprite() {
        super();

        texture( Assets.Sprites.CAPYBARA );

        TextureFilm frames = new TextureFilm( texture, 15, 17 );

        idle = new Animation( 2, true );
        idle.frames( frames, 34, 34, 34, 35, 34, 34, 35, 35 );

        run = new Animation( 12, true );
        run.frames( frames, 46, 47, 48, 49, 50 );

        attack = new Animation( 12, false );
        attack.frames( frames, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45 );

        die = new Animation( 8, false );
        die.frames( frames, 32, 33 );

        play( idle );
    }
}
