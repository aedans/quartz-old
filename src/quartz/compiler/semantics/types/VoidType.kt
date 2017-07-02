package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

object VoidType : Type {
    override fun isConvertibleTo(type: Type): Boolean {
        return type == this
    }

    override fun toString(): String {
        return "void"
    }
}
