package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ExternFunctionDeclarationContext.toNode(): ExternFunctionDeclaration {
    return ExternFunctionDeclaration(
            signatureDefinition().NAME().text,
            Function(
                    signatureDefinition().typeList().type().map { it.toType() },
                    signatureDefinition().returnType?.toType() ?: Primitives.void,
                    emptyList(),
                    signatureDefinition().typeList().vararg != null
            )
    )
}
