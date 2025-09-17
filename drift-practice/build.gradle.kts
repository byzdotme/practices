plugins {
    alias { libs.plugins.kotlin.jvm }
}

group = "cn.bootz.teldrassil"
version = "1.0.0"

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.bundles.drift)
    testImplementation(libs.kotlin.test.junit5)
}


tasks.test {
    useJUnitPlatform()
}
