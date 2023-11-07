plugins {
    alias { libs.plugins.kotlin.jvm }
    id("application")
    id("org.openjfx.javafxplugin")
}

group = "me.tonyirl.practice.jfx"
version = "1.0.0"

dependencies {
    implementation(group ="org.apache.commons", name ="commons-pool2", version ="2.4.2")
}

javafx {
    version = "17.0.2"
    modules = listOf("javafx.fxml", "javafx.web")
}

application {
    mainClass.set("me.tony.practice.jfx.krystal.MyApp")
}
