package quartz.compiler.syntax.nodes.snodes

import quartz.compiler.generator.visitID
import quartz.compiler.syntax.nodes.Expression
import quartz.compiler.syntax.nodes.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class VarDeclaration(val name: String, val type: Type, val mutable: Boolean, val expression: Expression) : Statement {
    override fun toString(): String {
        return "${if (mutable) "var" else "val"} $name: $type = $expression"
    }

    override fun visit(builder: StringBuilder) {
        type.visit(builder)
        builder.append(" ")
        name.visitID(builder)
        builder.append(" = ")
        expression.visit(builder)
    }
}
