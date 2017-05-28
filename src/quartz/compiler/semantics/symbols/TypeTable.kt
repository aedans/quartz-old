package quartz.compiler.semantics.symbols

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

interface TypeTable {
    fun getType(name: String): Type?
}
