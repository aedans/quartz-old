package quartz.compiler.generator.semantics

import quartz.compiler.exceptions.QuartzException
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

fun Program.unwrapExpressions(): Program {
    return this.mapFnDeclarations(FunctionDeclaration::unwrapExpressions)
}

private fun FunctionDeclaration.unwrapExpressions(): FunctionDeclaration {
    val newStatements = mutableListOf<Statement>()
    statements.forEach { newStatements.add(it.unwrapExpressions(newStatements)) }
    return FunctionDeclaration(name, argNames, function, newStatements)
}

private fun Statement.unwrapExpressions(newStatements: MutableList<Statement>): Statement {
    return when (this) {
        is InlineC -> this
        is VariableDeclaration -> VariableDeclaration(name, expression?.unwrap(newStatements), type, mutable)
        is ReturnStatement -> ReturnStatement(expression.unwrap(newStatements))
        is VariableAssignment -> VariableAssignment(name, expression.unwrap(newStatements))
        is IfStatement -> IfStatement(
                test.unwrap(newStatements),
                trueStatements.map { it.unwrapExpressions(newStatements) },
                falseStatements.map { it.unwrapExpressions(newStatements) }
        )
        is WhileLoop -> WhileLoop(
                test.unwrap(newStatements),
                statements.map { it.unwrapExpressions(newStatements) }
        )
        is FunctionCall -> FunctionCall(
                expression.unwrap(newStatements),
                templates,
                expressions.map { it.unwrap(newStatements) },
                type
        )
        else -> throw QuartzException("Unrecognized node $this")
    }
}

private fun Expression.unwrap(newStatements: MutableList<Statement>): Expression {
    return when (this) {
        is InlineC -> this
        is NumberLiteral -> this
        is StringLiteral -> this
        is Identifier -> this
        is Cast -> Cast(expression.unwrap(newStatements), type)
        is UnaryOperator -> UnaryOperator(expression.unwrap(newStatements), id, type)
        is BinaryOperator -> BinaryOperator(expr1.unwrap(newStatements), expr2.unwrap(newStatements), id, type)
        is FunctionCall -> FunctionCall(expression.unwrap(newStatements), templates, expressions.map { it.unwrap(newStatements) }, type)
        is MemberAccess -> MemberAccess(name, expression.unwrap(newStatements), type)
        is IfExpression -> {
            val tempVarName = "temp${hashCode()}"
            newStatements.add(VariableDeclaration(tempVarName, null, type
                    ?: throw QuartzException("Unknown aliasedType for $this"), true))

            val trueStatements = mutableListOf<Statement>()
            trueStatements.add(VariableAssignment(tempVarName, ifTrue.unwrap(trueStatements)))

            val falseStatements = mutableListOf<Statement>()
            falseStatements.add(VariableAssignment(tempVarName, ifFalse.unwrap(falseStatements)))

            newStatements.add(IfStatement(
                    test,
                    trueStatements,
                    falseStatements
            ))
            Identifier(tempVarName, type)
        }
        else -> throw QuartzException("Unrecognized node $this")
    }
}
