package quartz.compiler.semantics.contexts

import quartz.compiler.tree.function.Block
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class BlockContext(
        val block: Block,
        val symbolContext: SymbolContext,
        val vars: Map<String, Type>
) : SymbolContext {
    override val programContext: ProgramContext
        get() = symbolContext.programContext

    override fun getVar(name: String): Type? {
        return vars[name] ?: symbolContext.getVar(name)
    }

    override fun addVar(name: String, type: Type): SymbolContext {
        return copy(vars = vars + (name to type))
    }

    override fun copy(programContext: ProgramContext): SymbolContext {
        return copy(
                symbolContext = symbolContext.copy(
                        programContext = programContext
                )
        )
    }
}