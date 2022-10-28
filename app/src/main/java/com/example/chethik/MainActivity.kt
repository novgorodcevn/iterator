package com.example.chethik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var value = 0

        addCounterBTN.setOnClickListener{
            value++
            if (value > 10) value = 10
            counterTV.text = value.toString()

        }
         addCounterBBB.setOnClickListener {
             value--
             if (value< 0) value = 0
             counterTV.text = value.toString()
         }

        addCounterCCC.setOnClickListener {
            value = 0

            counterTV.text = value.toString()
        }
    }
}