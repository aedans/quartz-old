package quartz.compiler.generator.semantics

import quartz.compiler.errors.QuartzException
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.function.expression.*
import quartz.compiler.tree.function.statement.*
import quartz.compiler.tree.misc.InlineC

/**
 * Created by Aedan Smith.
 */

fun Program.simplify(): Program {
    return this.mapFunctionDeclarations(FunctionDeclaration::simplify)
}

private fun FunctionDeclaration.simplify(): FunctionDeclaration {
    val newStatements = mutableListOf<Statement>()
    block.statementList.forEach { newStatements.add(it.simplify(newStatements)) }
    return FunctionDeclaration(name, argNames, function, Block(newStatements))
}

private fun Statement.simplify(newStatements: MutableList<Statement>): Statement {
    return when (this) {
        is InlineC -> this
        is Break -> this
        is Continue -> this
        is PrefixUnaryOperator -> unwrap(newStatements)
        is PostfixUnaryOperator -> unwrap(newStatements)
        is VariableDeclaration -> VariableDeclaration(name, expression?.unwrap(newStatements), type, mutable)
        is ReturnStatement -> ReturnStatement(expression.unwrap(newStatements))
        is Assignment -> Assignment(lvalue, expression.unwrap(newStatements), id, type)
        is IfStatement -> IfStatement(
                test.unwrap(newStatements),
                Block(trueBlock.statementList.map { it.simplify(newStatements) }),
                Block(falseBlock.statementList.map { it.simplify(newStatements) })
        )
        is WhileLoop -> WhileLoop(
                test.unwrap(newStatements),
                Block(block.statementList.map { it.simplify(newStatements) })
        )
        is FunctionCall -> FunctionCall(
                expression.unwrap(newStatements),
                args.map { it.unwrap(newStatements) },
                type
        )
        else -> throw QuartzException("Expected statement, found $this")
    }
}

private fun Expression.unwrap(newStatements: MutableList<Statement>): Expression {
    return when (this) {
        is InlineC -> this
        is NumberLiteral -> this
        is StringLiteral -> this
        is Identifier -> this
        is Sizeof -> this
        is Cast -> Cast(expression.unwrap(newStatements), type)
        is PrefixUnaryOperator -> PrefixUnaryOperator(expression.unwrap(newStatements), id, type)
        is PostfixUnaryOperator -> PostfixUnaryOperator(expression.unwrap(newStatements), id, type)
        is BinaryOperator -> BinaryOperator(expr1.unwrap(newStatements), expr2.unwrap(newStatements), id, type)
        is Assignment -> Assignment(lvalue.unwrap(newStatements), expression.unwrap(newStatements), id, type)
        is FunctionCall -> FunctionCall(expression.unwrap(newStatements), args.map { it.unwrap(newStatements) }, type)
        is MemberAccess -> MemberAccess(name, expression.unwrap(newStatements), type)
        is IfExpression -> {
            val tempVarName = "temp${hashCode()}"
            newStatements.add(VariableDeclaration(tempVarName, null, type
                    ?: throw QuartzException("Unknown aliasedType for $this"), true))

            val trueStatements = mutableListOf<Statement>()
            trueStatements.add(Assignment(Identifier(tempVarName, emptyList(), type), ifTrue.unwrap(trueStatements), Assignment.ID.EQ, type))

            val falseStatements = mutableListOf<Statement>()
            falseStatements.add(Assignment(Identifier(tempVarName, emptyList(), type), ifFalse.unwrap(falseStatements), Assignment.ID.EQ, type))

            newStatements.add(IfStatement(
                    test,
                    Block(trueStatements),
                    Block(falseStatements)
            ))
            Identifier(tempVarName, emptyList(), type)
        }
        else -> throw QuartzException("Expected expression, found $this")
    }
}