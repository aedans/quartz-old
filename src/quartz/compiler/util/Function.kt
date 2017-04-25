package quartz.compiler.util

import quartz.compiler.errors.QuartzException
import quartz.compiler.semantics.types.TemplateType

/**
 * Created by Aedan Smith.
 */

data class Function(val args: List<Type>, val returnType: Type?, val templates: List<TemplateType>, val vararg: Boolean) {
    override fun toString(): String {
        return (if (templates.isEmpty()) "" else templates.joinToString(prefix = "<", postfix = ">") { it.toString() }) +
                "${args.joinToString(prefix = "(", postfix = ")") { it.toString() }}${if (vararg) "..." else ""} -> $returnType"
    }

    fun mapTypes(function: (Type?) -> Type?): Function {
        return Function(
                args.map { function(it.mapTypes(function))!! },
                function(returnType?.mapTypes(function)),
                templates,
                vararg
        )
    }

    fun withTemplates(templates: List<Type>): Function {
        if (templates.size != this.templates.size)
            throw QuartzException("Incorrect number of templates for $this ($templates)")

        val templateMap = this.templates.zip(templates).toMap()
        return this.mapTypes { templateMap[it] ?: it }.copy(templates = emptyList())
    }
}
