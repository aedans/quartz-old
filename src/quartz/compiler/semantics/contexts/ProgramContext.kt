package quartz.compiler.semantics.contexts

import quartz.compiler.semantics.types.type
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

data class ProgramContext(
        val program: Program,
        val context: Program
) :  SymbolContext {
    override val programContext
        get() = this

    override fun getVar(name: String): Type? {
        return program.functionDeclarations[name]?.type()
                ?: program.externFunctionDeclarations[name]?.type()
                // TODO remove
                ?: context.functionDeclarations[name]?.type()
                ?: context.externFunctionDeclarations[name]?.type()
    }

    override fun addVar(name: String, type: Type): SymbolContext {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getType(name: String): Type? {
        return program.structDeclarations[name]?.type()
                ?: program.typealiasDeclarations[name]?.aliasedType
                // TODO remove
                ?: context.structDeclarations[name]?.type()
                ?: context.typealiasDeclarations[name]?.aliasedType
    }

    override fun getFunctionDeclaration(name: String): FunctionDeclaration? {
        return program.functionDeclarations[name]
    }

    override fun copy(programContext: ProgramContext): SymbolContext {
        return programContext
    }
}
