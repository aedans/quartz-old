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
        functionDeclarations.forEach {
            errorScope({ "function ${it.value.name}" }) {
                it.value.mapTypes { it?.resolveType(this, newTypealiasDeclarations, newStructDeclarations) }
            }
        }
        copy(structDeclarations = newStructDeclarations, typealiasDeclarationDeclarations = newTypealiasDeclarations)
    }
}

fun Type.resolveType(
        program: Program,
        newTypealiasDeclarations: MutableMap<String, TypealiasDeclaration>,
        newStructDeclarations: MutableMap<String, StructDeclaration>
): Type {
    return when {
        this is AliasedType -> {
            val newAlias = resolveAlias(string, program) ?: return this

            if (!newTypealiasDeclarations.contains(newAlias.name)) {
                newTypealiasDeclarations.put(newAlias.name, newAlias)
                newTypealiasDeclarations.put(newAlias.name, newAlias
                        .mapTypes { it?.resolveType(program, newTypealiasDeclarations, newStructDeclarations) })
            }

            this.copy(string = newAlias.name)
        }
        this is StructType -> {
            val newStruct = resolveStruct(string, program) ?: return this

            if (!newStructDeclarations.contains(newStruct.name)) {
                newStructDeclarations.put(newStruct.name, newStruct)
                newStructDeclarations.put(newStruct.name, newStruct
                        .mapTypes { it?.resolveType(program, newTypealiasDeclarations, newStructDeclarations) })
            }

            this.copy(string = newStruct.name)
        }
        this is ConstType -> this
        this is FunctionType -> this
        this is PointerType -> this
        this is NumberType -> this
        this is VoidType -> this
        this is UnresolvedType -> this
        else -> throw QuartzException("Expected type, found $this")
    }
}

fun resolveAlias(
        name: String,
        program: Program
): TypealiasDeclaration? {
    return program.typealiasDeclarationDeclarations[name]
}

fun resolveStruct(
        name: String,
        program: Program
): StructDeclaration? {
    return program.structDeclarations[name]
}
