package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.VoidType
import quartz.compiler.tree.declarations.ExternFunctionDeclaration
import quartz.compiler.tree.util.Function

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ExternFunctionDeclarationContext.toExpr(): ExternFunctionDeclaration {
    return ExternFunctionDeclaration(
            NAME().text,
            Function(
                    typeList().toList(),
                    returnType?.toType() ?: VoidType,
                    typeList().isVararg()
            )
    )
}
