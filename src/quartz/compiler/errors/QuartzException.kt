package quartz.compiler.errors

/**
 * Created by Aedan Smith.
 */

class QuartzException(message: String, val causes: List<String> = emptyList()) : Exception(message, null, false, true) {
    override fun toString(): String {
        var s = "QuartzException: $message"
        causes.forEach { s += "\n\t$it" }
        return s
    }
}
