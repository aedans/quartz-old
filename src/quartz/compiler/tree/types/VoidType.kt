package quartz.compiler.tree.types

import quartz.compiler.tree.Type

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
