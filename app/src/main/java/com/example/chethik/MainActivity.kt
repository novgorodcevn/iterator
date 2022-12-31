package com.example.chethik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.Contacts.SettingsColumns.KEY
import android.provider.Settings.Global.putString
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: TestViewModel

    private lateinit var buttonIncrease: Button
    private lateinit var numberTv: TextView
    private lateinit var buttonClear: Button
    private lateinit var buttonDecrease: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)



        buttonIncrease = findViewById(R.id.button_increase)
        numberTv = findViewById(R.id.counter_tv)
        buttonClear = findViewById(R.id.button_clear)
        buttonDecrease = findViewById(R.id.button_decrease)
        numberTv.text = viewModel.counterValue.toString()


        buttonIncrease.setOnClickListener {
            viewModel.updateCount()
            numberTv.text = viewModel.counterValue.toString()


        }
        buttonDecrease.setOnClickListener {
            viewModel.decreaseCount()
            numberTv.text = viewModel.counterValue.toString()
        }
        buttonClear.setOnClickListener {
            viewModel.counterValue = 0
            numberTv.text = viewModel.counterValue.toString()
        }
    }

}