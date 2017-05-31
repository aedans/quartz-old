package quartz.compiler.generator

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.generator.translator.simplify
import quartz.compiler.generator.util.args
import quartz.compiler.generator.util.type
import quartz.compiler.semantics.types.FunctionType
import quartz.compiler.semantics.types.NamedType
import quartz.compiler.semantics.types.type
import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.function.Block
import quartz.compiler.tree.function.Expression
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.function.expression.*
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.misc.InlineC
import quartz.compiler.tree.util.Type
import java.io.OutputStream

/**
 * Created by Aedan Smith.
 */

data class CGenerator(
        val outputStream: OutputStream
) : Generator {
    val cStream = ProgramOutputStream(outputStream)
    val declaredFunctions = HashSet<String>()
    val declaredTypedefs = HashSet<String>()

    override fun isDeclared(globalDeclaration: GlobalDeclaration): Boolean {
        return when (globalDeclaration) {
            is FunctionDeclaration -> declaredFunctions.contains(globalDeclaration.name)
            is ExternFunctionDeclaration -> false
            else -> throw Exception("Expected global declaration, found $globalDeclaration")
        }
    }

    override fun declare(globalDeclaration: GlobalDeclaration) {
        when (globalDeclaration) {
            is FunctionDeclaration -> declaredFunctions.add(globalDeclaration.name)
            is ExternFunctionDeclaration -> { }
            else -> throw Exception("Expected global declaration, found $globalDeclaration")
        }
    }

    override fun generate(functionDeclaration: FunctionDeclaration) {
        cStream.functionTypedef(functionDeclaration.type())
        cStream.functionPrototype(functionDeclaration)
        cStream.function(functionDeclaration.simplify())
    }

    override fun generate(externFunctionDeclaration: ExternFunctionDeclaration) {
        cStream.functionTypedef(externFunctionDeclaration.type())
    }

    override fun generate(inlineC: InlineC) {
        cStream.inlineC(inlineC)
    }

    // TODO refactor
    fun ProgramOutputStream.inlineC(inlineCNode: InlineC) {
        name(inlineCNode.src)
    }

    fun ProgramOutputStream.functionPrototype(functionDeclaration: FunctionDeclaration) {
        type(functionDeclaration.function.returnType!!)
        name(functionDeclaration.name)
        args(functionDeclaration.argsWithNames)
        string(";")
        newline()
    }

    fun ProgramOutputStream.function(functionDeclaration: FunctionDeclaration) {
        margin {
            type(functionDeclaration.function.returnType!!)
            name(functionDeclaration.name)
            args(functionDeclaration.argsWithNames)
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
                is BlockExpression -> block(expression)
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
        type(variableDeclaration.variableType ?: throw QuartzException("Unknown type for $variableDeclaration"))
        name(variableDeclaration.name)
        variableDeclaration.expression?.apply {
            string("=")
            expression(this)
        }
    }

    fun ProgramOutputStream.block(block: Block) {
        braces {
            block.expressionList.forEach {
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
        if (!declaredTypedefs.contains(name)) {
            (type.function.args ?: throw Exception("Unknown argument types for $type")).forEach {
                declare(it ?: throw Exception("Unknown argument type for $type"))
            }
            declare(type.function.returnType ?: throw Exception("Unknown return type for $type"))
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
        declaredTypedefs.add(name)
    }
}
