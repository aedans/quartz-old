package quartz.compiler.syntax.tree.misc

import quartz.compiler.syntax.tree.GlobalDeclarationNode
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

class ExternFnDeclarationNode(val name: String, val function: Function) : GlobalDeclarationNode {
    override fun toString(): String {
        return "$name $function"
    }
}
