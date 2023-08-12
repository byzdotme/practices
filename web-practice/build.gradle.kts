plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    kotlin("plugin.allopen")
    id("org.springframework.boot")
}

allOpen {
    annotations("javax.persistence.Entity", "javax.persistence.MappedSuperclass", "javax.persistence.Embedabble")
}

dependencies {
    implementation(libs.jackson.module.kotlin)
    implementation(libs.springboot.validation)
    implementation(libs.springboot.web) {
        exclude(module = "spring-boot-starter-tomcat")
    }

    implementation(libs.springboot.undertow)
    implementation(libs.springboot.jpa)
    implementation("org.postgresql:postgresql:42.5.1")

    testImplementation(libs.springboot.test)
}

