package com.lunabbie.mushroommod.mixin;

import com.lunabbie.mushroommod.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.AttackGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.MobEntity;
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
            this.goalSelector.add(8, new MeleeAttackGoal(this, 1.0f, false));
            this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
            cir.setReturnValue(ActionResult.success(this.world.isClient));
        }
    }
}
