plugins {
    alias { libs.plugins.kotlin.jvm }
}

dependencies {
    implementation(libs.kotlinx.coroutines.core) {
        version { strictly(libs.versions.kotlinx.coroutines.get()) }
    }
    implementation(libs.jackson.module.kotlin) {
        version { strictly(libs.versions.jackson3.get()) }
    }
    testImplementation(libs.kotlin.test.junit5) {
        version { strictly(libs.versions.kotlin.get()) }
    }
}


abstract class GreetingToFileTask : DefaultTask() {

    @get:OutputFile
    abstract val destination: RegularFileProperty

    @TaskAction
    fun greet() {
        val file = destination.get().asFile
        file.parentFile.mkdirs()
        file.writeText("Hello!")
    }
}

val greetingFile = objects.fileProperty()

tasks.register<GreetingToFileTask>("greet") {
    destination.set(greetingFile)
}

tasks.register("sayGreeting") {
    dependsOn("greet")
    val greetingFile = greetingFile
    doLast {
        val file = greetingFile.get().asFile
        println("${file.readText()} (file: ${file.name})")
    }
}

greetingFile.set(layout.buildDirectory.file("hello.txt"))