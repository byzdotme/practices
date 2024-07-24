plugins {
    alias { libs.plugins.kotlin.jvm }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.reflect)
    implementation(libs.jackson.module.kotlin)
    testImplementation(libs.kotlin.test.junit5)
}

tasks.test {
    useJUnitPlatform()
}