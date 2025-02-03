package com.example.ex_05

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ex_05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonEntrar.setOnClickListener {
            var name: String = binding.editName.text.toString()
            var password: String = binding.editPassword.text.toString()
            if (name.equals("user") && password.equals("pass")){
                startActivity(Intent(this, LoginOkActivity::class.java))
            }
            else {
                startActivity(Intent( this, LoginErradoActivity::class.java ))
            }
        }
    }
}