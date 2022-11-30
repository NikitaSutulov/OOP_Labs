package com.nikitasutulov.lab3

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class PointShape(paint: Paint) : Shape(paint) {
    override fun show(canvas: Canvas) {
        setPaintStyle()
        canvas.drawCircle(startX, startY, 10f, paint)
    }

    override fun setPaintStyle() {
        paint.apply {
            color = Color.BLACK
            style = Paint.Style.FILL_AND_STROKE
        }
    }
}