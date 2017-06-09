package quartz.compiler.tree.declarations

import quartz.compiler.tree.Declaration
import quartz.compiler.tree.util.Function

/**
 * Created by Aedan Smith.
 */

data class ExternFunctionDeclaration(override val name: String, val function: Function) : Declaration {
    override fun toString(): String {
        return "$name$function"
    }
}
