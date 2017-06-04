package quartz.compiler.semantics.contexts

import quartz.compiler.semantics.types.type
import quartz.compiler.tree.Declaration
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.misc.InlineC
import quartz.compiler.tree.misc.TypealiasDeclaration
import quartz.compiler.tree.util.Type
import quartz.compiler.tree.util.toMap

/**
 * Created by Aedan Smith.
 */

class ProgramContext(program: Program) : SymbolContext {
    val functionDeclarations = program.filterIsInstance(FunctionDeclaration::class.java).toMap()
    val externFunctionDeclarations = program.filterIsInstance(ExternFunctionDeclaration::class.java).toMap()
    val typealiasDeclarations = program.filterIsInstance(TypealiasDeclaration::class.java).toMap()
    val inlineC = program.filterIsInstance(InlineC::class.java)

    override fun getType(name: String): Type? {
        return typealiasDeclarations[name]?.aliasedType
    }

    override fun getVar(name: String): Type? {
        return functionDeclarations[name]?.type()
                ?: externFunctionDeclarations[name]?.type()
    }

    override fun getDeclaration(name: String): Declaration? {
        return functionDeclarations[name]
                ?: externFunctionDeclarations[name]
                ?: typealiasDeclarations[name]
    }
}
