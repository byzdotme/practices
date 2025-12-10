plugins {
    java
}

group = "cn.bootz.teldrassil"
version = "1.0.0"

dependencies {
    implementation(libs.slf4j.simple)
    implementation(libs.lombok)
    implementation(libs.gson)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.jackson.databind) {
        version { strictly(libs.versions.jackson3.get()) }
    }
    implementation("io.undertow:undertow-servlet:2.3.20.Final")
    testImplementation(libs.kotlin.test.junit5) {
        version { strictly(libs.versions.kotlin.get()) }
    }
    annotationProcessor(libs.lombok)
}

tasks.withType<JavaCompile> {
    options.release.set(25)
}

tasks.test {
    useJUnitPlatform()
}

