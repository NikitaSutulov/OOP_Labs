package com.nikitasutulov.lab3

import android.graphics.Paint

class LineEditor(paint: Paint, shapes: Array<Shape?>): ShapeEditor(paint, shapes) {

    var lineShape: LineShape = LineShape(this.paint)

    override fun onLBDown(x: Float, y: Float) {
        lineShape = LineShape(paint)
        lineShape.setStartCoords(x, y)
    }

    override fun onLBUp() {
        if (shapes.contains(lineShape))
            ShapeManager.removeLastShape(shapes)
        lineShape.setGumTrace(false)
        ShapeManager.addShape(lineShape, shapes)
        lineShape = LineShape(paint)
    }

    override fun onMouseMove(x: Float, y: Float) {
        if (shapes.contains(lineShape))
            ShapeManager.removeLastShape(shapes)

        lineShape.setEndCoords(x, y)
        ShapeManager.addShape(lineShape, shapes)
    }
}