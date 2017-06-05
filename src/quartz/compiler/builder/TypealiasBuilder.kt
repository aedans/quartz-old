package quartz.compiler.builder

import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.declarations.TypealiasDeclaration

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.TypealiasDeclarationContext.toNode(): TypealiasDeclaration {
    return errorScope({ "typealias ${NAME().text}" }) {
        TypealiasDeclaration(NAME().text, type().toType())
    }
}
