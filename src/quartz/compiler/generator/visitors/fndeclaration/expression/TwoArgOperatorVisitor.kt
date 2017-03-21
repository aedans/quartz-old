package quartz.compiler.generator.visitors.fndeclaration.expression

import quartz.compiler.generator.visitors.fndeclaration.visit
import quartz.compiler.syntax.tree.program.function.expression.TwoArgOperatorNode

/**
 * Created by Aedan Smith.
 */

fun TwoArgOperatorNode.visit(string: StringBuilder) {
    when (id) {
        TwoArgOperatorNode.ID.ARRAY_ACCESS -> {
            string.append('(')
            expr1.visit(string)
            string.append(")[")
            expr2.visit(string)
            string.append(']')
        }
        else -> {
            string.append('(')
            expr1.visit(string)
            string.append(')')
            string.append(id)
            string.append('(')
            expr2.visit(string)
            string.append(')')
        }
    }
}
