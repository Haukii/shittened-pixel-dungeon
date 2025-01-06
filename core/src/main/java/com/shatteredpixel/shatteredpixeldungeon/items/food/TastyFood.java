package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Satisfied;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;

public abstract class TastyFood extends Food {

    @Override
    public void execute(Hero hero, String action) {
        super.execute(hero, action);
        if (action.equals(AC_EAT)) {
            Buff.affect(hero, Satisfied.class).apply(hero, energy / 2);
        }
    }
}
