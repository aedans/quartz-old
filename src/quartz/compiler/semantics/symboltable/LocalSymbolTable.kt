package quartz.compiler.semantics.symboltable

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class LocalSymbolTable(
        val variables: Map<String, Type>,
        val types: Map<String, Type>,
        val superTable: SymbolTable?
) : SymbolTable {
    override operator fun plus(variable: Pair<String, Type>): SymbolTable {
        return copy(variables = variables + variable)
    }

    override fun getVar(name: String): Type? {
        return variables[name] ?: superTable?.getVar(name)
    }

    override fun getType(name: String): Type? {
        return types[name] ?: superTable?.getType(name)
    }

    override fun globalSymbolTable(): GlobalSymbolTable {
        return superTable?.globalSymbolTable()!!
    }

    override fun toString(): String {
        return "SymbolTable($types, $variables, $superTable)"
    }
}
