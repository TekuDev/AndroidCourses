package com.dev.teku.colormyviews

import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setListeners() {

        val clickableViews: List<View> = listOf(box_one_text, box_two_text, box_three_text,
            box_four_text, box_five_text, constraint_layout, red_button, yellow_button,
            green_button)

        for (item in clickableViews) {

            item.setOnClickListener { makeColored(it) }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun makeColored(view: View) = when(view.id) {

        // Boxes using Color class colors for background
        R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
        R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

        // Boxes using Android color resources for background
        R.id.box_three_text -> view.setBackgroundColor(
            resources.getColor(android.R.color.holo_green_light, null))
        R.id.box_four_text -> view.setBackgroundColor(
            resources.getColor(android.R.color.holo_green_dark, null))
        R.id.box_five_text -> view.setBackgroundColor(
            resources.getColor(android.R.color.holo_green_light, null))

        // Boxes using custom colors for background
        R.id.red_button -> box_three_text.setBackgroundColor(
            resources.getColor(R.color.my_red, null))
        R.id.yellow_button -> box_four_text.setBackgroundColor(
            resources.getColor(R.color.my_yellow, null))
        R.id.green_button -> box_five_text.setBackgroundColor(
            resources.getColor(R.color.my_green, null))

        else -> view.setBackgroundColor(Color.LTGRAY)
    }
}
