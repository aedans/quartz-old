package quartz.compiler.errors

/**
 * Created by Aedan Smith.
 */

inline fun <T> errorScope(name: () -> String, function: () -> T): T {
    return try {
        function()
    } catch (qe: QuartzException) {
        throw QuartzException(
                qe.message.toString(),
                qe.causes + "in ${try { name() } catch (e: Throwable) { e.message }}"
        ).also { it.stackTrace = qe.stackTrace }
    } catch (e: Throwable) {
        throw QuartzException("[Internal error] ${e.message}").also { it.stackTrace = e.stackTrace }
    }
}
