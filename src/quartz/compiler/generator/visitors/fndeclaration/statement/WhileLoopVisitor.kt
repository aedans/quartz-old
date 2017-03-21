package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.generator.visitors.fndeclaration.visit
import quartz.compiler.syntax.tree.program.function.statement.WhileLoopNode
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

fun WhileLoopNode.visit(string: StringBuilder, depth: Int) {
    string.append("while (")
    test.visit(string)
    string.appendln("){")
    for (statement in statements) {
        string.append("    " * (depth + 1))
        statement.visit(string, depth + 1)
        string.appendln(";")
    }
    string.append(("    " * depth) + "}")
}
