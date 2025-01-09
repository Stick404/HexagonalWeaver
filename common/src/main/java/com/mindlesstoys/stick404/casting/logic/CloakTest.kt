package com.mindlesstoys.stick404.casting.logic

import at.petrak.hexcasting.api.casting.ParticleSpray
import at.petrak.hexcasting.api.casting.eval.vm.CastingVM
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.iota.PatternIota
import at.petrak.hexcasting.api.casting.math.HexPattern
import at.petrak.hexcasting.common.msgs.MsgNewSpiralPatternsS2C
import at.petrak.hexcasting.xplat.IXplatAbstractions
import com.mindlesstoys.stick404.casting.CloakCastEnv
import com.mindlesstoys.stick404.item.HexagonalWeaverItems
import com.mindlesstoys.stick404.item.MagicCloakItem
import com.mindlesstoys.stick404.mixin.cloak.PlayerMixin
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.phys.Vec3


class CloakTest {
    //I am going to scream :3
    fun cloakTest(item: ItemStack, player: PlayerMixin) {
        //this is *really* dumb
        //but the Compiler wants this method for compiling
        cloakRun(item,player as Player)
    }
    fun cloakTest(item: ItemStack, player: Player){
        //and this one for run time
        cloakRun(item,player)
    }

    private fun cloakRun(item: ItemStack, player: Player){
        if (item.`is`(HexagonalWeaverItems.MAGIC_CLOAK.get())){
            val hexItem = item.item as MagicCloakItem
            val sPlayer = player as ServerPlayer

            val instrs: List<Iota> = hexItem.getHex(item,sPlayer.serverLevel())!!
            val ctx = CloakCastEnv(sPlayer,null)
            var harness = CastingVM.empty(ctx)
            var clientView = harness.queueExecuteAndWrapIotas(instrs, sPlayer.serverLevel())

            //val patterns: List<HexPattern>? = instrs.stream()
            //    .filter { i -> i is PatternIota }
            //    .map { i -> (i as PatternIota).pattern }
            //    .toList()
            //val packet = MsgNewSpiralPatternsS2C(sPlayer.uuid, patterns, 140)
            //IXplatAbstractions.INSTANCE.sendPacketToPlayer(sPlayer, packet)
            //IXplatAbstractions.INSTANCE.sendPacketTracking(sPlayer, packet)


            if (clientView.resolutionType.success) { //clientView.resolutionType.success
                //gotten ItemPackagedHex#use
                //no clue if its needed...
                ParticleSpray(player.position(), Vec3(0.0, 1.5, 0.0), 0.4, Math.PI / 3, 30)
                    .sprayParticles(sPlayer.serverLevel(), ctx.pigment)
            }
        }
    }
}