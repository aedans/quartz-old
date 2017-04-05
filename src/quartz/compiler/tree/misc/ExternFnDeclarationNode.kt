package quartz.compiler.tree.misc

import quartz.compiler.tree.GlobalDeclarationNode
import quartz.compiler.util.Function
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class ExternFnDeclarationNode(val name: String, val function: Function) : GlobalDeclarationNode {
    override fun toString(): String {
        return "$name$function"
    }

    fun mapTypes(function: (Type?) -> Type?): ExternFnDeclarationNode {
        return ExternFnDeclarationNode(name, Function(
                this.function.args.map { function(it.mapTypes(function))!! },
                this.function.templates.map { function(it.mapTypes(function))!! },
                function(this.function.returnType.mapTypes(function))!!,
                this.function.vararg
        ))
    }
}
