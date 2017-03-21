package quartz.compiler.syntax.builder.program.struct

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.toType
import quartz.compiler.syntax.tree.program.struct.StructMemberNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.StructMemberContext.toNode(): StructMemberNode {
    return StructMemberNode(identifier().text, varType().toType(), varType().text == "var")
}
