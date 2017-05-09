package quartz.compiler.semantics.analyzer.function.expression

import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.expression.Assignment
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun Assignment.analyze(
        blockBuilder: BlockBuilder,
        program: Program,
        programBuilder: ProgramBuilder,
        expected: Type?
): Assignment {
    val newLValue = lvalue.analyze(blockBuilder, program, programBuilder, null)
    val newExpression = expression.analyze(blockBuilder, program, programBuilder, expected)
    val newType = newExpression.type
    return Assignment(newLValue, newExpression, id, newType)
}
