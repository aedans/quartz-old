package quartz.compiler.generator.semantics

import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.function.expression.IdentifierNode
import quartz.compiler.visitor.visitExpressions

/**
 * Created by Aedan Smith.
 */

private val VALID_CHAR_START = ('a'..'z') + ('A'..'Z') + '_'
private val VALID_CHAR = ('a'..'z') + ('A'..'Z') +('0'..'9') + '_'

fun ProgramNode.verifyNames(): ProgramNode {
    return this.visitExpressions { if (it is IdentifierNode) IdentifierNode(it.name.verifyName(), it.type) else it }
}

fun String.verifyName(): String {
    var s = ""
    forEach {
        if (it in VALID_CHAR)
            s += it
        else
            s += it.toInt()
    }
    if (s[0] !in VALID_CHAR_START) {
        s = '_' + s
    }
    return s
}
