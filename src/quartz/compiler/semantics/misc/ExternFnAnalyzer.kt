package quartz.compiler.semantics.misc

import quartz.compiler.semantics.SemanticAnalyzer
import quartz.compiler.syntax.tree.ProgramNode

/**
 * Created by Aedan Smith.
 */

val externFnAnalyzer: SemanticAnalyzer<ProgramNode> = { programNode, symbolTable ->
    programNode.externFnDeclarations.forEach { symbolTable.getGlobalSymbolTable().addFunction(it) }
}
