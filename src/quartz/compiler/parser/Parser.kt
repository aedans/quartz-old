package quartz.compiler.parser

import quartz.compiler.tokenizer.TokenStream

/**
 * Created by Aedan Smith.
 */

typealias Parser<T> = (TokenStream) -> T
