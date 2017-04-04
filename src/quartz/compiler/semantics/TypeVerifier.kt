package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.semantics.symboltable.addTo
import quartz.compiler.semantics.symboltable.localSymbolTable
import quartz.compiler.semantics.types.*
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.syntax.tree.function.expression.*
import quartz.compiler.syntax.tree.function.statement.*
import quartz.compiler.syntax.tree.misc.InlineCNode
import quartz.compiler.util.Type
import quartz.compiler.util.plus

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.verifyTypes(): ProgramNode {
    val newNode = mapTypes { (it as? UnresolvedType)?.verify(symbolTable) ?: it }
    return newNode.mapFnDeclarations { fnDeclaration -> fnDeclaration.verify(newNode.symbolTable) }
}

private fun FnDeclarationNode.verify(symbolTable: SymbolTable): FnDeclarationNode {
    val localSymbolTable = localSymbolTable(symbolTable)

    return mapStatements { it.verify(localSymbolTable) }
}

private fun StatementNode.verify(symbolTable: SymbolTable): StatementNode {
    return when (this) {
        is InlineCNode -> this
        is VarDeclarationNode -> verify(symbolTable)
        is ReturnNode -> verify(symbolTable)
        is IfStatementNode -> verify(symbolTable)
        is WhileLoopNode -> verify(symbolTable)
        is FnCallNode -> verify(symbolTable)
        else -> throw QuartzException("Unrecognized node $this")
    }
}

private fun VarDeclarationNode.verify(symbolTable: SymbolTable): VarDeclarationNode {
    val newExpression = expression?.verify(symbolTable)

    return VarDeclarationNode(name, newExpression, type.verifyAs(newExpression?.type), mutable).apply { addTo(symbolTable) }
}

private fun ReturnNode.verify(symbolTable: SymbolTable): ReturnNode {
    return ReturnNode(expression.verify(symbolTable))
}

private fun IfStatementNode.verify(symbolTable: SymbolTable): IfStatementNode {
    val localSymbolTable = symbolTable.localSymbolTable()
    return IfStatementNode(
            test.verify(symbolTable).verifyAs(Primitives.int),
            trueStatements.map { it.verify(localSymbolTable) },
            falseStatements.map { it.verify(localSymbolTable) }
    )
}

private fun WhileLoopNode.verify(symbolTable: SymbolTable): WhileLoopNode {
    val localSymbolTable = symbolTable.localSymbolTable()
    return WhileLoopNode(
            test.verify(symbolTable),
            statements.map { it.verify(localSymbolTable) }
    )
}

private fun ExpressionNode.verify(symbolTable: SymbolTable): ExpressionNode {
    return when (this) {
        is InlineCNode -> this
        is NumberLiteralNode -> this
        is StringLiteralNode -> this
        is IdentifierNode -> verify(symbolTable)
        is UnaryOperatorNode -> verify(symbolTable)
        is BinaryOperatorNode -> verify(symbolTable)
        is FnCallNode -> verify(symbolTable)
        is MemberAccessNode -> verify(symbolTable)
        is IfExpressionNode -> verify(symbolTable)
        else -> throw QuartzException("Unrecognized node $this")
    }
}

private fun IdentifierNode.verify(symbolTable: SymbolTable): IdentifierNode {
    val expectedType = symbolTable.getVar(name) ?: throw QuartzException("Could not find variable $name")
    return IdentifierNode(name,
            when {
                type == null -> expectedType
                type != expectedType -> throw QuartzException("Expected $expectedType, found $type ($this)")
                else -> type
            }
    )
}

private fun UnaryOperatorNode.verify(symbolTable: SymbolTable): UnaryOperatorNode {
    return UnaryOperatorNode(
            expression.verify(symbolTable),
            id,
            type
    )
}

private fun BinaryOperatorNode.verify(symbolTable: SymbolTable): BinaryOperatorNode {
    return if (id == BinaryOperatorNode.ID.ARRAY_ACCESS) {
        val newExpr1 = expr1.verify(symbolTable)
        val newExpr2 = expr2.verify(symbolTable).verifyAs(Primitives.int)
        val newType = (newExpr1.type as ArrayType).type
        BinaryOperatorNode(
                newExpr1,
                newExpr2,
                id,
                newType
        )
    } else {
        val newExpr1 = expr1.verify(symbolTable)
        val newExpr2 = expr2.verify(symbolTable)
        BinaryOperatorNode(
                newExpr1.verifyAs(expr2.type).verifyAs(type),
                newExpr2.verifyAs(expr1.type).verifyAs(type),
                id,
                type.verifyAs(newExpr1.type).verifyAs(newExpr2.type)
        )
    }
}

private fun FnCallNode.verify(symbolTable: SymbolTable): FnCallNode {
    try {
        val newExpression = expression.verify(symbolTable)
        val expressionFunction = (newExpression.type as? FunctionType)?.function
                ?: throw QuartzException("Could not call ${newExpression.type}")

        if (!expressionFunction.vararg && expressionFunction.args.size != expressions.size)
            throw QuartzException("Incorrect number of arguments for $this")

        return FnCallNode(
                newExpression,
                expressions.zip(expressionFunction.args + arrayOfNulls<Type>(expressions.size - expressionFunction.args.size))
                        .map { it.first.verify(symbolTable).verifyAs(it.first.type.verifyAs(it.second)) },
                type.verifyAs(expressionFunction.returnType)
        )
    } catch (e: QuartzException) {
        if (expression !is MemberAccessNode)
            throw e

        val expressionType = symbolTable.getVar(expression.name) as? FunctionType
                ?: throw QuartzException("Could not find function ${expression.name}")
        return FnCallNode(
                IdentifierNode(expression.name, expressionType),
                expression.expression + expressions,
                type
        ).verify(symbolTable)
    }
}

private fun MemberAccessNode.verify(symbolTable: SymbolTable): MemberAccessNode {
    val newExpression = expression.verify(symbolTable)
    val owner = symbolTable.getType(newExpression.type.toString()) as? StructType
            ?: throw QuartzException("Unknown struct ${newExpression.type}")
    val memberType = owner.structDeclarationNode.members[name]?.type
            ?: throw QuartzException("Unknown member $owner.$type")

    return MemberAccessNode(
            name,
            newExpression,
            memberType
    )
}

private fun IfExpressionNode.verify(symbolTable: SymbolTable): IfExpressionNode {
    val newTest = test.verify(symbolTable)
    val newIfTrue = ifTrue.verify(symbolTable)
    val newIfFalse = ifFalse.verify(symbolTable)
    val newType = type.verifyAs(newIfTrue.type).verifyAs(newIfFalse.type)

    return IfExpressionNode(
            newTest.verifyAs(Primitives.int),
            newIfTrue.verifyAs(newType).verifyAs(ifFalse.type),
            newIfFalse.verifyAs(newType).verifyAs(ifTrue.type),
            newType
    )
}

private fun ExpressionNode.verifyAs(type: Type?): ExpressionNode {
    return when {
        this.type == null -> this.withType(type)
        this.type == type || type == null -> this
        Type.canCast(this.type!!, type) -> CastNode(this, type)
        else -> throw QuartzException("Could not cast $this to $type")
    }
}

private fun Type?.verifyAs(type: Type?): Type? {
    return when {
        this == null -> type
        this == type || type == null -> this
        Type.canCast(this, type) -> this
        else -> throw QuartzException("Could not cast $this to $type")
    }
}

private fun UnresolvedType.verify(symbolTable: SymbolTable): Type {
    return symbolTable.getTrueType(string)
            ?: throw QuartzException("Unknown type $this")
}
