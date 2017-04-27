package quartz.compiler.semantics.analyzer

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.function.expression.*
import quartz.compiler.tree.function.statement.*
import quartz.compiler.tree.misc.InlineC
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun FunctionDeclaration.simplify(): FunctionDeclaration {
    return errorScope({ "function $name"}) {
        val newStatements = mutableListOf<Statement>()
        val nameSupplier = (0..Integer.MAX_VALUE).iterator()
        block.statementList.forEach { newStatements.add(it.simplify(newStatements, nameSupplier)) }
        copy(block = Block(newStatements))
    }
}

private fun Statement.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): Statement {
    return errorScope({ "statement $this" }) {
        when (this) {
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
}

private fun VariableDeclaration.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): VariableDeclaration {
    return VariableDeclaration(name, expression?.simplify(newStatements, nameSupplier), type, mutable)
}

private fun ReturnStatement.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): ReturnStatement {
    return ReturnStatement(
            expression.simplify(newStatements, nameSupplier).toUniqueVariable(newStatements, nameSupplier)
    )
}

private fun IfStatement.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): IfStatement {
    val newTrueStatements = mutableListOf<Statement>()
    val newFalseStatements = mutableListOf<Statement>()
    trueBlock.statementList.forEach { newTrueStatements.add(it.simplify(newTrueStatements, nameSupplier)) }
    falseBlock.statementList.forEach { newFalseStatements.add(it.simplify(newFalseStatements, nameSupplier)) }
    return IfStatement(
            test.simplify(newStatements, nameSupplier).toUniqueVariable(newStatements, nameSupplier),
            Block(newTrueStatements),
            Block(newFalseStatements)
    )
}

private fun WhileLoop.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): WhileLoop {
    val newLoopStatements = mutableListOf<Statement>()
    val testIdentifier = test.toUniqueVariable(newLoopStatements, nameSupplier)
    newLoopStatements.add(IfStatement(
            PrefixUnaryOperator(testIdentifier, PrefixUnaryOperator.ID.INVERT, Primitives.int),
            Block(listOf(InlineC("break"))),
            Block(emptyList())
    ))
    block.statementList.forEach { newLoopStatements.add(it.simplify(newLoopStatements, nameSupplier)) }
    return WhileLoop(
            NumberLiteral("1", Primitives.int),
            Block(newLoopStatements)
    )
}

private fun Expression.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): Expression {
    return errorScope({ "expression $this" }) {
        when (this) {
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
            is Lambda -> simplify(newStatements, nameSupplier)
            else -> throw QuartzException("Unrecognized node $this")
        }
    }
}

private fun Cast.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): Cast {
    return Cast(
            expression.simplify(newStatements, nameSupplier).toUniqueVariable(newStatements, nameSupplier),
            type
    )
}

private fun PrefixUnaryOperator.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): PrefixUnaryOperator {
    return PrefixUnaryOperator(
            expression.simplify(newStatements, nameSupplier).toUniqueVariable(newStatements, nameSupplier),
            id,
            type
    )
}

private fun PostfixUnaryOperator.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): PostfixUnaryOperator {
    return PostfixUnaryOperator(
            expression.simplify(newStatements, nameSupplier).toUniqueVariable(newStatements, nameSupplier),
            id,
            type
    )
}

private fun BinaryOperator.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): BinaryOperator {
    return BinaryOperator(
            expr1.simplify(newStatements, nameSupplier).toUniqueVariable(newStatements, nameSupplier),
            expr2.simplify(newStatements, nameSupplier).toUniqueVariable(newStatements, nameSupplier),
            id,
            type
    )
}

private fun Assignment.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): Assignment {
    return Assignment(lvalue.simplify(newStatements, nameSupplier), expression.simplify(newStatements, nameSupplier), id, type)
}

private fun FunctionCall.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): FunctionCall {
    return FunctionCall(
            expression.simplify(newStatements, nameSupplier).toUniqueVariable(newStatements, nameSupplier),
            args.map { it.simplify(newStatements, nameSupplier) }.map { it.toUniqueVariable(newStatements, nameSupplier) },
            type
    )
}

private fun MemberAccess.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): MemberAccess {
    return MemberAccess(
            name,
            expression.simplify(newStatements, nameSupplier).toUniqueVariable(newStatements, nameSupplier),
            type
    )
}

private fun IfExpression.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): Expression {
    val identifier = uniqueVariable(type ?: throw QuartzException("Unknown type for $this"), newStatements, nameSupplier)

    val trueStatements = mutableListOf<Statement>()
    trueStatements.add(Assignment(identifier, ifTrue.simplify(trueStatements, nameSupplier), Assignment.ID.EQ, type))

    val falseStatements = mutableListOf<Statement>()
    falseStatements.add(Assignment(identifier, ifFalse.simplify(falseStatements, nameSupplier), Assignment.ID.EQ, type))

    newStatements.add(IfStatement(
            test,
            Block(trueStatements),
            Block(falseStatements)
    ).simplify(newStatements, nameSupplier))

    return identifier
}

private fun Lambda.simplify(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): Expression {
    val newLambdaStatements = mutableListOf<Statement>()
    block.statementList.forEach { newLambdaStatements.add(it.simplify(newStatements, nameSupplier)) }
    return Lambda(argNames, function, Block(newLambdaStatements))
}

private fun Expression.toUniqueVariable(newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): Expression {
    if (this is InlineC || this is Identifier)
        return this
    val tempVarName = "__${nameSupplier.next()}"
    newStatements.add(VariableDeclaration(tempVarName, this, type ?: throw QuartzException("Unknown type for $this"), true))
    return Identifier(tempVarName, emptyList(), type)
}

private fun uniqueVariable(type: Type, newStatements: MutableList<Statement>, nameSupplier: Iterator<Int>): Identifier {
    val tempVarName = "__${nameSupplier.next()}"
    newStatements.add(VariableDeclaration(tempVarName, null, type, true))
    return Identifier(tempVarName, emptyList(), type)
}
