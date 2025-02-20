package com.example.ex_05.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ex_05.adapter.CarroListAdapter
import com.example.ex_05.data.CarroMock
import com.example.ex_05.databinding.ActivityRecyclerViewBinding



class RecyclerView : AppCompatActivity() {
    private val binding by lazy{
        ActivityRecyclerViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CarroListAdapter(CarroMock().listaDeCarros)

    }
}