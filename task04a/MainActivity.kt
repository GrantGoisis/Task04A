package com.example.task04a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)


                // New ViewOne object
                val myMainView = ViewOne(this)

                // setContentView(R.layout.activity_main)
                setContentView(myMainView)
        }
}
