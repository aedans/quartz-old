package quartz.compiler.tree.misc

import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class ExternFunctionDeclaration(val name: String, val function: Function) : GlobalDeclaration {
    override fun toString(): String {
        return "$name$function"
    }

    fun mapTypes(function: (Type?) -> Type?): ExternFunctionDeclaration {
        return ExternFunctionDeclaration(name, Function(
                this.function.args.map { function(it.mapTypes(function))!! },
                this.function.templates,
                function(this.function.returnType.mapTypes(function))!!,
                this.function.vararg
        ))
    }
}
