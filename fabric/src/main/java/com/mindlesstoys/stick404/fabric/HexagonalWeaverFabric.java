package com.mindlesstoys.stick404.fabric;

import net.fabricmc.api.ModInitializer;

import com.mindlesstoys.stick404.HexagonalWeaver;

public final class HexagonalWeaverFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        HexagonalWeaver.init();
    }
}
