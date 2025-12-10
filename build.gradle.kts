import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // see org.jetbrains.kotlin.gradle.plugin.KotlinGradleBuildServices#detectKotlinPluginLoadedInMultipleProjects
    alias { libs.plugins.kotlin.jvm } version libs.versions.kotlin.get() apply false
    alias { libs.plugins.kotlin.plugin.allopen } version libs.versions.kotlin.get() apply false
    alias { libs.plugins.kotlin.plugin.jpa } version libs.versions.kotlin.get() apply false
    alias { libs.plugins.kotlin.plugin.spring } version libs.versions.kotlin.get() apply false
    alias { libs.plugins.springboot} version libs.versions.springboot.get() apply false
    id("org.jruyi.thrift") version "0.4.2" apply false
    id("org.openjfx.javafxplugin") version "0.1.0" apply false
    id("org.beryx.jlink") version "2.26.0" apply false
    id("com.microsoft.thrifty") version "3.1.0" apply false
    id("systems.manifold.manifold-gradle-plugin") version "0.0.2-alpha" apply false
}


group = "me.tony.practice"
version = "1.0.0"

subprojects {
    repositories {
        mavenCentral()
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<JavaCompile> {
        options.release.set(21)
    }

    tasks.withType<KotlinCompile> {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
            freeCompilerArgs.addAll("-Xjsr305=strict", "-Xjdk-release=21")
        }
    }
}
