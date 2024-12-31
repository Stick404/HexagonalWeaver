package com.mindlesstoys.stick404.casting

import at.petrak.hexcasting.api.casting.castables.ConstMediaAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.iota.PatternIota
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern

object OpTest : ConstMediaAction {
    override val argc: Int = 0
    override fun execute(args: List<Iota>, env: CastingEnvironment): List<Iota> {
        return listOf(PatternIota(HexPattern.fromAngles("wew", HexDir.WEST)))
    }
}