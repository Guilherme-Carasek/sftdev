package com.example.ex_04

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import com.example.ex_04.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy {
       ActivityMain2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.buttonEntrar.setOnClickListener{
            var name: String = binding.editName.text.toString()
            var password: String = binding.editPassword.text.toString()
            var toast: Toast
            if (name.equals("user") && password.equals("pass")){
                toast = makeText(this, "Login válido", Toast.LENGTH_SHORT)
            }
            else {
                toast = makeText(this, "Login inválido", Toast.LENGTH_SHORT)
            }
            toast.show()

            binding.editName.text.clear()
            binding.editPassword.text.clear()
        }
    }
}