package com.nikitasutulov.lab3

import android.graphics.Paint

class EllipseEditor(paint: Paint, shapes: Array<Shape?>): ShapeEditor(paint, shapes) {
    var ellipseShape: EllipseShape = EllipseShape(this.paint)

    override fun onLBDown(x: Float, y: Float) {
        ellipseShape = EllipseShape(paint)
        ellipseShape.setStartCoords(x, y)
    }

    override fun onLBUp() {
        if (shapes.contains(ellipseShape))
            ShapeManager.removeLastShape(shapes)
        ellipseShape.setGumTrace(false)
        ShapeManager.addShape(ellipseShape, shapes)
        ellipseShape = EllipseShape(paint)
    }

    override fun onMouseMove(x: Float, y: Float) {
        if (shapes.contains(ellipseShape))
            ShapeManager.removeLastShape(shapes)
        ellipseShape.setEndCoords(x, y)
        ShapeManager.addShape(ellipseShape, shapes)
    }
}