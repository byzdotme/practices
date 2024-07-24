plugins {
    java
}

group = "cn.bootz.teldrassil"
version = "1.0.0"

dependencies {
    implementation(libs.slf4j.simple)
    implementation(libs.lombok)
    implementation(libs.springboot.web)
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("io.undertow:undertow-core:2.3.13.Final")
    implementation("io.undertow:undertow-servlet:2.3.13.Final")
    implementation("io.undertow:undertow-websockets-jsr:2.3.13.Final")
    implementation("com.google.code.findbugs:jsr305:3.0.2")
//    implementation("org.ow2.asm:asm:${libs.versions.asm}")
//    implementation("org.ow2.asm:asm-util:${libs.versions.asm}")
//    implementation("org.ow2.asm:asm-commons:${libs.versions.asm}")
//    implementation("org.ow2.asm:asm-tree:${libs.versions.asm}")
//    implementation("org.ow2.asm:asm-analysis:${libs.versions.asm}")
//    implementation("org.antlr:antlr4:4.13.0")
    testImplementation(libs.kotlin.test.junit5)
//    testImplementation("org.ow2.asm:asm-test:${libs.versions.asm}")
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
