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

        externFunction("acos", DOUBLE, DOUBLE)
        externFunction("asin", DOUBLE, DOUBLE)
        externFunction("atan", DOUBLE, DOUBLE)
        externFunction("atan2", DOUBLE, DOUBLE, DOUBLE)
        externFunction("cos", DOUBLE, DOUBLE)
        externFunction("cosh", DOUBLE, DOUBLE)
        externFunction("sin", DOUBLE, DOUBLE)
        externFunction("sinh", DOUBLE, DOUBLE)
        externFunction("tanh", DOUBLE, DOUBLE)
        externFunction("exp", DOUBLE, DOUBLE)
        externFunction("frexp", DOUBLE, DOUBLE, INT.ptr())
        externFunction("ldexp", DOUBLE, DOUBLE, INT)
        externFunction("log", DOUBLE, DOUBLE)
        externFunction("log10", DOUBLE, DOUBLE)
        externFunction("modf", DOUBLE, DOUBLE, DOUBLE.ptr())
        externFunction("pow", DOUBLE, DOUBLE, DOUBLE)
        externFunction("sqrt", DOUBLE, DOUBLE)
        externFunction("ciel", DOUBLE, DOUBLE)
        externFunction("fabs", DOUBLE, DOUBLE)
        externFunction("floor", DOUBLE, DOUBLE)
        externFunction("fmod", DOUBLE, DOUBLE, DOUBLE)
    }
}
