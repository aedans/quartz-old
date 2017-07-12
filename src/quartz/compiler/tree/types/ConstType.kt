package quartz.compiler.tree.types

import quartz.compiler.tree.Type

/**
 * Created by Aedan Smith.
 */

data class ConstType(val type: Type) : Type {
    override fun isConvertibleTo(type: Type): Boolean {
        return type.isConvertibleTo(this.type)
                || type is ConstType && this.type.isConvertibleTo(type.type)
    }

    override fun toString(): String {
        return "const $type"
    }
}
