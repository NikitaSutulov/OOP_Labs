package com.nikitasutulov.lab2

class ShapeAdder {
    companion object {
        private const val MAX_LIST_SIZE: Int = 124
        fun addShape(shape: Shape, shapes: MutableList<Shape>) {
            if (shapes.lastIndex == MAX_LIST_SIZE - 1) {
                shapes.removeAt(shapes.lastIndex)
            }
            shapes.add(shape)
        }
    }
}