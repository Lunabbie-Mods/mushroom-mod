package com.lunabbie.mushroommod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    private static final FoodComponent PAINSHROOM_FOODCOMPONENT = new FoodComponent.Builder().hunger(0).saturationModifier(0.0f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0), 1.0f).build();
    public static final Item PAINSHROOM = new Item(new FabricItemSettings().group(MushroomMod.ITEM_GROUP).food(PAINSHROOM_FOODCOMPONENT));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(MushroomMod.MODID, "painshroom"), PAINSHROOM);
    }
}
