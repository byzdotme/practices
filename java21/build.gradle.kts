plugins {
    java
}

group = "cn.bootz.teldrassil"
version = "1.0.0"

dependencies {
    implementation(libs.slf4j.simple)
    implementation(libs.lombok)
    testImplementation(platform("org.junit:junit-bom:5.9.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    annotationProcessor(libs.lombok)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.test {
    useJUnitPlatform()
}

// see https://docs.gradle.org/current/userguide/building_java_projects.html#sec:feature_preview
tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.add("--enable-preview")
}

tasks.withType<Test>().configureEach {
    jvmArgs("--enable-preview")
}

tasks.withType<JavaExec>().configureEach {
    jvmArgs("--enable-preview")
}
