package quartz.compiler.semantics.analyzer.function.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.analyzer.type.analyze
import quartz.compiler.semantics.analyzer.type.verifyAs
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.expression.VariableDeclaration

/**
 * Created by Aedan Smith.
 */

fun VariableDeclaration.analyze(
        blockBuilder: BlockBuilder,
        program: Program,
        programBuilder: ProgramBuilder
): VariableDeclaration {
    val analyzedType = varType?.analyze(blockBuilder.symbolTable, program, programBuilder)
    val newExpression = expression?.analyze(blockBuilder, program, programBuilder, analyzedType)
    val newType = analyzedType.verifyAs(newExpression?.type)

    return copy(expression = newExpression, varType = newType ?: throw QuartzException("Unknown type for $this"))
            .also {
                blockBuilder.symbolTable += it.name to it.varType!!
            }
}
