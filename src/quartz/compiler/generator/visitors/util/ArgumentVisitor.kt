package quartz.compiler.generator.visitors.util

import quartz.compiler.generator.Visitor
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

val argumentVisitor: Visitor<List<Pair<String, Type>>> = { args, string, depth ->
    string.append('(')
    args.dropLast(1).forEach {
        singleArgumentVisitor(it, string, depth)
        string.append(", ")
    }
    if (!args.isEmpty())
        singleArgumentVisitor(args.last(), string, depth)
    string.append(')')
}

private val singleArgumentVisitor: Visitor<Pair<String, Type>> = { arg, string, depth ->
    typeVisitor(arg.second, string, depth)
    string.append(' ')
    nameVisitor(arg.first, string, depth)
}
