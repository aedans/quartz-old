package quartz.compiler.generator.visitors.util

import quartz.compiler.generator.Visitor
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

val typeVisitor: Visitor<Type> = { type, string, _ ->
    string.append(type.toCString())
}
