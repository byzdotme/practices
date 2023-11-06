plugins {
    alias { libs.plugins.kotlin.jvm }
}

dependencies {
    compileOnly(libs.bundles.flink)
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}