package quartz.compiler.semantics

import quartz.compiler.semantics.types.StructType
import quartz.compiler.tree.Program
import quartz.compiler.tree.struct.StructDeclaration

/**
 * Created by Aedan Smith.
 */

fun Program.resolveTypeTemplates(): Program {
    val newStructDeclarations = mutableListOf<StructDeclaration>()
    return this.mapTypes {
        when (it) {
            is StructType -> it.resolveTypeTemplates(newStructDeclarations)
            else -> it
        }
    }.copy(structDeclarations = newStructDeclarations.map { it.name to it }.toMap())
}

private fun StructType.resolveTypeTemplates(newStructDeclarations: MutableList<StructDeclaration>): StructType {
    val typeMap = structDeclarationNode.templates.zip(templates).toMap()
    var newName = structDeclarationNode.name
    templates.forEach { newName += '_' + it.descriptiveString }

    val newStructDeclaration = StructDeclaration(
            newName,
            emptyList(),
            structDeclarationNode.members,
            structDeclarationNode.external
    ).mapTypes { typeMap[it] ?: it }

    if (!newStructDeclarations.contains(newStructDeclaration))
        newStructDeclarations.add(newStructDeclaration)

    return StructType(
            newName,
            emptyList(),
            newStructDeclaration
    )
}
