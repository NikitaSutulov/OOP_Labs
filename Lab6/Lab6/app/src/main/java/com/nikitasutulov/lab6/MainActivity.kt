package com.nikitasutulov.lab6

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var nPointEditText: EditText
    lateinit var xMinEditText: EditText
    lateinit var xMaxEditText: EditText
    lateinit var yMinEditText: EditText
    lateinit var yMaxEditText: EditText
    lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nPointEditText = findViewById(R.id.edit_text_nPoint)
        xMinEditText = findViewById(R.id.edit_text_xMin)
        xMaxEditText = findViewById(R.id.edit_text_xMax)
        yMinEditText = findViewById(R.id.edit_text_yMin)
        yMaxEditText = findViewById(R.id.edit_text_yMax)
        submitButton = findViewById(R.id.submit_button)

        submitButton.setOnClickListener {
            val obj2Intent: Intent? = packageManager.getLaunchIntentForPackage("com.nikitasutulov.object2")
            obj2Intent!!.addFlags(FLAG_ACTIVITY_SINGLE_TOP)
            obj2Intent.putExtra("nPoint", nPointEditText.text.toString().toInt())
            obj2Intent.putExtra("xMin", xMinEditText.text.toString().toInt())
            obj2Intent.putExtra("xMax", xMaxEditText.text.toString().toInt())
            obj2Intent.putExtra("yMin", yMinEditText.text.toString().toInt())
            obj2Intent.putExtra("yMax", yMaxEditText.text.toString().toInt())
            startActivity(obj2Intent)
        }

    }
}