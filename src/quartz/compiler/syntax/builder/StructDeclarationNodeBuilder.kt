package quartz.compiler.syntax.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.tree.struct.StructDeclarationNode
import quartz.compiler.syntax.tree.struct.StructMemberNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.StructDeclarationContext.toNode(): StructDeclarationNode {
    return StructDeclarationNode(identifier().text, structMember().map {
        val node = it.toNode()
        node.name to node
    }.toMap() )
}

fun QuartzParser.StructMemberContext.toNode(): StructMemberNode {
    return StructMemberNode(identifier().text, varType().toType(), varType().text == "var")
}
