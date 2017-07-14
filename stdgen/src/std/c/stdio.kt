package std.c

import util.*
import java.io.File

/**
 * Created by Aedan Smith.
 */

val FILE = "FILE"
val FPOS = "fpos_t"

fun File.stdio() {
    write("c/stdio") {
        comment("Bindings for stdio.h")
        newline()

        import("std.c.stdlib")
        newline()

        include("stdio.h")
        newline()

        externTypealias(FPOS)
        externTypealias(FILE)

        newline()

        todo("IOFBF")
        todo("IOLBF")
        todo("IONBF")
        todo("BUFSIZ")
        externVal("EOF", INT)
        externVal("FOPEN_MAX", ULONG)
        externVal("FILENAME_MAX", ULONG)
        externVal("L_tmpnam", ULONG)
        externVal("SEEK_CUR", ULONG)
        externVal("SEEK_END", ULONG)
        externVal("TMP_MAX", ULONG)
        externVal("stdin", FILE)
        externVal("stdout", FILE)
        externVal("stderr", FILE)

        newline()

        externFunction("fclose", INT.func(FILE.ptr()))
        externFunction("clearerr", VOID.func(FILE.ptr()))
        externFunction("feof", INT.func(FILE.ptr()))
        externFunction("ferror", INT.func(FILE.ptr()))
        externFunction("fflush", INT.func(FILE.ptr()))
        externFunction("fgetpos", INT.func(FILE.ptr(), FPOS.ptr()))
        externFunction("fopen", FILE.ptr().func(STRING, STRING))
        externFunction("fread", SIZE.func(VOID.ptr(), SIZE, SIZE, FILE.ptr()))
        externFunction("fseek", INT.func(FILE.ptr(), LONG, INT))
        externFunction("fsetpos", INT.func(FILE.ptr(), FPOS.ptr()))
        externFunction("ftell", LONG.func(FILE.ptr()))
        externFunction("fwrite", SIZE.func(VOID.ptr(), SIZE, SIZE, FILE.ptr()))
        externFunction("remove", INT.func(STRING))
        externFunction("rename", INT.func(STRING, STRING))
        externFunction("rewind", VOID.func(FILE.ptr()))
        externFunction("setbuf", VOID.func(FILE.ptr(), CHAR.ptr()))
        externFunction("setvbuf", INT.func(FILE.ptr(), CHAR.ptr(), INT, SIZE))
        externFunction("tmpfile", FILE.ptr().func())
        externFunction("tmpnam", CHAR.ptr().func(CHAR.ptr()))
        externFunction("fprintf", INT.func(FILE.ptr(), STRING, vararg = true))
        externFunction("printf", INT.func(STRING, vararg = true))
        externFunction("sprintf", INT.func(CHAR.ptr(), STRING, vararg = true))
        todo("vfprintf")
        todo("vprintf")
        todo("vsprintf")
        externFunction("fscanf", INT.func(FILE.ptr(), STRING, vararg = true))
        externFunction("scanf", INT.func(STRING, vararg = true))
        externFunction("sscanf", INT.func(STRING, STRING, vararg = true))
        externFunction("fgetc", INT.func(FILE.ptr()))
        externFunction("fgets", CHAR.ptr().func(CHAR.ptr(), INT, FILE.ptr()))
        externFunction("fputc", INT.func(INT, FILE.ptr()))
        externFunction("fputs", INT.func(STRING, FILE.ptr()))
        externFunction("getc", INT.func(FILE.ptr()))
        externFunction("getchar", INT.func())
        externFunction("gets", CHAR.ptr().func(CHAR.ptr()))
        externFunction("putc", INT.func(INT, FILE.ptr()))
        externFunction("putchar", INT.func(INT))
        externFunction("puts", INT.func(STRING))
        externFunction("ungetc", INT.func(INT, FILE.ptr()))
        externFunction("perror", VOID.func(STRING))
    }
}
