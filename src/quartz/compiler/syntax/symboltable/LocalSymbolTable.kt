package quartz.compiler.syntax.symboltable

import quartz.compiler.util.Variable

/**
 * Created by Aedan Smith.
 */

class LocalSymbolTable(val superTable: SymbolTable) : SymbolTable {
    private val variables = HashMap<String, Variable>()

    override fun add(name: String, variable: Variable) {
        variables.put(name, variable)
    }

    override fun get(name: String): Variable {
        val variable = variables[name]
        if (variable != null) {
            return variable
        } else {
            return superTable[name]
        }
    }

    override fun getGlobalSymbolTable() = superTable.getGlobalSymbolTable()

    override fun toString(): String {
        var string = ""
        variables.forEach { _, u -> string += u.toString() + '\n' }
        return string
    }
}
