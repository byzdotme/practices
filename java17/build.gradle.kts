plugins {
    java
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}


dependencies {
    implementation(libs.slf4j.simple)
    testImplementation(libs.springboot.test)
}
