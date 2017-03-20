package quartz.compiler.syntax.builder.program

import quartz.compiler.parser.QuartzParser
import quartz.compiler.syntax.builder.toType
import quartz.compiler.util.Function
import types.Primitives

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ExternFnDeclarationContext.toNode(): Function {
    return Function(
            name.text,
            typeList().varType().map { it.toType() },
            returnType?.toType() ?: Primitives.void
    )
}