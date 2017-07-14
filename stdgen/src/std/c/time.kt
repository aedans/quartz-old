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

        todo("struct tm")
//        struct("tm",
//                "tm_sec" to INT,
//                "tm_min" to INT,
//                "tm_hour" to INT,
//                "tm_mday" to INT,
//                "tm_mon" to INT,
//                "tm_year" to INT,
//                "tm_wday" to INT,
//                "tm_isds" to INT
//        )
        _typealias("tm", "tm".inlineC())
        newline()

        externTypealias(CLOCK)
        externTypealias(TIME)
        newline()

        externVal("CLOCKS_PER_SEC", ULONG)
        newline()

        externFunction("asctime", CHAR.ptr().func(TM.ptr()))
        externFunction("clock", CLOCK.func())
        externFunction("ctime", CHAR.ptr().func(TIME.ptr()))
        externFunction("difftime", DOUBLE.func(TIME, TIME))
        externFunction("gmtime", TM.ptr().func(TIME.ptr()))
        externFunction("localtime", TM.ptr().func(TIME.ptr()))
        externFunction("mktime", TIME.ptr().func(TM.ptr()))
        externFunction("strftime", SIZE.func(CHAR.ptr(), SIZE, CHAR.ptr(), TM.ptr()))
        externFunction("time", TIME.func(TIME.ptr()))
    }
}
