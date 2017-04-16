package quartz.compiler.semantics

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

fun Program.simplify(): Program {
    return this.mapFunctionDeclarations(FunctionDeclaration::simplify)
}

private fun FunctionDeclaration.simplify(): FunctionDeclaration {
    val newStatements = mutableListOf<Statement>()
    val nameSupplier = (0..Integer.MAX_VALUE).iterator()
    statements.forEach { newStatements.add(it.simplify(newStatements, nameSupplier)) }
    return FunctionDeclaration(name, argNames, function, newStatements)
}

private fun Statement.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): Statement {
    return when (this) {
        is InlineC -> this
        is PrefixUnaryOperator -> simplify(newStatements, nameSupplier)
        is PostfixUnaryOperator -> simplify(newStatements, nameSupplier)
        is VariableDeclaration -> simplify(newStatements, nameSupplier)
        is ReturnStatement -> simplify(newStatements, nameSupplier)
        is Assignment -> simplify(newStatements, nameSupplier)
        is IfStatement -> simplify(newStatements, nameSupplier)
        is WhileLoop -> simplify(newStatements, nameSupplier)
        is FunctionCall -> simplify(newStatements, nameSupplier)
        else -> throw QuartzException("Unrecognized node $this")
    }
}

private fun VariableDeclaration.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): VariableDeclaration {
    return VariableDeclaration(name, expression?.simplify(newStatements, nameSupplier), type, mutable)
}

private fun ReturnStatement.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): ReturnStatement {
    return ReturnStatement(expression.simplify(newStatements, nameSupplier))
}

private fun IfStatement.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): IfStatement {
    return IfStatement(
            test.simplify(newStatements, nameSupplier),
            trueStatements.map { it.simplify(newStatements, nameSupplier) },
            falseStatements.map { it.simplify(newStatements, nameSupplier) }
    )
}

private fun WhileLoop.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): WhileLoop {
    return WhileLoop(
            test.simplify(newStatements, nameSupplier),
            statements.map { it.simplify(newStatements, nameSupplier) }
    )
}

private fun Expression.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): Expression {
    return when (this) {
        is InlineC -> this
        is NumberLiteral -> this
        is StringLiteral -> this
        is Identifier -> this
        is Sizeof -> this
        is Cast -> simplify(newStatements, nameSupplier)
        is PrefixUnaryOperator -> simplify(newStatements, nameSupplier)
        is PostfixUnaryOperator -> simplify(newStatements, nameSupplier)
        is BinaryOperator -> simplify(newStatements, nameSupplier)
        is Assignment -> simplify(newStatements, nameSupplier)
        is FunctionCall -> simplify(newStatements, nameSupplier)
        is MemberAccess -> simplify(newStatements, nameSupplier)
        is IfExpression -> simplify(newStatements, nameSupplier)
        else -> throw QuartzException("Unrecognized node $this")
    }
}

fun Cast.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): Cast {
    return Cast(expression.simplify(newStatements, nameSupplier), type)
}

fun PrefixUnaryOperator.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): PrefixUnaryOperator {
    return PrefixUnaryOperator(expression.simplify(newStatements, nameSupplier), id, type)
}

fun PostfixUnaryOperator.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): PostfixUnaryOperator {
    return PostfixUnaryOperator(expression.simplify(newStatements, nameSupplier), id, type)
}

fun BinaryOperator.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): BinaryOperator {
    return BinaryOperator(expr1.simplify(newStatements, nameSupplier), expr2.simplify(newStatements, nameSupplier), id, type)
}

fun Assignment.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): Assignment {
    return Assignment(lvalue.simplify(newStatements, nameSupplier), expression.simplify(newStatements, nameSupplier), id, type)
}

fun FunctionCall.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): FunctionCall {
    return FunctionCall(expression.simplify(newStatements, nameSupplier), templates, args.map { it.simplify(newStatements, nameSupplier) }, type)
}

fun MemberAccess.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): MemberAccess {
    return MemberAccess(name, expression.simplify(newStatements, nameSupplier), type)
}

fun IfExpression.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): Identifier {
    val tempVarName = "_${nameSupplier.next()}"
    newStatements.add(VariableDeclaration(tempVarName, null, type
            ?: throw QuartzException("Unknown type for $this"), true))

    val trueStatements = mutableListOf<Statement>()
    trueStatements.add(Assignment(Identifier(tempVarName, type), ifTrue.simplify(trueStatements, nameSupplier), Assignment.ID.EQ, type))

    val falseStatements = mutableListOf<Statement>()
    falseStatements.add(Assignment(Identifier(tempVarName, type), ifFalse.simplify(falseStatements, nameSupplier), Assignment.ID.EQ, type))

    newStatements.add(IfStatement(
            test,
            trueStatements,
            falseStatements
    ))

    return Identifier(tempVarName, type)
}
