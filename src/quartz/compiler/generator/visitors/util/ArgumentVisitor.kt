package quartz.compiler.generator.visitors.util

import quartz.compiler.generator.Visitor
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

val argumentVisitor: Visitor<List<Pair<String, Type>>> = { args, string ->
    string.append('(')
    args.dropLast(1).forEach {
        singleArgumentVisitor(it, string)
        string.append(", ")
    }
    if (!args.isEmpty())
        singleArgumentVisitor(args.last(), string)
    string.append(')')
}

private val singleArgumentVisitor: Visitor<Pair<String, Type>> = { arg, string ->
    typeVisitor(arg.second, string)
    string.append(' ')
    nameVisitor(arg.first, string)
}
