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
import com.example.at_fundamentos.Adapter.FarmaciaAdapter
import com.example.at_fundamentos.Adapter.ListaComprasAdapter
import com.example.at_fundamentos.Model.Estabelecimento
import com.example.at_fundamentos.Model.Farmacia

import com.example.at_fundamentos.R
import com.example.at_fundamentos.ViewModel.ComercioViewModel
import kotlinx.android.synthetic.main.farmacia_recycle.*
import kotlinx.android.synthetic.main.fragment_adicionar_produto.*
import kotlinx.android.synthetic.main.fragment_farmacia.*
import kotlinx.android.synthetic.main.fragment_lista_compras.*

class FarmaciaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_farmacia, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var comprasFarmacia = mutableListOf(
            Farmacia("Dorflex", "5.50"),
            Farmacia("Amoxilina", "10.00"),
            Farmacia("Diazepam", "7.95"),
            Farmacia("Miconazol", "20.30"),
            Farmacia("Paracetamol", "3.45")
        )

        var farmaciaAdapter = FarmaciaAdapter(comprasFarmacia)

        rcyVwFarmacia.adapter = farmaciaAdapter
        rcyVwFarmacia.layoutManager = LinearLayoutManager(context)

        val itemTouchHelper = ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(
            0, ItemTouchHelper.RIGHT

        ) {

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

                var todosOsProdutos =  comercioViewModel!!.todosOsProdutos

                todosOsProdutos.add(position, Estabelecimento(
                    nomeProduto = txtVwNomeProduto.text.toString(),
                    precoProduto = txtVwPreco.text.toString()
                ))

                var listaComprasAdapter = ListaComprasAdapter(todosOsProdutos)
                rcyVwListaCompras.adapter = listaComprasAdapter
                rcyVwListaCompras.layoutManager = LinearLayoutManager(context)

                listaComprasAdapter.notifyItemInserted(position)

            }
        })

        itemTouchHelper.attachToRecyclerView(rcyVwFarmacia)
        itemTouchHelper.attachToRecyclerView(rcyVwListaCompras)
    }
}
