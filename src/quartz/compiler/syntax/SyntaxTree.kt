package quartz.compiler.syntax

import quartz.compiler.syntax.nodes.FnNode
import quartz.compiler.syntax.symboltable.GlobalSymbolTable

/**
 * Created by Aedan Smith.
 */

class SyntaxTree {
    val symbolTable = GlobalSymbolTable()

    val functionNodes = mutableListOf<FnNode>()

    override fun toString(): String {
        var string = ""
        functionNodes.forEach { string += it.toString() + '\n' }
        return string
    }
}
