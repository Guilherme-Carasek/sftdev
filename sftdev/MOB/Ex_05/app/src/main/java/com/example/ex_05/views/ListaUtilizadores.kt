package com.example.ex_05.views

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.ex_05.data.DBHelper
import com.example.ex_05.databinding.ActivityListaUtilizadoresBinding

class ListaUtilizadores : AppCompatActivity() {

    private val binding by lazy{
        ActivityListaUtilizadoresBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val db = DBHelper(this)

        db.utilizadorInsert("abc", "1234")
        db.utilizadorInsert("abcd", "12345")
        db.utilizadorInsert("abce", "12346")
        db.utilizadorInsert("123", "abc")
        db.utilizadorInsert("jac", "jac1")
        db.utilizadorInsert("sap", "sa")





        val listaUtilizadores = db.utilizadorListSelectAll()

        binding.listaTodosUtilizadores.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaUtilizadores)
    }
}