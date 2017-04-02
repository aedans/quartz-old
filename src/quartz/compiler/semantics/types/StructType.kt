package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class StructType(name: String, val members: Map<String, Type>) : NamedType(name) {
    override fun toString(): String {
        return name
    }
}
