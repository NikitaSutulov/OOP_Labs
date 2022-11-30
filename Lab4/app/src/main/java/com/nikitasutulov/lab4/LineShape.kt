package com.nikitasutulov.lab4

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

open class LineShape(paint: Paint): Shape(paint) {
    override fun show(canvas: Canvas) {
        if (!isGumTrace) {
            setPaintStyle()
        }
        else {
            setGumTracePaintStyle()
        }
        canvas.drawLine(startX, startY, endX, endY, paint)
    }

    override fun setPaintStyle() {
        super.setPaintStyle()
        paint.apply {
            color = Color.BLACK
            style = Paint.Style.FILL_AND_STROKE
        }
    }
}