package quartz.compiler.parser.nodes

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class FnDeclarationNode(val name: String, val args: ArrayList<Pair<String, Type>>, val returnType: Type) {
    val statements = mutableListOf<StatementNode>()

    override fun toString(): String {
        @Suppress("unused")
        fun Pair<String, Type>.string() = "$second $first"
        var s = "$name("
        args.dropLast(1).forEach { s += it.string() + ", " }
        if (!args.isEmpty()) s += args.last().string()
        s += "): $returnType\n"
        statements.forEach { s += "|   " + it.toString() + '\n' }
        return s
    }
}
