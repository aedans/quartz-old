package std.c

import util.*
import java.io.File

/**
 * Created by Aedan Smith.
 */

fun File.inttypes() {
    write("c/inttypes") {
        comment("Bindings for stdint.h")
        newline()

        import("std.c.stdint")
        newline()
        include("inttypes.h")

        DIOUXX.forEach { type ->
            newline()
            comment("printf $type extern val definitions")

            SIGNED_INT_RANGE.forEach { (i, _) ->
                NORM_LEAST_FAST.forEach { cat ->
                    externVal("PRI$type${cat.toUpperCase()}$i", STRING)
                }
            }

            PTR_MAX.forEach { ptr ->
                externVal("PRI$type$ptr", STRING)
            }
        }

        DIOUX.forEach { type ->
            newline()
            comment("scanf $type extern val definitions")

            SIGNED_INT_RANGE.forEach { (i, _) ->
                NORM_LEAST_FAST.forEach { cat ->
                    externVal("SCN$type${cat.toUpperCase()}$i", STRING)
                }
            }

            PTR_MAX.forEach { ptr ->
                externVal("SCN$type$ptr", STRING)
            }
        }
    }
}
