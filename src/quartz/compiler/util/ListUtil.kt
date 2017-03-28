package quartz.compiler.util

/**
 * Created by Aedan Smith.
 */

operator fun <T> T.plus(list: List<T>): List<T> {
    val newList = mutableListOf(this)
    newList.addAll(list)
    return newList
}
