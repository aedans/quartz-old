package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class ConstType(val type: Type) : Type {
    override val descriptiveString by lazy { "const_${type.descriptiveString}" }
    override val string by lazy { "const ${type.string}" }

    override fun isSupertype(type: Type): Boolean {
        return type.isSupertype(this.type)
                || type is ConstType && this.type.isSupertype(type.type)
    }

    override fun toString(): String {
        return "Const($type)"
    }
}
