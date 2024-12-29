package com.shatteredpixel.shatteredpixeldungeon.mechanics;


import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum HairColor {

    //This also supports different hairstyles, but none are made yet.

    DEFAULT                 ("Default",     0),
    ORANGE                  ("Orange",      1),
    YELLOW                  ("Yellow",      2),
    GREEN                   ("Green",       3),
    BLUE                    ("Cyan",        4),
    TURQUOISE               ("Turquoise",   5),
    PURPLE                  ("Purple",      6),
    PINK                    ("Pink",        7),
    BROWN                   ("Light Brown", 8),
    BLACK                   ("Black",       9),
    GRAY                    ("Gray",        10),
    WHITE                   ("White",       11),
    RUSSET                  ("Brown",       12),
    MAROON                  ("Red",         13),
    SEPIA                   ("Dark brown",  14),

    ;
    private final String name;
    private final int ID;

    HairColor(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String colorName() {
        return name;
    }


    public int ID() {
        return ID;
    }

    public static List<HairColor> all() {
        return new ArrayList<>(Arrays.asList(
                DEFAULT,
                ORANGE,
                YELLOW,
                GREEN,
                BLUE,
                TURQUOISE,
                PURPLE,
                PINK,
                BROWN,
                BLACK,
                GRAY,
                WHITE,
                RUSSET,
                MAROON,
                SEPIA
        ));
    }

    public static HairColor random(List<HairColor> exclude) {
        HairColor color;
        do {
            color = HairColor.all().get(Random.Int(HairColor.all().size()));
        } while (exclude.contains(color));
        return color;
    }
}
