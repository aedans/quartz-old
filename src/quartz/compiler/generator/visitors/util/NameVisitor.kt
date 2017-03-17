package quartz.compiler.generator.visitors.util

import quartz.compiler.generator.Visitor

/**
 * Created by Aedan Smith.
 */

// TODO Validate identifiers
val nameVisitor: Visitor<String> = { identifier, string, _ ->
    string.append(identifier)
}
