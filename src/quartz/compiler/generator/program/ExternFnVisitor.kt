package quartz.compiler.generator.program

import quartz.compiler.generator.util.visit
import quartz.compiler.generator.util.visitFunctionDescription
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun Function.visitTypedef(string: StringBuilder) {
    string.append("typedef ")
    returnType.visit(string)
    string.append(" (*")
    visitFunctionDescription(args, returnType, vararg, string)
    string.append("_t")
    string.append(')')
    string.append('(')
    if (!args.isEmpty()) {
        args.dropLast(1).forEach {
            it.visit(string)
            string.append(", ")
        }
        args.last().visit(string)
    }
    if (vararg) string.append(", ...")
    string.appendln(");")
}
