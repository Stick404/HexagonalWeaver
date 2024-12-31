package com.mindlesstoys.stick404.casting.arithmetic;

import at.petrak.hexcasting.api.casting.arithmetic.Arithmetic;
import at.petrak.hexcasting.common.lib.hex.HexArithmetics;
import com.mindlesstoys.stick404.HexagonalWeaver;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;

public class ArithmeticRegistry {
    public static final Logger LOGGER = LogManager.getLogger(HexagonalWeaver.MOD_ID);
    private static final Map<ResourceLocation, Arithmetic> ARITHMETICS = new LinkedHashMap<>();


    public static void init() {
        for (Map.Entry<ResourceLocation, Arithmetic> entry : ARITHMETICS.entrySet()) {
            Registry.register(HexArithmetics.REGISTRY, entry.getKey(), entry.getValue());
        }
    }

    public static PatternArithmetic PATTERN = make(PatternArithmetic.INSTANCE.arithName(), PatternArithmetic.INSTANCE);

    private static <T extends Arithmetic> T make(String name, T arithmetic) {
        var old = ARITHMETICS.put(new ResourceLocation(HexagonalWeaver.MOD_ID, name), arithmetic);
        if (old != null) {
            throw new IllegalArgumentException("Typo? Duplicate id " + name);
        }
        return arithmetic;
    }
}
