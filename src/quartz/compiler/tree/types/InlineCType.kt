package quartz.compiler.tree.types

import quartz.compiler.tree.Type

/**
 * Created by Aedan Smith.
 */

data class InlineCType(val string: String) : Type {
    override fun isConvertibleTo(type: Type): Boolean {
        return true
    }

    override fun toString(): String {
        return "%%$string%%"
    }
}
