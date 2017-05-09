package quartz.compiler.semantics.analyzer.function.statement

import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.statement.WhileLoop

/**
 * Created by Aedan Smith.
 */

fun WhileLoop.analyze(blockBuilder: BlockBuilder, program: Program, programBuilder: ProgramBuilder): WhileLoop {
    return WhileLoop(
            test.analyze(blockBuilder, program, programBuilder, Primitives.int),
            block.analyze(blockBuilder.symbolTable, program, programBuilder)
    )
}
