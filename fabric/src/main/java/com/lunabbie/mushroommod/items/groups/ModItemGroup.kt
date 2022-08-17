package com.lunabbie.mushroommod.items.groups

import com.lunabbie.mushroommod.identifier
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.registry.Registry

abstract class ModItemGroup(val group: ItemGroup) {

    companion object {
        fun registerAll() {
            MushroomItemGroup
        }
    }

    constructor(key: String, icon: () -> ItemStack) : this(FabricItemGroupBuilder.build(
        identifier(key), icon))

    private val _items = mutableListOf<Item>()
    val items: List<Item> = _items

    infix fun <T: Item> T.registeredAs(id: String): T {
        Registry.register(Registry.ITEM, identifier(id), this)
        _items.add(this)
        this@registeredAs.group = this@ModItemGroup.group
        return this
    }
}