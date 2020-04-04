package com.example.at_fundamentos.Adapter

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.at_fundamentos.ComercioActivity
import com.example.at_fundamentos.R
import com.example.at_fundamentos.fragments.HomeFragment
import com.example.at_fundamentos.fragments.ListaComprasFragment
import com.example.at_fundamentos.fragments.MercadoFragment

class DeslizePagerAdapter (fm: FragmentManager):
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    val numeroDeTabs = 3
    val opcoes = listOf("Home", "Produtos", "Minha Lista")

    override fun getItem(position: Int) = when(position) {
        0 -> HomeFragment()
        1 -> ComercioActivity()
        else -> ListaComprasFragment()
    }

    override fun getPageTitle(position: Int) = opcoes[position]
    override fun getCount() = numeroDeTabs
}