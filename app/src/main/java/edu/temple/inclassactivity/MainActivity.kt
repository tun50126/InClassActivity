package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.SpinnerAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind views
        val spinner = findViewById<Spinner>(R.id.spinner)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Fetch images into Array<Int> called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = Array(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        // Display images specified in imageArray in Spinner and RecyclerView
        if(spinner != null) {
            spinner.adapter = CustomSpinnerAdapter(this, imageArray)

        }
        else {
            recyclerView.adapter = CustomRecyclerAdapter(imageArray)
            val layoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = layoutManager
        }
    }
}