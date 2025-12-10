plugins {
    alias { libs.plugins.kotlin.jvm }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.reflect) {
        version { strictly(libs.versions.kotlin.get()) }
    }
    implementation(libs.jackson.module.kotlin) {
        version { strictly(libs.versions.jackson3.get()) }
    }
    implementation(libs.kotlinx.coroutines.core) {
        version { strictly(libs.versions.kotlinx.coroutines.get()) }
    }
    testImplementation(libs.kotlin.test.junit5) {
        version { strictly(libs.versions.kotlin.get()) }
    }
}

tasks.test {
    useJUnitPlatform()
}
