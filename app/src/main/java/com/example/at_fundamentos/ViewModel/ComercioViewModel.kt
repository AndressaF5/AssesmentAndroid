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

    var produtosMercado = mutableListOf(
        Mercado("Arroz", "13.00"),
        Mercado("Feijão", "4.99"),
        Mercado("Açúcar", "2.50"),
        Mercado("Sal", "1.99"),
        Mercado("Café", "8.99")
    )

    var produtosFarmacia = mutableListOf(
        Farmacia("Dorflex", "5.50"),
        Farmacia("Amoxilina", "10.00"),
        Farmacia("Diazepam", "7.95"),
        Farmacia("Miconazol", "20.30"),
        Farmacia("Paracetamol", "3.45")
    )

    var produtosSacolao = mutableListOf(
        Sacolao("Banana", "3.15 kg"),
        Sacolao("Manga", "4.99 kg"),
        Sacolao("Melancia", "2.75 kg"),
        Sacolao("Maça", "3.55 kg"),
        Sacolao("Goiaba", "2.00 kg")
    )

    var todosOsProdutos = MutableLiveData<MutableList<Estabelecimento>>().apply {
        value = mutableListOf()
    }
}