package quartz.compiler.parser.parsers

import quartz.compiler.parser.parsers.expressions.fnCallParser
import quartz.compiler.parser.parsers.expressions.inlineCParser
import quartz.compiler.parser.parsers.expressions.inlineCParser
import quartz.compiler.parser.parsers.statements.declarationParser
import quartz.compiler.parser.parsers.statements.returnParser
import quartz.compiler.parser.parsers.statements.declarationParser
import quartz.compiler.parser.parsers.statements.returnParser

/**
 * Created by Aedan Smith.
 */

val statementParsers = listOf(
        declarationParser,
        returnParser,
        fnCallParser,
        inlineCParser
)

