package quartz.compiler.parser.parsers.statements.expressions

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
