package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.syntax.tree.program.function.expression.NumberLiteralNode

/**
 * Created by Aedan Smith.
 */

fun NumberLiteralNode.visit(string: StringBuilder){
    string.append(this.string)
}
