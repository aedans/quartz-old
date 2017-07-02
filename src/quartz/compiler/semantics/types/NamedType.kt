package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class NamedType(val string: String) : Type {
    override fun isConvertibleTo(type: Type): Boolean {
        return type is NamedType && type.string == this.string
    }

    override fun toString(): String {
        return "Named($string)"
    }
}
