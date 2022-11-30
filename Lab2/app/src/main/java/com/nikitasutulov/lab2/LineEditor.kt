package com.nikitasutulov.lab2

import android.graphics.Paint

class LineEditor(paint: Paint, shapes: MutableList<Shape>): ShapeEditor(paint, shapes) {

    var lineShape: LineShape = LineShape(paint1)

    override fun onLBDown(x: Float, y: Float) {
        lineShape = LineShape(paint1)
        lineShape.setStartCoords(x, y)
    }

    override fun onLBUp() {
        lineShape = LineShape(paint1)
    }

    override fun onMouseMove(x: Float, y: Float) {
        if (shapes1.contains(lineShape))
            shapes1.removeAt(shapes1.lastIndex)

        lineShape.setEndCoords(x, y)
        ShapeAdder.addShape(lineShape, shapes1)
    }
}