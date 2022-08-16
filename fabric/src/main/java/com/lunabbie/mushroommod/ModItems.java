package com.lunabbie.mushroommod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.lunabbie.mushroommod.MushroomModKt.MODID;


public class ModItems {
    public static final Item PAINSHROOM = new BlockItem(
            ModBlocks.PAINSHROOM,
            new FabricItemSettings()
                    .group(MushroomModKt.getITEM_GROUP())
                    .food(
                            new FoodComponent.Builder()
                                    .hunger(0)
                                    .saturationModifier(0.0f)
                                    .alwaysEdible()
                                    .statusEffect(
                                            new StatusEffectInstance(
                                                    StatusEffects.INSTANT_DAMAGE,
                                                    1,
                                                    0,
                                                    false,
                                                    false
                                            ),
                                            1.0f
                                    )
                                    .build()
                    )
    );
    public static final Item MUSHROOM_BREW = new LeftoverFoodItem(
            new FabricItemSettings()
                    .group(MushroomModKt.getITEM_GROUP())
                    .maxCount(1)
                    .food(
                            new FoodComponent.Builder()
                                    .hunger(0)
                                    .saturationModifier(0.0f)
                                    .statusEffect(
                                            new StatusEffectInstance(
                                                    StatusEffects.INSTANT_HEALTH,
                                                    1,
                                                    0,
                                                    false,
                                                    false
                                            ),
                                            1.0f
                                    )

                                    .build()
                    ),
            Items.BUCKET
    );

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "painshroom"), PAINSHROOM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "mushroom_brew"), MUSHROOM_BREW);
    }
}
