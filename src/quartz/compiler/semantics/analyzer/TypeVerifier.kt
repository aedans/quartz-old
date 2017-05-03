package quartz.compiler.semantics.analyzer

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.resolveDotNotation
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.symboltable.addTo
import quartz.compiler.semantics.symboltable.localSymbolTable
import quartz.compiler.semantics.types.AliasedType
import quartz.compiler.semantics.types.ConstType
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.StructType
import quartz.compiler.semantics.verifyReturnType
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

fun FunctionDeclaration.verify(symbolTable: SymbolTable): FunctionDeclaration {
    return errorScope({ "function $name" }) {
        copy(block = block.verify(localSymbolTable(symbolTable)))
    }
}

private fun Statement.verify(symbolTable: SymbolTable): Statement {
    return errorScope({ "statement $this" }) {
        when (this) {
            is InlineC -> this
            is PrefixUnaryOperator -> verify(symbolTable, null)
            is PostfixUnaryOperator -> verify(symbolTable, null)
            is FunctionCall -> verify(symbolTable, null)
            is Assignment -> verify(symbolTable, null)
            is VariableDeclaration -> verify(symbolTable)
            is ReturnStatement -> verify(symbolTable)
            is IfStatement -> verify(symbolTable)
            is WhileLoop -> verify(symbolTable)
            is Block -> verify(symbolTable)
            else -> throw QuartzException("Expected statement, found $this")
        }
    }
}

private fun VariableDeclaration.verify(symbolTable: SymbolTable): VariableDeclaration {
    val newExpression = expression?.verify(symbolTable, type)

    return VariableDeclaration(
            name,
            newExpression,
            type.verifyAs(newExpression?.type),
            mutable
    ).apply { addTo(symbolTable) }
}

private fun ReturnStatement.verify(symbolTable: SymbolTable): ReturnStatement {
    return ReturnStatement(expression.verify(symbolTable, null))
}

private fun IfStatement.verify(symbolTable: SymbolTable): IfStatement {
    return IfStatement(
            test.verify(symbolTable, null),
            trueBlock.verify(symbolTable.localSymbolTable()),
            falseBlock.verify(symbolTable.localSymbolTable())
    )
}

private fun WhileLoop.verify(symbolTable: SymbolTable): WhileLoop {
    val localSymbolTable = symbolTable.localSymbolTable()
    return WhileLoop(
            test.verify(symbolTable, null),
            block.verify(localSymbolTable)
    )
}

private fun Block.verify(symbolTable: SymbolTable): Block {
    return Block(statementList.map { it.verify(symbolTable) })
}

private fun Expression.verify(symbolTable: SymbolTable, expected: Type?): Expression {
    return errorScope({ "expression $this" }) {
        when (this) {
            is InlineC -> verifyAs(expected)
            is NumberLiteral -> verifyAs(expected)
            is StringLiteral -> verifyAs(expected)
            is Sizeof -> verifyAs(expected)
            is Identifier -> verify(symbolTable, expected)
            is PrefixUnaryOperator -> verify(symbolTable, expected)
            is PostfixUnaryOperator -> verify(symbolTable, expected)
            is BinaryOperator -> verify(symbolTable, expected)
            is Assignment -> verify(symbolTable, expected)
            is FunctionCall -> verify(symbolTable, expected)
            is MemberAccess -> verify(symbolTable, expected)
            is IfExpression -> verify(symbolTable, expected)
            is Lambda -> verify(symbolTable, expected)
            else -> throw QuartzException("Expected expression, found $this")
        }
    }
}

private fun Expression.verifyAs(type: Type?): Expression {
    return when {
        this.type == null -> this.withType(type)
        type == null || this.type!!.isEqualTo(type) -> this
        this.type?.isInstance(type) ?: false -> Cast(this, type)
        type is AliasedType -> this.verifyAs(type.type)
        type is ConstType && type.type.isInstance(this.type!!) -> this.verifyAs(type.type)
        else -> throw QuartzException("Could not cast $this to $type")
    }
}

private fun Identifier.verify(symbolTable: SymbolTable, expected: Type?): Expression {
    val expectedType = symbolTable.getVar(name) ?: throw QuartzException("Could not find variable $name")
    return Identifier(
            name,
            when {
                type == null -> expectedType
                !type.isInstance(expectedType) -> throw QuartzException("Expected $expectedType, found $type ($this)")
                else -> type
            }
    ).verifyAs(expected)
}

