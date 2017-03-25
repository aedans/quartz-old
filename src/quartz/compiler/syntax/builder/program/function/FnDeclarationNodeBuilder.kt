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
    return FnDeclarationNode(
            name.text,
            fnArgumentList()?.fnArgument()?.map { it.name.text to it.type.toType() } ?: listOf(),
            returnType?.toType() ?: Primitives.void,
            if (body.expression() != null) {
                listOf(ReturnNode(body.expression().toNode()))
            } else {
                body.block().statement().map { it.toNode() }
            }
    )
}
