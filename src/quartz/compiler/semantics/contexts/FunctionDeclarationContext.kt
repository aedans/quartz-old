package quartz.compiler.semantics.contexts

import quartz.compiler.tree.Declaration
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.util.nullableZip

/**
 * Created by Aedan Smith.
 */

data class FunctionDeclarationContext(
        val symbolContext: SymbolContext,
        val functionDeclaration: FunctionDeclaration
) : SymbolContext {
    override fun getType(name: String): Type? {
        return symbolContext.getType(name)
    }

    override fun getVar(name: String): Type? {
        return functionDeclaration.argNames.nullableZip(functionDeclaration.function.args)
                ?.firstOrNull { it.first == name }?.second
                ?: symbolContext.getVar(name)
    }

    override fun getDeclaration(name: String): Declaration? {
        return if (name == functionDeclaration.name) functionDeclaration else symbolContext.getDeclaration(name)
    }
}
