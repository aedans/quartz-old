package quartz.compiler.semantics

import quartz.compiler.errors.errorScope
import quartz.compiler.semantics.types.StructType
import quartz.compiler.tree.Program
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

fun Program.resolveStructs(): Program {
    return errorScope({ "struct resolver" }) {
        val newStructDeclarations = mutableMapOf<String, StructDeclaration>()
        mapTypes { it?.resolveStruct(this, newStructDeclarations) }
        copy(structDeclarations = newStructDeclarations)
    }
}

fun Type.resolveStruct(
        program: Program,
        newStructDeclarations: MutableMap<String, StructDeclaration>
): Type {
    if (this !is StructType)
        return this

    val newStruct = resolveStruct(string, program) ?: return this

    if (!newStructDeclarations.contains(newStruct.name)) {
        newStructDeclarations.put(newStruct.name, newStruct)
    }

    return this.copy(string = newStruct.name)
}

fun resolveStruct(
        name: String,
        program: Program
): StructDeclaration? {
    return program.structDeclarations[name]
}
