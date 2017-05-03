package quartz.compiler.generator.util

import quartz.compiler.generator.ProgramOutputStream
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun ProgramOutputStream.args(args: List<Pair<String, Type?>>?) {
    args!!
    string("(")
    args.dropLast(1).forEach {
        arg(it.let { it.first to it.second!! })
        string(", ")
    }
    if (!args.isEmpty())
        arg(args.last().let { it.first to it.second!! })
    string(")")
}

fun ProgramOutputStream.arg(arg: Pair<String, Type>) {
    type(arg.second)
    name(arg.first)
}
