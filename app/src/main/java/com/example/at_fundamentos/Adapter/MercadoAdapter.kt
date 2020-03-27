package com.example.at_fundamentos.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.at_fundamentos.Model.Mercado
import com.example.at_fundamentos.R
import kotlinx.android.synthetic.main.mercado_recycle.view.*

class MercadoAdapter (
    private val mercados : List<Mercado>,
    private val callback : (Mercado) -> Unit
) : RecyclerView.Adapter<MercadoAdapter.MercadoViewHolder>() {

    class MercadoViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val txtVwNomeProduto = view.txtVwNomeProduto
        val txtVwPreco = view.txtVwPreco
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MercadoViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.mercado_recycle,
                parent,
                false
            )

        val mercadoViewHolder = MercadoViewHolder(view)

        mercadoViewHolder.itemView.setOnClickListener{
            val mercado = mercados[mercadoViewHolder.adapterPosition]

            callback(mercado)
        }

        return mercadoViewHolder
    }

    override fun getItemCount(): Int = mercados.size

    override fun onBindViewHolder(holder: MercadoViewHolder, position: Int) {
        val mercado = mercados[position]
        holder.txtVwNomeProduto.text = mercado.nomeProduto
        holder.txtVwPreco.text = mercado.precoProduto
    }
}