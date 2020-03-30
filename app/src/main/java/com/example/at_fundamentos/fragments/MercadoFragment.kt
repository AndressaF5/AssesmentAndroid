package com.example.at_fundamentos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.at_fundamentos.Adapter.ListaComprasAdapter
import com.example.at_fundamentos.Adapter.MercadoAdapter
import com.example.at_fundamentos.Model.Estabelecimento
import com.example.at_fundamentos.Model.Mercado

import com.example.at_fundamentos.R
import com.example.at_fundamentos.ViewModel.ComercioViewModel
import kotlinx.android.synthetic.main.fragment_adicionar_produto.*
import kotlinx.android.synthetic.main.fragment_lista_compras.*
import kotlinx.android.synthetic.main.fragment_mercado.*
import kotlinx.android.synthetic.main.mercado_recycle.*

class MercadoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mercado, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var comprasMercado = mutableListOf(
            Mercado("Arroz", "13.00"),
            Mercado("Feijão", "4.99"),
            Mercado("Açúcar", "2.50"),
            Mercado("Sal", "1.99"),
            Mercado("Café", "8.99")
        )

        var mercadoAdapter = MercadoAdapter(comprasMercado)

        rcyVwMercado.adapter = mercadoAdapter
        rcyVwMercado.layoutManager = LinearLayoutManager(context)

        val itemTouchHelper = ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(
            0, ItemTouchHelper.RIGHT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                var comercioViewModel: ComercioViewModel? = null
                activity?.let {
                    comercioViewModel = ViewModelProviders.of(it).get(ComercioViewModel::class.java)
                }

                val position = viewHolder.adapterPosition
                var todosOsProdutos = comercioViewModel!!.todosOsProdutos

                todosOsProdutos.add(position, Estabelecimento(
                    nomeProduto = txtVwNomeProduto.text.toString(),
                    precoProduto = txtVwPreco.text.toString(),
                    tipoComercio = "Mercado"
                ))

                var listaComprasAdapter = ListaComprasAdapter(todosOsProdutos)
                rcyVwListaCompras.adapter = listaComprasAdapter
                rcyVwListaCompras.layoutManager = LinearLayoutManager(context)

                listaComprasAdapter.notifyItemInserted(position)

            }
        })
        itemTouchHelper.attachToRecyclerView(rcyVwListaCompras)
    }
}
