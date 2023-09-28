plugins {
    java
}

java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

dependencies {
    implementation(libs.slf4j.simple)
    testImplementation(libs.springboot.test)
}
