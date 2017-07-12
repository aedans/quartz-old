package quartz.compiler.tree.pretty

import quartz.compiler.tree.Declaration
import quartz.compiler.tree.Expression
import quartz.compiler.tree.Program
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.declarations.FunctionDeclaration
import quartz.compiler.tree.expression.ExpressionList
import quartz.compiler.tree.expression.ExpressionPair
import quartz.compiler.tree.expression.LetExpression
import quartz.compiler.util.times
import java.io.PrintStream

/**
 * Created by Aedan Smith.
 */

fun Program.printPretty(printStream: PrintStream) {
    forEach {
        it.printPretty(printStream)
        printStream.print("\n\n")
    }
}

fun Declaration.printPretty(printStream: PrintStream) {
    when (this) {
        is FunctionDeclaration -> printPretty(printStream)
        is ExternFunctionDeclaration -> printPretty(printStream)
        else -> printStream.print(this)
    }
}

fun FunctionDeclaration.printPretty(printStream: PrintStream) {
    printStream.print("fn $name")
    printStream.print(args.joinToString(prefix = "(", postfix = ")") { "${it.first}: ${it.second}" })
    printStream.println(": $returnType")
    expression.printPretty(printStream, 1)
}

fun ExternFunctionDeclaration.printPretty(printStream: PrintStream) {
    printStream.print("extern fn $name")
    printStream.print(args.joinToString(prefix = "(", postfix = ")"))
}

fun Expression.printPretty(printStream: PrintStream, indent: Int) {
    when (this) {
        is ExpressionList -> printPretty(printStream, indent)
        is ExpressionPair -> printPretty(printStream, indent)
        is LetExpression -> printPretty(printStream, indent)
        else -> printStream.print("${"    " * indent}$this")
    }
}

fun ExpressionList.printPretty(printStream: PrintStream, indent: Int) {
    forEach {
        it.printPretty(printStream, indent)
        printStream.println()
    }
}

fun ExpressionPair.printPretty(printStream: PrintStream, indent: Int) {
    expr1.printPretty(printStream, indent)
    printStream.println(";")
    expr2.printPretty(printStream, indent)
}

fun LetExpression.printPretty(printStream: PrintStream, indent: Int) {
    printStream.print("    " * indent)
    printStream.print("let $name")
    if (variableType != null) print(": $variableType")
    if (value != null) print(" = $value")
    printStream.println(" in")
    expression.printPretty(printStream, indent)
}
