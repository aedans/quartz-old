package quartz.compiler.util

import quartz.compiler.syntax.tree.function.FnDeclarationNode

/**
 * Created by Aedan Smith.
 */

data class Function(val name: String, val args: List<Type>, val returnType: Type){
    constructor(fnDeclarationNode: FnDeclarationNode) :
            this(fnDeclarationNode.name, fnDeclarationNode.args.map { it.second }, fnDeclarationNode.returnType)
}
