package com.example.at_fundamentos.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.at_fundamentos.Model.Sacolao
import com.example.at_fundamentos.R
import kotlinx.android.synthetic.main.sacolao_recycle.view.*

class SacolaoAdapter (
    private val sacoloes : List<Sacolao>,
    private val callback : (Sacolao) -> Unit
) :RecyclerView.Adapter<SacolaoAdapter.SacolaoViewHolder>() {

    class SacolaoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtVwNomeProduto = view.txtVwNomeProduto
        val txtVwPreco = view.txtVwPreco
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SacolaoViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.sacolao_recycle,
                parent,
                false
            )

        val sacolaoViewHolder = SacolaoViewHolder(view)

        sacolaoViewHolder.itemView.setOnClickListener{
            val sacolao = sacoloes[sacolaoViewHolder.adapterPosition]

            callback(sacolao)
        }

        return sacolaoViewHolder
    }

    override fun getItemCount(): Int = sacoloes.size

    override fun onBindViewHolder(holder: SacolaoViewHolder, position: Int) {
        val sacolao = sacoloes[position]
        holder.txtVwNomeProduto.text = sacolao.nomeProduto
        holder.txtVwPreco.text = sacolao.precoProduto
    }
}