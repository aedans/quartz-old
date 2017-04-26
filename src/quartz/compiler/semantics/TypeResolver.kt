package quartz.compiler.semantics

import quartz.compiler.errors.QuartzException
import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.types.*
import quartz.compiler.tree.Program
import quartz.compiler.tree.misc.TypealiasDeclaration
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun Program.resolveTypes(): Program {
    return errorScope({ "type resolver" }) {
        val newTypealiasDeclarations = mutableMapOf<String, TypealiasDeclaration>()
        val newStructDeclarations = mutableMapOf<String, StructDeclaration>()
        val newFunctionDeclarations = functionDeclarations.map {
            errorScope({ "function ${it.value.name}" }) {
                it.value.mapTypes { it?.resolveType(this, newTypealiasDeclarations, newStructDeclarations) }
            }
        }
        copy(
                functionDeclarations = newFunctionDeclarations.map { it.name to it }.toMap(),
                structDeclarations = newStructDeclarations,
                typealiasDeclarationDeclarations = newTypealiasDeclarations
        )
    }
}

fun Type.resolveType(
        program: Program,
        newTypealiasDeclarations: MutableMap<String, TypealiasDeclaration>,
        newStructDeclarations: MutableMap<String, StructDeclaration>
): Type {
    return when (this) {
        is AliasedType -> {
            val newAlias = resolveAlias(string, program) ?: return this

            if (!newTypealiasDeclarations.contains(newAlias.name)) {
                newTypealiasDeclarations.put(newAlias.name, newAlias)
                newTypealiasDeclarations.put(newAlias.name, newAlias
                        .mapTypes { it?.resolveType(program, newTypealiasDeclarations, newStructDeclarations) })
            }

            this.copy(string = newAlias.name)
        }
        is StructType -> {
            val newStruct = resolveStruct(program) ?: return this

            if (!newStructDeclarations.contains(newStruct.name)) {
                newStructDeclarations.put(newStruct.name, newStruct)
                newStructDeclarations.put(newStruct.name, newStruct
                        .mapTypes { it?.resolveType(program, newTypealiasDeclarations, newStructDeclarations) })
            }

            StructType(newStruct)
        }
        is ConstType -> this
        is FunctionType -> this
        is PointerType -> this
        is NumberType -> this
        is VoidType -> this
        is TemplateType -> this
        else -> throw QuartzException("Expected type, found $this")
    }
}

fun resolveAlias(
        name: String,
        program: Program
): TypealiasDeclaration? {
    return program.typealiasDeclarationDeclarations[name]
}

fun StructType.resolveStruct(program: Program): StructDeclaration? {
    val struct = program.structDeclarations[string] ?: return null
    var newName = struct.name
    templates.forEach { newName += "_${it.descriptiveString}" }
    val templateMap = struct.templates.zip(templates).toMap()
    return struct.mapTypes { templateMap[it] ?: it }.copy(name = newName, templates = emptyList())
}
