package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type
import quartz.compiler.util.Visitor

/**
 * Created by Aedan Smith.
 */

data class PointerType(val type: Type) : Type {
    override fun isConvertibleTo(type: Type): Boolean {
        return type.isConvertibleTo(this.type)
                || type is PointerType && this.type.isConvertibleTo(type.type)
    }

    inline fun visitType(typeVisitor: Visitor<Type>): PointerType {
        return copy(type = typeVisitor(type))
    }

    override fun toString(): String {
        return "Pointer($type)"
    }
}
