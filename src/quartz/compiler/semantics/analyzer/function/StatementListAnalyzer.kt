package quartz.compiler.semantics.analyzer.function

import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.Statement

/**
 * Created by Aedan Smith.
 */

fun List<Statement>.analyze(blockBuilder: BlockBuilder, program: Program, programBuilder: ProgramBuilder): List<Statement> {
    return map { it.analyze(blockBuilder, program, programBuilder) }
}
