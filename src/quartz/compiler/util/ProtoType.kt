package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

open class ProtoType(val string: String, inline val function: () -> Type) {
    fun toType(): Type {
        return function()
    }

    override fun toString(): String {
        return string
    }
}
