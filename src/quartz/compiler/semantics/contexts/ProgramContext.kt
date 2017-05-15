package quartz.compiler.semantics.contexts

import quartz.compiler.semantics.types.type
import quartz.compiler.tree.Program
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class ProgramContext(
        val program: Program,
        val context: Program,
        val tempIndex: Int
) {
    fun getType(name: String): Type? {
        return program.structDeclarations[name]?.type()
                ?: program.typealiasDeclarations[name]?.aliasedType
        // TODO remove
                ?: context.structDeclarations[name]?.type()
                ?: context.typealiasDeclarations[name]?.aliasedType
    }

    fun getVar(name: String): Type? {
        return program.functionDeclarations[name]?.type()
                ?: program.externFunctionDeclarations[name]?.type()
        // TODO remove
                ?: context.functionDeclarations[name]?.type()
                ?: context.externFunctionDeclarations[name]?.type()
    }
}
