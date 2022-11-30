package com.nikitasutulov.lab2

import android.graphics.Paint

class EllipseEditor(paint: Paint, shapes: MutableList<Shape>): ShapeEditor(paint, shapes) {
    var ellipseShape: EllipseShape = EllipseShape(paint1)

    override fun onLBDown(x: Float, y: Float) {
        ellipseShape = EllipseShape(paint1)
        ellipseShape.setStartCoords(x, y)
    }

    override fun onLBUp() {
        if (shapes1.contains(ellipseShape))
            shapes1.removeAt(shapes1.lastIndex)
        ellipseShape.setGumTrace(false)
        ShapeAdder.addShape(ellipseShape, shapes1)
        ellipseShape = EllipseShape(paint1)
    }

    override fun onMouseMove(x: Float, y: Float) {
        if (shapes1.contains(ellipseShape))
            shapes1.removeAt(shapes1.lastIndex)
        ellipseShape.setEndCoords(x, y)
        ShapeAdder.addShape(ellipseShape, shapes1)
    }
}