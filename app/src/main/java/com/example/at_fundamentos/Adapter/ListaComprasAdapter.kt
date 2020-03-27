package com.example.at_fundamentos.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.at_fundamentos.R
import com.example.at_fundamentos.ViewModel.ComercioViewModel
import kotlinx.android.synthetic.main.lista_compras_recycle.view.*

class ListaComprasAdapter ()
    : RecyclerView.Adapter<ListaComprasAdapter.ListaComprasViewHolder>() {

    class ListaComprasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var campoTxtNomeProdutoMercado = view.txtVwNomeProdutoMercado
        var campoTxtPrecoProdutoMercado = view.txtVwPrecoProdutoMercado

        var campoTxtNomeProdutoFarmacia = view.txtVwNomeProdutoFarmacia
        var campoTxtPrecoProdutoFarmacia = view.txtVwPrecoProdutoFarmacia

        var campoTxtNomeProdutoSacolao = view.txtVwNomeProdutoSacolao
        var campoTxtPrecoProdutoSacolao = view.txtVwPrecoProdutoSacolao
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaComprasViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.lista_compras_recycle,
                parent,
                false
            )

        val listaComprasViewHolder = ListaComprasViewHolder(view)

        listaComprasViewHolder.itemView.setOnClickListener{
            var listaCompras = compras[listaComprasViewHolder.adapterPosition]
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ListaComprasViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}