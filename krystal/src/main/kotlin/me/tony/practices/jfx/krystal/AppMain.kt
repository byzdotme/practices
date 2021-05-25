package me.tony.practices.jfx.krystal

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.stage.Stage

/**
 * @author tony.zhuby
 * @date 2021/5/26
 */
class AppMain : Application() {
    override fun start(stage: Stage) {
        val pane = FXMLLoader.load<Pane>(javaClass.getResource("/main.fxml"))

        stage.title = "hello krystal"
        stage.scene = Scene(pane)
        stage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(AppMain::class.java, *args)
        }
    }
}