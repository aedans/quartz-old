package quartz.compiler.semantics.symboltable

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
        return types[name]
    }
}
