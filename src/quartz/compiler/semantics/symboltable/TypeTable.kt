package quartz.compiler.semantics.symboltable

import quartz.compiler.semantics.types.AliasedType
import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class TypeTable {
    private val types = HashMap<String, Type>()

    fun add(name: String, type: Type) {
        types.put(name, type)
    }

    fun get(name: String): Type? {
        val type = getTrue(name)
        return if (type is AliasedType) type.getTrueType() else type
    }

    fun getTrue(name: String): Type? {
        return types[name]
    }
}
