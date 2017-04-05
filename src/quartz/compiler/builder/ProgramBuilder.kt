package quartz.compiler.builder

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.Program
import quartz.compiler.tree.function.FnDeclaration
import quartz.compiler.tree.import.Library
import quartz.compiler.tree.import.import
import quartz.compiler.tree.misc.ExternFunctionDeclaration
import quartz.compiler.tree.misc.InlineC
import quartz.compiler.tree.misc.Typealias
import quartz.compiler.tree.struct.StructDeclaration
import java.io.InputStream

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ProgramContext.toNode(library: Library.LibraryPackage, parser: (InputStream) -> QuartzParser.ProgramContext): Program {
    val nodes = declaration().map { it.toNode() } + importDeclaration().map { it.import(library, parser) }.flatten().map { it.toNode() }
    val programNode = Program(
            nodes.filterIsInstance(FnDeclaration::class.java).map { it.name to it }.toMap(),
            nodes.filterIsInstance(ExternFunctionDeclaration::class.java).map { it.name to it }.toMap(),
            nodes.filterIsInstance(StructDeclaration::class.java).map { it.name to it }.toMap(),
            nodes.filterIsInstance(Typealias::class.java).map { it.name to it }.toMap(),
            nodes.filterIsInstance(InlineC::class.java)
    )
    return programNode
}

@Suppress("IMPLICIT_CAST_TO_ANY")
fun QuartzParser.DeclarationContext.toNode(): Any {
    return when {
        fnDeclaration() != null -> fnDeclaration().toNode()
        structDeclaration() != null -> structDeclaration().toNode()
        typealiasDeclaration() != null -> typealiasDeclaration().toNode()
        inlineC() != null -> inlineC().toNode()
        else -> throw QuartzException("Error translating $text")
    }.also { println("Found $it") }
}
