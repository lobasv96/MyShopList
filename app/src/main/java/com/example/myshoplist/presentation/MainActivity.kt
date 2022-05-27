package com.example.myshoplist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myshoplist.R

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = androidx.lifecycle.ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.shopList.observe(this) {
            Log.d("TestActivity", it.toString())
        }
    }
}