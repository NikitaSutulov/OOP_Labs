package com.nikitasutulov.lab1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class Work2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work2)

        val seekBar: SeekBar = findViewById(R.id.seek_bar)
        val seekBarValue: TextView = findViewById(R.id.seek_bar_value)
        val yesButton: Button = findViewById(R.id.work2_yes_button)
        val cancelButton: Button = findViewById(R.id.work2_cancel_button)

        var curValue = seekBar.progress

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                seekBarValue.text = p1.toString()
                curValue = seekBar.progress
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        yesButton.setOnClickListener {
            val mainActivityIntent: Intent = intent
            mainActivityIntent.putExtra("result", curValue.toString())
            setResult(Activity.RESULT_OK, mainActivityIntent)
            finish()
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }
}