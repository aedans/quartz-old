package quartz.compiler.syntax.builder.program.function

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.toType
import quartz.compiler.syntax.tree.program.function.FnDeclarationNode
import quartz.compiler.syntax.tree.program.function.statement.ReturnNode
import quartz.compiler.util.types.Primitives

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.FnDeclarationContext.toNode(): FnDeclarationNode {
    val node = FnDeclarationNode(
            name.text,
            fnArgumentList()?.fnArgument()?.map { it.name.text to it.type.toType() } ?: listOf(),
            returnType?.toType() ?: Primitives.void
    )
    if (body.expression() != null) {
        node.statements.add(ReturnNode(body.expression().toNode()))
    } else {
        body.block().statement().forEach {
            node.statements.add(it.toNode())
        }
    }
    return node
}
