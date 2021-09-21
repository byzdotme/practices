plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
}

dependencies {
    implementation(libs.springboot.base)
    implementation(libs.springboot.actuator)
    implementation(libs.spring.statemachine.starter) {
        exclude(group = "org.springframework.boot")
    }
}
