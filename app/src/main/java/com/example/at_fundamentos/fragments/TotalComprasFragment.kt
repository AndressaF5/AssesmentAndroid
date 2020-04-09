package com.example.at_fundamentos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.at_fundamentos.R
import com.example.at_fundamentos.ViewModel.ComercioViewModel
import kotlinx.android.synthetic.main.fragment_total_compras.*

class TotalComprasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_compras, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var comercioViewModel: ComercioViewModel = ViewModelProviders.of(this).get(ComercioViewModel::class.java)

        comercioViewModel.todosOsProdutos.observe(viewLifecycleOwner, Observer {
            var total = 0.0
            Toast.makeText(activity?.baseContext, "Evento disparado", Toast.LENGTH_LONG).show()
            it.forEach {
                total += it.precoProduto.toDouble()
            }
            comercioViewModel.totalCompras = total
            txtVwTotalCompras.text = "Total da compra = " + comercioViewModel.totalCompras
        })
    }
}
