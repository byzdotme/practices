plugins {
    alias { xa.plugins.kotlin.jvm }
    alias { xa.plugins.kotlin.plugin.spring }
    alias { xa.plugins.kotlin.plugin.jpa }
    alias { xa.plugins.springboot }
}

dependencies {
    implementation(xa.jackson.module.kotlin)
    implementation(xa.springboot.web)
    implementation(xa.springboot.jpa)
    implementation(xa.springboot.jta.atomikos)
    implementation("org.postgresql:postgresql:42.3.8")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}