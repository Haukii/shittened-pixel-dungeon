package com.shatteredpixel.shatteredpixeldungeon.mechanics;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.items.Amulet;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.ClothArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.LeatherArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.MailArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.PlateArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.ScaleArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.ArcaneBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Bomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Firebomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.FlashBangBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.FrostBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.HolyBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Noisemaker;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.RegrowthBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.ShrapnelBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.SmokeBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.WoollyBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Blandfruit;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.Car;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.GoldBar;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.Painting;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.Saw;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.SilverAmulet;
import com.shatteredpixel.shatteredpixeldungeon.items.misc.VeggieBag;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfAquaticRejuvenation;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfArcaneArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfDragonsBlood;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfHoneyedHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfIcyTouch;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfMight;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfToxicEssence;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.CeremonialCandle;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.Embers;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.GooBlob;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.MetalShard;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.Pickaxe;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.Ring;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfWealth;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.CurseInfusion;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.MagicalInfusion;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.PhaseShift;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.ReclaimTrap;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.SummonElemental;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.TelekineticGrab;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.WildEnergy;
import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LootGenerator {

    //I don't like this...
    private static Map<Class<? extends Item>, Float> items = new HashMap<>();
    private static List<Map.Entry<Class<? extends Item>, Float>> entries;


    public static List<Item> rollItems(int count) {
        List<Item> rolls = new ArrayList<>();
        if (Ring.getBuffedBonus(Dungeon.hero, RingOfWealth.Wealth.class) > 0) {
            count++;
        }
        for (int i = 0; i < count; i++) {
            rolls.add(rollItem());
        }
        return rolls;
    }

    public static Item rollItem() {
        Item lootItem = null;
        do {
            int id = Random.Int(entries.size());
            Class<? extends Item> item = entries.get(id).getKey();
            float percentage = entries.get(id).getValue();

            if (Random.Float() < percentage) {
                try {
                    lootItem = item.getDeclaredConstructor().newInstance();
                } catch (Exception e) {

                }
            }
        } while (lootItem == null);
        return lootItem;
    }

    static {
        for (Class<?> itemClass: Generator.Category.SEED.classes) {
            items.put((Class<? extends Item>) itemClass, 0.15f);
        }
        for (Class<?> itemClass: Generator.Category.STONE.classes) {
            items.put((Class<? extends Item>) itemClass, 0.11f);
        }

        for (Class<?> itemClass: Generator.Category.WEP_T1.classes) {
            items.put((Class<? extends Item>) itemClass, 0.04f);
        }
        for (Class<?> itemClass: Generator.Category.WEP_T2.classes) {
            items.put((Class<? extends Item>) itemClass, 0.03f);
        }
        for (Class<?> itemClass: Generator.Category.WEP_T3.classes) {
            items.put((Class<? extends Item>) itemClass, 0.02f);
        }
        for (Class<?> itemClass: Generator.Category.WEP_T4.classes) {
            items.put((Class<? extends Item>) itemClass, 0.01f);
        }
        for (Class<?> itemClass: Generator.Category.WEP_T5.classes) {
            items.put((Class<? extends Item>) itemClass, 0.005f);
        }
        for (Class<?> itemClass: Generator.Category.MIS_T1.classes) {
            items.put((Class<? extends Item>) itemClass, 0.05f);
        }
        for (Class<?> itemClass: Generator.Category.MIS_T2.classes) {
            items.put((Class<? extends Item>) itemClass, 0.04f);
        }
        for (Class<?> itemClass: Generator.Category.MIS_T3.classes) {
            items.put((Class<? extends Item>) itemClass, 0.03f);
        }
        for (Class<?> itemClass: Generator.Category.MIS_T4.classes) {
            items.put((Class<? extends Item>) itemClass, 0.02f);
        }
        for (Class<?> itemClass: Generator.Category.MIS_T5.classes) {
            items.put((Class<? extends Item>) itemClass, 0.01f);
        }

        for (Class<?> itemClass: Generator.Category.WAND.classes) {
            items.put((Class<? extends Item>) itemClass, 0.04f);
        }
        for (Class<?> itemClass: Generator.Category.RING.classes) {
            items.put((Class<? extends Item>) itemClass, 0.02f);
        }

        for (Class<?> itemClass: Generator.Category.POTION.classes) {
            items.put((Class<? extends Item>) itemClass, 0.1f);
        }
        for (Class<?> itemClass: Generator.Category.EXOTIC.classes) {
            items.put((Class<? extends Item>) itemClass, 0.04f);
        }
        for (Class<?> itemClass: Generator.Category.SCROLL.classes) {
            items.put((Class<? extends Item>) itemClass, 0.06f);
        }
        for (Class<?> itemClass: Generator.Category.FOOD.classes) {
            items.put((Class<? extends Item>) itemClass, 0.06f);
        }
        for (Class<?> itemClass: Generator.Category.FOOD_NEW.classes) {
            items.put((Class<? extends Item>) itemClass, 0.05f);
        }


        items.put(ClothArmor.class,0.03f);
        items.put(LeatherArmor.class,0.08f);
        items.put(MailArmor.class,0.06f);
        items.put(ScaleArmor.class,0.05f);
        items.put(PlateArmor.class,0.03f);

        items.put(ScrollOfUpgrade.class,0.015f);

        items.put(ArcaneBomb.class, 0.03f);
        items.put(Bomb.class, 0.04f);
        items.put(Firebomb.class, 0.03f);
        items.put(FlashBangBomb.class, 0.03f);
        items.put(FrostBomb.class, 0.03f);
        items.put(HolyBomb.class, 0.03f);
        items.put(Noisemaker.class, 0.03f);
        items.put(RegrowthBomb.class, 0.03f);
        items.put(ShrapnelBomb.class, 0.03f);
        items.put(SmokeBomb.class, 0.03f);
        items.put(WoollyBomb.class, 0.03f);

        items.put(GoldBar.class, 0.03f);
        items.put(GooBlob.class, 0.05f);
        items.put(MetalShard.class, 0.03f);
        items.put(CeremonialCandle.class, 0.01f);
        items.put(Blandfruit.class, 0.03f);
        items.put(SilverAmulet.class, 0.008f);
        items.put(Saw.class, 0.005f);
        items.put(Pickaxe.class, 0.005f);
        items.put(Embers.class,0.008f);
        items.put(Amulet.class,0.0005f);

        items.put(ElixirOfAquaticRejuvenation.class, 0.012f);
        items.put(ElixirOfArcaneArmor.class, 0.01f);
        items.put(ElixirOfDragonsBlood.class, 0.012f);
        items.put(ElixirOfHoneyedHealing.class, 0.01f);
        items.put(ElixirOfIcyTouch.class, 0.012f);
        items.put(ElixirOfToxicEssence.class, 0.015f);
        items.put(ElixirOfMight.class, 0.006f);

        items.put(PhaseShift.class, 0.01f);
        items.put(TelekineticGrab.class, 0.01f);
        items.put(WildEnergy.class, 0.01f);
        items.put(SummonElemental.class, 0.01f);
        items.put(ReclaimTrap.class, 0.01f);
        items.put(CurseInfusion.class, 0.01f);
        items.put(MagicalInfusion.class, 0.01f);

        items.put(VeggieBag.class, 0.1f);
        items.put(Car.class, 0.08f);
        items.put(Painting.class, 0.1f);

        entries = new ArrayList<>(items.entrySet());
    }
}
