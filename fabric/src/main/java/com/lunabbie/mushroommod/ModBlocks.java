package com.lunabbie.mushroommod;

import com.lunabbie.mushroommod.blocks.PainshroomBlock;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.lunabbie.mushroommod.MushroomModKt.MODID;

public class ModBlocks {
    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(MODID, "painshroom"), PainshroomBlock.INSTANCE);
    }
    public static void registerRendering() {
        BlockRenderLayerMap.INSTANCE.putBlock(PainshroomBlock.INSTANCE, RenderLayer.getCutout());
    }
}
