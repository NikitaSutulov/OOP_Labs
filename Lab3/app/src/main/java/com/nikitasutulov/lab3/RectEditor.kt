package com.nikitasutulov.lab3

import android.graphics.Paint

class RectEditor(paint: Paint, shapes: Array<Shape?>): ShapeEditor(paint, shapes) {
    var rectShape: RectShape = RectShape(this.paint)

    override fun onLBDown(x: Float, y: Float) {
        rectShape = RectShape(paint)
        rectShape.setStartCoords(x, y)
    }

    override fun onLBUp() {
        if (shapes.contains(rectShape))
            ShapeManager.removeLastShape(shapes)
        rectShape.setGumTrace(false)
        ShapeManager.addShape(rectShape, shapes)
        rectShape = RectShape(paint)    }

    override fun onMouseMove(x: Float, y: Float) {
        if (shapes.contains(rectShape))
            ShapeManager.removeLastShape(shapes)

        rectShape.setEndCoords(x, y)
        ShapeManager.addShape(rectShape, shapes)
    }
}