package com.example.ex_05

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ex_05.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {
    private val binding by lazy {
        ActivityMenuBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.blocoNotasButton.setOnClickListener {
            startActivity(Intent(this, blocoNotas::class.java))
        }

        binding.relogioButton.setOnClickListener{
            startActivity(Intent(this, App_Relogio::class.java))
        }

    }
}