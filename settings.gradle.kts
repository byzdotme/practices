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

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}
