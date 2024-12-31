package com.mindlesstoys.stick404.casting;

import at.petrak.hexcasting.api.casting.castables.Action;
import at.petrak.hexcasting.api.casting.ActionRegistryEntry;
import at.petrak.hexcasting.api.casting.castables.OperationAction;
import at.petrak.hexcasting.api.casting.math.HexDir;
import at.petrak.hexcasting.api.casting.math.HexPattern;
import at.petrak.hexcasting.common.lib.hex.HexActions;
import com.mindlesstoys.stick404.HexagonalWeaver;
import com.mindlesstoys.stick404.casting.actions.OpBreakPattern;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.core.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class PatternRegistry {
    public static final Logger LOGGER = LogManager.getLogger(HexagonalWeaver.MOD_ID);
    private static final Map<ResourceLocation, ActionRegistryEntry> PATTERNS = new LinkedHashMap<>();

    public static final HexPattern TEST_PATTERN = make("ede",HexDir.NORTH_WEST,"testpattern", OpTest.INSTANCE);
    public static final HexPattern BREAK_PATTERN = make("wddwdeqdwdqee",HexDir.NORTH_WEST,"breakpattern", OpBreakPattern.INSTANCE);

    public static void init() {
        for (Map.Entry<ResourceLocation, ActionRegistryEntry> entry : PATTERNS.entrySet()) {
            Registry.register(HexActions.REGISTRY, entry.getKey(), entry.getValue());
        }
    }

    //these 2 functions are taken from Complex Hex
    private static HexPattern make(String signature, HexDir dir, String name, Action act ) {
        PATTERNS.put(
                new ResourceLocation(HexagonalWeaver.MOD_ID, name),
                new ActionRegistryEntry(HexPattern.fromAngles(signature, dir), act)
        );
        return HexPattern.fromAngles(signature, dir);
    }
    private static HexPattern make(String signature, HexDir dir, String name) {
        HexPattern pattern = HexPattern.fromAngles(signature, dir);
        PATTERNS.put(
                new ResourceLocation(HexagonalWeaver.MOD_ID, name),
                new ActionRegistryEntry(pattern, new OperationAction(pattern))
        );
        return pattern;
    }
}
