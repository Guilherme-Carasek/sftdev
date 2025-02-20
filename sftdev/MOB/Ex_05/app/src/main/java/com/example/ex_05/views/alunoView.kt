package com.example.ex_05.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ex_05.databinding.ActivityAlunoViewBinding

class alunoView : AppCompatActivity() {
    private val binding by lazy {
        ActivityAlunoViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = intent

        val nome = intent.extras?.getString("nome")
        val morada = intent.extras?.getString("morada")
        val email = intent.extras?.getString("email")

        binding.alunoNomeView.text = nome
        binding.alunoMoradaView.text = morada
        binding.alunoEmailView.text = email


        binding.voltarButton.setOnClickListener{
            startActivity(Intent(this, LoginOkActivity::class.java))
        }

        binding.filmeButton.setOnClickListener{
            startActivity(Intent(this, Filme_favorito::class.java))
        }
    }
}