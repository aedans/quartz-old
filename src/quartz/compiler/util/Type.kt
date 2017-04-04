package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

abstract class Type(val string: String, val descriptiveString: String, val templates: List<Type>) {
    abstract fun canCastTo(type: Type): Boolean

    abstract fun mapTypes(function: (Type?) -> Type?): Type

    abstract fun withTemplates(templates: List<Type>): Type

    override fun equals(other: Any?): Boolean {
        return other is Type && other.string == this.string && other.templates == templates
    }

    override fun hashCode(): Int {
        return string.hashCode() + templates.hashCode()
    }

    override fun toString(): String {
        return "$string${if (templates.isNotEmpty()) "<$templates>" else ""}"
    }

    companion object {
        fun canCast(t1: Type, t2: Type): Boolean {
            return t1.canCastTo(t2) || t2.canCastTo(t1)
        }
    }
}
