plugins {
    java
    id("com.microsoft.thrifty")
}

dependencies {
    implementation(libs.ms.thrifty)
    implementation(project(":thrift-practice-base"))
}
