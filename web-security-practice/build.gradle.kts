plugins {
    alias { libs.plugins.kotlin.jvm }
    alias { libs.plugins.kotlin.plugin.allopen }
    alias { libs.plugins.kotlin.plugin.jpa }
    alias { libs.plugins.kotlin.plugin.spring }
    alias { libs.plugins.springboot }
}


allOpen {
    annotations("jakarta.persistence.Entity", "jakarta.persistence.MappedSuperclass", "jakarta.persistence.Embeddable")
}

dependencies {
    implementation(libs.kotlin.reflect)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.springboot.web)
    implementation(libs.springboot.validation)
    implementation(libs.springboot.jpa)
    implementation(libs.springboot.security)
    implementation(libs.postgres.driver)

    testImplementation(libs.kotlin.test.junit5)
    testImplementation(libs.springboot.test)
    testImplementation(libs.h2)
}

