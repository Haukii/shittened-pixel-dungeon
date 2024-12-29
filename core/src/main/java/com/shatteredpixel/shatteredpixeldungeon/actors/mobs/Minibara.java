package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.MinibaraSprite;
import com.watabou.utils.PathFinder;

public class Minibara extends Capybara {
    {
        spriteClass = MinibaraSprite.class;

        HP = HT = 10;
        defenseSkill = 2;

        EXP = -1;
        baseSpeed = 1f;
    }

    //Tries to find a parent and follow it around.
    private Mob parent;

    @Override
    public boolean act() {

        if (parent != null && parent.isAlive()) {
            target = parent.pos;
        }

        if (parent == null) {
            for (int i = 0; i < PathFinder.NEIGHBOURS8.length; i++) {
                Mob mob = Dungeon.level.findMob(pos +PathFinder.NEIGHBOURS8[i]);
                if (mob != null && (mob.getClass() == Capybara.class || mob.getClass() == CapybaraPile.class)) {
                    parent = Dungeon.level.findMob(mob.pos);
                }
            }
        }

        return super.act();
    }

    @Override
    protected Char chooseEnemy() {

        if (parent != null && parent.isAlive()) {
            return parent;
        }

        return super.chooseEnemy();
    }

    @Override
    public int damageRoll() {
        return super.damageRoll() - 2;
    }

    @Override
    protected boolean canAttack(Char enemy) {
        if (enemy instanceof Capybara)
            return false;
        return super.canAttack(enemy);
    }
}
