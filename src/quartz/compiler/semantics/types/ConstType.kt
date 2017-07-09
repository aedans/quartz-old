package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class ConstType(val type: Type) : Type {
    override fun isConvertibleTo(type: Type): Boolean {
        return type.isConvertibleTo(this.type)
                || type is ConstType && this.type.isConvertibleTo(type.type)
    }

    override fun toString(): String {
        return "Const($type)"
    }
}
