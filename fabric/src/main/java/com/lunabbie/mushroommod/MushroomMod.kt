package com.lunabbie.mushroommod

import com.lunabbie.mushroommod.items.groups.ModItemGroup
import net.minecraft.util.Identifier

const val MODID = "mushroommod"
fun identifier(id: String) = Identifier.of(MODID, id)

fun init() {
    ModItemGroup.registerAll()
    ModBlocks.register()
}

fun initClient() {
    ModBlocks.registerRendering()
}
