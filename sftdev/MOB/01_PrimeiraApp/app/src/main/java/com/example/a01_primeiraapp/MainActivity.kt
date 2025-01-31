package com.example.a01_primeiraapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a01_primeiraapp.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonConverterDol.setOnClickListener {
            val valorEur: Double = binding.editValorEur.text.toString().toDouble()
            val convRate: Double = 0.86
            var valorDol = (valorEur*convRate * 100).roundToInt().toDouble()/100
            binding.textResultado.text = "O valor em dólares é: \n $valorDol\$"
        }
    }
}