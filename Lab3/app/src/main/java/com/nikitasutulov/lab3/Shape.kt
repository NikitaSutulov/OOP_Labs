package com.nikitasutulov.lab3

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

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

    }

    fun setGumTracePaintStyle() {
        paint.apply {
            color = Color.RED
            style = Paint.Style.STROKE
        }
    }
}