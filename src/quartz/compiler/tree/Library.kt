package quartz.compiler.tree

import quartz.compiler.errors.except
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

    class LibraryPackage(name: String, val file: File, val subLibraries: Map<String, Library>) : Library(name) {
        override fun get(path: List<String>): File {
            if (path.isNotEmpty())
                return subLibraries[path.first()]?.get(path.drop(1))
                        ?: except { "Could not find package $path" }
            else
                return file
        }

        operator fun plus(libraries: List<Library>): LibraryPackage {
            var new = this
            libraries.forEach { new += it }
            return new
        }

        operator fun plus(library: Library): LibraryPackage {
            return when (library) {
                is LibraryPackage -> this + library
                is LibraryFile -> this + library
            }
        }

        operator fun plus(library: LibraryFile): LibraryPackage {
            return LibraryPackage(name, file, subLibraries + (library.name to library))
        }

        operator fun plus(library: LibraryPackage): LibraryPackage {
            return LibraryPackage(name, file, subLibraries + library.subLibraries)
        }

        override fun toString(depth: Int): String {
            var s = ("\t" * depth) + name + "\n"
            subLibraries.forEach { _, value -> s += value.toString(depth + 1) }
            return s
        }
    }

    class LibraryFile(name: String, val file: File) : Library(name) {
        override fun get(path: List<String>): File {
            if (!path.isEmpty())
                except { "Could not find $path" }
            return file
        }

        override fun toString(depth: Int): String {
            return ("\t") * depth + name + "\n"
        }
    }

    companion object {
        fun create(file: File): LibraryPackage {
            if (!file.isDirectory)
                except { "Could not find ${file.absolutePath}" }

            return LibraryPackage(file.name, file, mapOf(file.name to createLocal(file)))
        }

        private fun createLocal(file: File): Library {
            if (file.isDirectory) {
                return LibraryPackage(file.name, file, file.listFiles().map { createLocal(it) }.map { it.name to it }.toMap())
            } else {
                return LibraryFile(file.nameWithoutExtension, file)
            }
        }
    }
}

