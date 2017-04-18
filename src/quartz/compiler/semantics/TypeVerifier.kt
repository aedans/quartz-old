package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.symboltable.addTo
import quartz.compiler.semantics.symboltable.localSymbolTable
import quartz.compiler.semantics.types.AliasedType
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.semantics.types.StructType
import quartz.compiler.tree.Program
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

fun Program.verifyTypes(): Program {
    return this.mapFunctionDeclarations { fnDeclaration -> fnDeclaration.verify(symbolTable) }
}

private fun FunctionDeclaration.verify(symbolTable: SymbolTable): FunctionDeclaration {
    val localSymbolTable = localSymbolTable(symbolTable)

    return FunctionDeclaration(
            name,
            argNames,
            function,
            statements.map { it.verify(localSymbolTable) }
    )
}

private fun Statement.verify(symbolTable: SymbolTable): Statement {
    return when (this) {
        is InlineC -> this
        is PrefixUnaryOperator -> verify(symbolTable)
        is PostfixUnaryOperator -> verify(symbolTable)
        is VariableDeclaration -> verify(symbolTable)
        is Assignment -> verify(symbolTable)
        is ReturnStatement -> verify(symbolTable)
        is IfStatement -> verify(symbolTable)
        is WhileLoop -> verify(symbolTable)
        is Delete -> verify(symbolTable)
        is TypeSwitch -> verify(symbolTable)
        is FunctionCall -> verify(symbolTable)
        else -> throw QuartzException("Unrecognized node $this")
    }
}

private fun VariableDeclaration.verify(symbolTable: SymbolTable): VariableDeclaration {
    val newExpression = expression?.verify(symbolTable)

    return VariableDeclaration(
            name,
            newExpression,
            type.verifyAs(newExpression?.type),
            mutable
    ).apply { addTo(symbolTable) }
}

private fun ReturnStatement.verify(symbolTable: SymbolTable): ReturnStatement {
    return ReturnStatement(expression.verify(symbolTable))
}

private fun IfStatement.verify(symbolTable: SymbolTable): IfStatement {
    val localSymbolTable = symbolTable.localSymbolTable()
    return IfStatement(
            test.verify(symbolTable).verifyAs(Primitives.int),
            trueStatements.map { it.verify(localSymbolTable) },
            falseStatements.map { it.verify(localSymbolTable) }
    )
}

private fun WhileLoop.verify(symbolTable: SymbolTable): WhileLoop {
    val localSymbolTable = symbolTable.localSymbolTable()
    return WhileLoop(
            test.verify(symbolTable),
            statements.map { it.verify(localSymbolTable) }
    )
}

private fun Delete.verify(symbolTable: SymbolTable): Delete {
    return Delete(expression.verify(symbolTable))
}

private fun TypeSwitch.verify(symbolTable: SymbolTable): TypeSwitch {
    val newIdentifier = identifier.verify(symbolTable)
    return TypeSwitch(
            newIdentifier,
            branches.mapValues {
                val localSymbolTable = it.localSymbolTable(symbolTable, identifier.name)
                it.value.map { it.verify(localSymbolTable) }
            },
            elseBranch.map {
                val localSymbolTable = symbolTable.localSymbolTable()
                it.verify(localSymbolTable)
            }
    )
}

private fun Expression.verify(symbolTable: SymbolTable): Expression {
    return when (this) {
        is InlineC -> this
        is NumberLiteral -> this
        is StringLiteral -> this
        is Identifier -> verify(symbolTable)
        is PrefixUnaryOperator -> verify(symbolTable)
        is PostfixUnaryOperator -> verify(symbolTable)
        is BinaryOperator -> verify(symbolTable)
        is Assignment -> verify(symbolTable)
        is FunctionCall -> verify(symbolTable)
        is MemberAccess -> verify(symbolTable)
        is IfExpression -> verify(symbolTable)
        is Sizeof -> verify()
        else -> throw QuartzException("Unrecognized node $this")
    }
}

private fun Identifier.verify(symbolTable: SymbolTable): Identifier {
    val expectedType = symbolTable.getVar(name) ?: throw QuartzException("Could not find variable $name")
    return Identifier(name,
            when {
                type == null -> expectedType
                type != expectedType -> throw QuartzException("Expected $expectedType, found $type ($this)")
                else -> type
            }
    )
}

private fun PrefixUnaryOperator.verify(symbolTable: SymbolTable): PrefixUnaryOperator {
    val newExpression = expression.verify(symbolTable).verifyAs(type)
    return PrefixUnaryOperator(
            newExpression,
            id,
            type.verifyAs(newExpression.type)
    )
}

