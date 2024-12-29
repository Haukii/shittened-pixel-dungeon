package com.shatteredpixel.shatteredpixeldungeon.mechanics;

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.Random;

public enum Prefix {
    // {MIN DAMAGE, MAX DAMAGE, ACCURACY, SPEED}
    NONE(new float[]{0f,0f,0f,0f}, -1),
    ANNOYING(       new float[]{-0.2f   ,-0.25f ,-0.3f  ,-0.1f  },  ItemSpriteSheet.Prefix.ANNOYING),
    LONG(           new float[]{-0.1f   ,0.05f  ,-0.05f ,0.0f   },  ItemSpriteSheet.Prefix.LONG), // +1 reach
    MUSICAL(        new float[]{0.05f   ,0.05f  ,-0.02f ,0.0f   },  ItemSpriteSheet.Prefix.MUSICAL),
    FEARSOME(       new float[]{0.0f    ,0.15f  ,0.07f  ,0.0f   },  ItemSpriteSheet.Prefix.FEARSOME),
    DULL(           new float[]{-0.6f   ,-0.3f  ,0.0f   ,0.0f   },  ItemSpriteSheet.Prefix.DULL),
    BORING(         new float[]{-0.1f   ,-0.1f  ,0.0f   ,0.0f   },  ItemSpriteSheet.Prefix.BORING),
    CATASTROPHIC(   new float[]{-1.0f   ,0.4f   ,-0.4f  ,0.0f   },  ItemSpriteSheet.Prefix.CATASTROPHIC),
    SLOW(           new float[]{0.0f    ,0.0f   ,0.0f   ,-0.25f },  ItemSpriteSheet.Prefix.SLOW),
    WEIGHTLESS(     new float[]{-0.15f  ,-0.04f ,0.1f   ,0.25f  },  ItemSpriteSheet.Prefix.WEIGHTLESS),
    SILENT(         new float[]{0.0f    ,0.0f   ,0.25f  ,0.0f   },  ItemSpriteSheet.Prefix.SILENT),
    LOUD(           new float[]{0.0f    ,0.23f  ,-0.11f ,0.0f   },  ItemSpriteSheet.Prefix.LOUD),
    BOLD(           new float[]{0.13f   ,0.15f  ,-0.07f ,0.0f   },  ItemSpriteSheet.Prefix.BOLD),
    CONSTRUCTIVE(   new float[]{0.0f    ,0.1f   ,0.0f   ,0.0f   },  ItemSpriteSheet.Prefix.CONSTRUCTIVE),
    QUICK(          new float[]{-0.7f   ,-0.2f  ,0.0f   ,0.5f   },  ItemSpriteSheet.Prefix.QUICK),
    UNSTOPPABLE(    new float[]{2.0f    ,0.25f  ,0.1f   ,0.0f   },  ItemSpriteSheet.Prefix.UNSTOPPABLE),
    MASTERFUL(      new float[]{0.4f    ,0.3f   ,1.1f   ,0.12f  },  ItemSpriteSheet.Prefix.MASTERFUL),
    SCREAMING(      new float[]{1.2f    ,-0.1f  ,-0.45f ,0.2f   },  ItemSpriteSheet.Prefix.SCREAMING),
    MUTED(          new float[]{0.0f    ,0.0f   ,0.15f  ,0.0f   },  ItemSpriteSheet.Prefix.MUTED),
    BLAND(          new float[]{0.1f    ,0.0f   ,-0.02f ,0.0f   },  ItemSpriteSheet.Prefix.BLAND),
    HINDERED(       new float[]{0.0f    ,0.0f   ,-0.27f ,0.15f  },  ItemSpriteSheet.Prefix.HINDERED),
    EXCITED(        new float[]{0.3f    ,0.15f  ,-0.09f ,0.3f   },  ItemSpriteSheet.Prefix.EXCITED),
    CARELESS(       new float[]{0.0f    ,0.29f  ,-0.35f ,0.0f   },  ItemSpriteSheet.Prefix.CARELESS),
    AWKWARD(        new float[]{-0.25f  ,0.19f  ,-0.15f ,0.0f   },  ItemSpriteSheet.Prefix.AWKWARD),
    HURTFUL(        new float[]{2.5f    ,0.22f  ,-0.1f  ,0.0f   },  ItemSpriteSheet.Prefix.HURTFUL),
    DEAD(           new float[]{-1.0f   ,-0.8f  ,0.0f   ,0.0f   },  ItemSpriteSheet.Prefix.DEAD),
    FLIMSY(         new float[]{-0.2f   ,-0.2f  ,-0.2f  ,0.0f   },  ItemSpriteSheet.Prefix.FLIMSY),
    FAITHFUL(       new float[]{0.75f   ,0.3f   ,0.0f   ,0.0f   },  ItemSpriteSheet.Prefix.FAITHFUL),
    SPIKED(         new float[]{2.5f    ,0.0f   ,0.0f   ,0.0f   },  ItemSpriteSheet.Prefix.SPIKED),
    HEROIC(         new float[]{2f      ,1.0f   ,0.2f   ,0.0f   },  ItemSpriteSheet.Prefix.HEROIC),
    RUTHLESS(       new float[]{0.5f    ,0.2f   ,0.2f   ,-0.01f },  ItemSpriteSheet.Prefix.RUTHLESS),
    THUNDERING(     new float[]{0.6f    ,0.19f  ,0.04f  ,0.0f   },  ItemSpriteSheet.Prefix.THUNDERING),
    GLISTERING(     new float[]{0.0f    ,0.0f   ,0.0f   ,0.0f   },  ItemSpriteSheet.Prefix.GLISTERING),
    CELESTIAL(      new float[]{0.25f   ,0.6f   ,0.21f  ,-0.35f },  ItemSpriteSheet.Prefix.CELESTIAL),
    VENOMOUS(       new float[]{0.1f    ,0.11f  ,0.0f   ,0.0f   },  ItemSpriteSheet.Prefix.VENOMOUS), // 5% chance for poison
    ETERNAL(        new float[]{0.3f    ,0.25f  ,0.15f  ,0.0f   },  ItemSpriteSheet.Prefix.ETERNAL),
    SAVAGE(         new float[]{-0.5f   ,0.5f   ,-0.15f ,0.0f   },  ItemSpriteSheet.Prefix.SAVAGE),
    JAGGED(         new float[]{1.01f   ,0.2f   ,0.0f   ,-0.2f  },  ItemSpriteSheet.Prefix.JAGGED),
    FRUSTRATING(    new float[]{-0.11f  ,-0.14f ,-0.19f ,-0.12f },  ItemSpriteSheet.Prefix.FRUSTRATING),
    SOOTHING(       new float[]{0.05f   ,0.05f  ,0f     ,-0.05f },  ItemSpriteSheet.Prefix.SOOTHING),
    LUMINOUS(       new float[]{0f      ,0.15f  ,0.1f   ,0.1f   },  ItemSpriteSheet.Prefix.LUMINOUS),
    ELUSIVE(        new float[]{0f      ,0f     ,0.15f  ,0.13f  },  ItemSpriteSheet.Prefix.ELUSIVE),
    WORN(           new float[]{-0.11f  ,-0.06f ,0f     ,0f     },  ItemSpriteSheet.Prefix.WORN),
    CRYING(         new float[]{0f      ,0f     ,-0.4f  ,0f     },  ItemSpriteSheet.Prefix.CRYING),
    GARGANTUAN(     new float[]{0.4f    ,0.9f   ,0f     ,-0.65f },  ItemSpriteSheet.Prefix.GARGANTUAN),
    PROTECTIVE(     new float[]{0f      ,0f     ,0f     ,0f     },  ItemSpriteSheet.Prefix.PROTECTIVE), // +[weapon tier] armor
    STEADFAST(      new float[]{0.15f   ,0.1f   ,0f     ,0f     },  ItemSpriteSheet.Prefix.STEADFAST),  // +[weapon tier] armor
    VOLATILE(       new float[]{-1f     ,1.5f   ,-0.43f ,0f     },  ItemSpriteSheet.Prefix.VOLATILE),
    SINISTER(       new float[]{-0.1f   ,-0.1f  ,0f     ,0f     },  ItemSpriteSheet.Prefix.SINISTER),
    ABYSMAL(        new float[]{0f      ,-0.3f  ,-0.8f  ,0f     },  ItemSpriteSheet.Prefix.ABYSMAL),
    KNOCKOFF(       new float[]{-0.4f   ,-0.4f  ,0f     ,0f     },  ItemSpriteSheet.Prefix.KNOCKOFF),
    PLASTIC(        new float[]{-0.8f   ,-0.8f  ,0f     ,1f     },  ItemSpriteSheet.Prefix.PLASTIC),
    BENT(           new float[]{0f      ,0f     ,-0.1f  ,0f     },  ItemSpriteSheet.Prefix.BENT),
    STICKY(         new float[]{0f      ,0f     ,0f     ,-0.12f },  ItemSpriteSheet.Prefix.STICKY),
    HUMBLE(         new float[]{0.1f    ,0.1f   ,0.1f   ,0f     },  ItemSpriteSheet.Prefix.HUMBLE),
    BULKY(          new float[]{0f      ,0f     ,0f     ,-0.25f },  ItemSpriteSheet.Prefix.BULKY),
    WOBBLY(         new float[]{0f      ,0f     ,-0.2f  ,0f     },  ItemSpriteSheet.Prefix.WOBBLY),
    DUSTY(          new float[]{-0.15f  ,-0.1f  ,0f     ,0f     },  ItemSpriteSheet.Prefix.DUSTY),
    SHATTERED(      new float[]{0f      ,0.2f   ,0f     ,0f     },  ItemSpriteSheet.Prefix.SHATTERED);

