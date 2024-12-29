package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.items.food.MysteryMeat;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CapybaraPileSprite;
import com.watabou.utils.Random;

public class CapybaraPile extends Capybara {
    {
        spriteClass = CapybaraPileSprite.class;

        HP = HT = 20;
        defenseSkill = 4;

        EXP = -1;
        baseSpeed = 0.4f;
    }

    @Override
    public boolean act() {
        return super.act();
    }

    @Override
    public void die(Object cause) {
        MysteryMeat steak = new MysteryMeat();
        Dungeon.level.drop( steak.quantity(Random.Int(1, 2)), this.pos ).sprite.drop();
        super.die(cause);
    }
}
