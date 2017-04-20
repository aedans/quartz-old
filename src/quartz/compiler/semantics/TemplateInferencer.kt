package quartz.compiler.semantics

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.types.*
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun List<Pair<Type, Type>>.inferTemplates(templates: List<TemplateType>): List<Type> {
    return errorScope({ "template inferencer" }) {
        val templateMap = mutableMapOf<TemplateType, Type>()
        this.forEach { inferTemplates(it.first, it.second, templateMap) }
        templates.map { templateMap[it] ?: throw QuartzException("Unable to infer type for $it") }
    }
}

private fun inferTemplates(first: Type, second: Type, templateMap: MutableMap<TemplateType, Type>) {
    if (first is TemplateType) {
        val old = templateMap[first]
        if (old == null)
            templateMap.put(first, second)
        else if (!old.isEqualTo(second))
            throw QuartzException("Conflicting types for $first: ($old, $second)")
    } else
        when (second) {
            is UnresolvedType -> { }
            is NumberType -> { }
            is VoidType -> { }
            is TemplateType -> { }
            is AliasedType -> inferTemplates(first, second.type, templateMap)
            is PointerType -> inferTemplates((first as PointerType).type, second.type, templateMap)
            is StructType -> {
                (first as StructType).members.values.map { it.type }.zip(second.members.values.map { it.type })
                        .forEach { inferTemplates(it.first, it.second, templateMap) }
            }
            is FunctionType -> {
                inferTemplates((first as FunctionType).function.returnType!!, second.function.returnType!!, templateMap)
                first.function.args.zip(second.function.args).forEach { inferTemplates(it.first, it.second, templateMap) }
            }
            else -> throw QuartzException("Unrecognized type $second")
        }
}
