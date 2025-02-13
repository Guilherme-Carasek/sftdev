package com.example.ex_05

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.ex_05.databinding.ActivityBlocoNotasBinding


class blocoNotas : AppCompatActivity() {
    private val binding by lazy {
        ActivityBlocoNotasBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val listaNotas = ArrayList<String>()

        val sharedPreferences = this.getSharedPreferences("notes", Context.MODE_PRIVATE)



        binding.listNotes.adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, listaNotas)

        binding.saveNoteButton.setOnClickListener{
            val newNote:String = binding.editNotes.text.toString()
            listaNotas.add(newNote)

            // val gson = Gson()


            val editor:SharedPreferences.Editor = sharedPreferences.edit()


        }

    }

    override fun onStart() {
        super.onStart()

        binding.menuButton.setOnClickListener{
            startActivity(Intent(this, Menu::class.java))
        }


    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}