package com.nikitasutulov.lab2

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class EllipseShape(paint: Paint): Shape(paint) {
    private val paint1 = paint
    override fun show(canvas: Canvas) {
        if (!isGumTrace) {
            setFillPaintStyle()
            canvas.drawOval(2 * startX - endX, 2 * startY - endY, endX, endY, paint1)
        }
        setPaintStyle()
        canvas.drawOval(2 * startX - endX, 2 * startY - endY, endX, endY, paint1)
    }

    override fun setPaintStyle() {
        paint1.apply {
            color = Color.BLACK
            style = Paint.Style.STROKE
        }
    }

    private fun setFillPaintStyle() {
        paint1.apply {
            color = Color.rgb(192, 192, 192)
            style = Paint.Style.FILL
        }
    }
}