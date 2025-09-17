plugins {
    alias { libs.plugins.kotlin.jvm }
}

group = "me.tony.practice"

dependencies {
    implementation(libs.storm.client)
    testImplementation(libs.kotlin.test.junit5)
}
