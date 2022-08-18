package com.lunabbie.mushroommod.blocks

import net.minecraft.block.FlowerPotBlock
import net.minecraft.block.Material

object PottedPainshroomBlock : FlowerPotBlock(
    PainshroomBlock,
    Settings.of(Material.DECORATION).breakInstantly().nonOpaque()
)