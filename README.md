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
(located at `./std/` after running `gen-std`).

Supported tasks:

- `assemble` - builds the project
- `run-tests` - runs the tests
- `clean` - cleans the project

Supported subtasks:

- `compile` - compiles the project - invoked by assemble
- `gen-parser` - generates the parser - invoked by assemble
- `gen-std` - generates the standard library - invoked by assemble
- `clean-parser` - cleans the parser - invoked by clean
- `clean-std` - cleans the standard library - invoked by clean
- `clean-tests` - cleans the tests - invoked by clean
