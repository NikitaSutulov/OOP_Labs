package com.nikitasutulov.lab4

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
        supportActionBar?.title = "Lab 4"
        mainCanvas = MainCanvas(this)
        mainCanvas.setShapeEditorCurrentShape(LineShape(mainCanvas.paint))
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
        when (item.itemId) {
            R.id.ellipseButton, R.id.ellipseOption -> {
                currentSelectedOption = mainMenu.findItem(R.id.ellipseButton)
                mainCanvas.setShapeEditorCurrentShape(EllipseShape(mainCanvas.paint))
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.ellipse)
                supportActionBar?.subtitle = "Еліпс"
            }
            R.id.lineButton, R.id.lineOption -> {
                currentSelectedOption = mainMenu.findItem(R.id.lineButton)
                mainCanvas.setShapeEditorCurrentShape(LineShape(mainCanvas.paint))
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.line)
                supportActionBar?.subtitle = "Лінія"
            }
            R.id.pointButton, R.id.pointOption -> {
                currentSelectedOption = mainMenu.findItem(R.id.pointButton)
                mainCanvas.setShapeEditorCurrentShape(PointShape(mainCanvas.paint))
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.point)
                supportActionBar?.subtitle = "Точка"
            }
            R.id.rectButton, R.id.rectOption -> {
                currentSelectedOption = mainMenu.findItem(R.id.rectButton)
                mainCanvas.setShapeEditorCurrentShape(RectShape(mainCanvas.paint))
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.rectangle)
                supportActionBar?.subtitle = "Прямокутник"
            }
            R.id.lineWithCirclesButton, R.id.lineWithCirclesOption -> {
                currentSelectedOption = mainMenu.findItem(R.id.lineWithCirclesButton)
                mainCanvas.setShapeEditorCurrentShape(LineWithCirclesShape(mainCanvas.paint))
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.linewithcircles)
                supportActionBar?.subtitle = "Лінія з кружечками"
            }
            R.id.cubeButton, R.id.cubeOption -> {
                currentSelectedOption = mainMenu.findItem(R.id.cubeButton)
                mainCanvas.setShapeEditorCurrentShape(CubeShape(mainCanvas.paint))
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.cube)
                supportActionBar?.subtitle = "Каркас куба"
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
            R.id.lineWithCirclesButton -> {
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.linewithcircles_inactive)
            }
            R.id.cubeButton -> {
                currentSelectedOption.icon = ContextCompat.getDrawable(this, R.drawable.cube_inactive)
            }
        }
    }
}