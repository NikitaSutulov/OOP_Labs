package com.nikitasutulov.lab2

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class PointShape(paint: Paint) : Shape(paint) {
    private val paint1 = paint
    override fun show(canvas: Canvas) {
        setPaintStyle()
        canvas.drawCircle(startX, startY, 10f, paint1)
    }

    override fun setPaintStyle() {
        paint1.apply {
            color = Color.BLACK
            style = Paint.Style.FILL_AND_STROKE
        }
    }
}