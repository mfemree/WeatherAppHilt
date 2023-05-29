package com.betulnecanli.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.betulnecanli.weatherapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint                                            // bizim fragment'lerimizin hepsi main activitynin icinde calisan viewlar old. ve hilt'i kullandikalri icin
                                                              // bu activitymizin de hilt'i kullanmasi/injecte etmesi gerekiyor
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}