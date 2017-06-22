package std.c

import util.*
import java.io.File

/**
 * Created by Aedan Smith.
 */

fun File.stdint() {
    write("c/stdint") {
        comment("Bindings for stdint.h")
        newline()

        include("stdint.h")

        listOf("ptr", "max").forEach { cat ->
            newline()
            comment("int$cat definitions")

            SIGNED_UNSIGNED.forEach { sign ->
                externTypealias("${sign}int${cat}_t")
            }

            MIN_MAX.forEach { s ->
                externVal("INT${cat.toUpperCase()}_${s.toUpperCase()}", "int${cat}_t")
            }
            externVal("UINT${cat.toUpperCase()}_MAX", "uint${cat}_t")
        }

        SIGNED_INT_RANGE.forEach { (i, _) ->
            newline()
            comment("int$i definitions")

            SIGNED_UNSIGNED.forEach { sign ->
                NORM_LEAST_FAST.forEach { itype ->
                    externTypealias("${sign}int$itype${i}_t")
                }
            }
            MIN_MAX.forEach { s ->
                NORM_LEAST_FAST.forEach { itype ->
                    externVal("INT_${itype.toUpperCase()}${i}_$s", "int${itype}${i}_t")
                }
            }
            NORM_LEAST_FAST.forEach { itype ->
                externVal("UINT_${itype.toUpperCase()}${i}_MAX", "uint${itype}${i}_t")
            }
        }
    }
}
