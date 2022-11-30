package com.nikitasutulov.lab4

import android.content.Context
import android.graphics.*
import android.util.Log
import android.view.MotionEvent
import android.view.View

class MainCanvas (context: Context): View(context) {

    private val USER_STROKE_WIDTH = 6f
    private val MAX_LIST_SIZE: Int = 125

    //set background color
    private val backgroundColor = Color.WHITE
    private var canvas1: Canvas = Canvas()

    //set pen color
    private val penColor = Color.BLACK

    private val paint = Paint().apply {
        color = penColor
        isAntiAlias = true
        isDither = true
        style = Paint.Style.STROKE
        strokeWidth = USER_STROKE_WIDTH
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
    }

    private var motionX = 0f
    private var motionY = 0f

    private val shapes = arrayOfNulls<Shape>(MAX_LIST_SIZE)

    private var shapeEditor: MyEditor = MyEditor(paint, shapes)

    enum class ShapeOptions {
        POINT,
        LINE,
        RECT,
        ELLIPSE,
        LINE_WITH_CIRCLES,
        CUBE
    }

    fun setShapeEditorCurrentShapeOption(shapeOption: ShapeOptions) {
        shapeEditor.setCurrentShapeOption(shapeOption)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        canvas1 = Canvas()
        canvas1.drawColor(backgroundColor)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for (i in shapes) {
            i?.show(canvas!!)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        motionX = event!!.x
        motionY = event.y
        Log.d("EVENT_ACTION", event.action.toString())
        when (event.action) {
            MotionEvent.ACTION_DOWN -> touchStart()
            MotionEvent.ACTION_MOVE -> touchMove()
            MotionEvent.ACTION_UP -> touchUp()
        }
        return true
    }

    private fun touchUp() {
        invalidate()
        shapeEditor.onLBUp()
    }

    private fun touchMove() {
        invalidate()
        shapeEditor.onMouseMove(motionX, motionY)
        }

    private fun touchStart() {
        invalidate()
        shapeEditor.onLBDown(motionX, motionY)
    }
}