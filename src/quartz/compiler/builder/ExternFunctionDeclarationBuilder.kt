package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.VoidType
import quartz.compiler.tree.declarations.ExternFunctionDeclaration

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ExternFunctionDeclarationContext.toDecl(): ExternFunctionDeclaration {
    return ExternFunctionDeclaration(
            NAME().text,
            typeList().toList(),
            returnType?.toType() ?: VoidType,
            typeList().isVararg()
    )
}
