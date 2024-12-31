package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Cancelled;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.FoodCrate;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Egg;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.Warriorium;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.ArcaneCatalyst;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CapybaraSprite;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class Capybara extends Mob {

    {
        spriteClass = CapybaraSprite.class;

        HP = HT = 12;
        defenseSkill = 4;

        EXP = 0;
        maxLvl = 30;

        loot = new ArcaneCatalyst();
        lootChance = 0.2f;
        baseSpeed = 0.5f;
    }

    int eggs = 0;

    @Override
    public int damageRoll() {

        return Random.NormalIntRange(2, 4);
    }

    @Override
    public boolean act() {

        if (this.state == SLEEPING) {
            for (int i = 0; i < PathFinder.NEIGHBOURS8.length; i++) {
                if (Dungeon.hero.pos == pos + PathFinder.NEIGHBOURS8[i]) {
                    this.state = WANDERING;
                    break;
                }
            }
        }

        if ( this.state != SLEEPING && Dungeon.level.heroFOV[pos] && Random.Float() < 0.1f) {
            Sample.INSTANCE.play(Assets.Sounds.CAPYBARA, 0.7f, Random.Float(0.75f, 1f));
        }



        if (eggs < 3 && Random.Int(200) == 59 && state != SLEEPING) {
            Dungeon.level.drop( new Egg(), pos).sprite.drop( pos );
            if (fieldOfView != null && fieldOfView[Dungeon.hero.pos]) {
                Sample.INSTANCE.play(Assets.Sounds.EGG);
            }
            eggs++;
        }
        return super.act();
    }

    @Override
    public void die(Object cause) {
        if (Random.Int(3) == 1) {
            Sample.INSTANCE.play(Assets.Sounds.CAPYBARA, 1, Random.Float(1.6f, 2.2f));
        }
        if (cause instanceof Char && Random.Float() < 0.2f) {
            Buff.prolong((Char) cause, Cancelled.class, Cancelled.DURATION);
        }
        if (Random.Float() < 0.15f && Dungeon.LimitedDrops.FOODCRATE.count == 0) {
            Dungeon.level.drop(new FoodCrate(), pos).sprite.drop();
            Dungeon.LimitedDrops.FOODCRATE.count++;
        }
        super.die(cause);
    }

    @Override
    public int attackSkill(Char target) {
        return 10;
    }

    @Override
    public int drRoll() {
        return Random.NormalIntRange(3, 8);
    }

    public static Class<? extends Mob> random() {
        float roll = Random.Float();
        if (roll > 0.3f) {
            return Capybara.class;
        }
        return CapybaraPile.class;
    }

    private static final String EGGS = "EGGS";

    @Override
    public void storeInBundle(Bundle bundle) {
        super.storeInBundle(bundle);
        bundle.put(EGGS, eggs);
    }

    @Override
    public void restoreFromBundle(Bundle bundle) {
        super.restoreFromBundle(bundle);
        eggs = bundle.getInt(EGGS);
    }

    @Override
    protected Char chooseEnemy() {
        if (HP == HT && !(this instanceof Minibara)) {
            return null;
        }
        return super.chooseEnemy();
    }
}

