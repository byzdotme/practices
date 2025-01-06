plugins {
    alias { libs.plugins.kotlin.jvm }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.reflect)
    implementation(libs.jackson.module.kotlin)
    implementation("com.alibaba:dashscope-sdk-java:2.17.1")
    testImplementation(libs.kotlin.test.junit5)
}

tasks.test {
    useJUnitPlatform()
}