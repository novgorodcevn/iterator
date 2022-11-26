package com.example.chethik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.Contacts.SettingsColumns.KEY
import android.provider.Settings.Global.putString
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var buttonIncrease: Button
    private lateinit var textView: TextView
    private lateinit var buttonClear: Button
    private lateinit var buttonDecrease: Button
    private  var value = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonIncrease = findViewById(R.id.button_increase)
        textView = findViewById(R.id.counter)
        buttonClear = findViewById(R.id.button_clear)
        buttonDecrease = findViewById(R.id.button_decrease)

        buttonIncrease.setOnClickListener{
            value++
            if (value > 10) value = 10
            textView.text = value.toString()
        }
        buttonDecrease.setOnClickListener {
             value--
             if (value < 0) value = 0
            textView.text = value.toString()
         }

        buttonClear.setOnClickListener {
            value = 0
            textView.text = value.toString()
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("KEY" , value)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        value = savedInstanceState.getInt("KEY" , 0 )
        textView.setText("" + value)
    }

    private companion object {
        const val KEY = "KEY"
    }
}