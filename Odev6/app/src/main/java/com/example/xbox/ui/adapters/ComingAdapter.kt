package com.example.xbox.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xbox.databinding.ComingCardBinding
import com.example.xbox.ui.gamepass.Coming

class ComingAdapter (var mContext: Context, var comingListesi: ArrayList<Coming>) : RecyclerView.Adapter<ComingAdapter.ComingCardTutucu>() {

    inner class ComingCardTutucu(var tasarim: ComingCardBinding) :
        RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComingCardTutucu {
        var binding = ComingCardBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return ComingCardTutucu(binding)
    }

    override fun onBindViewHolder(holder: ComingCardTutucu, position: Int) {
        val coming = comingListesi.get(position)
        val t = holder.tasarim
        t.textViewComing.text = coming.tarih
        t.imageViewComing.setImageResource(
            mContext.resources.getIdentifier(coming.comingResim, "drawable", mContext.packageName)
        )
    }

    override fun getItemCount(): Int {
        return comingListesi.size
    }
}