package quartz.compiler.semantics.analyzer.function.statement

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.analyzer.type.analyze
import quartz.compiler.semantics.analyzer.type.verifyAs
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.statement.VariableDeclaration

/**
 * Created by Aedan Smith.
 */

fun VariableDeclaration.analyze(blockBuilder: BlockBuilder, program: Program, programBuilder: ProgramBuilder): VariableDeclaration {
    val newExpression = expression?.analyze(blockBuilder, program, programBuilder, null)
    val newType = type?.analyze(blockBuilder.symbolTable, program, programBuilder).verifyAs(newExpression?.type)

    return copy(expression = newExpression, type = newType ?: throw QuartzException("Unknown type for $this"))
            .also {
                blockBuilder.symbolTable += it.name to it.type!!
            }
}
