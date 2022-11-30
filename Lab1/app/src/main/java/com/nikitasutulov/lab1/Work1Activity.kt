package com.nikitasutulov.lab1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Work1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work1)

        val yesButton: Button = findViewById(R.id.work1_yes_button)
        val cancelButton: Button = findViewById(R.id.work1_cancel_button)

        yesButton.setOnClickListener {
            val editText: EditText = findViewById(R.id.edit_text)
            val mainActivityIntent: Intent = intent
            mainActivityIntent.putExtra("result", editText.text.toString())
            setResult(Activity.RESULT_OK, mainActivityIntent)
            finish()
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }
}