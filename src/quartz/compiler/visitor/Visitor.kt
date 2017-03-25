package quartz.compiler.visitor

/**
 * Created by Aedan Smith.
 */

typealias Visitor<T> = (T) -> T

operator fun <T> Visitor<T>.plus(visitor: Visitor<T>): Visitor<T> {
    return { t ->
        val newT = this.invoke(t)
        visitor(newT)
    }
}
