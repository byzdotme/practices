plugins {
    java
    id("systems.manifold.manifold-gradle-plugin")
}

group = "me.tonyirl"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.manifold.all)
    implementation("org.slf4j:slf4j-simple:2.0.9")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    annotationProcessor(libs.manifold.all)
    testAnnotationProcessor(libs.manifold.all)
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Xplugin:Manifold")
}

tasks.test {
    useJUnitPlatform()
}