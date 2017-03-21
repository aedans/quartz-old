package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.syntax.tree.program.function.expression.StringLiteralNode

/**
 * Created by Aedan Smith.
 */

// TODO Escape characters
fun StringLiteralNode.visit(string: StringBuilder) {
    string.append("\"${this.string}\"")
}
