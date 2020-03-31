package com.example.at_fundamentos.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.at_fundamentos.Model.Estabelecimento
import com.example.at_fundamentos.R
import kotlinx.android.synthetic.main.lista_compras_recycle.view.*

class ListaComprasAdapter(var todosOsProdutos: MutableList<Estabelecimento>?)
    : RecyclerView.Adapter<ListaComprasAdapter.ListaComprasViewHolder>() {

    class ListaComprasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var campoTxtNomeProduto = view.txtVwNomeProduto
        var campoTxtPreco = view.txtVwPrecoProduto
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

        return listaComprasViewHolder
    }

    override fun getItemCount(): Int = todosOsProdutos!!.size

    override fun onBindViewHolder(holder: ListaComprasViewHolder, position: Int) {
        val produtos = todosOsProdutos?.get(position)
        holder.campoTxtNomeProduto.text = produtos!!.nomeProduto
        holder.campoTxtPreco.text = produtos.precoProduto
    }
}