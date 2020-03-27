package com.example.at_fundamentos.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.at_fundamentos.Model.Farmacia
import com.example.at_fundamentos.R
import kotlinx.android.synthetic.main.farmacia_recycle.view.*

class FarmaciaAdapter(
    private val farmacias : List<Farmacia>
) : RecyclerView.Adapter<FarmaciaAdapter.FarmaciaViewHolder>() {

    class FarmaciaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtVwNomeProduto = view.txtVwNomeProduto
        val txtVwPreco = view.txtVwPreco
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmaciaViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.farmacia_recycle,
                parent,
                false
            )

        val farmaciaViewHolder = FarmaciaViewHolder(view)

        farmaciaViewHolder.itemView.setOnClickListener{
            val farmacia = farmacias[farmaciaViewHolder.adapterPosition]
        }

        return farmaciaViewHolder
    }

    override fun getItemCount(): Int = farmacias.size

    override fun onBindViewHolder(holder: FarmaciaViewHolder, position: Int) {
        val farmacia = farmacias[position]
        holder.txtVwNomeProduto.text = farmacia.nomeProduto
        holder.txtVwPreco.text = farmacia.precoProduto
    }
}