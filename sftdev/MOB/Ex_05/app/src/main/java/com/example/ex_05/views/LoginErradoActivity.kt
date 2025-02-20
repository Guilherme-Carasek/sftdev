package com.example.ex_05.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ex_05.databinding.ActivityLoginErradoBinding

class LoginErradoActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginErradoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.buttonHome.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}