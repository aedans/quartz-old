package quartz.compiler.tree.misc

import quartz.compiler.semantics.types.AliasedType
import quartz.compiler.tree.GlobalDeclarationNode
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class TypealiasNode(val name: String, val aliasedType: Type, val external: Boolean) : GlobalDeclarationNode {
    val type = AliasedType(name, aliasedType, external)

    override fun toString(): String {
        return "typealias $name = $aliasedType"
    }

    fun mapTypes(function: (Type?) -> Type?): TypealiasNode {
        return TypealiasNode(name, function(aliasedType.mapTypes(function))!!, false)
    }
}
