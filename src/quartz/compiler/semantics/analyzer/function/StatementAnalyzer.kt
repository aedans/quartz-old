package quartz.compiler.semantics.analyzer.function

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.analyzer.function.statement.analyze
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.function.statement.*

/**
 * Created by Aedan Smith.
 */

fun Statement.analyze(blockBuilder: BlockBuilder, program: Program, programBuilder: ProgramBuilder): Statement {
    return errorScope({ "statement $this" }) {
        when (this) {
            is VariableDeclaration -> analyze(blockBuilder, program, programBuilder)
            is ReturnStatement -> analyze(blockBuilder, program, programBuilder)
            is IfStatement -> analyze(blockBuilder, program, programBuilder)
            is WhileLoop -> analyze(blockBuilder, program, programBuilder)
            is Block -> analyze(blockBuilder.symbolTable, program, programBuilder)
            is Expression -> analyze(blockBuilder, program, programBuilder, null)
            else -> throw QuartzException("Expected statement, found $this")
        }
    }
}
