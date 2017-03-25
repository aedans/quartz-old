package quartz.compiler.generator.util

import quartz.compiler.util.Type
import java.lang.StringBuilder

/**
 * Created by Aedan Smith.
 */

fun List<Pair<String, Type>>.visit(string: StringBuilder) {
    string.append('(')
    dropLast(1).forEach {
        it.visit(string)
        string.append(", ")
    }
    if (!isEmpty())
        last().visit(string)
    string.append(')')
}

fun Pair<String, Type>.visit(string: StringBuilder) {
    second.visit(string)
    string.append(' ')
    first.visitName(string)
}
