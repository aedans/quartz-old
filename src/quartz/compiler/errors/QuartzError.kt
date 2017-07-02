package quartz.compiler.errors

/**
 * Created by Aedan Smith.
 */

class QuartzError(message: String?, causes: List<String> = emptyList())
    : QuartzException("[Internal error] $message", causes)
