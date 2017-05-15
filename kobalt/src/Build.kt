
import com.beust.kobalt.TaskResult
import com.beust.kobalt.TestResult
import com.beust.kobalt.api.Project
import com.beust.kobalt.api.annotation.Task
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.project
import java.io.File

val QuartzParserGen = project {
    name = "QuartzParserGen"
    group = "com.aedans"
    artifactId = name
    version = "0.1"

    dependencies {
        compile("org.antlr:antlr4:jar:")
    }

    sourceDirectories {
        path("parsergen")
    }

    assemble {
        jar {
            fatJar = true
            manifest {
                attributes("Main-Class", "ParserGenKt")
            }
        }
    }
}

val Quartz = project(QuartzParserGen) {
    name = "Quartz"
    group = "com.aedans"
    artifactId = name
    version = "0.1"

    dependencies {
        compile("org.antlr:antlr4:jar:")
    }

    dependenciesTest {
        compile("junit:junit:")
    }

    sourceDirectories {
        path("src")
    }

    sourceDirectoriesTest {
        path("test")
    }

    assemble {
        jar {
            name = "Quartz.jar"
            fatJar = true
            manifest {
                attributes("Main-Class", "MainKt")
            }
        }
    }
}

val QuartzLibGen = project(Quartz) {
    name = "QuartzLibGen"
    group = "com.aedans"
    artifactId = name
    version = "0.1"

    sourceDirectories {
        path("stdgen")
    }

    assemble {
        jar {
            fatJar = true
            manifest {
                attributes("Main-Class", "StdGenKt")
            }
        }
    }
}

@Task(
        name = "post-assemble",
        alwaysRunAfter = arrayOf("assemble"),
        description = "Runs all post-assembly tasks"
)
fun postAssemble(project: Project?): TaskResult {
    when (project) {
        QuartzParserGen -> {
            runCommand("java -jar ./${project.buildDirectory}/libs/${project.name}-${project.version}.jar")
        }
        QuartzLibGen -> {
            runCommand("java -jar ./${project.buildDirectory}/libs/${project.name}-${project.version}.jar .")
        }
    }
    return TaskResult(testResult = TestResult(true))
}

@Task(name = "clean-gen", alwaysRunAfter = arrayOf("clean"), description = "Cleans all Quartz files")
fun cleanGen(project: Project?): TaskResult {
    when (project) {
        QuartzParserGen -> {
            File("./src/quartz/compiler/parser").deleteRecursively()
        }
        Quartz -> {
            File("./test/debug").deleteRecursively()
            File("./test/exe").deleteRecursively()
            File("./test/out").deleteRecursively()
            File("./test/src").deleteRecursively()
        }
        QuartzLibGen -> {
            File("./std").deleteRecursively()
        }
    }
    return TaskResult(testResult = TestResult(true))
}

fun runCommand(command: String) {
    println("Running $command")
    Runtime.getRuntime().exec(command).also {
        Thread { while (it.isAlive || it.inputStream.available() > 0) {
            it.inputStream.read().takeIf { it > 0 }?.also { System.out.write(it) }
        } }.start()
        Thread { while (it.isAlive || it.errorStream.available() > 0) {
            it.errorStream.read().takeIf { it > 0 }?.also { System.err.write(it) }
        } }.start()
    }.waitFor()
}
