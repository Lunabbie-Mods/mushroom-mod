package com.lunabbie.mushroommod;

import com.lunabbie.mushroommod.items.MushroomBrew;
import com.lunabbie.mushroommod.items.Painshroom;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.lunabbie.mushroommod.MushroomModKt.MODID;


public class ModItems {
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "painshroom"), Painshroom.INSTANCE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "mushroom_brew"), MushroomBrew.INSTANCE);
    }
}
