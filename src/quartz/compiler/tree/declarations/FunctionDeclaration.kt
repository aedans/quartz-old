package quartz.compiler.tree.declarations

import quartz.compiler.tree.Declaration
import quartz.compiler.tree.expression.Block
import quartz.compiler.tree.util.Function

/**
 * Created by Aedan Smith.
 */

data class FunctionDeclaration(
        override val name: String,
        val argNames: List<String>,
        val function: Function,
        val block: Block
) : Declaration {
    override fun toString(): String {
        return "$name$function {\n${block.toString(1)}}"
    }
}
