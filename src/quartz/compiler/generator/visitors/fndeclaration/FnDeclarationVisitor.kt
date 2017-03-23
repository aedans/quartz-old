package quartz.compiler.generator.visitors.fndeclaration

import quartz.compiler.generator.visitors.util.visit
import quartz.compiler.generator.visitors.util.visitFunctionDescription
import quartz.compiler.generator.visitors.util.visitName
import quartz.compiler.syntax.tree.program.function.FnDeclarationNode

/**
 * Created by Aedan Smith.
 */

fun FnDeclarationNode.visit(string: StringBuilder) {
    returnType.visit(string)
    string.append(' ')
    name.visitName(string)
    args.visit(string)
    string.appendln('{')
    statements.forEach {
        string.append("    ")
        it.visit(string, 1)
        string.appendln(";")
    }
    string.appendln('}')
}

fun FnDeclarationNode.visitTypedef(string: StringBuilder) {
    string.append("typedef ")
    returnType.visit(string)
    string.append(" (*")
    visitFunctionDescription(args.map { it.second }, returnType, string)
    string.append("_t")
    string.append(')')
    string.append('(')
    if (!args.isEmpty()) {
        args.dropLast(1).forEach {
            it.visit(string)
            string.append(", ")
        }
        args.last().visit(string)
    }
    string.appendln(");")
}

fun FnDeclarationNode.visitPrototype(string: StringBuilder) {
    returnType.visit(string)
    string.append(' ')
    name.visitName(string)
    args.visit(string)
    string.appendln(";")
}
