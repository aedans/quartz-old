package quartz.compiler.syntax.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.util.Function
import quartz.compiler.util.types.Primitives

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ExternFnDeclarationContext.toNode(): Function {
    return Function(
            name.text,
            typeList().varType().map { it.toType() },
            returnType?.toType() ?: Primitives.void,
            typeList().vararg != null
    )
}
