package quartz.compiler.semantics.contexts

import quartz.compiler.tree.util.Type

/**
 * Created by Aedan Smith.
 */

interface TypeContext {
    fun getType(name: String): Type?
}
