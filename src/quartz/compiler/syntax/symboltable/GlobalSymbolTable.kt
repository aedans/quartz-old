package quartz.compiler.syntax.symboltable

import quartz.compiler.util.Function
import quartz.compiler.util.Variable

/**
 * Created by Aedan Smith.
 */

class GlobalSymbolTable : SymbolTable {
    private val functions = HashMap<String, Function>()
    private val variables = HashMap<String, Variable>()

    override fun add(name: String, variable: Variable) {
        variables.put(name, variable)
    }

    override fun get(name: String): Variable {
        return try { variables[name]!! }
        catch (e: NullPointerException) {
            throw RuntimeException("Could not find variable $name")
        }
    }

    fun addFunction(function: Function) {
        if (!functions.contains(function.name)) {
            functions.put(function.name, function)
        } else {
            throw RuntimeException("Function \"${function.name}\" already declared")
        }
    }

    fun getFunction(key: String): Function {
        return try { functions[key]!! }
        catch (_: NullPointerException) {
            throw RuntimeException("Could not find function with name $key")
        }
    }

    override fun getGlobalSymbolTable() = this

    override fun toString(): String {
        var string = ""
        functions.forEach { _, u -> u.toString() + '\n' }
        string += '\n'
        variables.forEach { _, u -> string += u.toString() + '\n' }
        return string
    }
}
