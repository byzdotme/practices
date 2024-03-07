plugins {
    alias { libs.plugins.kotlin.jvm }
}

dependencies {
    compileOnly(libs.bundles.flink)
    testImplementation(libs.kotlin.test.junit5)
}

tasks.test {
    useJUnitPlatform()
}