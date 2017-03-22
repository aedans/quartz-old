# Quartz

Quartz is a high level functional programming language designed
for asynchronous computation using the gpu. It provides powerful
optimizations such as pure function caching and deferred
declarations to take full advantage of the gpu without having
to worry about low-level thread management. Quartz compiles to 
CUDA-C, allowing for easy use with other C/C++/CUDA 
applications, and provides simple yet effective ways to use
existing C/C++/CUDA programs and libraries.

## Basic Syntax

### Variables

<pre>
// Immutable variable declaration
val x = 10

// Types can be inferred at compile time or stated explicitly 
val y: int = 10

// Mutable variable declaration
var size = 256
</pre>

Semicolons are not needed, but statements can still be on the
same line.

### Functions

<pre>
// Return type goes after the declaration
fn main(): int {
    // Function calls work as normal
    greetTheWorld()
    return 0
}

// Functions will assume void if nothing is specified
fn greetTheWorld() {
    // Backticks escape identifiers (TODO)
    printf(`theWorld'sGreeting`())
}

// Single expression functions are allowed
fn `theWorld'sGreeting`(): char[] = "Hello, World!"

// External definition for function printf
extern_fn printf(char[])

fn greetTheWorldInfix() {
    // Dot notation is allowed on all functions
    "Hello, World!".printf()   
}
</pre>

Illegal characters in function names will be replaced with
the appropriate ascii code, and illegal names will be prepended
with '_'.

Single expression functions are not guaranteed to compile to
single statement C functions. (ex: return if-else)

Here, the "theWorld'sGreeting" function would compile to

<pre>
char* theWorld39sGreeting() { 
    return "Hello, World!" 
}
</pre>

### Control flow 

<pre>
fn printTrueOrFalse(i: int) {
    // If statements work as normal
    if (i) {
        print("true")
    } else // Braces can be omitted for single-statement blocks
        print("false")
}

fn halt() // Braces can be omitted for single-statement functions, too
    // While loops work as normal
    while (1) { }
</pre>

### Structs

<pre>
// Struct declarations work as normal
struct Point {
    val x: int
    val y: int
}

// Implicit constructor:
// fn Point(x: int, y: int): Point ...

fn main() {
    // Calling the implicit constructor
    val p1 = Point(1, 2)
    // Dot notation works on structs
    val p2 = p1.translate(2, 2)
}

fn translate(point: Point, x: int, y: int) {
    // Dot notation to access variables
    return Point(point.x + x, point.y + y)
}
</pre>
