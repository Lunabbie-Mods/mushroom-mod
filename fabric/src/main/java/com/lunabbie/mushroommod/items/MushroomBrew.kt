package com.lunabbie.mushroommod.items

import com.lunabbie.mushroommod.items.util.LeftoverFoodItem
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.FoodComponent
import net.minecraft.item.Items

object MushroomBrew : LeftoverFoodItem(
    FabricItemSettings()
        .maxCount(1)
        .food(
            FoodComponent.Builder()
                .hunger(0)
                .saturationModifier(0.0f)
                .statusEffect(
                    StatusEffectInstance(
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
)