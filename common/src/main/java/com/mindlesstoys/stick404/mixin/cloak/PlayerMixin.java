package com.mindlesstoys.stick404.mixin.cloak;

import org.spongepowered.asm.mixin.Shadow;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class PlayerMixin {
    @Shadow
    public abstract boolean isInvulnerableTo(DamageSource arg);

    @Unique
    private DamageSource lastSource;

    @Inject(method = "actuallyHurt", at = @At("HEAD"))
    private void captureDamageSource(DamageSource source, float amount, CallbackInfo ci) {
        this.lastSource = source;
    }

    //Media Shield
    //@ModifyVariable(method = "actuallyHurt", at = @At("HEAD"), index = 2, argsOnly = true)
    //private float getDamageAfterMagicAbsorb(float amount) {
    //    if (isInvulnerableTo(lastSource)) return amount;
    //    if (lastSource.isBypassMagic()) return amount;
    //    return MediaShieldEnchantment.processIncomingDamage((PlayerEntity) (Object) this, amount);
    //}

}
