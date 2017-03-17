package quartz.compiler.tokenizer

import quartz.compiler.util.misc.CharStream

/**
 * Created by Aedan Smith.
 */

typealias Tokenizer = (CharStream) -> Token?
