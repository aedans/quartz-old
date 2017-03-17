package quartz.compiler.tree

/**
 * Created by Aedan Smith.
 */

class ProgramNode {
    val fnDeclarations = mutableListOf<FnDeclarationNode>()

    val inlineCNodes = mutableListOf<InlineCNode>()

    override fun toString(): String {
        var s = ""
        fnDeclarations.forEach { s += it.toString() + "\n\n" }
        return s
    }
}