package quartz.compiler.syntax.tree.misc

import quartz.compiler.syntax.tree.GlobalDeclarationNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class ExternTypealiasNode(val name: String, val type: Type) : GlobalDeclarationNode {
    override fun toString(): String {
        return "typealias $name = $type"
    }

    fun mapTypes(function: (Type?) -> Type?): ExternTypealiasNode {
        return ExternTypealiasNode(name, function(type.mapTypes(function))!!)
    }
}
