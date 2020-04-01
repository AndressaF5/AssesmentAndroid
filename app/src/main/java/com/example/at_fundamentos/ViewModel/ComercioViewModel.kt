package com.example.at_fundamentos.ViewModel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.at_fundamentos.Model.Estabelecimento
import com.example.at_fundamentos.Model.Farmacia
import com.example.at_fundamentos.Model.Mercado
import com.example.at_fundamentos.Model.Sacolao

class ComercioViewModel : ViewModel() {

    var produtosMercado: MutableList<Mercado> = mutableListOf()

    var produtosFarmacia: MutableList<Farmacia> = mutableListOf()

    var produtosSacolao: MutableList<Sacolao> = mutableListOf()

    var todosOsProdutos = MutableLiveData<MutableList<Estabelecimento>>().apply {
        value = mutableListOf<Estabelecimento>()
    }
}