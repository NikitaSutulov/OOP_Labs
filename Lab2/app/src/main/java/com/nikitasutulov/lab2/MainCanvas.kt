package com.nikitasutulov.lab2

import android.content.Context
import android.graphics.*
import android.util.Log
import android.view.MotionEvent
import android.view.View

private const val userStrokeWidth = 6f

class MainCanvas (context: Context): View(context) {

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
        strokeWidth = userStrokeWidth
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
    }

    private var motionX = 0f
    private var motionY = 0f

    private val shapes = mutableListOf<Shape>()

    private var currentShapeEditor: ShapeEditor = LineEditor(paint, shapes)

    enum class Options (val option: Int) {
        POINT(0),
        LINE(1),
        RECT(2),
        ELLIPSE(3)
    }

    fun setCurrentShapeEditor(option: Options) {
        currentShapeEditor = when (option) {
            Options.POINT -> PointEditor(paint, shapes)
            Options.LINE -> LineEditor(paint, shapes)
            Options.RECT -> RectEditor(paint, shapes)
            Options.ELLIPSE -> EllipseEditor(paint, shapes)
        }
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        canvas1 = Canvas()
        canvas1.drawColor(backgroundColor)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        for (i in shapes) {
            i.show(canvas!!)
            Log.d("INDEX", shapes.indexOf(i).toString())
            Log.d("SHAPE", i.javaClass.kotlin.toString())
        }

        Log.d("TAG", shapes.size.toString())
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
        currentShapeEditor.onLBUp()
    }

    private fun touchMove() {
        invalidate()
        currentShapeEditor.onMouseMove(motionX, motionY)
        }

    private fun touchStart() {
        invalidate()
        currentShapeEditor.onLBDown(motionX, motionY)
    }
}