package com.shatteredpixel.shatteredpixeldungeon.items.albums;

import com.shatteredpixel.shatteredpixeldungeon.items.Item;

import java.util.HashMap;

public abstract class Album extends Item {

    public HashMap<String, String> songs = new HashMap<>();

    {
        stackable = false;
        unique = true;
    }

    @Override
    public boolean isUpgradable() {
        return false;
    }

    @Override
    public boolean isIdentified() {
        return true;
    }
}
