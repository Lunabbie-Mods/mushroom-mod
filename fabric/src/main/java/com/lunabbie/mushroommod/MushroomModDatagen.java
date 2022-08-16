package com.lunabbie.mushroommod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Consumer;

public class MushroomModDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        dataGenerator.addProvider(RecipeProvider::new);
        dataGenerator.addProvider(ModelProvider::new);
        dataGenerator.addProvider(BlockLootTableProvider::new);
    }

    private static class RecipeProvider extends FabricRecipeProvider {
        public RecipeProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
            CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(ModItems.PAINSHROOM), Items.RED_MUSHROOM, 0.3f, 200).criterion("has_painshroom", RecipeProvider.conditionsFromItem(ModItems.PAINSHROOM)).offerTo(exporter);
        }
    }

    private static class ModelProvider extends FabricModelProvider {
        public ModelProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator generator) {
            generator.registerTintableCross(ModBlocks.PAINSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        }

        @Override
        public void generateItemModels(ItemModelGenerator generator) {
            generator.register(ModItems.MUSHROOM_BREW, new Model(Optional.of(new Identifier(MushroomMod.MODID, "item/generated")), Optional.empty(), TextureKey.LAYER0));
        }
    }

    private static class BlockLootTableProvider extends FabricBlockLootTableProvider {
        protected BlockLootTableProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateBlockLootTables() {
            addDrop(ModBlocks.PAINSHROOM, ModItems.PAINSHROOM);
        }
    }
}