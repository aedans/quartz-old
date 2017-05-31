package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.VoidType
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.util.Function

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ExternFunctionDeclarationContext.toNode(): ExternFunctionDeclaration {
    return ExternFunctionDeclaration(
            NAME().text,
            Function(
                    typeList()?.type()?.map { it.toType() } ?: emptyList(),
                    returnType?.toType() ?: VoidType,
                    typeList()?.vararg != null
            )
    )
}
