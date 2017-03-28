package quartz.compiler.semantics.symboltable

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

class LocalSymbolTable(val superTable: SymbolTable) : SymbolTable {
    private val variables = HashMap<String, Type>()

    override fun addVar(name: String, type: Type) {
        variables.put(name, type)
    }

    override fun getVar(name: String): Type? {
        val variable = variables[name]
        if (variable != null) {
            return variable
        } else {
            return superTable.getVar(name)
        }
    }

    override fun getGlobalSymbolTable() = superTable.getGlobalSymbolTable()

    override fun toString(): String {
        var string = ""
        variables.forEach { _, u -> string += u.toString() + '\n' }
        return string
    }
}
