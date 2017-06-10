package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class PointerType(val type: Type) : Type {
    override val descriptiveString by lazy { "${type.descriptiveString}_ptr" }
    override val string by lazy { "${type.string}*" }

    override fun isConvertibleTo(type: Type): Boolean {
        return type.isConvertibleTo(this.type)
                || type is PointerType && this.type.isConvertibleTo(type.type)
    }

    override fun toString(): String {
        return "Pointer($type)"
    }
}
