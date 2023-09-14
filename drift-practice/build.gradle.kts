plugins {
    kotlin("jvm")
}

group = "cn.bootz.teldrassil"
version = "1.0.0"

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.drift.client)
    implementation(libs.drift.server)
    implementation(libs.drift.transport.netty)
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}