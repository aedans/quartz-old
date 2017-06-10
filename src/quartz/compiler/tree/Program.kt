package quartz.compiler.tree

/**
 * Created by Aedan Smith.
 */

typealias Program = List<Declaration>

fun Program.toFancyString(): String {
    return joinToString(separator = "\n")
}
