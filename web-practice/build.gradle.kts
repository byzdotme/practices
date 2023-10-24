plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    kotlin("plugin.allopen")
    id("org.springframework.boot")
}

kotlin {
    jvmToolchain(17)
}

allOpen {
    annotations("javax.persistence.Entity", "javax.persistence.MappedSuperclass", "javax.persistence.Embedabble")
}

dependencies {
    implementation(libs.jackson.module.kotlin)
    implementation(libs.springboot.validation)
    implementation(libs.springboot.web)
    implementation(libs.springboot.jpa)
    implementation("org.postgresql:postgresql:42.6.0")

    testImplementation(libs.springboot.test)
}

