package com.example.gaara

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvNewArrival: RecyclerView
    private lateinit var rvPopular: RecyclerView
    private lateinit var btnAbout: Button

    private val newArrivalList = ArrayList<Outfit>()
    private val popularList = ArrayList<Outfit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        rvNewArrival = findViewById(R.id.rv_new_arrival)
        rvNewArrival.setHasFixedSize(true)

        rvPopular =  findViewById(R.id.rv_popular_outfit)
        rvPopular.setHasFixedSize(true)

        btnAbout = findViewById(R.id.about_page)
        btnAbout.setOnClickListener(this)

        newArrivalList.addAll(getListOutfit())
        popularList.addAll(getPopularOutfit())
        showRecyclerList()


    }

    private fun showSelectedHero(outfit: Outfit) {
        Toast.makeText(this, "Kamu memilih " + outfit.name, Toast.LENGTH_SHORT).show()
    }

    private fun getListOutfit() : ArrayList<Outfit> {
        val dataTitle = resources.getStringArray(R.array.data_new_arrival_title)
        val dataPrice = resources.getStringArray(R.array.data_new_arrival_price)
        val dataImage =  resources.obtainTypedArray(R.array.data_new_arrival_image)
        val dataDescription =  resources.getStringArray(R.array.data_new_arrival_description)
        val dataBrand =  resources.getStringArray(R.array.data_new_arrival_brand)
        val dataSize =  resources.getStringArray(R.array.data_new_arrival_size_available)
        val listOutfit = ArrayList<Outfit>()

        for (i in dataTitle.indices) {
            val outfit = Outfit(dataTitle[i], dataPrice[i], dataImage.getResourceId(i, -1), dataDescription[i],dataBrand[i] ,dataSize[i])
            listOutfit.add(outfit)

        }

        Log.d("Listoutfit", "getListOutfit: $listOutfit")
        return listOutfit

    }

    private fun getPopularOutfit(): ArrayList<Outfit> {
        val listOutfit = getListOutfit()
        val popularOutfit = ArrayList<Outfit>()

        // Reverse the order of items from listOutfit and add to popularOutfit
        for (i in listOutfit.size - 1 downTo 0) {
            popularOutfit.add(listOutfit[i])
        }

        Log.d("PopularOutfit", "getPopularOutfit: $popularOutfit")
        return popularOutfit
    }


    private fun showRecyclerList() {
        rvNewArrival.layoutManager  = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listOutfitAdapter = ListNewOutfitAdapter(newArrivalList,2)
        rvNewArrival.adapter = listOutfitAdapter

        listOutfitAdapter.setOnItemClickCallback(object : ListNewOutfitAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Outfit) {
                showSelectedHero(data)

                val intentDetail = Intent(this@MainActivity, DetailProductActivity::class.java)
                intentDetail.putExtra("outfit", data)
                startActivity(intentDetail)
            }
        })


        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvPopular.layoutManager = GridLayoutManager(this, 4)
        } else {
            rvPopular.layoutManager = GridLayoutManager(this,2)
        }
        val listPopularOutfit = ListNewOutfitAdapter(popularList,1)
        rvPopular.adapter = listPopularOutfit

        listPopularOutfit.setOnItemClickCallback(object : ListNewOutfitAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Outfit) {
                showSelectedHero(data)

                val intentDetail = Intent(this@MainActivity, DetailProductActivity::class.java)
                intentDetail.putExtra("outfit", data)
                startActivity(intentDetail)
            }
        })

    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.about_page -> {
                val intentAboutPage = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intentAboutPage)
            }
        }

    }


}