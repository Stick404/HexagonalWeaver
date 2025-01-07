package com.mindlesstoys.stick404.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class MagicCloakMaterial implements ArmorMaterial {
    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return 432; // like elytra
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return 0; // "not armor"
    }

    @Override
    public int getEnchantmentValue() {
        return 25; // like gold
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_LEATHER; //TODO: Make a new sound for this, maybe
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    @Override
    public String getName() {
        return "magic_cloak";
    }

    @Override
    public float getToughness() {
        return 0; // "not armor"
    }

    @Override
    public float getKnockbackResistance() {
        return 0; // "not armor"
    }
}
