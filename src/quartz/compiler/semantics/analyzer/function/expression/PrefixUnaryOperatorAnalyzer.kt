package quartz.compiler.semantics.analyzer.function.expression

import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.expression.PrefixUnaryOperator
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun PrefixUnaryOperator.analyze(
        blockBuilder: BlockBuilder,
        program: Program,
        programBuilder: ProgramBuilder,
        expected: Type?
): PrefixUnaryOperator {
    val newExpression = expression.analyze(blockBuilder, program, programBuilder, expected)
    val newType = newExpression.type
    return PrefixUnaryOperator(newExpression, id, newType)
}
