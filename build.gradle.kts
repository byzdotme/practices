import org.jetbrains.kotlin.gradle.dsl.KotlinTopLevelExtension

val javaVersion = "17"

plugins {
    kotlin("jvm") version "1.9.10" apply false
    kotlin("plugin.spring") version "1.9.10" apply false
    kotlin("plugin.jpa") version "1.9.10" apply false
    kotlin("plugin.allopen") version "1.9.10" apply false
    id("org.springframework.boot") version "3.1.3" apply false
    id("org.jruyi.thrift") version "0.4.2" apply false
    id("org.openjfx.javafxplugin") version "0.0.14" apply false
    id("org.beryx.jlink") version "2.26.0" apply false
    id("com.microsoft.thrifty") version "3.1.0" apply false
}

group = "me.tonyirl"
version = "1.0.0"

allprojects {

    extensions.findByType<JavaPluginExtension>()?.apply {
        sourceCompatibility = JavaVersion.toVersion(javaVersion)
        targetCompatibility = JavaVersion.toVersion(javaVersion)
    }
    extensions.findByType<KotlinTopLevelExtension>()?.apply {
        jvmToolchain(11)
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

}

