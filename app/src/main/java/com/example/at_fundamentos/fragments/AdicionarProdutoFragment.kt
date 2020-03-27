package com.example.at_fundamentos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.at_fundamentos.Model.Farmacia
import com.example.at_fundamentos.Model.Mercado
import com.example.at_fundamentos.Model.Sacolao

import com.example.at_fundamentos.R
import com.example.at_fundamentos.ViewModel.ComercioViewModel
import kotlinx.android.synthetic.main.fragment_adicionar_produto.*

class AdicionarProdutoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adicionar_produto, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var comercioViewModel: ComercioViewModel? = null
        activity?.let{
            comercioViewModel = ViewModelProviders.of(it).get(ComercioViewModel::class.java)
        }

        btnCadastrar.setOnClickListener{
            verificarComercio(editTextTipoComercio.text.toString())
        }
    }

    fun verificarComercio(tipo: String) {

        var txtNomeProduto = editTextNomeProduto.text.toString()
        var txtPrecoProduto = editTextPrecoProduto.text.toString()

        var comercioViewModel: ComercioViewModel? = null
        activity?.let{
            comercioViewModel = ViewModelProviders.of(it).get(ComercioViewModel::class.java)
        }

        if (tipo == "Mercado" || tipo == "mercado"){
            comercioViewModel!!.produtosMercado.value!!.add(Mercado(txtNomeProduto, txtPrecoProduto))

        }else if (tipo == "Farmacia" || tipo == "farmacia"){
            comercioViewModel!!.produtosFarmacia.value!!.add(Farmacia(txtNomeProduto, txtPrecoProduto))

        }else{
            comercioViewModel!!.produtosSacolao.value!!.add(Sacolao(txtNomeProduto, txtPrecoProduto))
        }
    }
}
