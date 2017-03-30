package quartz.compiler.syntax.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.tree.misc.ExternFnDeclarationNode
import quartz.compiler.util.Function
import quartz.compiler.util.types.Primitives

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ExternFnDeclarationContext.toNode(): ExternFnDeclarationNode {
    return ExternFnDeclarationNode(
            name.text,
            Function(
                    typeList().varType().map { it.toType() },
                    returnType?.toType() ?: Primitives.void,
                    typeList().vararg != null
            )
    )
}
