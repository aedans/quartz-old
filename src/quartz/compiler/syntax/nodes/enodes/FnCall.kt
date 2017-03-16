package quartz.compiler.syntax.nodes.enodes

import quartz.compiler.generator.visitID
import quartz.compiler.syntax.nodes.Expression
import quartz.compiler.syntax.nodes.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class FnCall(val name: String, val args: List<Expression>, override val evalType: Type) : Expression, Statement {
    override fun toString(): String {
        return "$name(${args.toString().substring(1, args.toString().length-1)}): $evalType"
    }

    override fun visit(builder: StringBuilder) {
        name.visitID(builder)
        builder.append("(")
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
