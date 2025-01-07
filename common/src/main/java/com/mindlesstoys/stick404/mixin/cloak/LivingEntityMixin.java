package com.mindlesstoys.stick404.mixin.cloak;

import com.mindlesstoys.stick404.item.HexagonalWeaverItems;
import net.minecraft.world.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.world.entity.LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "getEquipmentSlotForItem", at = @At("HEAD"), cancellable = true)
    private static void injectCloakEquipmentSlot(net.minecraft.world.item.ItemStack itemStack, CallbackInfoReturnable<EquipmentSlot> cir) {
        if (itemStack.is(HexagonalWeaverItems.MAGIC_CLOAK.get())) cir.setReturnValue(EquipmentSlot.HEAD);
    }
}
