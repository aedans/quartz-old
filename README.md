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

Before getting acquainted with the more complex features of
Quartz, it's important to understand the basics of its syntax.

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
    // Calling fnDeclarations works as normal
    greetTheWorld()
    return 0
}

// Functions will assume void if nothing is specified
fn greetTheWorld() {
    // Backticks escape identifiers (TODO)
    printf(`theWorld'sGreeting`())
}

// Single expression fnDeclarations
// Single expressions' types can be inferenced (TODO)
fn `theWorld'sGreeting`() = "Hello, World!"
</pre>

Illegal characters in function names will be replaced with
the appropriate ascii code, and illegal names will be prepended
with '_'.

Single expression fnDeclarations are not guaranteed to compile to
single statement C fnDeclarations. (ex: return if-else)

Here, the "theWorld'sGreeting" function would compile to

<pre>
char* theWorld39sGreeting() { 
    return "Hello, World!" 
}
</pre>

#### Casting

<pre>
fn intToLong(i: int): long {
    // Cast int to long
    return (long) i
}

fn charToInt(c: char): int {
    // Compiler will implicity cast c to an int
    return c
}

fn intToString(i: int): string {
    // Compilation Error: Could not cast int to char[]
    return (string) i
}
</pre>

Non-redundant casts in Quartz are compiled directly to C casts.
