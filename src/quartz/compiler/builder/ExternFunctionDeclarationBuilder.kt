package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.VoidType
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
                    signatureDefinition().returnType?.toType() ?: VoidType,
                    signatureDefinition().typeList().vararg != null
            )
    )
}
