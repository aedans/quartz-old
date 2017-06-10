package quartz.compiler.semantics.types

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

object InferredType : Type {
    override val descriptiveString: String
        get() =  throw IllegalAccessError()
    override val string: String
        get() = throw IllegalAccessError()

    override fun isSupertype(type: Type): Boolean {
        throw IllegalAccessError()
    }
}
