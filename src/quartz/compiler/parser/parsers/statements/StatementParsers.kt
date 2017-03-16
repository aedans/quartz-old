package quartz.compiler.parser.parsers.statements

import quartz.compiler.parser.parsers.statements.expressions.expressionParsers

/**
 * Created by Aedan Smith.
 */

val statementParsers = listOf(
        declarationParser,
        returnParser
) + expressionParsers

