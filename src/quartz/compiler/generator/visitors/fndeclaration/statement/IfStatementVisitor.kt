package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.generator.visitors.fndeclaration.visit
import quartz.compiler.syntax.tree.program.function.statement.IfStatementNode
import quartz.compiler.util.times

/**
 * Created by Aedan Smith.
 */

fun IfStatementNode.visit(string: StringBuilder, depth: Int) {
    string.append("if (")
    test.visit(string)
    string.appendln("){")
    for (statement in trueStatements) {
        string.append("    " * (depth + 1))
        statement.visit(string, depth + 1)
        string.appendln(";")
    }
    string.append(("    " * depth) + "}")
    if (!falseStatements.isEmpty()) {
        string.appendln("else{")
        for (statement in falseStatements) {
            string.append("    " * (depth + 1))
            statement.visit(string, depth + 1)
            string.appendln(";")
        }
        string.append(("    " * depth) + "}")
    }
}
