package std.c

import util.*
import java.io.File

/**
 * Created by Aedan Smith.
 */

fun File.math() {
    write("c/math") {
        comment("Bindings for math.h")
        newline()

        include("math.h")
        newline()

        externVal("HUGE_VAL", DOUBLE)
        newline()

        externFunction("acos", DOUBLE.func(DOUBLE))
        externFunction("asin", DOUBLE.func(DOUBLE))
        externFunction("atan", DOUBLE.func(DOUBLE))
        externFunction("atan2", DOUBLE.func(DOUBLE, DOUBLE))
        externFunction("cos", DOUBLE.func(DOUBLE))
        externFunction("cosh", DOUBLE.func(DOUBLE))
        externFunction("sin", DOUBLE.func(DOUBLE))
        externFunction("sinh", DOUBLE.func(DOUBLE))
        externFunction("tanh", DOUBLE.func(DOUBLE))
        externFunction("exp", DOUBLE.func(DOUBLE))
        externFunction("frexp", DOUBLE.func(DOUBLE, INT.ptr()))
        externFunction("ldexp", DOUBLE.func(DOUBLE, INT))
        externFunction("log", DOUBLE.func(DOUBLE))
        externFunction("log10", DOUBLE.func(DOUBLE))
        externFunction("modf", DOUBLE.func(DOUBLE, DOUBLE.ptr()))
        externFunction("pow", DOUBLE.func(DOUBLE, DOUBLE))
        externFunction("sqrt", DOUBLE.func(DOUBLE))
        externFunction("ciel", DOUBLE.func(DOUBLE))
        externFunction("fabs", DOUBLE.func(DOUBLE))
        externFunction("floor", DOUBLE.func(DOUBLE))
        externFunction("fmod", DOUBLE.func(DOUBLE, DOUBLE))
    }
}
