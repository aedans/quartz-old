package quartz.compiler.errors

/**
 * Created by Aedan Smith.
 */

inline fun err(message: () -> String): Nothing {
    throw QuartzError(message())
}

inline fun except(message: () -> String): Nothing {
    throw QuartzException(message())
}

inline fun <T> errorScope(name: () -> String, function: () -> T): T {
    return try {
        function()
    } catch (qe: QuartzException) {
        throw QuartzException(
                qe.message,
                qe.causes + "in ${try { name() } catch (e: Throwable) { e.message }}"
        ).also { it.stackTrace = qe.stackTrace }
    } catch (e: Throwable) {
        throw QuartzException("[Internal error] ${e.message}").also { it.stackTrace = e.stackTrace }
    }
}
