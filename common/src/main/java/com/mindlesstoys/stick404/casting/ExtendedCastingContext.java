package com.mindlesstoys.stick404.casting;

import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Unique;

public interface ExtendedCastingContext {
    @Nullable ItemStack mediaworks$getForcedCastingStack();

    void hexagonal_weaver$setForcedCastingStack(@Nullable ItemStack itemStack);

    int hexagonal_weaver$getReciprocationReps();

    void hexagonal_weaver$setReciprocationReps(int reps);

    @Unique
    @Nullable ItemStack hexagonal_weaver$getForcedCastingStack();

    int mediaworks$getReciprocationReps();

    void mediaworks$setReciprocationReps(int reps);
}
