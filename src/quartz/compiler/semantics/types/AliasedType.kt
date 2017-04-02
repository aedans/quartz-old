package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class AliasedType(name: String, val type: Type) : NamedType(name) {
    override fun canCastTo(type: Type): Boolean {
        return type == this.type || super.canCastTo(type)
    }

    override fun toString(): String {
        return name
    }
}
