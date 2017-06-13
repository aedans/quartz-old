package quartz.compiler.generator

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.types.*
import quartz.compiler.tree.Declaration
import quartz.compiler.tree.Program
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.declarations.InlineC
import quartz.compiler.tree.declarations.TypealiasDeclaration
import quartz.compiler.tree.expression.Expression
import quartz.compiler.tree.expression.expressions.*
import quartz.compiler.tree.util.Type
import quartz.compiler.util.nullableZip
import java.io.OutputStream

/**
 * Created by Aedan Smith.
 */

object Generator {
    fun generate(outputStream: OutputStream, program: Program) {
        val programOutputStream = ProgramOutputStream(outputStream)
        program.forEach { programOutputStream.declare(it) }
        program.forEach { programOutputStream.generate(it) }
    }

    fun ProgramOutputStream.declare(declaration: Declaration) {
        when (declaration) {
            is TypealiasDeclaration -> { }
            is InlineC -> { }
            is FunctionDeclaration -> {
                functionTypedef(declaration.type())
                functionPrototype(declaration)
            }
            is ExternFunctionDeclaration -> functionTypedef(declaration.type())
            else -> throw Exception("Expected declaration, found $declaration")
        }
    }

    fun ProgramOutputStream.generate(declaration: Declaration) {
        when (declaration) {
            is TypealiasDeclaration -> { }
            is ExternFunctionDeclaration -> { }
            is FunctionDeclaration -> generate(declaration)
            is InlineC -> generate(declaration)
            else -> throw Exception("Expected declaration, found $declaration")
        }
    }

    fun ProgramOutputStream.generate(functionDeclaration: FunctionDeclaration) {
        function(functionDeclaration.desugar())
    }

    fun ProgramOutputStream.generate(inlineC: InlineC) {
        inlineC(inlineC)
    }

    // TODO refactor
    fun ProgramOutputStream.inlineC(inlineCNode: InlineC) {
        name(inlineCNode.src)
    }

    fun ProgramOutputStream.functionPrototype(functionDeclaration: FunctionDeclaration) {
        type(functionDeclaration.function.returnType)
        name(functionDeclaration.name)
        args(functionDeclaration.argNames.nullableZip(functionDeclaration.function.args))
        string(";")
        newline()
    }

    fun ProgramOutputStream.function(functionDeclaration: FunctionDeclaration) {
        margin {
            type(functionDeclaration.function.returnType)
            name(functionDeclaration.name)
            args(functionDeclaration.argNames.nullableZip(functionDeclaration.function.args))
            block(functionDeclaration.block)
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
                is UnaryOperator -> prefixUnaryOperator(expression)
                is BinaryOperator -> binaryOperator(expression)
                is Assignment -> assignment(expression)
                is FunctionCall -> functionCall(expression)
                is IfExpression -> ifExpression(expression)
                is VariableDeclaration -> varDeclaration(expression)
                is Block -> block(expression)
                else -> throw QuartzException("Unrecognized expression $expression")
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

    fun ProgramOutputStream.prefixUnaryOperator(unaryOperator: UnaryOperator) {
        string(unaryOperator.id)
        parentheses { expression(unaryOperator.expression) }
    }

    fun ProgramOutputStream.binaryOperator(binaryOperator: BinaryOperator) {
        parentheses { expression(binaryOperator.expr1) }
        string(binaryOperator.id)
        parentheses { expression(binaryOperator.expr2) }
    }

    fun ProgramOutputStream.assignment(assignment: Assignment) {
        expression(assignment.lvalue)
        string("=")
        expression(assignment.expression)
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
        parentheses { expression(ifExpression.condition) }
        expression(ifExpression.ifTrue)
        name("else")
        expression(ifExpression.ifFalse)
    }

    fun ProgramOutputStream.varDeclaration(variableDeclaration: VariableDeclaration) {
        type(variableDeclaration.variableType)
        name(variableDeclaration.name)
        variableDeclaration.expression?.apply {
            string("=")
            expression(this)
        }
    }

    fun ProgramOutputStream.block(block: Block) {
        braces {
            block.forEach {
                newline()
                expression(it)
                string(";")
            }
        }
    }

    fun ProgramOutputStream.declare(type: Type) {
        when (type) {
            is FunctionType -> functionTypedef(type)
            is NamedType -> throw QuartzException("Unresolved type $type")
        }
    }

    fun ProgramOutputStream.functionTypedef(type: FunctionType) {
        val name = type.descriptiveString
        (type.function.args ?: throw Exception("Unknown argument types for $type")).forEach {
            declare(it)
        }
        declare(type.function.returnType)
        name("typedef")
        type(type.function.returnType)
        parentheses {
            string("*")
            string("__$name")
            string("_t")
        }
        parentheses {
            type.function.args.dropLast(1).forEach {
                type(it)
                string(", ")
            }
            if (type.function.args.isNotEmpty())
                type(type.function.args.last())
            if (type.function.vararg) {
                if (type.function.args.isNotEmpty())
                    string(", ")
                string("...")
            }
        }
        string(";")
        newline()
    }

    fun ProgramOutputStream.type(type: Type?) {
        type!!
        when (type) {
            is PointerType -> {
                type(type.type)
                string("*")
            }
            is FunctionType -> {
                name("__${type.descriptiveString}_t ")
            }
            is ConstType -> {
                name("const")
                type(type.type)
            }
            is NumberType -> {
                name(type.string)
            }
            is VoidType -> {
                name("void")
            }
            is InlineCType -> {
                name(type.string)
            }
            else -> throw Exception("Expected type, found $type")
        }
    }

    fun ProgramOutputStream.args(args: List<Pair<String, Type?>>?) {
        args!!
        string("(")
        args.dropLast(1).forEach {
            arg(it.let { it.first to it.second!! })
            string(", ")
        }
        if (!args.isEmpty())
            arg(args.last().let { it.first to it.second!! })
        string(")")
    }

    fun ProgramOutputStream.arg(arg: Pair<String, Type?>) {
        type(arg.second)
        name(arg.first)
    }
}
