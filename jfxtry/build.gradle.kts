plugins {
    kotlin("jvm")
    id("application")
    id("org.openjfx.javafxplugin")
}

group = "me.tonyirl"
version = "1.0.0"

dependencies {
}

javafx {
    version = "17.0.2"
    modules = listOf("javafx.fxml", "javafx.web")
}

application {
    mainClass.set("me.tony.practice.jfx.drag.DragAndDropExample")
}
