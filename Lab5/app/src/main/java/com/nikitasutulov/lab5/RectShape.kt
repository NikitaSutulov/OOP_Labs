package com.nikitasutulov.lab5

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

open class RectShape(paint: Paint) : Shape(paint) {
    override fun show(canvas: Canvas) {
        if (!isGumTrace) {
            setFillPaintStyle()
            canvas.drawRect(2 * startX - endX, 2 * startY - endY, endX, endY, paint)
            setPaintStyle()
            super.show(canvas)
            canvas.drawRect(2 * startX - endX, 2 * startY - endY, endX, endY, paint)
        }
        else {
            setGumTracePaintStyle()
            canvas.drawRect(2 * startX - endX, 2 * startY - endY, endX, endY, paint)
        }
    }

    override fun createShape(): Shape {
        return RectShape(paint)
    }

    override fun setPaintStyle() {
        super.setPaintStyle()
        paint.apply {
            color = Color.BLACK
            style = Paint.Style.STROKE
        }
    }

    protected open fun setFillPaintStyle() {
        paint.apply {
            color = Color.rgb(255, 255, 255)
            style = Paint.Style.FILL
        }
    }
}