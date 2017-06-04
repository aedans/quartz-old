package quartz.compiler.semantics.contexts

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

interface VariableContext {
    fun getVar(name: String): Type?
}
