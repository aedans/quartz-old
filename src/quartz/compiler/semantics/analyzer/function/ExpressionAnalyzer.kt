package quartz.compiler.semantics.analyzer.function

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.analyzer.function.expression.analyze
import quartz.compiler.semantics.types.AliasedType
import quartz.compiler.semantics.types.ConstType
import quartz.compiler.semantics.util.BlockBuilder
import quartz.compiler.semantics.util.ProgramBuilder
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.expression.*
import quartz.compiler.tree.misc.InlineC
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun Expression.analyze(blockBuilder: BlockBuilder, program: Program, programBuilder: ProgramBuilder, expected: Type?): Expression {
    return errorScope({ "expression $this" }) {
        when (this) {
            is InlineC -> this
            is NumberLiteral -> this
            is StringLiteral -> this
            is Identifier -> analyze(blockBuilder, program, programBuilder)
            is Sizeof -> analyze(blockBuilder.symbolTable, program, programBuilder)
            is Cast -> analyze(blockBuilder, program, programBuilder)
            is ReturnExpression -> analyze(blockBuilder, program, programBuilder)
            is PrefixUnaryOperator -> analyze(blockBuilder, program, programBuilder, expected)
            is PostfixUnaryOperator -> analyze(blockBuilder, program, programBuilder, expected)
            is BinaryOperator -> analyze(blockBuilder, program, programBuilder, expected)
            is Assignment -> analyze(blockBuilder, program, programBuilder, expected)
            is FunctionCall -> analyze(blockBuilder, program, programBuilder)
            is MemberAccess -> analyze(blockBuilder, program, programBuilder, expected)
            is IfExpression -> analyze(blockBuilder, program, programBuilder, expected)
            is WhileExpression -> analyze(blockBuilder, program, programBuilder, expected)
            is VariableDeclaration -> analyze(blockBuilder, program, programBuilder)
            is BlockExpression -> analyze(blockBuilder, program, programBuilder, expected)
            is Lambda -> analyze(blockBuilder, program, programBuilder, expected)
            else -> throw QuartzException("Expected expression, found $this")
        }.verifyAs(expected)
    }
}

fun Expression.verifyAs(type: Type?): Expression {
    return when {
        this.type == null -> this.withType(type)
        type == null || this.type!!.isEqualTo(type) -> this
        this.type?.isInstance(type) ?: true -> Cast(this, type)
        type is AliasedType -> this.verifyAs(type.type)
        type is ConstType && type.type.isInstance(this.type!!) -> this.verifyAs(type.type)
        else -> throw QuartzException("Could not cast $this (${this.type}) to $type")
    }
}

