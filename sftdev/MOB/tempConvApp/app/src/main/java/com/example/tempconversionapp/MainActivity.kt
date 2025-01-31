package com.example.tempconversionapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tempconversionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonConvertTemp.setOnClickListener{
            val tempCelsius: Double = binding.editTempInput.text.toString().toDouble()
            val tempFarenheit: Double = (tempCelsius * 1.8) +32
            binding.textResultado.text = "$tempFarenheit ºF"
        }
    }
}