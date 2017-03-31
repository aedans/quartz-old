package quartz.compiler.syntax.tree.import

import quartz.compiler.exceptions.QuartzException
import quartz.compiler.util.times
import java.io.File

/**
 * Created by Aedan Smith.
 */

sealed class Library(val name: String) {
    abstract fun get(path: List<String>): File

    abstract fun toString(depth: Int): String

    override fun toString(): String {
        return toString(0)
    }

    class LibraryPackage(name: String, val subLibraries: Map<String, Library>) : Library(name) {
        override fun get(path: List<String>): File {
            return subLibraries[path.first()]?.get(path.drop(1))
                    ?: throw QuartzException("Could not find package $path in $name")
        }

        operator fun plus(library: Library): LibraryPackage {
            return LibraryPackage(name, subLibraries + (library.name to library))
        }

        override fun toString(depth: Int): String {
            var s = ("|    " * depth) + name + "\n"
            subLibraries.forEach { _, value -> s += value.toString(depth + 1) }
            return s
        }
    }

    class LibraryFile(name: String, val file: File) : Library(name) {
        override fun get(path: List<String>): File {
            if (!path.isEmpty())
                throw Exception("Could not find $path")
            return file
        }

        override fun toString(depth: Int): String {
            return ("|    ") * depth + name + "\n"
        }
    }

    companion object {
        fun create(file: File): LibraryPackage {
            if (!file.isDirectory)
                throw QuartzException("Could not find ${file.absolutePath}")

            return LibraryPackage(file.name, file.listFiles().map { createLocal(it) }.map { it.name to it }.toMap())
        }

        private fun createLocal(file: File): Library {
            if (file.isDirectory) {
                return LibraryPackage(file.name, file.listFiles().map { createLocal(it) }.map { it.name to it }.toMap())
            } else {
                return LibraryFile(file.nameWithoutExtension, file)
            }
        }
    }
}

