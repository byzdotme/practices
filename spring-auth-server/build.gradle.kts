plugins {
    alias { libs.plugins.kotlin.jvm }
    alias { libs.plugins.kotlin.plugin.spring }
}

dependencies {
    implementation(libs.springboot.auth.server)
    testImplementation(libs.kotlin.test.junit5)
    testImplementation(libs.springboot.test)
}

tasks.test {
    useJUnitPlatform()
}