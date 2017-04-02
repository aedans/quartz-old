package quartz.compiler.syntax.tree.misc

import quartz.compiler.syntax.tree.GlobalDeclarationNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class TypealiasNode(val name: String, val type: Type) : GlobalDeclarationNode {
    override fun toString(): String {
        return "typealias $name = $type"
    }

    fun mapTypes(function: (Type?) -> Type?): TypealiasNode {
        return TypealiasNode(name, function(type)!!)
    }
}
