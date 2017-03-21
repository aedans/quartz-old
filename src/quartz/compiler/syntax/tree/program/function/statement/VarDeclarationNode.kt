package quartz.compiler.syntax.tree.program.function.statement

import quartz.compiler.syntax.tree.program.function.ExpressionNode
import quartz.compiler.syntax.tree.program.function.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class VarDeclarationNode(val name: String, var type: Type?, val mutable: Boolean, var expression: ExpressionNode?) : StatementNode {
    override fun toString(): String {
        return "${if (mutable) "var" else "val"} $name${if (type == null) "" else ": " + type.toString()}" +
                if (expression != null) " = $expression" else ""
    }
}
