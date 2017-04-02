package quartz.compiler.syntax.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.syntax.tree.misc.ExternFnDeclarationNode
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ExternFnDeclarationContext.toNode(): ExternFnDeclarationNode {
    return ExternFnDeclarationNode(
            identifier().text,
            Function(
                    typeList().type().map { it.toType() },
                    returnType?.toType() ?: Primitives.void,
                    typeList().vararg != null
            )
    )
}
