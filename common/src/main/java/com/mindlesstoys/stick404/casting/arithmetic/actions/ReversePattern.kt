package com.mindlesstoys.stick404.casting.arithmetic.actions

import at.petrak.hexcasting.api.casting.arithmetic.operator.OperatorBasic
import at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaMultiPredicate
import at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaPredicate
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.iota.PatternIota
import at.petrak.hexcasting.api.casting.math.HexPattern
import at.petrak.hexcasting.common.lib.hex.HexIotaTypes

object ReversePattern : OperatorBasic(1, IotaMultiPredicate.all(IotaPredicate.ofType(HexIotaTypes.PATTERN))) {
    override fun apply(iotas: Iterable<Iota>, env: CastingEnvironment): Iterable<Iota> {
        val out = mutableListOf<Iota>()
        val startIota = iotas.first()
        if (startIota is PatternIota) {
            val patternNorm = startIota.pattern
            val patternRev = patternNorm.angles.reversed().toMutableList()
            var newStartDirt = patternNorm.angles.fold(patternNorm.startDir) { dir, angle -> dir.rotatedBy(angle) }

            out.add(0,PatternIota(HexPattern(newStartDirt, patternRev)))
            return out
        }
        else {
            return emptyList() //should *never* be reached. But just in case
        }
    }
}