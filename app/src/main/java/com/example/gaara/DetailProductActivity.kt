package com.example.gaara

import android.content.Intent
import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.RecyclerView

class DetailProductActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvDetailName: TextView
    private lateinit var tvDetailPrice: TextView
    private lateinit var tvDetailDescription: TextView
    private lateinit var tvBrand: TextView
    private lateinit var tvSize: TextView
    private lateinit var menuBack: ImageView
    private lateinit var ivDetailImage: ImageView
    private lateinit var btnShare: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        val dataOutfit = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Outfit>("outfit", Outfit::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Outfit>("outfit")
        }

        tvDetailName = findViewById(R.id.tv_detail_title)
        tvDetailPrice = findViewById(R.id.tv_detail_price)
        ivDetailImage = findViewById(R.id.iv_detail_image)
        tvDetailDescription = findViewById(R.id.tv_detail_descriptiom)
        tvSize = findViewById(R.id.tv_size)
        tvBrand = findViewById(R.id.tv_brand)
        menuBack = findViewById(R.id.ic_back)
        btnShare = findViewById(R.id.action_share)

        tvDetailName.text = dataOutfit?.name
        tvDetailPrice.text = dataOutfit?.price
        tvDetailDescription.text = dataOutfit?.description
        tvBrand.text = dataOutfit?.brand
        tvSize.text = dataOutfit?.size
        menuBack.setOnClickListener(this)
        dataOutfit?.image?.let { ivDetailImage.setImageResource(it) }

        btnShare.setOnClickListener{
            sendMessage("""
              Heyy, could you help me buy a ${dataOutfit?.name} outfit? It's priced at ${dataOutfit?.price}. Thanks a bunch!

            """.trimIndent())
        }


    }

    fun sendMessage(message:String) {

        // Creating intent with action send
        val intent = Intent(Intent.ACTION_SEND)

        // Setting Intent type
        intent.type = "text/plain"

        // Setting whatsapp package name
        intent.setPackage("com.whatsapp")

        // Give your message here
        intent.putExtra(Intent.EXTRA_TEXT, message)
        try {
            startActivity(intent)
        } catch (ex: Exception) {
            Toast.makeText(
                this,
                "Please install whatsapp first.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onClick(view: View?) {
       when(view?.id) {
           R.id.ic_back -> {
               super.onBackPressed();

           }
       }
    }
}