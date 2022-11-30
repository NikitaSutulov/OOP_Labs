package com.nikitasutulov.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {
    private lateinit var mainCanvas: MainCanvas
    private lateinit var currentCheckedOption: MenuItem
    private lateinit var mainMenu: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainCanvas = MainCanvas(this)
        mainCanvas.setCurrentShapeEditor(MainCanvas.Options.LINE)
        setContentView(mainCanvas)
        showSystemUI()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val mainMenuInflater: MenuInflater = menuInflater
        mainMenuInflater.inflate(R.menu.main_menu, menu)
        mainMenu = menu!!
        currentCheckedOption = mainMenu.findItem(R.id.lineOption)
        currentCheckedOption.isChecked = true
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.ellipseOption -> {
                mainCanvas.setCurrentShapeEditor(MainCanvas.Options.ELLIPSE)
            }
            R.id.lineOption -> {
                mainCanvas.setCurrentShapeEditor(MainCanvas.Options.LINE)
            }
            R.id.pointOption -> {
                mainCanvas.setCurrentShapeEditor(MainCanvas.Options.POINT)
            }
            R.id.rectOption -> {
                mainCanvas.setCurrentShapeEditor(MainCanvas.Options.RECT)
            }
        }
        currentCheckedOption.isChecked = false
        currentCheckedOption = item
        currentCheckedOption.isChecked = true

        return super.onOptionsItemSelected(item)
    }

    private fun showSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(window, mainCanvas).show(WindowInsetsCompat.Type.systemBars())
    }
}