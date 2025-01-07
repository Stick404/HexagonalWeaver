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
        val pattern = args.getPattern(0, argc)
        val patternAng = pattern.angles.dropLast(1)
        val newStartDirt = patternAng.fold(pattern.startDir) { dir, angle -> dir.rotatedBy(angle) }

        return listOf(
            PatternIota(HexPattern(pattern.startDir, patternAng.toMutableList())),
            PatternIota(HexPattern(newStartDirt))
        )
    }
}