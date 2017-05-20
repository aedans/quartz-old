package quartz.compiler.tree.function

import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.util.Function

/**
 * Created by Aedan Smith.
 */

data class FunctionDeclaration(
        val name: String,
        val argNames: List<String>,
        val generics: List<String>,
        val function: Function,
        val block: Block
) : GlobalDeclaration {
    val argsWithNames = when {
        function.args == null -> null
        argNames.size != function.args.size -> throw Exception("$argNames.size != ${function.args}.size")
        else -> argNames.zip(function.args)
    }

    override fun toString(): String {
        return "$name${generics.joinToString(prefix = "<", postfix = ">")}$function {\n${block.toString(1)}}"
    }
}
