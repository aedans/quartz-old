package quartz.compiler.builder

import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.misc.TypealiasDeclaration

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.TypealiasDeclarationContext.toNode(): TypealiasDeclaration {
    errorScope({ "typealias ${NAME().text}" }) {
        return TypealiasDeclaration(NAME().text, type().toType(), extern != null)
    }
}
