package quartz.compiler.semantics.verifier.symboltable

import quartz.compiler.syntax.tree.program.struct.StructDeclarationNode
import quartz.compiler.util.Function
import quartz.compiler.util.Variable
import quartz.compiler.util.types.FunctionType

/**
 * Created by Aedan Smith.
 */

class GlobalSymbolTable : SymbolTable {
    private val functions = HashMap<String, Function>()
    private val structs = HashMap<String, StructDeclarationNode>()
    private val variables = HashMap<String, Variable>()

    override fun add(name: String, variable: Variable) {
        variables.put(name, variable)
    }

    override fun get(name: String): Variable? {
        return variables[name]
    }

    fun addFunction(function: Function) {
        if (!functions.contains(function.name)) {
            functions.put(function.name, function)
            variables.put(function.name, Variable(function.name, FunctionType(function.args, function.returnType)))
        } else {
            throw Exception("Function \"${function.name}\" already declared")
        }
    }

    fun getFunction(key: String): Function? {
        return functions[key]
    }

    fun addStruct(struct: StructDeclarationNode) {
        if (!structs.contains(struct.name)){
            structs.put(struct.name, struct)
        } else {
            throw Exception("Struct \"${struct.name}\" already declared")
        }
    }

    fun getStruct(key: String): StructDeclarationNode {
        return try { structs[key]!! }
        catch (_: NullPointerException) {
            throw Exception("Could not find struct with name $key")
        }
    }

    override fun getGlobalSymbolTable(): GlobalSymbolTable {
        return this
    }

    override fun toString(): String {
        var string = ""
        functions.forEach { _, u -> u.toString() + '\n' }
        string += '\n'
        variables.forEach { _, u -> string += u.toString() + '\n' }
        return string
    }
}