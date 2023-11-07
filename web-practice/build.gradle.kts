plugins {
    alias { libs.plugins.kotlin.jvm }
    alias { libs.plugins.kotlin.plugin.allopen }
    alias { libs.plugins.kotlin.plugin.jpa }
    alias { libs.plugins.kotlin.plugin.spring }
    alias { libs.plugins.springboot }
}

kotlin {
    jvmToolchain(17)
}

allOpen {
    annotations("javax.persistence.Entity", "javax.persistence.MappedSuperclass", "javax.persistence.Embedabble")
}

dependencies {
    implementation(libs.jackson.module.kotlin)
    implementation(libs.springboot.validation)
    implementation(libs.springboot.web)
    implementation(libs.springboot.jpa)
    implementation("org.postgresql:postgresql:42.6.0")

    testImplementation(libs.springboot.test)
}

