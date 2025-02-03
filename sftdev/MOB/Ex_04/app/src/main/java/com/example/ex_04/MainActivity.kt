package com.example.ex_04

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import com.example.ex_04.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.buttonDolar.setOnClickListener {
            val valorEur: Double = binding.editEuros.text.toString().toDouble()
            val convRate: Double = 1.03
            var valorDol = (valorEur*convRate * 100).roundToInt().toDouble()/100
            val toast = makeText(this,"O valor em dólares é: \n $valorDol\$", Toast.LENGTH_LONG)
            toast.show()
        }

        binding.buttonReal.setOnClickListener {
            val valorEur: Double = binding.editEuros.text.toString().toDouble()
            val convRate: Double = 6.01
            var valorReal = (valorEur*convRate * 100).roundToInt().toDouble()/100
            val toast = makeText(this,"O valor em reais é: \n R\$ $valorReal", Toast.LENGTH_LONG)
            toast.show()
        }

        binding.buttonCup.setOnClickListener {
            val valorEur: Double = binding.editEuros.text.toString().toDouble()
            val convRate: Double = 24.90
            var valorCup = (valorEur*convRate * 100).roundToInt().toDouble()/100
            val toast = makeText(this,"O valor em CUP é: \n $valorCup\$", Toast.LENGTH_LONG)
            toast.show()
        }

        binding.buttonGoActivityTwo.setOnClickListener(){
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}