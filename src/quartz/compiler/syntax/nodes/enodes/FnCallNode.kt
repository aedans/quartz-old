package quartz.compiler.syntax.nodes.enodes

import quartz.compiler.syntax.nodes.ExpressionNode
import quartz.compiler.syntax.nodes.StatementNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class FnCallNode(val name: String, val args: List<ExpressionNode>, override val evalType: Type) : ExpressionNode, StatementNode {
    override fun toString(): String {
        return "$name(${args.toString().substring(1, args.toString().length-1)}): $evalType"
    }

    override fun visit(builder: StringBuilder) {
        builder.append("$name(")
        for (arg in args.dropLast(1)) {
            arg.visit(builder)
            builder.append(", ")
        }
        if (!args.isEmpty()) {
            args.last().visit(builder)
        }
        builder.append(")")
    }
}
