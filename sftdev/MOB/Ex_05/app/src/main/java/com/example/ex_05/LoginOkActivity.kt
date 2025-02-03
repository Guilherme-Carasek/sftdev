package com.example.ex_05

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ex_05.databinding.ActivityLoginOkBinding

class LoginOkActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginOkBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}