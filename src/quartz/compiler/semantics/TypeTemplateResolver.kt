package quartz.compiler.semantics

import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.types.StructType
import quartz.compiler.semantics.types.TemplateType
import quartz.compiler.tree.Program
import quartz.compiler.tree.struct.StructDeclaration

/**
 * Created by Aedan Smith.
 */

fun Program.resolveTypeTemplates(): Program {
    return errorScope({ "type template resolver" }) {
        val newStructDeclarations = mutableListOf<StructDeclaration>()
        this.mapTypes {
            when (it) {
                is StructType -> errorScope({ "struct type $it" }) {
                    it.resolveTypeTemplates(newStructDeclarations)
                }
                else -> it
            }
        }.copy(structDeclarations = newStructDeclarations.map { it.name to it }.toMap())
    }
}

private fun StructType.resolveTypeTemplates(newStructDeclarations: MutableList<StructDeclaration>): StructType {
    if (templates.any { it is TemplateType })
        return this

    val typeMap = templates.zip(templates).toMap()
    var newName = string
    templates.forEach { newName += '_' + it.descriptiveString }

    val newStructDeclaration = StructDeclaration(
            newName,
            emptyList(),
            members,
            false
    ).mapTypes { typeMap[it] ?: it }

    if (!newStructDeclarations.contains(newStructDeclaration))
        newStructDeclarations.add(newStructDeclaration)

    return newStructDeclaration.type
}
