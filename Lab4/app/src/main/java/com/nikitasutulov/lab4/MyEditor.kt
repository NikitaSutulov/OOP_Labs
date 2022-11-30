package com.nikitasutulov.lab4

import android.graphics.Paint

open class MyEditor(paint: Paint, shapes: Array<Shape?>) {
    val paint = paint
    val shapes = shapes

    private var currentShape = Shape(paint)
    private var currentShapeOption = MainCanvas.ShapeOptions.LINE

    fun onLBDown(x: Float, y: Float) {
        setCurrentShape(currentShapeOption)
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

    fun setCurrentShapeOption(shapeOption: MainCanvas.ShapeOptions) {
        currentShapeOption = shapeOption
    }

    private fun setCurrentShape(shapeOption: MainCanvas.ShapeOptions) {
        currentShape = when(shapeOption) {
            MainCanvas.ShapeOptions.ELLIPSE -> EllipseShape(paint)
            MainCanvas.ShapeOptions.LINE -> LineShape(paint)
            MainCanvas.ShapeOptions.POINT -> PointShape(paint)
            MainCanvas.ShapeOptions.RECT -> RectShape(paint)
            MainCanvas.ShapeOptions.LINE_WITH_CIRCLES -> LineWithCirclesShape(paint)
            MainCanvas.ShapeOptions.CUBE -> CubeShape(paint)
        }
    }
}