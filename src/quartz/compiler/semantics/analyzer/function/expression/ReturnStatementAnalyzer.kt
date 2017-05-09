package quartz.compiler.semantics.analyzer.function.expression

import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.expression.ReturnExpression

/**
 * Created by Aedan Smith.
 */

fun ReturnExpression.analyze(
        blockBuilder: BlockBuilder,
        program: Program,
        programBuilder: ProgramBuilder
): ReturnExpression {
    return ReturnExpression(expression.analyze(blockBuilder, program, programBuilder, null))
}
