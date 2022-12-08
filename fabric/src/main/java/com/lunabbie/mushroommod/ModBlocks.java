package com.lunabbie.mushroommod;

import com.lunabbie.mushroommod.blocks.PainshroomBlock;
import com.lunabbie.mushroommod.blocks.PottedPainshroomBlock;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static com.lunabbie.mushroommod.MushroomModKt.identifier;

public class ModBlocks {
    public static void register() {
        Registry.register(Registries.BLOCK, identifier("painshroom"), PainshroomBlock.INSTANCE);
        Registry.register(Registries.BLOCK, identifier("potted_painshroom"), PottedPainshroomBlock.INSTANCE);
    }

    public static void registerRendering() {
        BlockRenderLayerMap.INSTANCE.putBlock(PainshroomBlock.INSTANCE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PottedPainshroomBlock.INSTANCE, RenderLayer.getCutout());
    }
}
