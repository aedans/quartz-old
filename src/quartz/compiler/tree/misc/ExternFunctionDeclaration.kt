package quartz.compiler.tree.misc

import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.tree.util.Function

/**
 * Created by Aedan Smith.
 */

data class ExternFunctionDeclaration(val name: String, val function: Function) : GlobalDeclaration {
    override fun toString(): String {
        return "$name$function"
    }
}
