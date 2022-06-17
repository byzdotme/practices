plugins {
    java
    id("org.jruyi.thrift")
}

dependencies {
    implementation(libs.thrift.lib)
    implementation(project(":thrift-practice-base"))
}

tasks.withType<org.jruyi.gradle.thrift.plugin.CompileThrift> {
    thriftExecutable = "thrift"
    includeDirs = setOf(file("${project(":thrift-practice-base").projectDir}/src/main/thrift"))
    generator("java", "private-members", "fullcamel", "generated_annotations=undated", "option_type")
}