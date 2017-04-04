package quartz.compiler.semantics.types

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

object Primitives {
    val char: Type = NumType("char")
    val short: Type = NumType("short")
    val int: Type = NumType("int")
    val long: Type = NumType("long")
    val float: Type = NumType("float")
    val double: Type = NumType("double")
    val void: Type = QVoid()
}

private class NumType(string: String) : Type(string, string, emptyList()) {
    override fun withTemplates(templates: List<Type>): Type {
        if (templates.isEmpty()) return this
        throw QuartzException("Templates are not allowed on $this")
    }

    override fun mapTypes(function: (Type?) -> Type?): Type {
        return this
    }

    override fun canCastTo(type: Type): Boolean {
        return type is NumType
    }
}

private class QVoid : Type("void", "void", emptyList()) {
    override fun withTemplates(templates: List<Type>): Type {
        if (templates.isEmpty()) return this
        throw QuartzException("Templates are not allowed on $this")
    }

    override fun mapTypes(function: (Type?) -> Type?): Type {
        return this
    }

    override fun canCastTo(type: Type): Boolean {
        return type is QVoid
    }
}
