package com.lunabbie.mushroommod.items

import com.lunabbie.mushroommod.ITEM_GROUP
import com.lunabbie.mushroommod.blocks.PainshroomBlock
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.BlockItem
import net.minecraft.item.FoodComponent

object Painshroom : BlockItem(
    PainshroomBlock,
    FabricItemSettings()
        .group(ITEM_GROUP)
        .food(
            FoodComponent.Builder()
                .hunger(0)
                .saturationModifier(0.0f)
                .alwaysEdible()
                .statusEffect(
                    StatusEffectInstance(
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
)