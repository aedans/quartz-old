package quartz.compiler.generator.program

import quartz.compiler.errors.errorScope
import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.generator.util.args
import quartz.compiler.generator.util.type
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.*
import quartz.compiler.tree.misc.InlineC

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.functionPrototype(functionDeclaration: FunctionDeclaration) {
    declare("functionPrototype_${functionDeclaration.name}") {
        type(functionDeclaration.function.returnType!!)
        name(functionDeclaration.name)
        args(functionDeclaration.argsWithNames)
        string(";")
        newline()
    }
}

fun ProgramOutputStream.function(functionDeclaration: FunctionDeclaration) {
    margin {
        declare("function_${functionDeclaration.name}") {
            type(functionDeclaration.function.returnType!!)
            name(functionDeclaration.name)
            args(functionDeclaration.argsWithNames)
            block(functionDeclaration.block)
        }
    }
}

fun ProgramOutputStream.expression(expression: Expression) {
    errorScope({ "expression $expression" }) {
        when (expression) {
            is InlineC -> inlineC(expression)
            is NumberLiteral -> numberLiteral(expression)
            is StringLiteral -> stringLiteral(expression)
            is Identifier -> identifier(expression)
            is Sizeof -> sizeof(expression)
            is Cast -> cast(expression)
            is ReturnExpression -> returnExpression(expression)
            is PrefixUnaryOperator -> prefixUnaryOperator(expression)
            is PostfixUnaryOperator -> postfixUnaryOperator(expression)
            is BinaryOperator -> binaryOperator(expression)
            is Assignment -> assignment(expression)
            is MemberAccess -> memberAccess(expression)
            is FunctionCall -> functionCall(expression)
            is IfExpression -> ifExpression(expression)
            is WhileExpression -> whileExpression(expression)
            is VariableDeclaration -> varDeclaration(expression)
            is BlockExpression -> block(expression)
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

fun ProgramOutputStream.sizeof(sizeof: Sizeof) {
    name("sizeof")
    parentheses { type(sizeof.sizeType) }
}

fun ProgramOutputStream.cast(cast: Cast) {
    parentheses { type(cast.type) }
    parentheses { expression(cast.expression) }
}

fun ProgramOutputStream.returnExpression(returnExpression: ReturnExpression) {
    name("return")
    expression(returnExpression.expression)
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

fun ProgramOutputStream.functionCall(functionCall: FunctionCall) {
    expression(functionCall.expression)
    parentheses {
        if (functionCall.args.isNotEmpty()) {
            functionCall.args.dropLast(1).forEach {
                expression(it)
                string(",")
            }
            expression(functionCall.args.last())
        }
    }
}

fun ProgramOutputStream.ifExpression(ifExpression: IfExpression) {
    name("if")
    parentheses { expression(ifExpression.test) }
    expression(ifExpression.ifTrue)
    name("else")
    expression(ifExpression.ifFalse)
}

fun ProgramOutputStream.whileExpression(whileExpression: WhileExpression) {
    name("while")
    parentheses { expression(whileExpression.test) }
    expression(whileExpression.block)
}

fun ProgramOutputStream.varDeclaration(variableDeclaration: VariableDeclaration) {
    type(variableDeclaration.varType ?: throw Exception("Unknown varType for $variableDeclaration"))
    name(variableDeclaration.name)
    variableDeclaration.expression?.apply {
        string("=")
        expression(this)
    }
}

fun ProgramOutputStream.block(block: BlockExpression) {
    braces {
        block.expressionList.forEach {
            newline()
            expression(it)
            string(";")
        }
    }
}
