package quartz.compiler.tokenizer

import quartz.compiler.util.misc.StringIterator

/**
 * Created by Aedan Smith.
 */

typealias Tokenizer = (StringIterator) -> Token?
