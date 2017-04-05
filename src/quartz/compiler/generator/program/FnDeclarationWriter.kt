package quartz.compiler.generator.program

import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.generator.util.args
import quartz.compiler.generator.util.type
import quartz.compiler.tree.function.ExpressionNode
import quartz.compiler.tree.function.FnDeclarationNode
import quartz.compiler.tree.function.StatementNode
import quartz.compiler.tree.function.expression.*
import quartz.compiler.tree.function.statement.*
import quartz.compiler.tree.misc.InlineCNode

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.functionPrototype(fnDeclarationNode: FnDeclarationNode) {
    declare("fnPrototype_${fnDeclarationNode.name}") {
        type(fnDeclarationNode.function.returnType)
        name(fnDeclarationNode.name)
        args(fnDeclarationNode.argsWithNames)
        string(";")
        newline()
    }
}

fun ProgramOutputStream.function(fnDeclarationNode: FnDeclarationNode) {
    margin {
        declare("fn_${fnDeclarationNode.name}") {
            type(fnDeclarationNode.function.returnType)
            name(fnDeclarationNode.name)
            args(fnDeclarationNode.argsWithNames)
            block(fnDeclarationNode.statements)
        }
    }
}

fun ProgramOutputStream.block(statements: List<StatementNode>) {
    braces {
        statements.forEach {
            newline()
            statement(it)
            string(";")
        }
    }
}

fun ProgramOutputStream.statement(statement: StatementNode) {
    when (statement) {
        is InlineCNode -> inlineC(statement)
        is VarDeclarationNode -> varDeclaration(statement)
        is ReturnNode -> returnStatement(statement)
        is IfStatementNode -> ifStatement(statement)
        is WhileLoopNode -> whileLoop(statement)
        is FnCallNode -> fnCall(statement)
        is VarAssignmentNode -> varAssignment(statement)
        else -> throw Exception("Unrecognized statement $statement")
    }
}

fun ProgramOutputStream.varDeclaration(varDeclarationNode: VarDeclarationNode) {
    type(varDeclarationNode.type ?: throw Exception("Unknown aliasedType for $this"))
    name(varDeclarationNode.name)
    varDeclarationNode.expression?.apply {
        string("=")
        expression(this)
    }
}

fun ProgramOutputStream.returnStatement(returnNode: ReturnNode) {
    name("return")
    expression(returnNode.expression)
}

fun ProgramOutputStream.ifStatement(ifStatementNode: IfStatementNode) {
    name("if")
    parentheses { expression(ifStatementNode.test) }
    block(ifStatementNode.trueStatements)
    if (!ifStatementNode.falseStatements.isEmpty()) {
        name("else")
        block(ifStatementNode.falseStatements)
    }
}

fun ProgramOutputStream.whileLoop(whileLoopNode: WhileLoopNode) {
    name("while")
    parentheses { expression(whileLoopNode.test) }
    block(whileLoopNode.statements)
}

fun ProgramOutputStream.expression(expression: ExpressionNode) {
    when (expression) {
        is InlineCNode -> inlineC(expression)
        is NumberLiteralNode -> numberLiteral(expression)
        is StringLiteralNode -> stringLiteral(expression)
        is IdentifierNode -> identifier(expression)
        is CastNode -> cast(expression)
        is UnaryOperatorNode -> unaryOperator(expression)
        is BinaryOperatorNode -> binaryOperator(expression)
        is MemberAccessNode -> memberAccess(expression)
        is FnCallNode -> fnCall(expression)
        else -> throw Exception("Unrecognized expression $expression")
    }
}

fun ProgramOutputStream.numberLiteral(numberLiteralNode: NumberLiteralNode) {
    name(numberLiteralNode.string)
}

fun ProgramOutputStream.stringLiteral(stringLiteralNode: StringLiteralNode) {
    string("\"${stringLiteralNode.string}\"")
}

fun ProgramOutputStream.identifier(identifierNode: IdentifierNode) {
    name(identifierNode.name)
}

fun ProgramOutputStream.cast(castNode: CastNode) {
    parentheses { type(castNode.type ?: throw Exception("Unknown aliasedType for $this")) }
    parentheses { expression(castNode.expression) }
}

fun ProgramOutputStream.unaryOperator(unaryOperatorNode: UnaryOperatorNode) {
    string(unaryOperatorNode.id)
    parentheses { expression(unaryOperatorNode.expression) }
}

fun ProgramOutputStream.binaryOperator(binaryOperatorNode: BinaryOperatorNode) {
    when (binaryOperatorNode.id) {
        BinaryOperatorNode.ID.ARRAY_ACCESS -> {
            parentheses { expression(binaryOperatorNode.expr1) }
            brackets { expression(binaryOperatorNode.expr2) }
        }
        else -> {
            parentheses { expression(binaryOperatorNode.expr1) }
            string(binaryOperatorNode.id)
            parentheses { expression(binaryOperatorNode.expr2) }
        }
    }
}

fun ProgramOutputStream.memberAccess(memberAccessNode: MemberAccessNode) {
    expression(memberAccessNode.expression)
    string(".")
    name(memberAccessNode.name)
}

fun ProgramOutputStream.fnCall(fnCallNode: FnCallNode) {
    expression(fnCallNode.expression)
    parentheses {
        fnCallNode.expressions.dropLast(1).forEach {
            expression(it)
            string(", ")
        }
        if (!fnCallNode.expressions.isEmpty())
            expression(fnCallNode.expressions.last())
    }
}

fun ProgramOutputStream.varAssignment(varAssignmentNode: VarAssignmentNode) {
    name(varAssignmentNode.name)
    string("=")
    expression(varAssignmentNode.expression)
}
