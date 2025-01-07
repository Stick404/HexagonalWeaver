package com.mindlesstoys.stick404.item;

import com.mindlesstoys.stick404.HexagonalWeaver;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class HexagonalWeaverItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(HexagonalWeaver.MOD_ID,Registries.ITEM);
    public static final RegistrySupplier<Item> MAGIC_CLOAK = ITEMS.register("magic_cloak",() -> new MagicCloakItem(new MagicCloakMaterial(), ArmorItem.Type.HELMET,new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static void init() {
        ITEMS.register();
    }
}
