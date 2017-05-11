import org.antlr.v4.Tool
import java.io.File

/**
 * Created by Aedan Smith.
 */

fun main(args: Array<String>) {
    val parserOutput = File("./src/quartz/compiler/parser").absolutePath
    val grammar = File("./grammar").absolutePath
    File(parserOutput)
            .also { it.deleteRecursively() }
            .also { it.mkdirs() }
    Tool.main(("-o $parserOutput" +
            " -package quartz.compiler.parser -no-listener" +
            " -no-visitor -lib $grammar $grammar/Quartz.g4")
                    .split(" ").toTypedArray())
}
