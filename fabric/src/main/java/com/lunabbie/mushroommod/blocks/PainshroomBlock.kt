package com.lunabbie.mushroommod.blocks

import net.minecraft.block.BlockState
import net.minecraft.block.MapColor
import net.minecraft.block.Material
import net.minecraft.block.MushroomPlantBlock
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView

object PainshroomBlock : MushroomPlantBlock(
    Settings.of(Material.PLANT, MapColor.PINK).nonOpaque().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)
        .postProcess { state: BlockState?, world: BlockView?, pos: BlockPos? -> true }, null
)