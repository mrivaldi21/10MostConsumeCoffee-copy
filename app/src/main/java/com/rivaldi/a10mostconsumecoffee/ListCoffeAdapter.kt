package com.rivaldi.a10mostconsumecoffee

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.rivaldi.a10mostconsumecoffee.databinding.ItemRowCoffeBinding

class ListCoffeAdapter(
    private val listCoffe: ArrayList<Coffe>
) : RecyclerView.Adapter<ListCoffeAdapter.ListViewHolder>() {

    //set interface when item is clicked
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    //Old Binding View Holder
    class ListViewHolder(var binding: ItemRowCoffeBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemRowCoffeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listCoffe.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listCoffe[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItemCoffe)
        holder.binding.tvCoffeName.text = name
        holder.binding.tvCoffeDescription.text = description
        holder.itemView.setOnClickListener {
//            onItemClickCallback.onItemClicked(listCoffe[holder.adapterPosition])
            val intentDetail = Intent(holder.itemView.context, DetailCoffe::class.java)
            intentDetail.putExtra("key_coffe", listCoffe[holder.adapterPosition])
            Log.i("info", "The selected data is ${listCoffe[holder.adapterPosition]}")
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Coffe)
    }
}