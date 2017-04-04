package quartz.compiler.semantics

import quartz.compiler.semantics.types.StructType
import quartz.compiler.syntax.tree.ProgramNode
import quartz.compiler.syntax.tree.struct.StructDeclarationNode

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.resolveTypeTemplates(): ProgramNode {
    val newStructDeclarations = mutableListOf<StructDeclarationNode>()
    return this.mapTypes {
        when (it) {
            is StructType -> it.resolveTypeTemplates(newStructDeclarations)
            else -> it
        }
    }.copy(structDeclarations = newStructDeclarations)
}

private fun StructType.resolveTypeTemplates(newStructDeclarations: MutableList<StructDeclarationNode>): StructType {
    val typeMap = structDeclarationNode.templates.zip(templates).toMap()
    var newName = structDeclarationNode.name
    templates.forEach { newName += '_' + it.descriptiveString }

    val newStructDeclaration = StructDeclarationNode(
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
