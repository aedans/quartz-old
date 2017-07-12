package quartz.compiler.generator

import quartz.compiler.errors.err
import quartz.compiler.errors.errorScope
import quartz.compiler.generator.expressions.VariableDeclarationExpression
import quartz.compiler.tree.Declaration
import quartz.compiler.tree.Expression
import quartz.compiler.tree.Type
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.declarations.InlineC
import quartz.compiler.tree.declarations.TypealiasDeclaration
import quartz.compiler.tree.expression.*
import quartz.compiler.tree.types.*
import java.io.OutputStream
import java.io.PrintStream
import java.util.*

/**
 * Created by Aedan Smith.
 */

class ProgramWriter(outputStream: OutputStream) {
    private val declared = HashSet<Any>()
    private val identifierChars = { c: Char -> c in 'a'..'z' || c in 'A'..'Z' || c in '0'..'9'|| c == '_' }
    private var lastChar = ' '
    private val printStream = PrintStream(outputStream)
    private var indent = 0

    init {
        comment("Generated by the Quartz compiler")
    }

    fun declareDeclaration(declaration: Declaration) {
        declaration.declare()
    }

    private fun Declaration.declare() {
        when (this) {
            is TypealiasDeclaration -> {
            }
            is InlineC -> {
            }
            is FunctionDeclaration -> {
                type.declare()
                this.declare()
            }
            is ExternFunctionDeclaration -> type.declare()
            else -> err { "Expected declaration, found $this" }
        }
    }

    private fun FunctionDeclaration.declare() {
        declare {
            returnType.generate()
            name(name)
            args.generate()
            string(";")
            newline()
        }
    }

    private fun Type.declare() {
        when (this) {
            is FunctionType -> this.declare()
            is NamedType -> err { "Unresolved type $this" }
        }
    }

    private fun FunctionType.declare() {
        declare {
            val name = description()
            args.forEach {
                it.declare()
            }
            returnType.declare()
            name("typedef")
            returnType.generate()
            parentheses {
                string("*")
                string("__$name")
                string("_t")
            }
            parentheses {
                args.dropLast(1).forEach {
                    it.generate()
                    string(", ")
                }
                if (args.isNotEmpty())
                    args.last().generate()
                if (vararg) {
                    if (args.isNotEmpty())
                        string(", ")
                    string("...")
                }
            }
            string(";")
            newline()
        }
    }

    fun generateDeclaration(declaration: Declaration) {
        declaration.generate()
    }

    private fun Declaration.generate() {
        when (this) {
            is TypealiasDeclaration -> {
            }
            is ExternFunctionDeclaration -> {
            }
            is InlineC -> generate()
            is FunctionDeclaration -> this.desugar().generate()
            else -> err { "Expected declaration, found $this" }
        }
    }

    private fun FunctionDeclaration.generate() {
        margin {
            returnType.generate()
            name(name)
            args.generate()
            (expression as ExpressionList).generate()
        }
    }

    private fun Expression.generate() {
        errorScope({ "value ${this}" }) {
            when (this) {
                EmptyExpression -> string("{}")
                is InlineC -> generate()
                is NumberLiteral -> generate()
                is StringLiteral -> generate()
                is Identifier -> generate()
                is Sizeof -> generate()
                is Cast -> generate()
                is ReturnExpression -> generate()
                is UnaryOperation -> generate()
                is BinaryOperation -> generate()
                is ExpressionPair -> generate()
                is Assignment -> generate()
                is FunctionCall -> generate()
                is IfExpression -> generate()
                is VariableDeclarationExpression -> generate()
                is ExpressionList -> generate()
                else -> err { "Unrecognized expression ${this}" }
            }
        }
    }

    private fun InlineC.generate() {
        name(src)
    }

    private fun NumberLiteral.generate() {
        name(string)
    }

    private fun StringLiteral.generate() {
        string("\"$string\"")
    }

    private fun Identifier.generate() {
        name(name)
    }

    private fun Sizeof.generate() {
        name("sizeof")
        parentheses { sizeType.generate() }
    }

    private fun Cast.generate() {
        parentheses { type.generate() }
        parentheses { expression.generate() }
    }

    private fun ReturnExpression.generate() {
        name("return")
        expression.generate()
    }

    private fun UnaryOperation.generate() {
        string(id)
        parentheses { expression.generate() }
    }

    private fun BinaryOperation.generate() {
        parentheses { expr1.generate() }
        string(id)
        parentheses { expr2.generate() }
    }

    private fun ExpressionPair.generate() {
        parentheses { expr1.generate() }
        string(",")
        newline()
        string("\t")
        parentheses { expr2.generate() }
    }

    private fun Assignment.generate() {
        lvalue.generate()
        string("=")
        expression.generate()
    }

    private fun FunctionCall.generate() {
        expression.generate()
        parentheses {
            if (args.isNotEmpty()) {
                args.dropLast(1).forEach {
                    it.generate()
                    string(",")
                }
                args.last().generate()
            }
        }
    }

    private fun IfExpression.generate() {
        name("if")
        parentheses { condition.generate() }
        (ifTrue as ExpressionList).generate()
        if (ifFalse != null) {
            name("else")
            (ifFalse as ExpressionList).generate()
        }
    }

    private fun VariableDeclarationExpression.generate() {
        variableType.generate()
        name(name)
        value?.apply {
            string("=")
            value.generate()
        }
    }

    private fun ExpressionList.generate() {
        braces {
            forEach {
                newline()
                it.generate()
                string(";")
            }
        }
    }

    private fun Type?.generate() {
        this!!
        when (this) {
            is FunctionType -> name("__${description()}_t ")
            is NumberType -> name(string)
            is VoidType -> name("void")
            is InlineCType -> name(string)
            is PointerType -> {
                type.generate()
                string("*")
            }
            is ConstType -> {
                name("const")
                type.generate()
            }
            else -> err { "Expected type, found ${this}" }
        }
    }

    private fun List<Pair<String, Type?>>?.generate() {
        this!!
        string("(")
        dropLast(1).forEach {
            it.let { it.first to it.second!! }.generate()
            string(", ")
        }
        if (!isEmpty())
            last().let { it.first to it.second!! }.generate()
        string(")")
    }

    private fun Pair<String, Type?>.generate() {
        second.generate()
        name(first)
    }

    private inline fun Any.declare(function: () -> Unit) {
        if (!declared.contains(this)) {
            declared.add(this)
            function()
        }
    }

    private inline fun margin(function: ProgramWriter.() -> Unit) {
        newline()
        function()
        newline()
    }

    private inline fun braces(function: ProgramWriter.() -> Unit) {
        string("{")
        indent++
        function()
        indent--
        newline()
        string("}")
    }

    private inline fun parentheses(function: ProgramWriter.() -> Unit) {
        string("(")
        function()
        string(")")
    }

    private fun comment(string: String) {
        string("/* $string */\n")
    }

    private fun name(string: Any) {
        if (identifierChars(lastChar))
            string(" ")
        string(string)
    }

    private fun newline() {
        string('\n')
        for (i in 0 until indent) {
            string('\t')
        }
    }

    private fun string(string: Any) {
        string(string.toString())
    }

    private fun string(string: String) {
        printStream.print(string)
        lastChar = if (string.isNotEmpty()) string.last() else ' '
    }
}
