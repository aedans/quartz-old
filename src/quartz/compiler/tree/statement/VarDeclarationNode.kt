package quartz.compiler.tree.statement

import quartz.compiler.tree.ExpressionNode
import quartz.compiler.tree.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class VarDeclarationNode(val name: String, var type: Type?, val mutable: Boolean, var expression: ExpressionNode) : StatementNode {
    override fun toString(): String {
        return "${if (mutable) "var" else "val"} $name${if (type == null) "" else ": " + type.toString()} = $expression"
    }
}
