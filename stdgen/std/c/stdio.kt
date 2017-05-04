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

        externTypealias(FPOS, ULONG)
        externTypealias(FILE, VOID)

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

        externFunction("fclose", INT, FILE.ptr())
        externFunction("clearerr", null, FILE.ptr())
        externFunction("feof", INT, FILE.ptr())
        externFunction("ferror", INT, FILE.ptr())
        externFunction("fflush", INT, FILE.ptr())
        externFunction("fgetpos", INT, FILE.ptr(), FPOS.ptr())
        externFunction("fopen", FILE.ptr(), STRING, STRING)
        externFunction("fread", SIZE, VOID.ptr(), SIZE, SIZE, FILE.ptr())
        externFunction("fseek", INT, FILE.ptr(), LONG, INT)
        externFunction("fsetpos", INT, FILE.ptr(), FPOS.ptr())
        externFunction("ftell", LONG, FILE.ptr())
        externFunction("fwrite", SIZE, VOID.ptr(), SIZE, SIZE, FILE.ptr())
        externFunction("remove", INT, STRING)
        externFunction("rename", INT, STRING, STRING)
        externFunction("rewind", null, FILE.ptr())
        externFunction("setbuf", null, FILE.ptr(), CHAR.ptr())
        externFunction("setvbuf", INT, FILE.ptr(), CHAR.ptr(), INT, SIZE)
        externFunction("tmpfile", FILE.ptr())
        externFunction("tmpnam", CHAR.ptr(), CHAR.ptr())
        externFunction("fprintf", INT, FILE.ptr(), STRING, "...")
        externFunction("printf", INT, STRING, "...")
        externFunction("sprintf", INT, CHAR.ptr(), STRING, "...")
        todo("vfprintf")
        todo("vprintf")
        todo("vsprintf")
        externFunction("fscanf", INT, FILE.ptr(), STRING, "...")
        externFunction("scanf", INT, STRING, "...")
        externFunction("sscanf", INT, STRING, STRING, "...")
        externFunction("fgetc", INT, FILE.ptr())
        externFunction("fgets", CHAR.ptr(), CHAR.ptr(), INT, FILE.ptr())
        externFunction("fputc", INT, INT, FILE.ptr())
        externFunction("fputs", INT, STRING, FILE.ptr())
        externFunction("getc", INT, FILE.ptr())
        externFunction("getchar", INT)
        externFunction("gets", CHAR.ptr(), CHAR.ptr())
        externFunction("putc", INT, INT, FILE.ptr())
        externFunction("putchar", INT, INT)
        externFunction("puts", INT, STRING)
        externFunction("ungetc", INT, INT, FILE.ptr())
        externFunction("perror", null, STRING)
    }
}
