package com.nikitasutulov.object3

import android.content.ClipboardManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries


class MainActivity : AppCompatActivity() {

    lateinit var lineGraphView: GraphView
    lateinit var copiedData: String
    lateinit var minAndMaxX: Pair<Double, Double>
    lateinit var minAndMaxY: Pair<Double, Double>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        if (hasFocus) {
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val copiedPointsString = clipboard.primaryClip?.getItemAt(0)?.text?.toString()
            copiedData = copiedPointsString.toString()

            lineGraphView = findViewById(R.id.idGraphView)
            lineGraphView.removeAllSeries()

            val series = getSeriesFromString(copiedData)

            series.isDrawDataPoints = true
            series.dataPointsRadius = 10f
            series.color = R.color.purple_200

            lineGraphView.animate()
            lineGraphView.viewport.isScrollable = true
            lineGraphView.viewport.isScalable = true
            lineGraphView.viewport.setScalableY(false)
            lineGraphView.viewport.setScrollableY(false)

            lineGraphView.viewport.setMinX(minAndMaxX.first)
            lineGraphView.viewport.setMaxX(minAndMaxX.second)
            lineGraphView.viewport.setMinY(minAndMaxY.first)
            lineGraphView.viewport.setMaxY(minAndMaxY.second)

            lineGraphView.addSeries(series)
        }
    }

    private fun getSeriesFromString(str: String): LineGraphSeries<DataPoint> {
        val pointsStrArray = str.trimEnd('\n').split("\n").toMutableList().also { it.removeAt(0) }
        var pointsList = mutableListOf<DataPoint>()
        var minX: Double = pointsStrArray[0].split("\t\t\t")[0].toDouble()
        var maxX: Double = pointsStrArray[pointsStrArray.size - 1].split("\t\t\t")[0].toDouble()
        var minY: Double = pointsStrArray[0].split("\t\t\t")[1].toDouble()
        var maxY: Double = minY

        for (i in pointsStrArray.indices) {
            val x = pointsStrArray[i].split("\t\t\t")[0].toDouble()
            val y = pointsStrArray[i].split("\t\t\t")[1].toDouble()
            if (i == 0) {
                minX = x
            } else if (i == pointsStrArray.size - 1) {
                maxX = x
            }
            if (y <= minY) {
                minY = y
            } else {
                maxY = y
            }
            pointsList.add(DataPoint(x, y))
        }
        minAndMaxX = Pair(minX, maxX)
        minAndMaxY = Pair(minY, maxY)

        return LineGraphSeries(pointsList.toTypedArray())
    }
}