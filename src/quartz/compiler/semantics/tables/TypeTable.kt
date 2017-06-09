package quartz.compiler.semantics.tables

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

interface TypeTable {
    fun getType(name: String): Type?
}
