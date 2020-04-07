package com.example.at_fundamentos.Adapter

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.at_fundamentos.ComercioActivity
import com.example.at_fundamentos.R
import com.example.at_fundamentos.fragments.*

class DeslizePagerAdapter (fm: FragmentManager):
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    val numeroDeTabs = 4
    val opcoes = listOf("Mercado", "Farmácia", "Sacolão", "Adicionar Produto")

    override fun getItem(position: Int): Fragment {
        if (position == 0){
            return MercadoFragment()
        }else if (position == 1){
            return FarmaciaFragment()
        }else if (position == 2){
            return SacolaoFragment()
        }else{
            return AdicionarProdutoFragment()
        }
    }

    override fun getPageTitle(position: Int) = opcoes[position]
    override fun getCount() = numeroDeTabs
}