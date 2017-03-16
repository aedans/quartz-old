package quartz.compiler.syntax.nodes.enodes

import quartz.compiler.syntax.nodes.Expression
import quartz.compiler.syntax.nodes.Statement
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class InlineC(val src: String, override val evalType: Type): Expression, Statement {
    override fun toString(): String {
        return "%$src%"
    }

    override fun visit(builder: StringBuilder) {
        builder.append(src)
    }
}
