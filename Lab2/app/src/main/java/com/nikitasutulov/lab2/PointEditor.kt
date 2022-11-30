package com.nikitasutulov.lab2

import android.graphics.Paint

class PointEditor(paint: Paint, shapes: MutableList<Shape>): ShapeEditor(paint, shapes) {
    var pointShape: PointShape = PointShape(paint1)

    override fun onLBDown(x: Float, y: Float) {
        pointShape = PointShape(paint1)
        pointShape.setStartCoords(x, y)
    }

    override fun onLBUp() {
        ShapeAdder.addShape(pointShape, shapes1)
        pointShape = PointShape(paint1)
    }

    override fun onMouseMove(x: Float, y: Float) {

    }
}