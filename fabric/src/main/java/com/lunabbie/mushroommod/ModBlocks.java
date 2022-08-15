package com.lunabbie.mushroommod;

import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class ModBlocks {
    public static Block PAINSHROOM = new MushroomPlantBlock(AbstractBlock.Settings.of(Material.PLANT, MapColor.PINK).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).postProcess((BlockState state, BlockView world, BlockPos pos) -> true), null);

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(MushroomMod.MODID, "painshroom"), PAINSHROOM);
    }
}
