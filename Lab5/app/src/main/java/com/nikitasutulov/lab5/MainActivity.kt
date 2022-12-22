package com.nikitasutulov.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    private lateinit var mainCanvas: MainCanvas
    private lateinit var currentSelectedOption: MenuItem
    private lateinit var mainMenu: Menu
    private lateinit var frameLayout: FrameLayout
    private lateinit var tableFragment: TableFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Lab 5"
        setContentView(R.layout.activity_main)
        mainCanvas = findViewById(R.id.mainCanvas)
        mainCanvas.setShapeEditorCurrentShape(LineShape(mainCanvas.paint))

        frameLayout = findViewById(R.id.tableContainer)

        tableFragment = TableFragment()
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.tableContainer, tableFragment)
        ft.commit()
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
        if (item.itemId != R.id.toggleTableButton && item.itemId != R.id.toggleTableOption)
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
            R.id.toggleTableButton, R.id.toggleTableOption -> {
                if (frameLayout.visibility == View.GONE) {
                    frameLayout.visibility = View.VISIBLE
                } else {
                    frameLayout.visibility = View.GONE
                }
            }
        }
        return super.onOptionsItemSelected(item)
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