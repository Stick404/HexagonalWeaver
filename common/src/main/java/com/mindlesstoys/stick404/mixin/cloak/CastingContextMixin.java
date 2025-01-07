package com.mindlesstoys.stick404.mixin.cloak;

import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import com.mindlesstoys.stick404.casting.ExtendedCastingContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = CastingEnvironment.class, priority = 10000)
public abstract class CastingContextMixin implements ExtendedCastingContext {
    @Unique
    private @Nullable ItemStack hexagonal_weaver$forcedCastingStack;
    @Unique
    private int hexagonal_weaver$reciprocationReps;

    @Unique
    @Override
    public @Nullable ItemStack hexagonal_weaver$getForcedCastingStack() {
        return hexagonal_weaver$forcedCastingStack;
    }

    @Unique
    @Override
    public void hexagonal_weaver$setForcedCastingStack(@Nullable ItemStack itemStack) {
        this.hexagonal_weaver$forcedCastingStack = itemStack;
    }

    @Override
    public int hexagonal_weaver$getReciprocationReps() {
        return hexagonal_weaver$reciprocationReps;
    }

    @Override
    public void hexagonal_weaver$setReciprocationReps(int reps) {
        this.hexagonal_weaver$reciprocationReps = reps;
    }
    @Shadow
    public abstract LivingEntity getCastingEntity();
}
