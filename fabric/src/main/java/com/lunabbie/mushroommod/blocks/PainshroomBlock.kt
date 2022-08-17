package com.lunabbie.mushroommod.blocks

import net.minecraft.block.MapColor
import net.minecraft.block.Material
import net.minecraft.block.MushroomPlantBlock
import net.minecraft.sound.BlockSoundGroup

object PainshroomBlock : MushroomPlantBlock(
    Settings.of(Material.PLANT, MapColor.PINK).nonOpaque().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)
        .postProcess { _, _, _ -> true }, null
)