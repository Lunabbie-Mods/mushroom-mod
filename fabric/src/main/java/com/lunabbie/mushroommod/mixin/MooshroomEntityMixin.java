package com.lunabbie.mushroommod.mixin;

import com.lunabbie.mushroommod.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MooshroomEntity.class)
public abstract class MooshroomEntityMixin extends CowEntity {
    public MooshroomEntityMixin(EntityType<? extends CowEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "interactMob", at = @At("TAIL"), cancellable = true)
    private void addPainshroomInteraction(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(ModItems.PAINSHROOM) && !this.isBaby()) {
            ItemStack handStack = player.getStackInHand(hand);
            if (!player.getAbilities().creativeMode) {
                handStack.decrement(1);
            }
            // TODO do something
            cir.setReturnValue(ActionResult.success(this.world.isClient));
        }
    }
}
