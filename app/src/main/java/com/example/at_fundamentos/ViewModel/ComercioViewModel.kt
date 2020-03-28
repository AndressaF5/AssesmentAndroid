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

    var produtosMercado = MutableLiveData<MutableList<Mercado>>().apply {
        value = mutableListOf()
    }
    var produtosFarmacia = MutableLiveData<MutableList<Farmacia>>().apply {
        value = mutableListOf()
    }
    var produtosSacolao = MutableLiveData<MutableList<Sacolao>>().apply {
        value = mutableListOf()
    }

    var todosOsProdutos = MutableLiveData<MutableList<Estabelecimento>>().apply{
        value = mutableListOf()
    }

    // fazer lista de com todos os estabelecimentos e chamar em cada fragment do estabelecimento

    //fun observar(){
    //    comercioViewModel.produtosAlgumaCoisa.observe(context, Observer{
    //        Toast....
    //    })
    //}
}