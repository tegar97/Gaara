package com.example.gaara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate

class AboutActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        btnBack = findViewById(R.id.go_back_home)
        btnBack.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.go_back_home -> {
                super.onBackPressed();

            }

        }
    }
}