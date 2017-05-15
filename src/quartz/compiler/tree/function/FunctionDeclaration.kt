package quartz.compiler.tree.function

import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

data class FunctionDeclaration(
        val name: String,
        val argNames: List<String>,
        val function: Function,
        val block: Block
) : GlobalDeclaration {
    val argsWithNames by lazy {
        when {
            function.args == null -> null
            argNames.size != function.args.size -> throw Exception("$argNames.size != ${function.args}.size")
            else -> argNames.zip(function.args)
        }
    }

    override fun toString(): String {
        return "$name$function {\n${block.toString(1)}}"
    }
}
