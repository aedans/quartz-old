package std.c

import util.*
import java.io.File

/**
 * Created by Aedan Smith.
 */

val TM = "tm"
val TIME = "time_t"
val CLOCK = "clock_t"

fun File.time() {
    write("c/time") {
        comment("Bindings for time.h")
        newline()

        import("std.c.stdlib")
        newline()

        include("time.h")
        newline()

        struct("tm",
                true to "tm_sec" to INT,
                true to "tm_min" to INT,
                true to "tm_hour" to INT,
                true to "tm_mday" to INT,
                true to "tm_mon" to INT,
                true to "tm_year" to INT,
                true to "tm_wday" to INT,
                true to "tm_isds" to INT
        )
        newline()

        externTypealias(CLOCK, ULONG)
        externTypealias(TIME, ULONG)
        newline()

        externVal("CLOCKS_PER_SEC", ULONG)
        newline()

        externFunction("asctime", CHAR.ptr(), TM.ptr())
        externFunction("clock", CLOCK)
        externFunction("ctime", CHAR.ptr(), TIME.ptr())
        externFunction("difftime", DOUBLE, TIME, TIME)
        externFunction("gmtime", TM.ptr(), TIME.ptr())
        externFunction("localtime", TM.ptr(), TIME.ptr())
        externFunction("mktime", TIME.ptr(), TM.ptr())
        externFunction("strftime", SIZE, CHAR.ptr(), SIZE, CHAR.ptr(), TM.ptr())
        externFunction("time", TIME, TIME.ptr())
    }
}
