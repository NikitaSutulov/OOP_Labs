package com.nikitasutulov.lab4

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class EllipseShape(paint: Paint): Shape(paint) {
    override fun show(canvas: Canvas) {
        if (!isGumTrace) {
            setPaintStyle()
            canvas.drawOval(startX, startY, endX, endY, paint)
        }
        else {
            setGumTracePaintStyle()
            canvas.drawOval(startX, startY, endX, endY, paint)
        }
    }

    override fun setPaintStyle() {
        super.setPaintStyle()
        paint.apply {
            color = Color.BLACK
            style = Paint.Style.STROKE
        }
    }
}