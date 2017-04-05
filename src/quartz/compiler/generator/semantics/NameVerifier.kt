package quartz.compiler.generator.semantics

import quartz.compiler.tree.Program
import quartz.compiler.tree.function.expression.Identifier

/**
 * Created by Aedan Smith.
 */

// TODO fix

private val VALID_CHAR_START = ('a'..'z') + ('A'..'Z') + '_'
private val VALID_CHAR = ('a'..'z') + ('A'..'Z') +('0'..'9') + '_'

fun Program.verifyNames(): Program {
    return this.mapExpressions { if (it is Identifier) Identifier(it.name.verifyName(), it.type) else it }
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
