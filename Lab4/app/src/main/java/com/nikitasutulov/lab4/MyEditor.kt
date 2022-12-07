package com.nikitasutulov.lab4

import android.graphics.Paint

open class MyEditor(paint: Paint, shapes: Array<Shape?>) {
    val paint = paint
    val shapes = shapes

    private var currentShape = Shape(paint)

    fun onLBDown(x: Float, y: Float) {
        setCurrentShape(currentShape)
        currentShape.setStartCoords(x, y)
    }

    fun onLBUp() {
        if (shapes.contains(currentShape))
            ShapeManager.removeLastShape(shapes)
        currentShape.setGumTrace(false)
        ShapeManager.addShape(currentShape, shapes)
    }

    fun onMouseMove(x: Float, y: Float) {
        if (shapes.contains(currentShape))
            ShapeManager.removeLastShape(shapes)
        currentShape.setEndCoords(x, y)
        ShapeManager.addShape(currentShape, shapes)
    }

    fun setCurrentShape(shape: Shape) {
        val constructor = shape::class.java.getConstructor(paint::class.java)
        currentShape = constructor.newInstance(paint)
    }
}