package quartz.compiler.syntax.builder.program.function.statements

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.program.function.toNode
import quartz.compiler.syntax.builder.toType
import quartz.compiler.syntax.tree.program.function.statement.VarDeclarationNode

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.VarDeclarationContext.toNode(): VarDeclarationNode {
    return VarDeclarationNode(
            name.text,
            if (type != null) type.toType() else null,
            declarationType.text == "var",
            value.toNode()
    )
}
