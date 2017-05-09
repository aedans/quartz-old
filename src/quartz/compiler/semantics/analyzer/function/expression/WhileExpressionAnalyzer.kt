package quartz.compiler.semantics.analyzer.function.expression

import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.expression.BlockExpression
import quartz.compiler.tree.function.expression.WhileExpression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun WhileExpression.analyze(
        blockBuilder: BlockBuilder,
        program: Program,
        programBuilder: ProgramBuilder,
        expected: Type?
): WhileExpression {
    return WhileExpression(
            test.analyze(blockBuilder, program, programBuilder, Primitives.int),
            block.analyze(blockBuilder, program, programBuilder, expected) as BlockExpression
    )
}