private fun PrefixUnaryOperator.verify(symbolTable: SymbolTable, expected: Type?): PrefixUnaryOperator {
    val newExpression = expression.verify(symbolTable, expected)
    return PrefixUnaryOperator(
            newExpression,
            id,
            expected.verifyAs(newExpression.type)
    )
}

private fun PostfixUnaryOperator.verify(symbolTable: SymbolTable, expected: Type?): PostfixUnaryOperator {
    val newExpression = expression.verify(symbolTable, expected)
    return PostfixUnaryOperator(
            newExpression,
            id,
            expected.verifyAs(newExpression.type)
    )
}

private fun BinaryOperator.verify(symbolTable: SymbolTable, expected: Type?): BinaryOperator {
    val newExpr1 = expr1.verify(symbolTable, expected)
    val newExpr2 = expr2.verify(symbolTable, expected)
    return BinaryOperator(
            newExpr1,
            newExpr2,
            id,
            expected.verifyAs(newExpr1.type).verifyAs(newExpr2.type)
    )
}

private fun Assignment.verify(symbolTable: SymbolTable, expected: Type?): Assignment {
    val newLValue = lvalue.verify(symbolTable, expected)
    val newExpression = expression.verify(symbolTable, expected)
    return Assignment(
            newLValue,
            newExpression,
            id,
            expected.verifyAs(newLValue.type).verifyAs(newExpression.type)
    )
}

private fun FunctionCall.verify(symbolTable: SymbolTable, expected: Type?): Expression {
    return try {
        val newExpression = expression.verify(symbolTable, null)
        val expressionFunction = newExpression.type.asFunction()?.function
                ?: throw QuartzException("Could not call ${newExpression.type}")
        expressionFunction.args!!

        if (!expressionFunction.vararg && expressionFunction.args.size != args.size)
            throw QuartzException("Incorrect number of arguments for $this")

        val expressions = args.zip(expressionFunction.args + arrayOfNulls<Type>(args.size - expressionFunction.args.size))
                .map { it.first.verify(symbolTable, it.second) }

        FunctionCall(
                newExpression,
                expressions,
                type.verifyAs(expressionFunction.returnType)
        ).verifyAs(expected)
    } catch (e: QuartzException) {
        if (expression !is MemberAccess)
            throw e

        resolveDotNotation(symbolTable).verify(symbolTable, expected)
    }
}

private fun MemberAccess.verify(symbolTable: SymbolTable, expected: Type?): Expression {
    val newExpression = expression.verify(symbolTable, null)
    val owner = newExpression.type.asStruct()
            ?: throw QuartzException("${newExpression.type.asStruct()} is not a struct")
    val memberType = owner.members[name]?.type.verifyAs(expected)
            ?: throw QuartzException("Unknown member $owner.$type")

    return MemberAccess(
            name,
            newExpression,
            memberType
    ).verifyAs(expected)
}

private fun IfExpression.verify(symbolTable: SymbolTable, expected: Type?): IfExpression {
    val newTest = test.verify(symbolTable, null)
    val newIfTrue = ifTrue.verify(symbolTable, expected)
    val newIfFalse = ifFalse.verify(symbolTable, expected)

    return IfExpression(
            newTest,
            newIfTrue,
            newIfFalse,
            type.verifyAs(newIfTrue.type).verifyAs(newIfFalse.type)
    )
}

private fun Lambda.verify(symbolTable: SymbolTable, expected: Type?): Expression {
    if (function.args == null)
        return copy(function = (expected as FunctionType).function).verify(symbolTable, expected)
    if (argNames == null)
        return copy(argNames = function.args.mapIndexed { i, _ -> "p$i"}).verify(symbolTable, expected)

    val localSymbolTable = localSymbolTable(symbolTable)
    val newBlock = block.verify(localSymbolTable)
    return Lambda(
            argNames,
            function.copy(returnType = newBlock.verifyReturnType(function.returnType)),
            newBlock
    ).verifyAs(expected)
}

private fun Type?.verifyAs(type: Type?): Type? {
    return when {
        this == null -> type
        type == null -> this
        this.isEqualTo(type) -> type
        this.isInstance(type) -> type
        type is AliasedType -> this.verifyAs(type.type)
        type is ConstType && type.type.isInstance(this) -> this.verifyAs(type.type)
        else -> throw QuartzException("Could not cast $this to $type")
    }
}

fun Type?.asStruct(): StructType? {
    return when (this) {
        is AliasedType -> type.asStruct()
        is StructType -> this
        else -> null
    }
}

fun Type?.asFunction(): FunctionType? {
    return when (this) {
        is AliasedType -> type.asFunction()
        is FunctionType -> this
        else -> null
    }
}
