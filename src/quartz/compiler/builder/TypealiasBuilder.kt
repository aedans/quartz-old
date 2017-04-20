package quartz.compiler.builder

import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.misc.TypealiasDeclaration

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.TypealiasDeclarationContext.toNode(): TypealiasDeclaration {
    errorScope({ "typealias ${identifier().text}" }) {
        return TypealiasDeclaration(identifier().text, type().toType(), extern != null)
    }
}
