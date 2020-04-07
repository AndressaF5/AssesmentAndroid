package com.example.at_fundamentos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.at_fundamentos.Adapter.ListaComprasAdapter
import com.example.at_fundamentos.Adapter.MercadoAdapter
import com.example.at_fundamentos.R
import com.example.at_fundamentos.ViewModel.ComercioViewModel
import kotlinx.android.synthetic.main.fragment_mercado.*

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

        var comercioViewModel: ComercioViewModel? = null
        activity?.let {
            comercioViewModel = ViewModelProviders.of(it).get(ComercioViewModel::class.java)
        }

        var mercadoAdapter = MercadoAdapter(comercioViewModel!!.produtosMercado)
        rcyVwMercado.adapter = mercadoAdapter
        rcyVwMercado.layoutManager = LinearLayoutManager(context)

        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0, ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                var todosOsProdutos = comercioViewModel!!.todosOsProdutos.value
                todosOsProdutos!!.add(comercioViewModel!!.produtosMercado[viewHolder.adapterPosition])
            }
        })
        itemTouchHelper.attachToRecyclerView(rcyVwMercado)
    }
}
