package com.shatteredpixel.shatteredpixeldungeon.plants;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.watabou.noosa.audio.Sample;

public abstract class FoodPlant extends Plant {

    @Override
    public void activate(Char ch) {
        if (Dungeon.hero.fieldOfView != null && Dungeon.hero.fieldOfView[pos]) {
            Sample.INSTANCE.play(Assets.Sounds.HARVEST);
        }
    }
}
