package com.example.gaara

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class ListNewOutfitAdapter(private val listOutfit : ArrayList<Outfit>, private val costumeType: Int) : RecyclerView.Adapter<ListNewOutfitAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image : ImageView = itemView.findViewById(R.id.itemImage)
        val tvTitle : TextView = itemView.findViewById(R.id.itemTitle)
        val tvPrice : TextView = itemView.findViewById(R.id.itemPrice)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return when (costumeType) {


            1 -> {
                Log.d("ViewType", "onCreateViewHolder: $viewType")

                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_grid_popular, parent, false)
                ListViewHolder(view)
            }

            2 -> {


                Log.d("ViewType", "onCreateViewHolder: $viewType")

                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_row_new_arrival, parent, false)
                ListViewHolder(view)
            }
            // Add more cases for other layout types
            else -> {
                Log.d("ViewType", "onCreateViewHolder: $viewType")
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_grid_popular, parent, false)
                ListViewHolder(view)
            }
        }

    }

    override fun getItemCount(): Int = listOutfit.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title,price,image) = listOutfit[position]
        holder.image.setImageResource(image)
        holder.tvTitle.text = title
        holder.tvPrice.text = price

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listOutfit[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Outfit)
    }



}