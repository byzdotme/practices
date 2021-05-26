package me.tony.practices.jfx.krystal.controller

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.web.WebView
import java.net.URL
import java.util.*

/**
 * @author tony.zhuby
 * @date 2021/5/27
 */
class MainController : Initializable {

    @FXML
    lateinit var webview: WebView
    override fun initialize(location: URL?, resources: ResourceBundle?) {
        webview.engine.load("https://baike.baidu.com/item/%E9%83%91%E7%A7%80%E6%99%B6")
    }


}