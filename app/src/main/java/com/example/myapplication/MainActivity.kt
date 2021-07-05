package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "start of onCreate function")

        val name: String = "Ivan"
        val surname: String = "Ivanov"
        var age: Int = 37
        var height: Double = 172.2

        val summary: String = "name: $name surname: $surname age: $age height: $height"

        val outputProgram: TextView = findViewById(R.id.output)
        outputProgram.text = summary

        Log.d(TAG, "end of onCreate function")

    }
}