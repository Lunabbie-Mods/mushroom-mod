package com.lunabbie.mushroommod.items.groups

import com.lunabbie.mushroommod.identifier
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry

abstract class ModItemGroup(val group: ItemGroup) {

    companion object {
        fun registerAll() {
            MushroomItemGroup
        }
    }

    constructor(key: String, icon: () -> ItemStack) : this(FabricItemGroup.builder(
        identifier(key)).icon(icon).build())

    private val _items = mutableListOf<Item>()
    val items: List<Item> = _items

    infix fun <T: Item> T.registeredAs(id: String): T {
        Registry.register(Registries.ITEM, identifier(id), this)
        _items.add(this)
        this@registeredAs.group = this@ModItemGroup.group
        return this
    }
}