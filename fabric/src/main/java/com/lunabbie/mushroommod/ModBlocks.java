package com.lunabbie.mushroommod;

import com.lunabbie.mushroommod.blocks.PainshroomBlock;
import com.lunabbie.mushroommod.blocks.PottedPainshroomBlock;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.registry.Registry;

import static com.lunabbie.mushroommod.MushroomModKt.identifier;

public class ModBlocks {
    public static void register() {
        Registry.register(Registry.BLOCK, identifier("painshroom"), PainshroomBlock.INSTANCE);
        Registry.register(Registry.BLOCK, identifier("potted_painshroom"), PottedPainshroomBlock.INSTANCE);
    }

    public static void registerRendering() {
        BlockRenderLayerMap.INSTANCE.putBlock(PainshroomBlock.INSTANCE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PottedPainshroomBlock.INSTANCE, RenderLayer.getCutout());
    }
}
