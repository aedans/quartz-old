package quartz.compiler.syntax.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.util.Type
import quartz.compiler.util.types.ArrayType
import quartz.compiler.util.types.FunctionType
import quartz.compiler.util.types.Primitives
import quartz.compiler.util.types.StructType

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.VarTypeContext.toType(): Type {
    return if (typeName != null) {
        when (typeName.IDENTIFIER().text) {
            "char" -> Primitives.char
            "short" -> Primitives.short
            "int" -> Primitives.int
            "long" -> Primitives.long
            "float" -> Primitives.float
            "double" -> Primitives.double
            "void" -> Primitives.void
            else -> StructType(typeName.IDENTIFIER().text)
        }
    } else {
        if (array != null) {
            ArrayType(varType().toType())
        } else {
            FunctionType(args.varType().map { it.toType() }, returnType.toType())
        }
    }
}
