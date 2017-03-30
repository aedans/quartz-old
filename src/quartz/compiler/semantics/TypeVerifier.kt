package quartz.compiler.semantics

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.semantics.symboltable.LocalSymbolTable
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.ExpressionNode
import quartz.compiler.syntax.tree.function.FnDeclarationNode
import quartz.compiler.syntax.tree.function.StatementNode
import quartz.compiler.syntax.tree.function.expression.*
import quartz.compiler.syntax.tree.function.statement.*
import quartz.compiler.util.Type
import quartz.compiler.util.plus
import quartz.compiler.util.types.ArrayType
import quartz.compiler.util.types.FunctionType
import quartz.compiler.util.types.Primitives
import quartz.compiler.visitor.program.function.visit
import quartz.compiler.visitor.program.visit
import quartz.compiler.visitor.visit

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.verifyTypes(symbolTable: SymbolTable): ProgramNode {
    return this.visit(
            { fnDeclaration -> fnDeclaration.verify(symbolTable) }
    )
}

private fun FnDeclarationNode.verify(symbolTable: SymbolTable): FnDeclarationNode {
    val localSymbolTable = LocalSymbolTable(symbolTable)
    this.args.forEach { localSymbolTable.addVar(it.first, it.second) }

    return this.visit({ statement -> statement.verify(localSymbolTable) })
}

private fun StatementNode.verify(symbolTable: SymbolTable): StatementNode {
    return this.visit(
            varDeclarationVisitor = { verify(symbolTable) },
            returnVisitor = { verify(symbolTable) },
            ifStatementVisitor = { verify(symbolTable) },
            whileLoopVisitor = { verify(symbolTable) },
            fnCallVisitor = { verify(symbolTable) }
    )
}

private fun VarDeclarationNode.verify(symbolTable: SymbolTable): VarDeclarationNode {
    val newExpression = expression?.verify(symbolTable)
    val newType = type.verifyAs(newExpression?.type)
    symbolTable.addVar(name, newType ?: throw QuartzException("Unknown type for $this"))

    return VarDeclarationNode(name, newType, mutable, newExpression)
}

private fun ReturnNode.verify(symbolTable: SymbolTable): ReturnNode {
    return ReturnNode(expressionNode.verify(symbolTable))
}

private fun IfStatementNode.verify(symbolTable: SymbolTable): IfStatementNode {
    val localSymbolTable = LocalSymbolTable(symbolTable)
    return IfStatementNode(
            test.verify(symbolTable).verifyAs(Primitives.bool),
            trueStatements.map { it.verify(localSymbolTable) },
            falseStatements.map { it.verify(localSymbolTable) }
    )
}

private fun WhileLoopNode.verify(symbolTable: SymbolTable): WhileLoopNode {
    val localSymbolTable = LocalSymbolTable(symbolTable)
    return WhileLoopNode(
            test.verify(symbolTable),
            statements.map { it.verify(localSymbolTable) }
    )
}

private fun ExpressionNode.verify(symbolTable: SymbolTable): ExpressionNode {
    return this.visit(
            identifierVisitor = { verify(symbolTable) },
            unaryOperatorVisitor = { verify(symbolTable) },
            binaryOperatorVisitor = { verify(symbolTable) },
            fnCallVisitor = { verify(symbolTable) },
            memberAccessVisitor = { verify(symbolTable) },
            ifExpressionVisitor = { verify(symbolTable) }
    )
}

private fun IdentifierNode.verify(symbolTable: SymbolTable): IdentifierNode {
    val expectedType = symbolTable.getVar(name) ?: throw QuartzException("Could not find variable $name")
    return IdentifierNode(name,
            when {
                type == null -> expectedType
                type != expectedType -> throw QuartzException("Expected $expectedType, found $this")
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

        val expressionType = symbolTable.getVar(expression.name) as FunctionType
        return FnCallNode(
                IdentifierNode(expression.name, expressionType),
                (expression.expression.verify(symbolTable) + expressions).zip(expressionType.function.args).map {
                    it.first.verify(symbolTable).verifyAs(it.first.type.verifyAs(it.second)) },
                type.verifyAs(expressionType.function.returnType)
        )
    }
}

private fun MemberAccessNode.verify(symbolTable: SymbolTable): MemberAccessNode {
    val newExpression = expression.verify(symbolTable)
    val owner = symbolTable.getGlobalSymbolTable().structs[newExpression.type.toString()]
            ?: throw QuartzException("Unknown struct ${newExpression.type}")
    val memberType = owner.members[name]
            ?: throw QuartzException("Unknown member $owner.$type")

    return MemberAccessNode(
            name,
            memberType,
            newExpression
    )
}

private fun IfExpressionNode.verify(symbolTable: SymbolTable): IfExpressionNode {
    val newTest = test.verify(symbolTable)
    val newIfTrue = ifTrue.verify(symbolTable)
    val newIfFalse = ifFalse.verify(symbolTable)
    val newType = type.verifyAs(newIfTrue.type).verifyAs(newIfFalse.type)

    return IfExpressionNode(
            newTest.verifyAs(Primitives.bool),
            newIfTrue.verifyAs(newType).verifyAs(ifFalse.type),
            newIfFalse.verifyAs(newType).verifyAs(ifTrue.type),
            newType
    )
}

private fun ExpressionNode.verifyAs(type: Type?): ExpressionNode {
    when {
        this.type == null -> return this.withType(type)
        this.type == type || type == null -> return this
        this.type!!.canCastTo(type) -> return CastNode(type, this)
        else -> throw QuartzException("Could not cast $this to $type")
    }
}

private fun Type?.verifyAs(type: Type?): Type? {
    when {
        this == null -> return type
        this == type || type == null -> return this
        this.canCastTo(type) -> return type
        else -> throw QuartzException("Could not cast $this to $type")
    }
}
