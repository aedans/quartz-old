
import org.testng.Assert
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import java.io.File

/**
 * Created by Aedan Smith.
 */

fun File.subFile(path: String): File {
    val file = File(this, path)
    file.parentFile.mkdirs()
    return file
}

val testFile = File("test")
fun testFile(path: String): File {
    return testFile.subFile(path)
}

fun libFile(path: String): File {
    return File("kobaltBuild/libs/$path")
}

fun runCommand(command: String, out: String.() -> Unit, err: String.() -> Unit) {
    println("Running $command")
    Runtime.getRuntime().exec(command).also {
        it.inputStream.reader().readText().out()
        it.errorStream.reader().readText().err()
    }.also { it.waitFor() }
}

val withErrors = true
val withoutErrors = false

val assertNoErrors: String.() -> Unit = {
    Assert.assertTrue(isEmpty(), "\n$this")
}

val assertErrors: String.() -> Unit = {
    Assert.assertFalse(isEmpty(), "Error test compiled without errors")
}

interface CompilerRunner {
    fun compile(input: File, output: File, err: String.() -> Unit)
}

object QuartzCompilerRunner : CompilerRunner {
    val file = testFile
    val flags = "--debug-builder --debug-analyzer -t"
    val qc = libFile("Quartz.jar")

    override fun compile(input: File, output: File, err: String.() -> Unit) {
        runCommand(
                "java -jar $qc $input -o $output $flags",
                { file.subFile("debug/${input.nameWithoutExtension}.txt").writeText(this) },
                err
        )
    }
}

object ClangCompilerRunner : CompilerRunner {
    val file = testFile
    val flags = "-Wall -Wextra -Wno-ignored-qualifiers -Wno-format-security -Wno-unused-variable -Wno-infinite-recursion -O0"

    override fun compile(input: File, output: File, err: String.() -> Unit) {
        runCommand(
                "clang $input -o $output $flags",
                { if (isNotEmpty()) file.subFile("debug/${input.nameWithoutExtension}.txt").writeText(this) },
                err
        )
    }
}

infix fun Boolean.compile(string: String) {
    compile(string, Thread.currentThread().stackTrace[2].methodName)
}

infix fun String.isOutputOf(string: String) {
    isOutputOf(string, Thread.currentThread().stackTrace[2].methodName)
}

fun Boolean.compile(string: String, name: String) {
    string.run {
        val quartz = testFile("debug/$name.qz")
        val c = testFile("debug/$name.c")
        val exe = testFile("debug/$name.exe")
        quartz.writeText(string)
        if (this@compile) {
            QuartzCompilerRunner.compile(quartz, c, assertErrors)
        } else {
            QuartzCompilerRunner.compile(quartz, c, assertNoErrors)
            ClangCompilerRunner.compile(c, exe, assertNoErrors)
        }
    }
}

fun String.isOutputOf(string: String, name: String) {
    withoutErrors.compile(string, name)
    runCommand(
            testFile("debug/$name.exe").path,
            { Assert.assertEquals(this@isOutputOf.trim(), this.trim()) },
            assertNoErrors
    )
}

@Test
class QuartzTest {
    @BeforeClass
    fun setUp() {
        testFile("debug").deleteRecursively()
    }

    fun empty() = withErrors compile
"""
"""

    fun simpleMain() = withoutErrors compile
"""
fn main(): int {
    0;
}
"""

    fun invalidCast() = withErrors compile
"""
fn main(): int {
    0 as *const char;
}
"""

    fun invalidImplicitCast() = withErrors compile
"""
fn main(): int {
    val hello: *const char = 0;
    0;
}
"""

    fun invalidReturn() = withErrors compile
"""
fn main(): int {
    "Hello, world!";
}
"""

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
    0.0;
}
"""

    fun implicitInlineCCasts() = withoutErrors compile
"""
typealias i8 = %%int%%

fn main(): i8 {
    val a = 0 as i8;
    val b: i8 = 0;
    a + b;
}
"""

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
    0;
}
"""

    fun typealias1() = withoutErrors compile
"""
typealias i = int

fn main(): int {
    val a = 0 as i;
    val b: i = 0;
    a + b;
}
"""

    fun typealias2() = withoutErrors compile
"""
typealias i0 = int
${(1..100).map { "typealias i$it = i${it - 1}" }.joinToString(prefix = "", postfix = "", separator = "\n")}

fn main(): int {
    val a = 0 ${(0..99).map { "as i$it" }.joinToString(prefix = "", postfix = "", separator = " ")};
    val b: i100 = 0;
    a + b;
}
"""

    fun recursive1() = withoutErrors compile
"""
fn main(): int {
    0.identity();
}

fn identity(i: int): int {
    i.identity();
}
"""

    fun recursive2() = withoutErrors compile
"""
fn main(): int {
    main1();
    main2();
    0;
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

    fun depth() = withoutErrors compile
"""
fn main(): int {
    _0();
}

${(0..99).map { "fn _$it(): int { _${it + 1}(); }" }.joinToString(prefix = "", postfix = "", separator = "\n")}

fn _100(): int {
    0;
}
"""

    fun std() = withoutErrors compile
"""
import std

fn main(): int {
    0;
}
"""

    fun helloWorld1() = "Hello, world!" isOutputOf
"""
import std.c.stdio

fn main(): int {
    printf("Hello, world!");
    0;
}
"""

    fun helloWorld2() = "Hello, world!" isOutputOf
"""
import std.c.stdio

typealias string = *char

fn main(): int {
    val _greeter = greeter;
    _greeter()().printf();
    0;
}

fn greeter(): () -> string {
    helloWorld;
}

fn helloWorld(): string {
    "Hello, world!";
}
"""

    fun helloWorld3() = "Hello, world!" isOutputOf
"""
import std.c.stdio

fn main(): int {
    val l = if _false() then "Failed" else helloWorld();
    (if _true() then l else "Failed").printf();
    0;
}

fn helloWorld(): *char {
    "Hello, world!";
}

fn _true(): int {
    1;
}

fn _false(): int {
    0;
}
"""

    fun countToTen() = "0 1 2 3 4 5 6 7 8 9 10" isOutputOf
"""
import std.c.stdio

fn main(): int {
    val counter = countTo;
    counter(10, print);
    0;
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

    fun fibonacciRecursive() = "0 1 1 2 3 5 8 13 21 34 55" isOutputOf
"""
import std.c.stdio

fn main(): int {
    10.fibBelow();
    0;
}

fn fibBelow(i: int) {
    if i > 0 then (i - 1).fibBelow();
    i.fib().printInt();
}

fn fib(i: int): int {
    if i == 0 then 0
        else if i == 1 then 1
        else (i - 1).fib() + (i - 2).fib();
}

fn printInt(i: int) {
    printf("%d ", i);
}
"""

    fun fizzBuzzRecursive() = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz" isOutputOf
"""
import std.c.stdio

fn main(): int {
    15.fizzBuzz();
    0;
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
