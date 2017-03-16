package quartz.compiler.syntax.builder

import quartz.compiler.parser.parsers.parsenodes.FnDeclarationNode
import quartz.compiler.parser.parsers.parsenodes.ProgramNode
import quartz.compiler.syntax.SyntaxTree
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun ProgramNode.toSyntaxTree(): SyntaxTree {
    val syntaxTree = SyntaxTree()
    for ((name, args, rType) in this.getNodes().filterIsInstance(FnDeclarationNode::class.java)) {
        syntaxTree.symbolTable.addFunction(Function(name, args.map { it.second.toType() }, rType.toType()))
    }
    for (node in this.getNodes()){
        when (node) {
            is FnDeclarationNode -> syntaxTree.functionNodes.add(node.toFunctionNode(syntaxTree.symbolTable))
            else -> RuntimeException("Unrecognized node $node")
        }
    }
    return syntaxTree
}
