package com.example.tdmobile.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.tdmobile.R
import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        main_button.setOnClickListener{

            mainViewModel.onClickedIncrement("")
        }

        mainViewModel.counter.observe(this, Observer {

                value -> main_text.text = value.toString()

        })
    }
}