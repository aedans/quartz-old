package quartz.compiler.generator.program

import quartz.compiler.errors.errorScope
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
        type(functionDeclaration.function.returnType!!)
        name(functionDeclaration.name)
        args(functionDeclaration.argsWithNames)
        string(";")
        newline()
    }
}

fun ProgramOutputStream.function(functionDeclaration: FunctionDeclaration) {
    margin {
        declare("fn_${functionDeclaration.name}") {
            type(functionDeclaration.function.returnType!!)
            name(functionDeclaration.name)
            args(functionDeclaration.argsWithNames)
            block(functionDeclaration.block)
        }
    }
}

fun ProgramOutputStream.block(block: Block) {
    braces {
        block.statementList.forEach {
            newline()
            statement(it)
            string(";")
        }
    }
}

fun ProgramOutputStream.statement(statement: Statement) {
    errorScope({ "statement $statement" }) {
        when (statement) {
            is InlineC -> inlineC(statement)
            is PrefixUnaryOperator -> prefixUnaryOperator(statement)
            is PostfixUnaryOperator -> postfixUnaryOperator(statement)
            is VariableDeclaration -> varDeclaration(statement)
            is ReturnStatement -> returnStatement(statement)
            is IfStatement -> ifStatement(statement)
            is WhileLoop -> whileLoop(statement)
            is FunctionCall -> fnCall(statement)
            is Assignment -> varAssignment(statement)
            is Block -> block(statement)
            else -> throw Exception("Unrecognized statement $statement")
        }
    }
}

fun ProgramOutputStream.varDeclaration(variableDeclaration: VariableDeclaration) {
    type(variableDeclaration.type ?: throw Exception("Unknown type for $variableDeclaration"))
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
    block(ifStatement.trueBlock)
    if (!ifStatement.falseBlock.statementList.isEmpty()) {
        name("else")
        block(ifStatement.falseBlock)
    }
}

fun ProgramOutputStream.whileLoop(whileLoop: WhileLoop) {
    name("while")
    parentheses { expression(whileLoop.test) }
    block(whileLoop.block)
}

fun ProgramOutputStream.expression(expression: Expression) {
    errorScope({ "expression $expression" }) {
        when (expression) {
            is InlineC -> inlineC(expression)
            is NumberLiteral -> numberLiteral(expression)
            is StringLiteral -> stringLiteral(expression)
            is Identifier -> identifier(expression)
            is Cast -> cast(expression)
            is PrefixUnaryOperator -> prefixUnaryOperator(expression)
            is PostfixUnaryOperator -> postfixUnaryOperator(expression)
            is BinaryOperator -> binaryOperator(expression)
            is Assignment -> assignment(expression)
            is MemberAccess -> memberAccess(expression)
            is Sizeof -> sizeof(expression)
            is FunctionCall -> fnCall(expression)
            else -> throw Exception("Unrecognized expression $expression")
        }
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
    parentheses { type(cast.type ?: throw Exception("Unknown type for $this")) }
    parentheses { expression(cast.expression) }
}

fun ProgramOutputStream.prefixUnaryOperator(prefixUnaryOperator: PrefixUnaryOperator) {
    string(prefixUnaryOperator.id)
    parentheses { expression(prefixUnaryOperator.expression) }
}

fun ProgramOutputStream.postfixUnaryOperator(postfixUnaryOperator: PostfixUnaryOperator) {
    parentheses { expression(postfixUnaryOperator.expression) }
    string(postfixUnaryOperator.id)
}

fun ProgramOutputStream.binaryOperator(binaryOperator: BinaryOperator) {
    parentheses { expression(binaryOperator.expr1) }
    string(binaryOperator.id)
    parentheses { expression(binaryOperator.expr2) }
}

fun ProgramOutputStream.assignment(assignment: Assignment) {
    expression(assignment.lvalue)
    string(assignment.id)
    expression(assignment.expression)
}

fun ProgramOutputStream.memberAccess(memberAccess: MemberAccess) {
    expression(memberAccess.expression)
    string(".")
    name(memberAccess.name)
}

fun ProgramOutputStream.sizeof(sizeof: Sizeof) {
    name("sizeof")
    parentheses { type(sizeof.sizeType) }
}

fun ProgramOutputStream.fnCall(functionCall: FunctionCall) {
    expression(functionCall.expression)
    parentheses {
        functionCall.args.dropLast(1).forEach {
            expression(it)
            string(", ")
        }
        if (!functionCall.args.isEmpty())
            expression(functionCall.args.last())
    }
}

fun ProgramOutputStream.varAssignment(assignment: Assignment) {
    expression(assignment.lvalue)
    string("=")
    expression(assignment.expression)
}
