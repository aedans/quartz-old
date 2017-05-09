package quartz.compiler.semantics.analyzer.function.statement

import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.statement.ReturnStatement

/**
 * Created by Aedan Smith.
 */

fun ReturnStatement.analyze(blockBuilder: BlockBuilder, program: Program, programBuilder: ProgramBuilder): ReturnStatement {
    return ReturnStatement(expression.analyze(blockBuilder, program, programBuilder, null))
}
