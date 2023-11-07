plugins {
    alias { libs.plugins.kotlin.jvm }
}

group = "cn.bootz.teldrassil"
version = "1.0.0"

dependencies {
    implementation(libs.springboot.webflux)
    testImplementation(libs.springboot.test)
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}