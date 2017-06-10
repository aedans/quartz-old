package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class ConstType(val type: Type) : Type {
    override val descriptiveString by lazy { "const_${type.descriptiveString}" }
    override val string by lazy { "const ${type.string}" }

    override fun isConvertibleTo(type: Type): Boolean {
        return type.isConvertibleTo(this.type)
                || type is ConstType && this.type.isConvertibleTo(type.type)
    }

    override fun toString(): String {
        return "Const($type)"
    }
}
