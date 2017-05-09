@file:Suppress("UnusedImport")

package quartz.compiler.semantics.analyzer.function.expression

import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.analyzer.function.expression.analyze
import quartz.compiler.semantics.analyzer.type.verifyAs
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.expression.IfExpression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun IfExpression.analyze(
        blockBuilder: BlockBuilder,
        program: Program,
        programBuilder: ProgramBuilder,
        expected: Type?
): IfExpression {
    return analyzeTypes(blockBuilder, program, programBuilder, expected)
}

fun IfExpression.analyzeTypes(
        blockBuilder: BlockBuilder,
        program: Program,
        programBuilder: ProgramBuilder,
        expected: Type?
): IfExpression {
    val newTest = test.analyze(blockBuilder, program, programBuilder, Primitives.int)
    val newIfTrue = ifTrue.analyze(blockBuilder, program, programBuilder, expected)
    val newIfFalse = ifFalse.analyze(blockBuilder, program, programBuilder, expected)
    val newType = newIfTrue.type.verifyAs(newIfFalse.type)
    return IfExpression(newTest, newIfTrue, newIfFalse, newType)
}
