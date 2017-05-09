package quartz.compiler.semantics.analyzer.function.expression

import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.analyzer.type.analyze
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.expression.Cast

/**
 * Created by Aedan Smith.
 */

fun Cast.analyze(
        blockBuilder: BlockBuilder,
        program: Program,
        programBuilder: ProgramBuilder
): Cast {
    val newType = type.analyze(blockBuilder.symbolTable, program, programBuilder)
    val newExpression = expression.analyze(blockBuilder, program, programBuilder, type)
    return Cast(newExpression, newType)
}
