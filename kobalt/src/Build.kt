
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

    sourceDirectories {
        path("src")
    }

    assemble {
        jar {
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

val QuartzTestRunner = project(Quartz, QuartzLibGen) {
    name = "QuartzTestRunner"
    group = "com.aedans"
    artifactId = name
    version = "0.1"

    sourceDirectories {
        path("testrun")
    }

    assemble {
        jar {
            fatJar = true
            manifest {
                attributes("Main-Class", "TestRunnerKt")
            }
        }
    }
}

@Task(name = "gen-parser", alwaysRunAfter = arrayOf("assemble"), dependsOn = arrayOf("assemble"), description = "Generates the Quartz parser")
fun genParser(project: Project?): TaskResult {
    if (project == QuartzParserGen) {
        runCommand("java -jar ./${project.buildDirectory}/libs/${project.name}-${project.version}.jar")
    }
    return TaskResult(testResult = TestResult(true))
}

@Task(name = "clean-parser", alwaysRunAfter = arrayOf("clean"), description = "Cleans the Quartz parser")
fun cleanParser(project: Project?): TaskResult {
    if (project == QuartzParserGen) {
        File("./src/quartz/compiler/parser").deleteRecursively()
    }
    return TaskResult(testResult = TestResult(true))
}

@Task(name = "gen-std", alwaysRunAfter = arrayOf("assemble"), dependsOn = arrayOf("assemble"), description = "Generates the standard library")
fun genStd(project: Project?): TaskResult {
    if (project == QuartzLibGen) {
        runCommand("java -jar ./${project.buildDirectory}/libs/${project.name}-${project.version}.jar .")
    }
    return TaskResult(testResult = TestResult(true))
}

@Task(name = "clean-std", alwaysRunAfter = arrayOf("clean"), description = "Cleans the standard library")
fun cleanStd(project: Project?): TaskResult {
    if (project == QuartzLibGen) {
        File("./std").deleteRecursively()
    }
    return TaskResult(testResult = TestResult(true))
}

@Task(name = "run-tests", alwaysRunAfter = arrayOf("test"), dependsOn = arrayOf("assemble"), description = "Compiles and runs all tests")
fun runTests(project: Project?): TaskResult {
    if (project == QuartzTestRunner) {
        runCommand("java -jar ./${project.buildDirectory}/libs/${project.name}-${project.version}.jar" +
                " test ./${project.buildDirectory}/libs/${Quartz.name}-${Quartz.version}.jar")
    }
    return TaskResult(testResult = TestResult(true))
}

@Task(name = "clean-tests", alwaysRunAfter = arrayOf("clean"), description = "Cleans all tests")
fun cleanTests(project: Project?): TaskResult {
    if (project == QuartzTestRunner) {
        File("./test/debug").deleteRecursively()
        File("./test/exe").deleteRecursively()
        File("./test/out").deleteRecursively()
        File("./test/src").deleteRecursively()
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
