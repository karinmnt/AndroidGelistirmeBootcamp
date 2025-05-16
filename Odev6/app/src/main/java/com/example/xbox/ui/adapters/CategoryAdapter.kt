package com.example.xbox.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xbox.databinding.ItemCategoryCardBinding
import com.example.xbox.ui.gamepass.Category


class CategoryAdapter (var mContext: Context, var categoryListesi: ArrayList<Category>) : RecyclerView.Adapter<CategoryAdapter.ItemCategoryCardTutucu>() {

    inner class ItemCategoryCardTutucu(var tasarim: ItemCategoryCardBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCategoryCardTutucu {
        var binding = ItemCategoryCardBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return ItemCategoryCardTutucu(binding)
    }

    override fun onBindViewHolder(holder: ItemCategoryCardTutucu, position: Int) {
        val category = categoryListesi.get(position)
        val t = holder.tasarim
        t.tvName.text=category.name
    }

    override fun getItemCount(): Int {
        return categoryListesi.size
    }
}