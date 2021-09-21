group = "me.tony.practices"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
}

dependencies {
    implementation(libs.springboot.web)
    implementation(libs.springboot.es)
    implementation(libs.jackson.module.kotlin)
}