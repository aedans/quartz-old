import org.junit.Assert
import org.junit.Test
import java.io.File
import java.io.FileOutputStream
import java.io.PrintStream
import java.nio.file.Files

/**
 * Created by Aedan Smith.
 */

fun File.subFile(path: String): File {
    val file = File(this, path)
    file.parentFile.mkdirs()
    return file
}

val testFile = File("./test")
fun testFile(path: String): File {
    return testFile.subFile(path)
}

fun libFile(path: String): File {
    return File("./kobaltBuild/libs/$path")
}

fun File.write(string: String) {
    PrintStream(FileOutputStream(this)).println(string)
}

fun runCommand(command: String, out: String.() -> Unit, err: String.() -> Unit) {
    Runtime.getRuntime().exec(command).also {
        it.inputStream.reader().readText().out()
        it.errorStream.reader().readText().err()
    }.also { it.waitFor() }
}

fun String.withFile(name: String = "temp.txt", function: File.() -> Unit) {
    val file = testFile("temp/$name")
    Files.write(file.toPath(), toByteArray())
    file.function()
}

val withErrors = true
val withoutErrors = false

val assertNoErrors: String.() -> Unit = {
    Assert.assertTrue("\n$this", isEmpty())
}

val assertErrors: String.() -> Unit = {
    Assert.assertFalse("Error test compiled without errors", isEmpty())
}

interface CompilerRunner {
    fun compile(input: File, output: File, err: String.() -> Unit)
}

object QuartzCompilerRunner : CompilerRunner {
    val file = testFile(".")
    val qc = libFile("Quartz.jar")
    var count = 0

    override fun compile(input: File, output: File, err: String.() -> Unit) {
        runCommand(
                "java -jar $qc ${input.absolutePath} ${output.absolutePath}",
                { file.subFile("debug/qz$count.txt").write(this) },
                err
        )
        count++
    }
}

object GccCompilerRunner : CompilerRunner {
    val file = testFile(".")
    val flags = "-Wall -Wextra -Wno-ignored-qualifiers -Wno-discarded-qualifiers -Wno-format-security -Wno-unused-variable"
    var count = 0

    override fun compile(input: File, output: File, err: String.() -> Unit) {
        runCommand(
                "gcc ${input.absolutePath} -o ${output.absolutePath} $flags",
                { file.subFile("debug/gcc$count.txt").write(this) },
                {
                    if (isNotEmpty())
                        input.copyTo(file.subFile("debug/gcc$count.c"))
                    err()
                }
        )
        count++
    }
}

// TODO
object NvccCompilerRunner : CompilerRunner {
    val file = testFile(".")
    val flags = "--machine 32 -x cu -Wno-deprecated-gpu-targets --cudart shared"
    var count = 0

    override fun compile(input: File, output: File, err: String.() -> Unit) {
        runCommand(
                "nvcc ${input.absolutePath} -o ${output.absolutePath} $flags",
                { file.subFile("debug/nvcc$count.txt").write(this) },
                err
        )
        count++
    }
}

infix fun Boolean.compile(string: String) {
    string.run {
        withFile("temp.qz") quartz@ {
            withFile("temp.c") c@ {
                withFile("temp.exe") exe@ {
                    if (this@compile) {
                        QuartzCompilerRunner.compile(this@quartz, this@c, assertErrors)
                    } else {
                        QuartzCompilerRunner.compile(this@quartz, this@c, assertNoErrors)
                        GccCompilerRunner.compile(this@c, this@exe, assertNoErrors)
                    }
                }
            }
        }
    }
}

infix fun String.isOutputOf(string: String) {
    withoutErrors compile string
    runCommand(
            testFile("temp/temp.exe").absolutePath,
            { Assert.assertEquals(this@isOutputOf.trim(), this.trim()) },
            assertNoErrors
    )
}

class QuartzTest {
    init {
        testFile("debug").deleteRecursively()
        testFile("temp").deleteRecursively()
    }

    @Test
    fun empty() = withErrors compile
"""
"""

    @Test
    fun simpleMain() = withoutErrors compile
"""
fn main(): int {
    return 0;
}
"""

//    @Test
    fun invalidCast() = withErrors compile
"""
fn main(): int {
    return 0 as *const char;
}
"""

    @Test
    fun invalidImplicitCast() = withErrors compile
"""
fn main(): int {
    val hello: *const char = 0;
    return 0;
}
"""

//    @Test
    fun invalidReturn() = withErrors compile
"""
fn main(): int {
    return "Hello, world!";
}
"""

    @Test
    fun implicitNumberCasts() = withoutErrors compile
"""
fn main(): int {
    val a: char = 0;
    val b: short = 0;
    val c: int = 0;
    val d: long = 0;
    val e: uchar = 0;
    val f: ushort = 0;
    val g: uint = 0;
    val h: ulong = 0;
    val i: float = 0;
    val j: double = 0;
    return 0.0;
}
"""

