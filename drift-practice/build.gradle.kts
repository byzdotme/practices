plugins {
    alias { libs.plugins.kotlin.jvm }
}

group = "cn.bootz.teldrassil"
version = "1.0.0"

dependencies {
    implementation(libs.kotlinx.coroutines.core) {
        version { strictly(libs.versions.kotlinx.coroutines.get()) }
    }
    implementation(libs.bundles.drift)
    testImplementation(libs.kotlin.test.junit5) {
        version { strictly(libs.versions.kotlin.get()) }
    }
}


tasks.test {
    useJUnitPlatform()
}
