import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val javaVersion = "11"

plugins {
    kotlin("jvm") version "1.5.31" apply false
    kotlin("plugin.spring") version "1.5.30" apply false
    id("org.springframework.boot") version "2.5.4" apply false
    id("org.jruyi.thrift") version "0.4.2" apply false
    id("org.openjfx.javafxplugin") version "0.0.10" apply false
    id("org.beryx.jlink") version "2.24.1" apply false
}

group = "me.tonyirl"
version = "1.0.0"

allprojects {

    extensions.findByType<JavaPluginExtension>()?.run {
        sourceCompatibility = JavaVersion.toVersion(javaVersion)
        targetCompatibility = JavaVersion.toVersion(javaVersion)
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = javaVersion
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }

}
