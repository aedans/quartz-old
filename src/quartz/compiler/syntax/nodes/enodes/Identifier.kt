package quartz.compiler.syntax.nodes.enodes

import quartz.compiler.generator.visitID
import quartz.compiler.syntax.nodes.Expression
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class Identifier(val name: String, override val evalType: Type) : Expression {
    override fun toString(): String {
        return "$name: $evalType"
    }

    override fun visit(builder: StringBuilder) {
        name.visitID(builder)
    }
}
