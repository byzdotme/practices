plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "practices"

include("web-practice")
include("common-practice")
//include("thrift-practice")
//include("thrift-practice-base")
include("eventbus")
include("statemachine")
include("krystal")
//include("java17")
include("elktry")
include("jfxtry")
include("drift-practice")
include("reactive-practice")
include("modernjava")
//include("manifold-practice")
//include("xa-practice")
include("flink-practice")
//
//pluginManagement {
//    repositories {
//        mavenLocal()
//        gradlePluginPortal()
//    }
//}

dependencyResolutionManagement {
    versionCatalogs {
        create("xa") {
            version("kotlin", "1.6.21")
            version("springboot", "2.7.18")
            version("jackson", "2.13.5")

            library("kotlin-test-junit5", "org.jetbrains.kotlin", "kotlin-test-junit5").versionRef("kotlin")
            library(
                "jackson-module-kotlin",
                "com.fasterxml.jackson.module",
                "jackson-module-kotlin"
            ).versionRef("jackson")
            library("springboot-base", "org.springframework.boot", "spring-boot-starter").versionRef("springboot")
            library("springboot-web", "org.springframework.boot", "spring-boot-starter-web").versionRef("springboot")
            library(
                "springboot-jpa",
                "org.springframework.boot",
                "spring-boot-starter-data-jpa"
            ).versionRef("springboot")
            library(
                "springboot-jta-atomikos",
                "org.springframework.boot",
                "spring-boot-starter-jta-atomikos"
            ).versionRef("springboot")

            plugin("kotlin.jvm", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
            plugin("kotlin.plugin.spring", "org.jetbrains.kotlin.plugin.spring").versionRef("kotlin")
            plugin("kotlin.plugin.jpa", "org.jetbrains.kotlin.plugin.jpa").versionRef("kotlin")
            plugin("springboot", "org.springframework.boot").versionRef("springboot")
        }
    }
}
include("spring-auth-server")
