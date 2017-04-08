package quartz.compiler.builder

import quartz.compiler.parser.QuartzParser
import quartz.compiler.semantics.types.NamedType
import quartz.compiler.semantics.types.Primitives
import quartz.compiler.semantics.types.TemplateType
import quartz.compiler.tree.function.FunctionDeclaration
import quartz.compiler.util.Function

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.DestructorDeclarationContext.toNode(): FunctionDeclaration {
    val type = type().toType()
    return FunctionDeclaration(
            "__Q_destructor_${(type as NamedType).string}",
            listOf("it"),
            Function(
                    listOf(type),
                    identifierList().identifier().map { TemplateType(it.text) },
                    Primitives.void,
                    false
            ),
            fnBlock().block().statement().map { it.toNode() }
    )
}
