//package com.example.gaara
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class ListPopularOutfitAdapter(private val listOutfit : ArrayList<Outfit>) : RecyclerView.Adapter<ListNewOutfitAdapter.ListViewHolder>() {
//    class ListViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        val image : ImageView = itemView.findViewById(R.id.itemImage)
//        val tvTitle : TextView = itemView.findViewById(R.id.itemTitle)
//        val tvPrice : TextView = itemView.findViewById(R.id.itemPrice)
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder2 {
//        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_popular, parent, false)
//        return ListViewHolder2(view)
//    }
//
//    override fun onBindViewHolder(holder: ListNewOutfitAdapter.ListViewHolder, position: Int) {
//        val (title,price,image) = listOutfit[position]
//        holder.image.setImageResource(image)
//        holder.tvTitle.text = title
//        holder.tvPrice.text = price
//    }
//
//    override fun getItemCount(): Int = listOutfit.size
//
//
//
//
//
//}