    // {MIN DAMAGE, MAX DAMAGE, ACCURACY, SPEED}

    private final float[] buffs;
    private final int icon;

    public static final Prefix[]all =
            {
                    ANNOYING,
                    LONG,
                    MUSICAL,
                    FEARSOME,
                    DULL,
                    BORING,
                    CATASTROPHIC,
                    SLOW,
                    WEIGHTLESS,
                    SILENT,
                    LOUD,
                    BOLD,
                    CONSTRUCTIVE,
                    QUICK,
                    UNSTOPPABLE,
                    MASTERFUL,
                    SCREAMING,
                    MUTED,
                    BLAND,
                    HINDERED,
                    EXCITED,
                    CARELESS,
                    AWKWARD,
                    HURTFUL,
                    DEAD,
                    FLIMSY,
                    FAITHFUL,
                    SPIKED,
                    HEROIC,
                    RUTHLESS,
                    THUNDERING,
                    GLISTERING,
                    CELESTIAL,
                    VENOMOUS,
                    ETERNAL,
                    SAVAGE,
                    JAGGED,
                    FRUSTRATING,
                    SOOTHING,
                    LUMINOUS,
                    ELUSIVE,
                    WORN,
                    CRYING,
                    GARGANTUAN,
                    PROTECTIVE,
                    STEADFAST,
                    VOLATILE,
                    SINISTER,
                    ABYSMAL,
                    KNOCKOFF,
                    PLASTIC,
            };

    public static Prefix random() {
        return Prefix.all[Random.Int(Prefix.all.length)];
    }

    Prefix(float[] buffs, int icon) {
        this.buffs = buffs;
        this.icon = icon;
    }

    public float min() {
        return buffs[0];
    }

    public float max() {
        return buffs[1];
    }

    public float acc() {
        return buffs[2];
    }

    public float speed() {
        return buffs[3];
    }

    public int icon() {
        return icon;
    }
}
