package com.lunabbie.mushroommod

import com.lunabbie.mushroommod.items.groups.ModItemGroup
import net.minecraft.util.Identifier

const val MOD_ID = "mushroommod"
fun identifier(id: String) = Identifier.of(MOD_ID, id)

fun init() {
    ModItemGroup.registerAll()
    ModBlocks.register()
}

fun initClient() {
    ModBlocks.registerRendering()
}
