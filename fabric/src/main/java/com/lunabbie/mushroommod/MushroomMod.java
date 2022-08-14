package com.lunabbie.mushroommod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class MushroomMod implements ModInitializer {

    public static final String MODID = "mushroommod";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MODID, "items"),
            () -> new ItemStack(ModItems.PAINSHROOM)
    );

    @Override
    public void onInitialize() {
        ModItems.register();
    }
}
