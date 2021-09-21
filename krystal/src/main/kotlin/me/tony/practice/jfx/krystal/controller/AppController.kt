package me.tony.practice.jfx.krystal.controller

import javafx.fxml.FXML
import javafx.scene.web.WebView

/**
 * @author tony.zhuby
 */
class AppController {

    @FXML
    lateinit var webview: WebView

    fun initialize() {
        webview.engine.load("https://baike.baidu.com/item/%E9%83%91%E7%A7%80%E6%99%B6")
    }
}