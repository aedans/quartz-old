package quartz.compiler.generator.program

import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.generator.util.args
import quartz.compiler.generator.util.type
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.Statement
import quartz.compiler.tree.function.expression.*
import quartz.compiler.tree.function.statement.*
import quartz.compiler.tree.misc.InlineC

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.functionPrototype(functionDeclaration: FunctionDeclaration) {
    declare("fnPrototype_${functionDeclaration.name}") {
        type(functionDeclaration.function.returnType)
        name(functionDeclaration.name)
        args(functionDeclaration.argsWithNames)
        string(";")
        newline()
    }
}

fun ProgramOutputStream.function(functionDeclaration: FunctionDeclaration) {
    margin {
        declare("fn_${functionDeclaration.name}") {
            type(functionDeclaration.function.returnType)
            name(functionDeclaration.name)
            args(functionDeclaration.argsWithNames)
            block(functionDeclaration.statements)
        }
    }
}

fun ProgramOutputStream.block(statements: List<Statement>) {
    braces {
        statements.forEach {
            newline()
            statement(it)
            string(";")
        }
    }
}

fun ProgramOutputStream.statement(statement: Statement) {
    when (statement) {
        is InlineC -> inlineC(statement)
        is VariableDeclaration -> varDeclaration(statement)
        is ReturnStatement -> returnStatement(statement)
        is IfStatement -> ifStatement(statement)
        is WhileLoop -> whileLoop(statement)
        is FunctionCall -> fnCall(statement)
        is VariableAssignment -> varAssignment(statement)
        else -> throw Exception("Unrecognized statement $statement")
    }
}

fun ProgramOutputStream.varDeclaration(variableDeclaration: VariableDeclaration) {
    type(variableDeclaration.type ?: throw Exception("Unknown aliasedType for $this"))
    name(variableDeclaration.name)
    variableDeclaration.expression?.apply {
        string("=")
        expression(this)
    }
}

fun ProgramOutputStream.returnStatement(returnStatement: ReturnStatement) {
    name("return")
    expression(returnStatement.expression)
}

fun ProgramOutputStream.ifStatement(ifStatement: IfStatement) {
    name("if")
    parentheses { expression(ifStatement.test) }
    block(ifStatement.trueStatements)
    if (!ifStatement.falseStatements.isEmpty()) {
        name("else")
        block(ifStatement.falseStatements)
    }
}

fun ProgramOutputStream.whileLoop(whileLoop: WhileLoop) {
    name("while")
    parentheses { expression(whileLoop.test) }
    block(whileLoop.statements)
}

fun ProgramOutputStream.expression(expression: Expression) {
    when (expression) {
        is InlineC -> inlineC(expression)
        is NumberLiteral -> numberLiteral(expression)
        is StringLiteral -> stringLiteral(expression)
        is Identifier -> identifier(expression)
        is Cast -> cast(expression)
        is UnaryOperator -> unaryOperator(expression)
        is BinaryOperator -> binaryOperator(expression)
        is MemberAccess -> memberAccess(expression)
        is FunctionCall -> fnCall(expression)
        else -> throw Exception("Unrecognized expression $expression")
    }
}

fun ProgramOutputStream.numberLiteral(numberLiteral: NumberLiteral) {
    name(numberLiteral.string)
}

fun ProgramOutputStream.stringLiteral(stringLiteral: StringLiteral) {
    string("\"${stringLiteral.string}\"")
}

fun ProgramOutputStream.identifier(identifier: Identifier) {
    name(identifier.name)
}

fun ProgramOutputStream.cast(cast: Cast) {
    parentheses { type(cast.type ?: throw Exception("Unknown aliasedType for $this")) }
    parentheses { expression(cast.expression) }
}

fun ProgramOutputStream.unaryOperator(unaryOperator: UnaryOperator) {
    string(unaryOperator.id)
    parentheses { expression(unaryOperator.expression) }
}

fun ProgramOutputStream.binaryOperator(binaryOperator: BinaryOperator) {
    when (binaryOperator.id) {
        BinaryOperator.ID.ARRAY_ACCESS -> {
            parentheses { expression(binaryOperator.expr1) }
            brackets { expression(binaryOperator.expr2) }
        }
        else -> {
            parentheses { expression(binaryOperator.expr1) }
            string(binaryOperator.id)
            parentheses { expression(binaryOperator.expr2) }
        }
    }
}

fun ProgramOutputStream.memberAccess(memberAccess: MemberAccess) {
    expression(memberAccess.expression)
    string(".")
    name(memberAccess.name)
}

fun ProgramOutputStream.fnCall(functionCall: FunctionCall) {
    expression(functionCall.expression)
    parentheses {
        functionCall.expressions.dropLast(1).forEach {
            expression(it)
            string(", ")
        }
        if (!functionCall.expressions.isEmpty())
            expression(functionCall.expressions.last())
    }
}

fun ProgramOutputStream.varAssignment(variableAssignment: VariableAssignment) {
    name(variableAssignment.name)
    string("=")
    expression(variableAssignment.expression)
}
