package quartz.compiler.util

import quartz.compiler.semantics.types.TemplateType

/**
 * Created by Aedan Smith.
 */

data class Function(val args: List<Type>, val templates: List<TemplateType>, val returnType: Type?, val vararg: Boolean) {
    override fun toString(): String {
        return (if (templates.isNotEmpty()) templates.joinToString(prefix = "<", postfix = ">") { it.toString() } else "") +
                "${args.joinToString(prefix = "(", postfix = ")") { it.toString() }}${if (vararg) "..." else ""} -> $returnType"
    }

    fun mapTypes(function: (Type?) -> Type?): Function {
        return Function(
                args.map { function(it.mapTypes(function))!! },
                templates,
                function(returnType?.mapTypes(function)),
                vararg
        )
    }
}
