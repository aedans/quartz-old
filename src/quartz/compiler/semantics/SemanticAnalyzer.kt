package quartz.compiler.semantics

import quartz.compiler.tree.ProgramNode
import quartz.compiler.semantics.function.FnDeclarationCheck
import quartz.compiler.semantics.symboltable.GlobalSymbolTable

/**
 * Created by Aedan Smith.
 */

class SemanticAnalyzer(val check: MutableList<SemanticCheck<ProgramNode>> = mutableListOf(
        FnDeclarationCheck()
)) {
    val symbolTable = GlobalSymbolTable()

    fun analyze(node: ProgramNode) {
        check.forEach { it(node, symbolTable) }
    }
}
