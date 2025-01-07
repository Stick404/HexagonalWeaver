package com.mindlesstoys.stick404.casting.logic;

import at.petrak.hexcasting.api.casting.eval.env.PackagedItemCastEnv;
import at.petrak.hexcasting.api.casting.eval.vm.CastingImage;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MediaDiscoveryHandler {
    //idk if I still need this class
    //but I'll keep it, just in case
    private static final List<Function<CastingImage, @Nullable PackagedItemCastEnv>> PACKAGED_HEX_DISCOVERERS = new ArrayList<>();
}
