import org.jetbrains.kotlin.gradle.dsl.KotlinTopLevelExtension

plugins {
    alias { libs.plugins.kotlin.jvm } apply false
    alias { libs.plugins.kotlin.plugin.spring } apply false
    alias { libs.plugins.kotlin.plugin.jpa } apply false
    alias { libs.plugins.kotlin.plugin.allopen } apply false
    id("org.springframework.boot") version "3.1.5" apply false
    id("org.jruyi.thrift") version "0.4.2" apply false
    id("org.openjfx.javafxplugin") version "0.0.14" apply false
    id("org.beryx.jlink") version "2.26.0" apply false
    id("com.microsoft.thrifty") version "3.1.0" apply false
    id("systems.manifold.manifold-gradle-plugin") version "0.0.2-alpha" apply false
}

group = "me.tonyirl"
version = "1.0.0"

allprojects {

    extensions.findByType<JavaPluginExtension>()?.apply {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    extensions.findByType<KotlinTopLevelExtension>()?.apply {
        jvmToolchain(11)
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

}

