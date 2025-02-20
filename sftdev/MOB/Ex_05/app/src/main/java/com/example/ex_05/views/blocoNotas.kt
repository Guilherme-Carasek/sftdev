package com.example.ex_05.views

import android.content.Context
import android.content.Intent
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

        val setNotas = sharedPreferences.getStringSet("notes", emptySet())?.toMutableList() ?: mutableListOf()

        listaNotas.addAll(setNotas)

        binding.listNotes.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNotas)

        binding.saveNoteButton.setOnClickListener{
            val newNote:String = binding.editNotes.text.toString()

            setNotas.add(newNote)
            val editor = sharedPreferences.edit()
            editor.putStringSet("notes", setNotas.toSet())
            editor.apply()

            binding.editNotes.text.clear()

            listaNotas.clear()
            listaNotas.addAll(setNotas)
            binding.listNotes.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNotas)

        }

        binding.listNotes.setOnItemClickListener{ parent, view, position, id ->
            setNotas.remove(listaNotas.get(position))
            val editor = sharedPreferences.edit()
            editor.putStringSet("notes", setNotas.toSet())
            editor.apply()

            listaNotas.clear()
            listaNotas.addAll(setNotas)
            binding.listNotes.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNotas)
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