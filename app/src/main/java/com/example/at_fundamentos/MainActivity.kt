package com.example.at_fundamentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import com.example.at_fundamentos.ViewModel.ComercioViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var comercioViewModel = ViewModelProviders.of(this).get(ComercioViewModel::class.java)

        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)


    }
}
