package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

data class Function(val args: List<Type?>?, val returnType: Type?, val vararg: Boolean) {
    override fun toString(): String {
        return "${args?.joinToString(prefix = "(", postfix = ")") ?: "(???)"}${if (vararg) "..." else ""} -> ${returnType ?: "???"}"
    }

    fun mapTypes(function: (Type?) -> Type?): Function {
        return Function(
                args?.map { function(it?.mapTypes(function)) },
                function(returnType?.mapTypes(function)),
                vararg
        )
    }
}
