package com.mindlesstoys.stick404;

import com.mindlesstoys.stick404.casting.PatternRegistry;
import com.mindlesstoys.stick404.casting.arithmetic.ArithmeticRegistry;
import com.mindlesstoys.stick404.item.HexagonalWeaverItems;

public final class HexagonalWeaver {
    public static final String MOD_ID = "hexagonal_weaver";

    public static void init() {
        // Write common init code here.
        PatternRegistry.init();
        ArithmeticRegistry.init();
        HexagonalWeaverItems.init();
    }
}
