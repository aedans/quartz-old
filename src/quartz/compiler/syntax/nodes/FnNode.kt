package quartz.compiler.syntax.nodes

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class FnNode(val name: String, val args: List<Pair<String, Type>>, val returnType: Type) {
    val statements = mutableListOf<StatementNode>()

    override fun toString(): String {
        var string ="$name("
        args.forEach { string += it.first + ": " + it.second + ", " }
        string = (if (!args.isEmpty()) string.substring(0, string.length-2) else string) + "): $returnType\n"
        statements.forEach {
            string += "    " + it.toString() + '\n'
        }
        return string
    }

    fun visit(builder: StringBuilder) {
        builder.append("$returnType ")
        builder.append("$name(")
        for (arg in args.dropLast(1)) {
            builder.append("${arg.second} ${arg.first}")
            builder.append(", ")
        }
        if (!args.isEmpty()) {
            builder.append("${args.last().second} ${args.last().first}")
        }

        builder.append(")")
    }
}
