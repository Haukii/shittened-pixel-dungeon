package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.watabou.noosa.TextureFilm;

public class CapybaraPileSprite extends MobSprite {

    public CapybaraPileSprite() {
        super();

        texture( Assets.Sprites.CAPYBARA );

        TextureFilm frames = new TextureFilm( texture, 15, 17 );

        idle = new Animation( 2, true );
        idle.frames( frames, 17, 17, 17, 18, 17, 17, 18, 18 );

        run = new Animation( 12, true );
        run.frames( frames, 21, 22, 23, 24 );

        attack = new Animation( 12, false );
        attack.frames( frames, 19, 20, 17 );

        die = new Animation( 12, false );
        die.frames( frames, 25, 26, 27 );

        play( idle );
    }
}
