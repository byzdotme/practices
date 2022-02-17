package me.tony.practice.jfx.drag

import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.input.ClipboardContent
import javafx.scene.input.Dragboard
import javafx.scene.input.TransferMode
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.stage.Stage


/**
 * @author tony.zhuby
 */
class DragAndDropExample : Application() {
    override fun start(primaryStage: Stage) {
        val circle: Circle = createCircle("#ff00ff", "#ff88ff", 100.0)
        circle.onDragDetected = EventHandler {
            println("Circle 1 drag detected")
            val db: Dragboard = circle.startDragAndDrop(*TransferMode.ANY)
            val content = ClipboardContent()
            content.putString("Circle source text")
            db.setContent(content)
        }
        circle.onMouseDragged = EventHandler { it.isDragDetect = true }
        val circle2: Circle = createCircle("#00ffff", "#88ffff", 300.0)
        circle2.onDragOver = EventHandler {
            if (it.gestureSource !== circle2 && it.dragboard.hasString()) {
                it.acceptTransferModes(*TransferMode.COPY_OR_MOVE)
            }
            it.consume()
        }
        circle2.onDragDropped = EventHandler {
            val db = it.dragboard
            if (db.hasString()) {
                println("Dropped: " + db.string)
                it.isDropCompleted = true
            } else {
                it.isDropCompleted = false
            }
            it.consume()
        }
        val pane = Pane()
        pane.children += circle
        pane.children += circle2
        val scene = Scene(pane, 1024.0, 800.0, true)
        primaryStage.scene = scene
        primaryStage.title = "Drag and drop Example"
        primaryStage.show()
    }

    private fun createCircle(strokeColor: String, fillColor: String, x: Double): Circle {
        val circle = Circle()
        circle.centerX = x
        circle.centerY = 200.0
        circle.radius = 50.0
        circle.stroke = Color.valueOf(strokeColor)
        circle.strokeWidth = 5.0
        circle.fill = Color.valueOf(fillColor)
        return circle
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(DragAndDropExample::class.java, *args)
        }
    }
}