package com.example.at_fundamentos.ViewModel

import androidx.lifecycle.ViewModel
import com.example.at_fundamentos.Model.Farmacia
import com.example.at_fundamentos.Model.Mercado
import com.example.at_fundamentos.Model.Sacolao

class ComercioViewModel : ViewModel() {

    var produtosMercado: MutableList<Mercado> = mutableListOf()
    var produtosFarmacia: MutableList<Farmacia> = mutableListOf()
    var produtosSacolao: MutableList<Sacolao> = mutableListOf()
}