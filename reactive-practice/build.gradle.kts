plugins {
    alias { libs.plugins.kotlin.jvm }
}

group = "cn.bootz.teldrassil"
version = "1.0.0"

dependencies {
    implementation(libs.springboot.webflux)
    testImplementation(libs.springboot.test)
    testImplementation(libs.kotlin.test.junit5)
}

tasks.test {
    useJUnitPlatform()
}