package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

data class Function(val name: String, val args: List<Type>, val returnType: Type, val vararg: Boolean)
