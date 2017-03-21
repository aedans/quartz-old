package quartz.compiler.syntax.builder.program.struct

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.tree.program.struct.StructDeclarationNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.StructDeclarationContext.toNode(): StructDeclarationNode {
    return StructDeclarationNode(identifier().text, structMember().map { it.toNode() })
}
