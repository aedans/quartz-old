package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.declarations.ExternFunctionDeclaration

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ExternFunctionDeclarationContext.toDecl(): ExternFunctionDeclaration {
    return ExternFunctionDeclaration(
            NAME().text,
            functionType().toType()
    )
}
