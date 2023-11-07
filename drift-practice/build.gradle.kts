plugins {
    alias { libs.plugins.kotlin.jvm }
}

group = "cn.bootz.teldrassil"
version = "1.0.0"

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.bundles.drift)
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}
