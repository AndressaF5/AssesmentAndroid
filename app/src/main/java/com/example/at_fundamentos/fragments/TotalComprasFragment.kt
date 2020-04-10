package com.example.at_fundamentos.fragments

import android.annotation.SuppressLint
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

    var comercioViewModel: ComercioViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_compras, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            comercioViewModel = ViewModelProviders.of(it).get(ComercioViewModel::class.java)
        }

        comercioViewModel!!.todosOsProdutos.observe(viewLifecycleOwner, Observer {
            var total = 0.0
            it.forEach {
                 total += it.precoProduto.toDouble()
            }
            comercioViewModel!!.totalCompras.value = total
        })

        comercioViewModel!!.totalCompras.observe(viewLifecycleOwner, Observer {
            if(it == 0.0){
                txtVwTotalCompras.setText("Total da compra = " + 0.0)
            }else{
                txtVwTotalCompras.setText("Total da compra = " + comercioViewModel!!.totalCompras.value)
            }
        })
    }
}
