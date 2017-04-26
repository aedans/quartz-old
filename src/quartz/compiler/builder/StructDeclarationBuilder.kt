package quartz.compiler.builder

import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.TemplateType
import quartz.compiler.tree.struct.StructDeclaration
import quartz.compiler.tree.struct.StructMember

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.StructDeclarationContext.toNode(): StructDeclaration {
    errorScope({ "struct ${NAME().text}" }) {
        return StructDeclaration(
                NAME().text,
                nameList()?.NAME()?.map { TemplateType(it.text) } ?: emptyList(),
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
