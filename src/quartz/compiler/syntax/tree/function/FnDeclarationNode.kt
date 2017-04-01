package quartz.compiler.syntax.tree.function

import quartz.compiler.syntax.tree.GlobalDeclarationNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class FnDeclarationNode(
        val name: String,
        val args: List<Pair<String, Type>>,
        val returnType: Type,
        val statements: List<StatementNode> = listOf()
) : GlobalDeclarationNode {
    override fun toString(): String {
        var s = "$name$args: $returnType"
        statements.forEach { s += '\n' + it.toString(1) }
        return s
    }
}
