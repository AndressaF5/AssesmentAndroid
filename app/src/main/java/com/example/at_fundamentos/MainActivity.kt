package com.example.at_fundamentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.at_fundamentos.Adapter.DeslizePagerAdapter
import com.example.at_fundamentos.ViewModel.ComercioViewModel
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var comercioViewModel = ViewModelProviders.of(this).get(ComercioViewModel::class.java)

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        viewPager.adapter = DeslizePagerAdapter(supportFragmentManager)
    }
}
