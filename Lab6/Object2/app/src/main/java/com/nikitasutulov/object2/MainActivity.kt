package com.nikitasutulov.object2

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generatePoints()
        val obj3Intent: Intent? = packageManager.getLaunchIntentForPackage("com.nikitasutulov.object3")
        obj3Intent!!.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(obj3Intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        generatePoints()
        val obj3Intent: Intent? = packageManager.getLaunchIntentForPackage("com.nikitasutulov.object3")
        obj3Intent!!.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(obj3Intent)
    }

    private fun generatePoints() {
        val nPoint = intent.extras!!.getInt("nPoint")
        val xMin = intent.extras!!.getInt("xMin")
        val xMax = intent.extras!!.getInt("xMax")
        val yMin = intent.extras!!.getInt("yMin")
        val yMax = intent.extras!!.getInt("yMax")
        val textView: TextView = findViewById(R.id.textView)

        val points = mutableListOf<Pair<Int, Int>>()
        for (i in 1..nPoint) {
            val randX = Random.nextInt(xMin, xMax)
            val randY = Random.nextInt(yMin, yMax)
            points.add(Pair(randX, randY))
        }

        points.sortBy { point -> point.first }

        var string = "X\t\t\tY\n"

        for (i in points.indices) {
            string += points[i].first.toString() + "\t\t\t" + points[i].second.toString() + "\n"
        }
        textView.text = string.trim('\n')

        val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("coords", textView.text)
        clipboard.setPrimaryClip(clip)

    }
}