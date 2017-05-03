package quartz.compiler.builder

import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.tree.struct.StructMember

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.StructDeclarationContext.toNode(): StructDeclaration {
    return errorScope({ "struct ${NAME().text}" }) {
        StructDeclaration(
                NAME().text,
                structMember().map {
                    val node = it.toNode()
                    node.name to node
                }.toMap(),
                extern != null
        )
    }
}

fun QuartzParser.StructMemberContext.toNode(): StructMember {
    return errorScope({ "struct member ${NAME().text}" }) {
        StructMember(NAME().text, type().toType(), type().text == "var")
    }
}
