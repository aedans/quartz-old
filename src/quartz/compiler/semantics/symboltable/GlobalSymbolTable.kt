package quartz.compiler.semantics.symboltable

import quartz.compiler.util.Type
import quartz.compiler.util.types.StructType

/**
 * Created by Aedan Smith.
 */

class GlobalSymbolTable : SymbolTable {
    val structs = HashMap<String, StructType>()
    private val variables = HashMap<String, Type>()

    override fun getVar(name: String): Type? {
        return variables[name]
    }

    override fun addVar(name: String, type: Type) {
        variables.put(name, type)
    }

    override fun getGlobalSymbolTable(): GlobalSymbolTable {
        return this
    }

    override fun toString(): String {
        var string = ""
        variables.forEach { _, u -> string += u.toString() + '\n' }
        return string
    }
}
