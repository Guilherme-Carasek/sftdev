package com.example.ex_05

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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


        val sharedPreferencesNome = this.getSharedPreferences("nome", Context.MODE_PRIVATE)
        val storedName = sharedPreferencesNome.getString("nome", "").toString()

        val sharedPreferencesPass = this.getSharedPreferences("password", Context.MODE_PRIVATE)
        val storedPass = sharedPreferencesPass.getString("password", "").toString()

        binding.editName.setText(storedName)
        binding.editPassword.setText(storedPass)

        binding.buttonEntrar.setOnClickListener {
            var name: String = binding.editName.text.toString()
            var password: String = binding.editPassword.text.toString()
            if (name.equals("user") && password.equals("pass")){

                val editorNome:SharedPreferences.Editor = sharedPreferencesNome.edit()
                editorNome.putString("nome", name)
                editorNome.apply()

                val editorPass:SharedPreferences.Editor = sharedPreferencesPass.edit()
                editorPass.putString("password", password)
                editorPass.apply()

                startActivity(Intent(this, LoginOkActivity::class.java))
            }
            else {
                startActivity(Intent( this, LoginErradoActivity::class.java ))
            }
        }
    }
}