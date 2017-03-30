package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

data class Function(val args: List<Type>, val returnType: Type, val vararg: Boolean) {
    override fun toString(): String {
        return "$args${if (vararg) "..." else ""} -> $returnType"
    }
}
