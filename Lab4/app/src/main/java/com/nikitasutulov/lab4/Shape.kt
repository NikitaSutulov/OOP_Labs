package com.nikitasutulov.lab4

import android.graphics.*

open class Shape(paint: Paint) {
    protected var startX: Float = 0f
    protected var startY: Float = 0f
    protected var endX: Float = 0f
    protected var endY: Float = 0f
    protected var paint = paint

    protected var isGumTrace = true

    fun setStartCoords(x: Float, y: Float) {
        startX = x
        startY = y
    }

    fun setEndCoords(x: Float, y: Float) {
        endX = x
        endY = y
    }

    @JvmName("setGumTrace1")
    fun setGumTrace(gumTrace: Boolean) {
        isGumTrace = gumTrace
    }

    open fun show(canvas: Canvas) {

    }

    open fun setPaintStyle() {
        paint.apply {
            pathEffect = PathEffect()
        }
    }

    fun setGumTracePaintStyle() {
        val dashIntervals = FloatArray(2) {30f; 10f}
        paint.apply {
            color = Color.RED
            style = Paint.Style.STROKE
            pathEffect = DashPathEffect(dashIntervals, 0f)
        }
    }
}