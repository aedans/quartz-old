package quartz.compiler.generator.visitors.fndeclaration.statement

import quartz.compiler.generator.visitors.fndeclaration.visit
import quartz.compiler.syntax.tree.program.function.statement.ReturnNode

/**
 * Created by Aedan Smith.
 */

fun ReturnNode.visit(string: StringBuilder) {
    string.append("return ")
    expressionNode.visit(string)
}
