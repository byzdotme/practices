import org.jetbrains.kotlin.gradle.dsl.KotlinTopLevelExtension

val javaVersion = "17"

plugins {
    kotlin("jvm") version "1.8.22" apply false
    kotlin("plugin.spring") version "1.8.22" apply false
    kotlin("plugin.jpa") version "1.8.22" apply false
    kotlin("plugin.allopen") version "1.8.22" apply false
    id("org.springframework.boot") version "3.1.2" apply false
    id("org.jruyi.thrift") version "0.4.2" apply false
    id("org.openjfx.javafxplugin") version "0.0.14" apply false
    id("org.beryx.jlink") version "2.26.0" apply false
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

    extensions.findByType<KotlinTopLevelExtension>()?.jvmToolchain(11)
}
