group = "me.tony.practices"
version = "1.0-SNAPSHOT"

plugins {
    alias { libs.plugins.kotlin.jvm }
    alias { libs.plugins.kotlin.plugin.spring }
    alias { libs.plugins.springboot }
}

dependencies {
    implementation(libs.springboot.web)
    implementation(libs.springboot.es)
    implementation(libs.jackson.module.kotlin)
}