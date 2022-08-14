package com.lunabbie.mushroommod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item PAINSHROOM = new Item(new FabricItemSettings().group(MushroomMod.ITEM_GROUP));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(MushroomMod.MODID, "painshroom"), PAINSHROOM);
    }
}
