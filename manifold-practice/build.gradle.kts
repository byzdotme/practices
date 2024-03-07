plugins {
    java
    id("systems.manifold.manifold-gradle-plugin")
}

group = "me.tonyirl"
version = "1.0.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

dependencies {
    implementation(libs.manifold.all)
    implementation(libs.slf4j.simple)
    testImplementation(libs.kotlin.test.junit5)
    annotationProcessor(libs.manifold.all)
    testAnnotationProcessor(libs.manifold.all)
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Xplugin:Manifold")
}

tasks.test {
    useJUnitPlatform()
}