package com.lunabbie.mushroommod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class LeftoverFoodItem extends Item {
    private final Item leftover;

    public LeftoverFoodItem(Settings settings, Item leftover) {
        super(settings);
        this.leftover = leftover;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        if (user instanceof PlayerEntity && ((PlayerEntity) user).getAbilities().creativeMode) {
            return itemStack;
        }
        return new ItemStack(leftover);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        if (leftover.equals(Items.BUCKET) || leftover.equals(Items.BOWL)) return UseAction.DRINK;
        else return super.getUseAction(stack);
    }

}
