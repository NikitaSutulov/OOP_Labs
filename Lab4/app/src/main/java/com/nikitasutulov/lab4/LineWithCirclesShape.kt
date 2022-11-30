package com.nikitasutulov.lab4

import android.graphics.Canvas
import android.graphics.Paint

class LineWithCirclesShape(paint: Paint) : LineShape(paint) {
    private var circleSize = 20f

    override fun show(canvas: Canvas) {
        super.show(canvas)
        canvas.drawCircle(startX, startY, circleSize, paint)
        canvas.drawCircle(endX, endY, circleSize, paint)
    }
}