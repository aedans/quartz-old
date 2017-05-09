package quartz.compiler.semantics.analyzer.function.expression

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.analyzer.function.analyze
import quartz.compiler.semantics.analyzer.type.analyze
import quartz.compiler.semantics.analyzer.type.asStruct
import quartz.compiler.semantics.analyzer.type.verifyAs
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.expression.MemberAccess
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun MemberAccess.analyze(
        blockBuilder: BlockBuilder,
        program: Program,
        programBuilder: ProgramBuilder,
        expected: Type?
): MemberAccess {
    val newExpression = expression.analyze(blockBuilder, program, programBuilder, null)
    val owner = newExpression.type.asStruct()?.analyze(blockBuilder.symbolTable, program, programBuilder)
            ?: throw QuartzException("${newExpression.type.asStruct()} is not a struct")
    val memberType = owner.members[name]?.type.verifyAs(expected)
            ?: throw QuartzException("Unknown member $owner.$type")

    return MemberAccess(name, newExpression, memberType)
}
