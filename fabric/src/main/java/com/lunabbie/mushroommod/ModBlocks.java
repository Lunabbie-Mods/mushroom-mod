package com.lunabbie.mushroommod;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class ModBlocks {
    public static Block PAINSHROOM = new MushroomPlantBlock(AbstractBlock.Settings.of(Material.PLANT, MapColor.PINK).nonOpaque().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).postProcess((BlockState state, BlockView world, BlockPos pos) -> true), null);

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(MushroomMod.MODID, "painshroom"), PAINSHROOM);
    }
    public static void registerRendering() {
        BlockRenderLayerMap.INSTANCE.putBlock(PAINSHROOM, RenderLayer.getCutout());
    }
}
