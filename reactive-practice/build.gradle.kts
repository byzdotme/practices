plugins {
    alias { libs.plugins.kotlin.jvm }
    alias { libs.plugins.kotlin.plugin.spring }
}

group = "cn.bootz.teldrassil"
version = "1.0.0"

dependencies {
    implementation(libs.bundles.kt.springboot.webflux)
    testImplementation(libs.bundles.kt.springboot.test)
    testImplementation(libs.reactor.test)
}

tasks.test {
    useJUnitPlatform()
}