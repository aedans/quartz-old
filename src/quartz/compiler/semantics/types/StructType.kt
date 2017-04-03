package quartz.compiler.semantics.types

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class StructType(name: String, val members: Map<String, Type>, val external: Boolean) : NamedType(name) {
    override fun mapTypes(function: (Type?) -> Type?): Type {
        return StructType(name, members.map { it.key to function(it.value.mapTypes(function))!! }.toMap(), external)
    }

    override fun toString(): String {
        return name
    }
}
