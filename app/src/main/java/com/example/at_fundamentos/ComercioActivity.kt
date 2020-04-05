package com.example.at_fundamentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.example.at_fundamentos.Adapter.DeslizePagerAdapter
import com.example.at_fundamentos.ViewModel.ComercioViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_comercio.*

class ComercioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comercio)

        var comercioViewModel = ViewModelProviders.of(this).get(ComercioViewModel::class.java)

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        viewPager.adapter = DeslizePagerAdapter(supportFragmentManager)
    }
}
