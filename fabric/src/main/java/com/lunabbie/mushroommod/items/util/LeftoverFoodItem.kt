package com.lunabbie.mushroommod.items.util

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.UseAction
import net.minecraft.world.World

open class LeftoverFoodItem(settings: Settings, private val leftover: Item) : Item(settings) {
    override fun finishUsing(stack: ItemStack, world: World, user: LivingEntity): ItemStack {
        val itemStack = super.finishUsing(stack, world, user)
        if (user is PlayerEntity && user.abilities.creativeMode) {
            return itemStack
        }
        return ItemStack(leftover)
    }
    override fun getUseAction(stack: ItemStack): UseAction = when (leftover) {
        Items.BUCKET -> UseAction.DRINK
        Items.BOWL -> UseAction.DRINK
        else -> super.getUseAction(stack)
    }
}
