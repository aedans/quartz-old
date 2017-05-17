package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class PointerType(val type: Type) : Type("${type.descriptiveString}_ptr") {
    override val string = "${type.string}*"

    override fun isInstance(type: Type): Boolean {
        return type is PointerType && this.type.isEqualTo(type.type)
    }

    override fun toString(): String {
        return "Pointer($type)"
    }
}
