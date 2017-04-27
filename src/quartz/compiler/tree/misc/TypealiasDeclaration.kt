package quartz.compiler.tree.misc

import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class TypealiasDeclaration(val name: String, val aliasedType: Type, val external: Boolean) : GlobalDeclaration {
    override fun toString(): String {
        return "typealias $name = $aliasedType"
    }

    fun mapTypes(function: (Type?) -> Type?): TypealiasDeclaration {
        return TypealiasDeclaration(name, function(aliasedType.mapTypes(function))!!, external)
    }
}
