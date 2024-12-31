package com.mindlesstoys.stick404.casting.actions

import at.petrak.hexcasting.api.casting.castables.ConstMediaAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.getPattern
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.iota.PatternIota
import at.petrak.hexcasting.api.casting.math.HexPattern

object OpBreakPattern : ConstMediaAction {
    override val argc = 1
    override fun execute(args: List<Iota>, env: CastingEnvironment): List<Iota> { //most of this code was taken from Hex Bound
        var pattern = args.getPattern(0, argc)
        var newStartDirt = pattern.angles.dropLast(1).fold(pattern.startDir) { dir, angle -> dir.rotatedBy(angle) }
        var newDirList = pattern.angles.dropLast(1)

        return listOf(
            PatternIota(HexPattern(pattern.startDir,newDirList.toMutableList())),
            PatternIota(HexPattern(newStartDirt))
        )
    }
}