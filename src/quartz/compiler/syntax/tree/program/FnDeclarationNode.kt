package quartz.compiler.syntax.tree.program

import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class FnDeclarationNode(val name: String, val args: List<Pair<String, Type>>, val returnType: Type) {
    var statements = mutableListOf<StatementNode>()

    override fun toString(): String {
        @Suppress("unused")
        fun Pair<String, Type>.string() = "$second $first"
        var s = "$name("
        args.dropLast(1).forEach { s += it.string() + ", " }
        if (!args.isEmpty()) s += args.last().string()
        s += "): $returnType"
        statements.forEach { s += '\n' + it.toString(1) }
        return s
    }
}
