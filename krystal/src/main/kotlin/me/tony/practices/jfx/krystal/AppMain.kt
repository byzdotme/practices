package me.tony.practices.jfx.krystal

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

/**
 * @author tony.zhuby
 * @date 2021/5/26
 */
class AppMain : Application() {
    override fun start(stage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("/main.fxml"))
        stage.apply {
            title = "hello krystal"
            scene = Scene(root)
        }.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(AppMain::class.java, *args)
        }
    }
}