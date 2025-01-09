package com.mindlesstoys.stick404.casting;

import at.petrak.hexcasting.api.HexAPI;
import at.petrak.hexcasting.api.casting.eval.CastResult;
import at.petrak.hexcasting.api.casting.eval.env.PackagedItemCastEnv;
import at.petrak.hexcasting.api.casting.eval.env.PlayerBasedCastEnv;
import at.petrak.hexcasting.api.casting.iota.PatternIota;
import at.petrak.hexcasting.api.pigment.FrozenPigment;
import at.petrak.hexcasting.common.msgs.MsgNewSpiralPatternsS2C;
import at.petrak.hexcasting.xplat.IXplatAbstractions;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;

import java.util.List;

public class CloakCastEnv extends PlayerBasedCastEnv {

    public CloakCastEnv(ServerPlayer caster, InteractionHand castingHand) {
        super(caster, castingHand);
    }

    @Override
    public void postExecution(CastResult result) {
        super.postExecution(result);
    }

    @Override
    public long extractMediaEnvironment(long cost, boolean simulate) {
        if (this.caster.isCreative())
            return 0;

        var canOvercast = this.canOvercast();
        return this.extractMediaFromInventory(cost, canOvercast, simulate);
    }

    @Override
    public InteractionHand getCastingHand() {
        return this.castingHand;
    }

    @Override
    public FrozenPigment getPigment() {
        return HexAPI.instance().getColorizer(this.caster);
    }
}
