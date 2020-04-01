package com.example.at_fundamentos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.at_fundamentos.Adapter.FarmaciaAdapter
import com.example.at_fundamentos.Adapter.MercadoAdapter
import com.example.at_fundamentos.Adapter.SacolaoAdapter
import com.example.at_fundamentos.Model.Farmacia
import com.example.at_fundamentos.Model.Mercado
import com.example.at_fundamentos.Model.Sacolao

import com.example.at_fundamentos.R
import com.example.at_fundamentos.ViewModel.ComercioViewModel
import kotlinx.android.synthetic.main.fragment_adicionar_produto.*
import kotlinx.android.synthetic.main.fragment_farmacia.*
import kotlinx.android.synthetic.main.fragment_mercado.*
import kotlinx.android.synthetic.main.fragment_sacolao.*

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
            notifyRecycleMercado(comercioViewModel!!.produtosMercado, txtNomeProduto, txtPrecoProduto)

        }else if (tipo == "Farmacia" || tipo == "farmacia"){
            notifyRecycleFarmacia(comercioViewModel!!.produtosFarmacia, txtNomeProduto, txtPrecoProduto)

        }else{
            notifyRecycleSacolao(comercioViewModel!!.produtosSacolao, txtNomeProduto, txtPrecoProduto)
        }
    }

    private fun mostrarToast() {

        Toast.makeText(
            activity?.baseContext,
            "Produto cadastrado com sucesso!",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun notifyRecycleMercado(comprasMercado: MutableList<Mercado>, txtNomeProduto: String, txtPrecoProduto: String){

        var mercadoAdapter = MercadoAdapter(comprasMercado)

        rcyVwMercado.adapter = mercadoAdapter
        rcyVwMercado.layoutManager = LinearLayoutManager(context)

        comprasMercado.add(Mercado(txtNomeProduto, txtPrecoProduto))
        mercadoAdapter.notifyItemInserted(comprasMercado.lastIndex)
        mostrarToast()
    }

    private fun notifyRecycleFarmacia(comprasFarmacia: MutableList<Farmacia>, txtNomeProduto: String, txtPrecoProduto: String){

        var farmaciaAdapter = FarmaciaAdapter(comprasFarmacia)

        rcyVwFarmacia.adapter = farmaciaAdapter
        rcyVwFarmacia.layoutManager = LinearLayoutManager(context)

        comprasFarmacia.add(Farmacia(txtNomeProduto, txtPrecoProduto))
        farmaciaAdapter.notifyItemInserted(comprasFarmacia.lastIndex)
        mostrarToast()
    }

    private fun notifyRecycleSacolao(comprasSacolao: MutableList<Sacolao>, txtNomeProduto: String, txtPrecoProduto: String){

        var sacolaoAdapter = SacolaoAdapter(comprasSacolao)

        rcyVwSacolao.adapter = sacolaoAdapter
        rcyVwSacolao.layoutManager = LinearLayoutManager(context)

        comprasSacolao.add(Sacolao(txtNomeProduto, txtPrecoProduto))
        sacolaoAdapter.notifyItemInserted(comprasSacolao.lastIndex)
        mostrarToast()
    }
}
