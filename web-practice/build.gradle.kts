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
    annotations("jakarta.persistence.Entity", "jakarta.persistence.MappedSuperclass", "jakarta.persistence.Embeddable")
}

dependencies {
    implementation(platform(libs.springboot.bom))
    implementation(libs.kotlin.reflect)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.springboot.validation)
    implementation(libs.springboot.web)
    implementation(libs.springboot.jpa)

    implementation("org.eclipse:yasson")

    implementation(platform(libs.springcloud.bom))
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    implementation("org.postgresql:postgresql:42.6.0")

    testImplementation(libs.springboot.test)
    testImplementation(libs.kotlin.test.junit5)
}

