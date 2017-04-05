package quartz.compiler.tree.misc

import quartz.compiler.semantics.types.AliasedType
import quartz.compiler.tree.GlobalDeclaration
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class Typealias(val name: String, val aliasedType: Type, val external: Boolean) : GlobalDeclaration {
    val type = AliasedType(name, aliasedType, external)

    override fun toString(): String {
        return "typealias $name = $aliasedType"
    }

    fun mapTypes(function: (Type?) -> Type?): Typealias {
        return Typealias(name, function(aliasedType.mapTypes(function))!!, false)
    }
}
