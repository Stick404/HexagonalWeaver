package com.mindlesstoys.stick404.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.mindlesstoys.stick404.HexagonalWeaver;

@Mod(HexagonalWeaver.MOD_ID)
public final class HexagonalWeaverForge {
    public HexagonalWeaverForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(HexagonalWeaver.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        HexagonalWeaver.init();
    }
}