private fun PostfixUnaryOperator.verify(symbolTable: SymbolTable): PostfixUnaryOperator {
    val newExpression = expression.verify(symbolTable).verifyAs(type)
    return PostfixUnaryOperator(
            newExpression,
            id,
            type.verifyAs(newExpression.type)
    )
}

private fun BinaryOperator.verify(symbolTable: SymbolTable): BinaryOperator {
    val newExpr1 = expr1.verify(symbolTable)
    val newExpr2 = expr2.verify(symbolTable)
    return BinaryOperator(
            newExpr1.verifyAs(newExpr1.type).verifyAs(type),
            newExpr2.verifyAs(newExpr2.type).verifyAs(type),
            id,
            type.verifyAs(newExpr1.type).verifyAs(newExpr2.type)
    )
}

private fun Assignment.verify(symbolTable: SymbolTable): Assignment {
    val newLValue = lvalue.verify(symbolTable)
    val newExpression = expression.verify(symbolTable)
    return Assignment(
            newLValue.verifyAs(newExpression.type).verifyAs(type),
            newExpression.verifyAs(newLValue.type).verifyAs(type),
            id,
            type.verifyAs(lvalue.type).verifyAs(newExpression.type)
    )
}

private fun FunctionCall.verify(symbolTable: SymbolTable): FunctionCall {
    return try {
        val newExpression = expression.verify(symbolTable)
        val expressionFunction = newExpression.type.asFunction()?.function
                ?: throw QuartzException("Could not call ${newExpression.type}")

        if (!expressionFunction.vararg && expressionFunction.args.size != args.size)
            throw QuartzException("Incorrect number of arguments for $this")

        val expressions = args.map { it.verify(symbolTable) }

        val templates = if (templates.isNotEmpty() || expressionFunction.templates.isEmpty())
            templates
        else
            expressionFunction.args.zip(expressions.map { it.type ?: throw QuartzException("Could not infer type for $this") })
                    .inferTemplates(expressionFunction.templates)

        if (templates.size != expressionFunction.templates.size)
            throw QuartzException("Could not infer types for $this")

        val templateMap = expressionFunction.templates.zip(templates).toMap()
        val templateExpressionFunction = expressionFunction.mapTypes { templateMap[it] ?: it }

        FunctionCall(
                newExpression,
                templates,
                expressions
                        .zip(templateExpressionFunction.args + arrayOfNulls<Type>(expressions.size - expressionFunction.args.size))
                        .map { it.first.verifyAs(it.first.type.verifyAs(it.second)) },
                type.verifyAs(templateExpressionFunction.returnType)
        )
    } catch (e: QuartzException) {
        if (expression !is MemberAccess)
            throw e

        resolveDotNotation(symbolTable).verify(symbolTable)
    }
}

private fun MemberAccess.verify(symbolTable: SymbolTable): MemberAccess {
    val newExpression = expression.verify(symbolTable)
    val owner = newExpression.type.asStruct()
            ?: throw QuartzException("${newExpression.type.asStruct()} is not a struct")
    val memberType = owner.members[name]?.type
            ?: throw QuartzException("Unknown member $owner.$type")

    return MemberAccess(
            name,
            newExpression,
            memberType
    )
}

private fun IfExpression.verify(symbolTable: SymbolTable): IfExpression {
    val newTest = test.verify(symbolTable)
    val newIfTrue = ifTrue.verify(symbolTable)
    val newIfFalse = ifFalse.verify(symbolTable)
    val newType = type.verifyAs(newIfTrue.type).verifyAs(newIfFalse.type)

    return IfExpression(
            newTest.verifyAs(Primitives.int),
            newIfTrue.verifyAs(newType).verifyAs(ifFalse.type),
            newIfFalse.verifyAs(newType).verifyAs(ifTrue.type),
            newType
    )
}

private fun Sizeof.verify(): Sizeof {
    return this
}

private fun Expression.verifyAs(type: Type?): Expression {
    return when {
        this.type == null -> this.withType(type)
        this.type == type || type == null -> this
        this.type?.isInstance(type) ?: false -> Cast(this, type)
        type is AliasedType -> this.verifyAs(type.type)
        else -> throw QuartzException("Could not cast $this (${this.type}) to $type")
    }
}

private fun Type?.verifyAs(type: Type?): Type? {
    return when {
        this == null -> type
        this == type || type == null -> this
        this.isInstance(type) -> this
        type is AliasedType -> this.verifyAs(type.type)
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
