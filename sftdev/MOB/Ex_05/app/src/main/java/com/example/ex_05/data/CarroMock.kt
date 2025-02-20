package com.example.ex_05.data

import com.example.ex_05.model.Carro

class CarroMock {

    var listaDeCarros = ArrayList<Carro>()

    init {
        for (i in 1..100) {
            listaDeCarros.add(Carro(i, "Modelo $i"))
        }
    }
}