package com.lunabbie.mushroommod

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier


const val MODID = "mushroommod"
val ITEM_GROUP = FabricItemGroupBuilder.build(Identifier(MODID, "items")) { ItemStack(ModItems.PAINSHROOM) }
fun init() {
    ModItems.register()
    ModBlocks.register()
}

fun initClient() {
    ModBlocks.registerRendering()
}
