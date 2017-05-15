package quartz.compiler.semantics.contexts

import quartz.compiler.util.Type

/**
 * Created by Aedan Smith.
 */

data class TypeContext(
        val type: Type,
        val programContext: ProgramContext
) {
    fun getType(name: String): Type? {
        return programContext.getType(name)
    }
}
