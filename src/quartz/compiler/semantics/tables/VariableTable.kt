package quartz.compiler.semantics.tables

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

interface VariableTable {
    fun getVar(name: String): Type?
}
