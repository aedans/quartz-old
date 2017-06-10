package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class NamedType(override val string: String) : Type {
    override val descriptiveString get() = string

    override fun isSupertype(type: Type): Boolean {
        return type is NamedType && type.string == this.string
    }

    override fun isEqualTo(type: Type): Boolean {
        return type is NamedType && type.string == this.string
    }

    override fun toString(): String {
        return "Named($string)"
    }
}
