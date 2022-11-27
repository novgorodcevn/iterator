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
    private lateinit var textField: TextView
    private lateinit var buttonClear: Button
    private lateinit var buttonDecrease: Button
    private var counterValue = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonIncrease = findViewById(R.id.button_increase)
        textField = findViewById(R.id.counter)
        buttonClear = findViewById(R.id.button_clear)
        buttonDecrease = findViewById(R.id.button_decrease)

        buttonIncrease.setOnClickListener {
            counterValue++ ; if (counterValue > 10) counterValue = 10
            textField.text = counterValue.toString()
        }
        buttonDecrease.setOnClickListener {
            counterValue-- ; if (counterValue < 0) counterValue = 0
            textField.text = counterValue.toString()
        }
        buttonClear.setOnClickListener {
            counterValue = 0
            textField.text = counterValue.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val userValue = counterValue
        outState.putInt("KEY", counterValue)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val userInt = savedInstanceState.getInt("KEY", 0)
        counterValue = userInt
        textField.text = counterValue.toString()
    }

    private companion object {
        const val COUNTER_VALUE_KEY = "KEY"
    }
}