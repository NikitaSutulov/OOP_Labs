package com.nikitasutulov.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {
    private lateinit var mainCanvas: MainCanvas
    private lateinit var currentSelectedOption: MenuItem
    private lateinit var mainMenu: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Lab 3"
        mainCanvas = MainCanvas(this)
        mainCanvas.setCurrentShapeEditor(MainCanvas.Options.LINE)
        setContentView(mainCanvas)
        showSystemUI()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val mainMenuInflater: MenuInflater = menuInflater
        mainMenuInflater.inflate(R.menu.main_menu, menu)
        mainMenu = menu!!
        currentSelectedOption = mainMenu.findItem(R.id.lineButton)
        currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.line)
        supportActionBar?.subtitle = "Лінія"
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setIconInactive(currentSelectedOption)
        currentSelectedOption = when(item.itemId) {
            R.id.ellipseOption, R.id.ellipseButton -> mainMenu.findItem(R.id.ellipseButton)
            R.id.lineOption, R.id.lineButton -> mainMenu.findItem(R.id.lineButton)
            R.id.pointOption, R.id.pointButton -> mainMenu.findItem(R.id.pointButton)
            else -> mainMenu.findItem(R.id.rectButton)
        }
        when (item.itemId) {
            R.id.ellipseButton, R.id.ellipseOption -> {
                mainCanvas.setCurrentShapeEditor(MainCanvas.Options.ELLIPSE)
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.ellipse)
                supportActionBar?.subtitle = "Еліпс"
            }
            R.id.lineButton, R.id.lineOption -> {
                mainCanvas.setCurrentShapeEditor(MainCanvas.Options.LINE)
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.line)
                supportActionBar?.subtitle = "Лінія"
            }
            R.id.pointButton, R.id.pointOption -> {
                mainCanvas.setCurrentShapeEditor(MainCanvas.Options.POINT)
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.point)
                supportActionBar?.subtitle = "Точка"
            }
            R.id.rectButton, R.id.rectOption -> {
                mainCanvas.setCurrentShapeEditor(MainCanvas.Options.RECT)
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.rectangle)
                supportActionBar?.subtitle = "Прямокутник"
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(window, mainCanvas).show(WindowInsetsCompat.Type.systemBars())
    }

    private fun setIconInactive(item: MenuItem) {
        when(item.itemId) {
            R.id.ellipseButton -> {
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.ellipse_inactive)
            }
            R.id.lineButton -> {
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.line_inactive)
            }
            R.id.pointButton -> {
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.point_inactive)
            }
            R.id.rectButton -> {
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.rectangle_inactive)
            }
        }
    }
}