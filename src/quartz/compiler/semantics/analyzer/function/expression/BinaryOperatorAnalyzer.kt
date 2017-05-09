package quartz.compiler.semantics.analyzer.function.expression

import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.analyzer.type.verifyAs
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.expression.BinaryOperator
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun BinaryOperator.analyze(
        blockBuilder: BlockBuilder,
        program: Program,
        programBuilder: ProgramBuilder,
        expected: Type?
): BinaryOperator {
    val newExpr1 = expr1.analyze(blockBuilder, program, programBuilder, expected)
    val newExpr2 = expr2.analyze(blockBuilder, program, programBuilder, expected)
    val newType = newExpr1.type.verifyAs(newExpr2.type).verifyAs(expected)
    return BinaryOperator(newExpr1, newExpr2, id, newType)
}
