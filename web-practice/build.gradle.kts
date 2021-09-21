plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
}

dependencies {
    implementation(libs.jackson.module.kotlin)
    implementation(libs.springboot.validation)
    implementation(libs.springboot.web) {
        exclude(module = "spring-boot-starter-tomcat")
    }

    implementation(libs.springboot.undertow)

    testImplementation(libs.springboot.test)
}
