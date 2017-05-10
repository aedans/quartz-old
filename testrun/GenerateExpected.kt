import java.io.File

/**
 * Created by Aedan Smith.
 */

fun main(args: Array<String>) {
    val out = File(args[0], "out")
    val expected = File(args[0], "expected")
    expected.deleteRecursively()
    out.copyRecursively(expected)
}
