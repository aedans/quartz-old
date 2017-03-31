package quartz.compiler.syntax.tree.import

import quartz.compiler.parser.QuartzParser
import java.io.FileInputStream
import java.io.InputStream

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ImportDeclarationContext.import(library: Library.LibraryPackage, parser: (InputStream) -> QuartzParser.ProgramContext): List<QuartzParser.DeclarationContext> {
    val path = packageList().identifier().map { it.text }.toMutableList()
    val file = library.get(path)
    val input = FileInputStream(file)
    return parser(input).declaration()
}
