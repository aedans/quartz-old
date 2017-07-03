package quartz.compiler.tree.declarations

import quartz.compiler.tree.Declaration
import quartz.compiler.tree.util.Function
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

data class ExternFunctionDeclaration(override val name: String, val function: Function) : Declaration {
    inline fun visitFunction(functionVisitor: Visitor<Function>): ExternFunctionDeclaration {
        return copy(function = functionVisitor(function))
    }

    override fun toString(): String {
        return "$name$function"
    }
}
