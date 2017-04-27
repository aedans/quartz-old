package quartz.compiler.tree.import

import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import java.io.File
import java.io.FileInputStream
import java.io.InputStream

/**
 * Created by Aedan Smith.
 */

fun QuartzParser.ImportDeclarationContext.import(
        library: Library.LibraryPackage,
        parser: (InputStream) -> QuartzParser.ProgramContext
): List<QuartzParser.DeclarationContext> {
    val path = packageList().NAME().map { it.text }.toMutableList()
    val file = errorScope({ "${library.name}/" + path.joinToString(".") { it.toString() } }) { library.get(path) }
    val programs = parse(file, parser)
    return programs.map { it.declaration() }.flatten() +
            programs.map { it.importDeclaration().map { it.import(library, parser) }.flatten() }.flatten()
}

fun parse(file: File, parser: (InputStream) -> QuartzParser.ProgramContext): List<QuartzParser.ProgramContext> {
    return if (!file.isDirectory) {
        listOf(parser(FileInputStream(file)))
    } else {
        file.listFiles().map {
            parse(it, parser)
        }.flatten()
    }
}
