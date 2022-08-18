package com.lunabbie.mushroommod.mixin;

import com.lunabbie.mushroommod.items.Painshroom;
import net.minecraft.item.Items;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingRecipeRegistry.class)
public abstract class BrewingRecipeRegistryMixin {
    @Inject(method = "registerDefaults", at = @At("TAIL"))
    private static void addDragonBreathRecipe(CallbackInfo ci) {
        BrewingRecipeRegistry.registerItemRecipe(Items.SPLASH_POTION, Painshroom.INSTANCE, Items.LINGERING_POTION);
    }
}
