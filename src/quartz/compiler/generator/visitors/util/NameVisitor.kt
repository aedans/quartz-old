package quartz.compiler.generator.visitors.util

import quartz.compiler.generator.Visitor

/**
 * Created by Aedan Smith.
 */

private val VALID_CHAR_START = ('a'..'z') + ('A'..'Z') + '_'
private val VALID_CHAR = ('a'..'z') + ('A'..'Z') +('0'..'9') + '_'

val nameVisitor: Visitor<String> = { identifier, string, _ ->
    var s = ""
    identifier.forEach {
        if (it in VALID_CHAR)
            s += it
        else
            s += it.toInt()
    }
    if (s[0] !in VALID_CHAR_START) {
        s = '_' + s
    }
    string.append(s)
}
