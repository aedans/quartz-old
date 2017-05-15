# Quartz

Quartz is a high level functional programming language designed
for asynchronous computation using the gpu. It provides powerful
optimizations such as pure function caching, memoization, and 
deferred declarations to take full advantage of the gpu without 
needing to worry about low-level thread management. Quartz 
compiles to CUDA-C, allowing for easy use with other C/C++/CUDA 
applications, and provides simple yet effective ways to use
existing C/C++/CUDA programs and libraries.

## Building

Quartz uses [Kobalt](http://beust.com/kobalt) for its build system.
Kobalt tasks can be executed using `./kobaltw [task]` on Linux and
`kobaltw.bat [task]` on Windows.

Note that the Quartz compiler requires the environment variable
`QZ_LIB` to be set to the location of the standard library 
(located at `./std/` after running `assemble`).

Supported tasks:

- `assemble` - builds the project
- `test` - runs the tests
- `clean` - cleans the project
