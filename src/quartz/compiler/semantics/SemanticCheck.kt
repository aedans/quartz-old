package quartz.compiler.semantics

import quartz.compiler.semantics.symboltable.SymbolTable

/**
 * Created by Aedan Smith.
 */

typealias SemanticCheck<T> = (T, SymbolTable) -> Unit
