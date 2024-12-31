package com.mindlesstoys.stick404.casting.arithmetic

import at.petrak.hexcasting.api.casting.arithmetic.Arithmetic
import at.petrak.hexcasting.api.casting.arithmetic.Arithmetic.*
import at.petrak.hexcasting.api.casting.arithmetic.engine.InvalidOperatorException
import at.petrak.hexcasting.api.casting.arithmetic.operator.Operator
import at.petrak.hexcasting.api.casting.arithmetic.operator.Operator.Companion.downcast
import at.petrak.hexcasting.api.casting.arithmetic.operator.OperatorBinary
import at.petrak.hexcasting.api.casting.arithmetic.operator.OperatorUnary
import at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaMultiPredicate
import at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaPredicate
import at.petrak.hexcasting.api.casting.iota.DoubleIota
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.iota.PatternIota
import at.petrak.hexcasting.api.casting.math.HexPattern
import at.petrak.hexcasting.common.lib.hex.HexIotaTypes
import at.petrak.hexcasting.common.lib.hex.HexIotaTypes.PATTERN
import com.mindlesstoys.stick404.casting.arithmetic.actions.MergePatterns
import com.mindlesstoys.stick404.casting.arithmetic.actions.ReversePattern
import java.util.function.BinaryOperator
import java.util.function.UnaryOperator
import java.util.regex.Pattern

object PatternArithmetic : Arithmetic {
    private val ACCEPTS: IotaMultiPredicate = IotaMultiPredicate.all(IotaPredicate.ofType(PATTERN))
    private val OPS = listOf(
        ADD,
        ABS,
        REV
    )
    override fun arithName() = "pattern_ops"

    override fun opTypes() = OPS

    override fun getOperator(pattern: HexPattern): Operator {
        return when (pattern) {
            ADD -> MergePatterns
            ABS -> make        { a -> (a.pattern.angles.size + 1).toDouble() }
            REV -> ReversePattern
            else -> throw InvalidOperatorException("$pattern is not a valid operator in Arithmetic $this.")
        }
    } //I have no clue what anything in here does. And if I do, one day, understand, I will fear that later person

    //private fun make(op: UnaryOperator<HexPattern>): OperatorUnary = OperatorUnary(ACCEPTS)
    //{ i: Iota -> PatternIota(
    //    op.apply(downcast(i, PATTERN).pattern)
    //    )
    //}
    fun make(op: (PatternIota) -> (Double)) = OperatorUnary(ACCEPTS)
    {i: Iota -> DoubleIota(op(downcast(i, PATTERN))) }
}