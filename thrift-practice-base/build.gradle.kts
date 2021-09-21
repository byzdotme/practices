plugins {
    `java-library`
    id("org.jruyi.thrift")
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

dependencies {
    implementation(libs.thrift.lib)
}


tasks.withType<org.jruyi.gradle.thrift.plugin.CompileThrift> {
    thriftExecutable = "/usr/local/opt/thrift/bin/thrift"
    generator("java", "private-members", "fullcamel", "generated_annotations=undated", "option_type")
}
