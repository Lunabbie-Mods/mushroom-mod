package com.lunabbie.mushroommod.items.groups

import com.lunabbie.mushroommod.items.MushroomBrew
import com.lunabbie.mushroommod.items.Painshroom

object MushroomItemGroup: ModItemGroup(key = "items", icon = { Painshroom.defaultStack }) {
    init {
        MushroomBrew registeredAs "mushroom_brew"
        Painshroom registeredAs "painshroom"
    }
}