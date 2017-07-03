package quartz.compiler.builder

import quartz.compiler.errors.errorScope
import quartz.compiler.parser.QuartzParser
import quartz.compiler.tree.util.Library
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
    val path = packageList().toList()
    return errorScope({ path.joinToString(".") }) {
        val file = library.get(path)
        val programs = parse(file, parser)
        programs.map { it.declaration() }.flatten() +
                programs.map { it.importDeclaration().map { it.import(library, parser) }.flatten() }.flatten()
    }
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