    @Test
    fun implicitInlineCCasts() = withoutErrors compile
"""
typealias i8 = %%int%%

fn main(): i8 {
    val a = 0 as i8;
    val b: i8 = 0;
    return a + b;
}
"""

    @Test
    fun operators() = withoutErrors compile
"""
fn main(): int {
    val a = 0 + 0;
    val b = 0 - 0;
    val c = 0 / 1;
    val d = 0 * 0;
    val e = 0 % 1;
    val f = 0 << 0;
    val g = 0 >> 0;
    val h = 0 > 0;
    val i = 0 < 0;
    val j = 0 >= 0;
    val k = 0 <= 0;
    val l = 0 == 0;
    val m = 0 != 0;
    val n = 0 && 0;
    val o = 0 & 0;
    val p = 0 || 0;
    val q = 0 | 0;
    val r = 0 ^ 0;
    a += 0;
    b -= 0;
    c *= 0;
    d /= 1;
    e %= 1;
    f &= 0;
    g |= 0;
    h ^= 0;
    i <<= 0;
    j >>= 0;
    return 0;
}
"""

    @Test
    fun typealias1() = withoutErrors compile
"""
typealias i = int

fn main(): int {
    val a = 0 as i;
    val b: i = 0;
    return a + b;
}
"""

//    @Test
    fun typealias2() = withoutErrors compile
"""
typealias i0 = int
typealias i1 = i0
typealias i2 = i1
typealias i3 = i2

fn main(): int {
    val a = 0 as i0 as i1 as i2 as i3;
    val b: i3 = 0;
    return a + b;
}
"""

    @Test
    fun recursive1() = withoutErrors compile
"""
fn main(): int {
    return 0.identity();
}

fn identity(i: int): int {
    return i.identity();
}
"""

//    @Test
    fun recursive2() = withoutErrors compile
"""
fn main(): int {
    main1();
    main2();
    return 0;
}

fn main1() {
    main1();
    main2();
}

fn main2() {
    main1();
    main2();
}
"""

    @Test
    fun depth() = withoutErrors compile
"""
fn main(): int {
    return _0();
}

${(0..99).map { "fn _$it(): int { return _${it + 1}(); }" }.joinToString(prefix = "", postfix = "", separator = "\n")}

fn _100(): int {
    return 0;
}
"""

    @Test
    fun std() = withoutErrors compile
"""
import std

fn main(): int {
    return 0;
}
"""

    @Test
    fun helloWorld1() = "Hello, world!" isOutputOf
"""
import std.c.stdio

fn main(): int {
    printf("Hello, world!");
    return 0;
}
"""

    @Test
    fun helloWorld2() = "Hello, world!" isOutputOf
"""
import std.c.stdio

typealias string = *char

fn main(): int {
    val _greeter = greeter;
    _greeter()().printf();
    return 0;
}

fn greeter(): () -> string {
    return helloWorld;
}

fn helloWorld(): string {
    return "Hello, world!";
}
"""

    @Test
    fun helloWorld3() = "Hello, world!" isOutputOf
"""
import std.c.stdio

fn main(): int {
    val l = if _false() then "Failed" else helloWorld();
    (if _true() then l else "Failed").printf();
    return 0;
}

fn helloWorld(): *char {
    return "Hello, world!";
}

fn _true(): int {
    return 1;
}

fn _false(): int {
    return 0;
}
"""

    @Test
    fun countToTen() = "0 1 2 3 4 5 6 7 8 9 10" isOutputOf
"""
import std.c.stdio

fn main(): int {
    val counter = countTo;
    counter(10, print);
    return 0;
}

fn countTo(i: int, printer: (int) -> void) {
    val counter = countTo;
    if i > 0 then (i - 1).counter(printer);
    printer(i);
}

fn print(i: int) {
    printf("%d ", i);
}
"""

    @Test
    fun fibonacciRecursive() = "0 1 1 2 3 5 8 13 21 34 55" isOutputOf
"""
import std.c.stdio

fn main(): int {
    10.fibBelow();
    return 0;
}

fn fibBelow(i: int) {
    if i > 0 then (i - 1).fibBelow();
    i.fib().printInt();
}

fn fib(i: int): int {
    return if i == 0 then 0
        else if i == 1 then 1
        else (i - 1).fib() + (i - 2).fib();
}

fn printInt(i: int) {
    printf("%d ", i);
}
"""

    @Test
    fun fizzBuzzRecursive() = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz" isOutputOf
"""
import std.c.stdio

fn main(): int {
    15.fizzBuzz();
    return 0;
}

fn fizzBuzz(i: int) {
    if i > 1 then (i - 1).fizzBuzz();

    if i % 5 == 0 && i % 3 == 0 then printf("FizzBuzz ")
    else if i % 3 == 0 then printf("Fizz ")
    else if i % 5 == 0 then printf("Buzz ")
    else printInt(i);
}

fn printInt(i: int) {
    printf("%d ", i);
}
"""
}
