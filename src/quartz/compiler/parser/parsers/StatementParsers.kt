package quartz.compiler.parser.parsers

import quartz.compiler.parser.parsers.statements.declarationParser
import quartz.compiler.parser.parsers.statements.returnParser

/**
 * Created by Aedan Smith.
 */

val statementParsers = listOf(
        declarationParser,
        returnParser
) + expressionParsers

