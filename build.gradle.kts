import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val javaVersion = "17"

plugins {
    kotlin("jvm") version "1.7.0" apply false
    kotlin("plugin.spring") version "1.7.0" apply false
    id("org.springframework.boot") version "2.7.0" apply false
    id("org.jruyi.thrift") version "0.4.2" apply false
    id("org.openjfx.javafxplugin") version "0.0.13" apply false
    id("org.beryx.jlink") version "2.25.0" apply false
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
