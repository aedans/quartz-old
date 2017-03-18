package quartz.compiler.semantics

import quartz.compiler.semantics.symboltable.GlobalSymbolTable
import quartz.compiler.semantics.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

typealias SemanticAnalyzer<T> = (T, SymbolTable) -> Unit

fun <T> Iterable<SemanticAnalyzer<T>>.analyze(t: T) {
    val symbolTable = GlobalSymbolTable()
    this.forEach { it(t, symbolTable) }
}
