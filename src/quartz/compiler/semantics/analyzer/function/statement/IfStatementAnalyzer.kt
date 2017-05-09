package quartz.compiler.semantics.analyzer.function.statement

import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.statement.IfStatement

/**
 * Created by Aedan Smith.
 */

fun IfStatement.analyze(blockBuilder: BlockBuilder, program: Program, programBuilder: ProgramBuilder): IfStatement {
    return IfStatement(
            test.analyze(blockBuilder, program, programBuilder, Primitives.int),
            trueBlock.analyze(blockBuilder.symbolTable, program, programBuilder),
            falseBlock.analyze(blockBuilder.symbolTable, program, programBuilder)
    )
}
