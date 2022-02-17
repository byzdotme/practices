package me.tony.practice.jfx.jfx3d

import javafx.application.Application
import javafx.application.ConditionalFeature
import javafx.application.Platform
import javafx.scene.Group
import javafx.scene.PerspectiveCamera
import javafx.scene.Scene
import javafx.scene.shape.Box
import javafx.scene.shape.CullFace
import javafx.scene.transform.Rotate
import javafx.stage.Stage
import java.util.logging.Logger

/**
 * @author tony.zhuby
 */
class Jfx3DExample :Application(){
    override fun start(stage: Stage) {
        if (!Platform.isSupported(ConditionalFeature.SCENE3D)) {
            log.info("3D not support")
            return
        }
        val box = Box(100.0, 100.0, 100.0)
        box.cullFace = CullFace.NONE
        box.translateX = 250.0
        box.translateY = 100.0
        box.translateZ = 400.0

        val camera = PerspectiveCamera(false)
        camera.translateX = 150.0
        camera.translateY = -100.0
        camera.translateZ = 250.0

        val root = Group(box)
        root.rotationAxis = Rotate.X_AXIS
        root.rotate = 30.0

        val scene = Scene(root, 500.0, 300.0, true)
        scene.camera = camera
        stage.scene = scene
        stage.title = "3D example"

        stage.show()
    }

    companion object {
        private val log:Logger = Logger.getLogger("")

        @JvmStatic
        fun main(args: Array<String>) {
            launch(Jfx3DExample::class.java, *args)
        }

    }
}