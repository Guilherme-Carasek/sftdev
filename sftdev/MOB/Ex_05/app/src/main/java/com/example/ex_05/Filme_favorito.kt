package com.example.ex_05

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ex_05.databinding.ActivityFilmeFavoritoBinding


class Filme_favorito : AppCompatActivity() {
    private val binding by lazy {
        ActivityFilmeFavoritoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonVoltar.setOnClickListener{
            startActivity(Intent(this, LoginOkActivity::class.java))
        }
    }
}