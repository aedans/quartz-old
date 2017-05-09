package quartz.compiler.semantics.analyzer.function.expression

import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.symboltable.localSymboltable
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.expression.BlockExpression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun BlockExpression.analyze(
        blockBuilder: BlockBuilder,
        program: Program,
        programBuilder: ProgramBuilder,
        expected: Type?
): BlockExpression {
    return analyzeExpressions(blockBuilder, program, programBuilder, expected)
}

fun BlockExpression.analyzeExpressions(
        blockBuilder: BlockBuilder,
        program: Program,
        programBuilder: ProgramBuilder,
        @Suppress("UNUSED_PARAMETER") expected: Type?
): BlockExpression {
    return if (expressionList.isEmpty())
        this
    else {
        val localBlockBuilder = BlockBuilder(blockBuilder.symbolTable.localSymboltable())
        BlockExpression(expressionList.map { it.analyze(localBlockBuilder, program, programBuilder, null) })
    }
}
