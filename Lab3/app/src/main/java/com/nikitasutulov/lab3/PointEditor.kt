package com.nikitasutulov.lab3

import android.graphics.Paint

class PointEditor(paint: Paint, shapes: Array<Shape?>): ShapeEditor(paint, shapes) {
    var pointShape: PointShape = PointShape(this.paint)

    override fun onLBDown(x: Float, y: Float) {
        pointShape = PointShape(paint)
        pointShape.setStartCoords(x, y)
    }

    override fun onLBUp() {
        ShapeManager.addShape(pointShape, shapes)
        pointShape = PointShape(paint)
    }

    override fun onMouseMove(x: Float, y: Float) {

    }
}