rootProject.name = "practices"

include("web-practice")
include("common-practice")
//include("thrift-practice")
//include("thrift-practice-base")
include("eventbus")
include("statemachine")
include("krystal")
include("java17")
include("elktry")
include("jfxtry")
include("drift-practice")
include("reactive-practice")
include("java21")
include("manifold-practice")
include("xa-practice")

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement { 
    versionCatalogs { 
        create("xa") {
            version("springboot", "2.7.17")
            
            library("springboot-base", "org.springframework.boot", "spring-boot-starter").versionRef("springboot")
            library("springboot-jta-atomikos", "org.springframework.boot", "spring-boot-starter-jta-atomikos").versionRef("springboot")
        }
    }
}
include("flink-practice")
