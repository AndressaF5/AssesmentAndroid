package com.example.at_fundamentos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.at_fundamentos.Adapter.FarmaciaAdapter
import com.example.at_fundamentos.Model.Farmacia

import com.example.at_fundamentos.R

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
    }
}
