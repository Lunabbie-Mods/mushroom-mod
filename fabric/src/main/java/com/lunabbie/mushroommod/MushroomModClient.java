package com.lunabbie.mushroommod;

import net.fabricmc.api.ClientModInitializer;

public class MushroomModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModBlocks.registerRendering();
    }
}
