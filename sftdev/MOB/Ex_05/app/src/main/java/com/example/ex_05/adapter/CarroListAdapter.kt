package com.example.ex_05.adapter;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ex_05.R
import com.example.ex_05.model.Carro

class CarroListAdapter(val listaDeCarros: ArrayList<Carro>): RecyclerView.Adapter<CarroListAdapter.CarroViewHolder>() {

    class CarroViewHolder (ItemView :View) : RecyclerView.ViewHolder(ItemView){
        val textView = itemView.findViewById<TextView>(R.id.text_Modelo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_carro_list, parent, false)

        return CarroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaDeCarros.size
    }

    override fun onBindViewHolder(holder: CarroViewHolder, position: Int) {
        val carro = listaDeCarros[position]

        holder.textView.setText(carro.modelo)
    }


}
