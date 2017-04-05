package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.TemplateType
import quartz.compiler.tree.struct.StructDeclarationNode
import quartz.compiler.tree.struct.StructMemberNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.StructDeclarationContext.toNode(): StructDeclarationNode {
    return StructDeclarationNode(
            identifier().text,
            identifierList()?.identifier()?.map { TemplateType(it.text) } ?: emptyList(),
            structMember().map {
                val node = it.toNode()
                node.name to node
            }.toMap(),
            extern != null
    )
}

fun QuartzParser.StructMemberContext.toNode(): StructMemberNode {
    return StructMemberNode(identifier().text, type().toType(), type().text == "var")
}
