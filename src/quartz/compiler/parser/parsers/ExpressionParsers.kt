package quartz.compiler.parser.parsers

import quartz.compiler.parser.parsers.expressions.*

/**
 * Created by Aedan Smith.
 */

val expressionParsers = listOf(
        numberParser,
        stringParser,
        fnCallParser,
        identifierParser,
        castParser,
        inlineCParser
)
