package quartz.compiler.semantics.symboltable

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class SymbolTable(val superTable: SymbolTable? = null) {
    private val variables = HashMap<String, Type>()
    private val types = HashMap<String, Type>()

    fun addVar(name: String, type: Type) {
        variables.put(name, type)
    }

    fun getVar(name: String): Type? {
        val variable = variables[name]
        if (variable != null) {
            return variable
        } else {
            return superTable?.getVar(name)
        }
    }

    fun addType(name: String, type: Type) {
        types.put(name, type)
    }

    fun getType(name: String): Type? {
        return types[name] ?: superTable?.getType(name)
    }

    fun localSymbolTable(): SymbolTable {
        return SymbolTable(this)
    }

    override fun toString(): String {
        var string = ""
        variables.forEach { _, u -> string += u.toString() + '\n' }
        return string
    }
}
