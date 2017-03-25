package quartz.compiler.semantics

import quartz.compiler.semantics.symboltable.LocalSymbolTable
import quartz.compiler.semantics.symboltable.SymbolTable
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.FnDeclarationNode
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.syntax.tree.program.function.expression.*
import quartz.compiler.syntax.tree.program.function.statement.*
import quartz.compiler.util.Type
import quartz.compiler.util.types.Primitives
import quartz.compiler.util.types.StructType
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
    this.args.forEach { localSymbolTable.add(it.first, it.second) }

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
    symbolTable.add(name, newType ?: throw Exception("Unknown type for $this"))

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
    val expectedType = symbolTable[name] ?: throw Exception("Could not find variable $name")
    return IdentifierNode(name,
            when {
                type == null -> expectedType
                type != expectedType -> throw Exception("Expected $expectedType, found $this")
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
        BinaryOperatorNode(
                expr1.verify(symbolTable),
                expr2.verify(symbolTable).verifyAs(Primitives.int),
                id,
                type
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
    val function = symbolTable.getGlobalSymbolTable().getFunction(name) ?: throw Exception("Could not find function $name")

    if (function.args.size != expressions.size) throw Exception("Incorrect number of arguments for $this")

    return FnCallNode(
            name,
            expressions.zip(function.args).map { it.first.verify(symbolTable).withType(it.first.type.verifyAs(it.second)) },
            type.verifyAs(function.returnType)
    )
}

private fun MemberAccessNode.verify(symbolTable: SymbolTable): MemberAccessNode {
    val newExpression = expression.verify(symbolTable)
    val structType = newExpression.type as StructType
    val struct = symbolTable.getGlobalSymbolTable().getStruct(structType.name)

    return MemberAccessNode(
            name,
            type.verifyAs(struct.type),
            newExpression.verifyAs(structType)
    )
}

private fun IfExpressionNode.verify(symbolTable: SymbolTable): IfExpressionNode {
    test.verify(symbolTable)
    ifTrue.verify(symbolTable)
    ifFalse.verify(symbolTable)

    return IfExpressionNode(
            test.verifyAs(Primitives.bool),
            ifTrue.verifyAs(type).verifyAs(ifFalse.type),
            ifFalse.verifyAs(type).verifyAs(ifTrue.type),
            type.verifyAs(ifTrue.type).verifyAs(ifTrue.type)
    )
}

private fun ExpressionNode.verifyAs(type: Type?): ExpressionNode {
    when {
        this.type == null -> return this.withType(type)
        this.type == type || type == null -> return this
        this.type!!.canCastTo(type) -> return CastNode(type, this)
        else -> throw Exception("Could not cast $this to $type")
    }
}

private fun Type?.verifyAs(type: Type?): Type? {
    when {
        this == null -> return type
        this == type || type == null -> return this
        this.canCastTo(type) -> return type
        else -> throw Exception("Could not cast $this to $type")
    }
}
