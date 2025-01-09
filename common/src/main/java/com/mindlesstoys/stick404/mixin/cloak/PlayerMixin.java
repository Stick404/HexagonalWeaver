package com.mindlesstoys.stick404.mixin.cloak;

import at.petrak.hexcasting.api.HexAPI;
import at.petrak.hexcasting.common.lib.HexDamageTypes;
import at.petrak.hexcasting.datagen.tag.HexDamageTypeTagProvider;
import com.mindlesstoys.stick404.casting.logic.CloakTest;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Shadow;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin {
    @Shadow
    public abstract boolean isInvulnerableTo(DamageSource arg);

    @Shadow public abstract Iterable<ItemStack> getArmorSlots();

    //@Inject(method = "actuallyHurt", at = @At("HEAD"))
    //private void captureDamageSource(DamageSource source, float amount, CallbackInfo ci) {
    //    this.hexagonal_weaver$lastSource = source;
    //}

    @Inject(method = "hurt", at = @At("HEAD"))
    private void runCloackCheck(DamageSource damageSource, float f, CallbackInfoReturnable<Boolean> cir){
        if(!damageSource.is(HexDamageTypes.OVERCAST)) { //so we dont crash the game
            Iterable<ItemStack> x = this.getArmorSlots();
            x.forEach(armor -> new CloakTest().cloakTest(armor, this));
        }
    }

    //Media Shield
    //@ModifyVariable(method = "actuallyHurt", at = @At("HEAD"), index = 2, argsOnly = true)
    //private float getDamageAfterMagicAbsorb(float amount) {
    //    if (isInvulnerableTo(lastSource)) return amount;
    //    if (lastSource.isBypassMagic()) return amount;
    //    return MediaShieldEnchantment.processIncomingDamage((PlayerEntity) (Object) this, amount);
    //}

}
