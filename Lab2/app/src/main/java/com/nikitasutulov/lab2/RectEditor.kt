package com.nikitasutulov.lab2

import android.graphics.Paint

class RectEditor(paint: Paint, shapes: MutableList<Shape>): ShapeEditor(paint, shapes) {
    var rectShape: RectShape = RectShape(paint1)

    override fun onLBDown(x: Float, y: Float) {
        rectShape = RectShape(paint1)
        rectShape.setStartCoords(x, y)
    }

    override fun onLBUp() {
        rectShape = RectShape(paint1)
    }

    override fun onMouseMove(x: Float, y: Float) {
        if (shapes1.contains(rectShape))
            shapes1.removeAt(shapes1.lastIndex)

        rectShape.setEndCoords(x, y)
        ShapeAdder.addShape(rectShape, shapes1)
    }
}