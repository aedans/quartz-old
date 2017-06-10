package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

object UnknownType : Type {
    override val descriptiveString: String
        get() = "???"
    override val string: String
        get() = "???"

    override fun isConvertibleTo(type: Type): Boolean {
        throw IllegalAccessError("Attempt to convert $this to $type")
    }

    override fun toString(): String {
        return string
    }
}
