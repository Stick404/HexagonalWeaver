package com.mindlesstoys.stick404.casting.arithmetic.actions

import at.petrak.hexcasting.api.casting.arithmetic.operator.OperatorBasic
import at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaMultiPredicate
import at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaPredicate
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.iota.PatternIota
import at.petrak.hexcasting.api.casting.math.HexPattern
import at.petrak.hexcasting.common.lib.hex.HexIotaTypes

object MergePatterns : OperatorBasic(2, IotaMultiPredicate.all(IotaPredicate.ofType(HexIotaTypes.PATTERN))) {
    override fun apply(iotas: Iterable<Iota>, env: CastingEnvironment): Iterable<Iota> {
        val out = mutableListOf<Iota>()
        val startIota = iotas.first()
        val extensionIota= iotas.last()
        if (startIota is PatternIota && extensionIota is PatternIota) {
            val startPattern = startIota.pattern
            val extensionPattern = extensionIota.pattern


            val endDir = startPattern.angles.fold(startPattern.startDir) { dir, angle -> dir.rotatedBy(angle) }
            val joinAngle = extensionPattern.startDir.angleFrom(endDir)

            val angles = (startPattern.angles + joinAngle + extensionPattern.angles).take(1600).toMutableList()
            out.add(0,PatternIota(HexPattern(startPattern.startDir,angles)))
            return out
        }
        else {
            return emptyList() //should *never* be reached. But just in case
        }
    }

}