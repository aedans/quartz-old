package quartz.compiler.syntax.builder

import quartz.compiler.parser.parsers.parsenodes.FnDeclaration
import quartz.compiler.parser.parsers.parsenodes.Program
import quartz.compiler.syntax.SyntaxTree
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun Program.toSyntaxTree(): SyntaxTree {
    val syntaxTree = SyntaxTree()
    for ((name, args, rType) in this.getNodes().filterIsInstance(FnDeclaration::class.java)) {
        syntaxTree.symbolTable.addFunction(Function(name, args.map { it.second.toType() }, rType.toType()))
    }
    for (node in this.getNodes()){
        when (node) {
            is FnDeclaration -> syntaxTree.functionNodes.add(node.toFunctionNode(syntaxTree.symbolTable))
            else -> RuntimeException("Unrecognized node $node")
        }
    }
    return syntaxTree
}
