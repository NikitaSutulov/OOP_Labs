package com.nikitasutulov.lab3

class ShapeManager {
    companion object {
        private const val MAX_LIST_SIZE: Int = 125
        private var lastIndex: Int = 0
        fun addShape(shape: Shape, shapes: Array<Shape?>) {
            if (lastIndex == MAX_LIST_SIZE - 1) {
                removeLastShape(shapes)
            }
            shapes[lastIndex] = shape
            lastIndex++
        }
        fun removeLastShape(shapes: Array<Shape?>) {
            shapes[lastIndex] = null
            lastIndex--
        }
    }
}