package com.example.xbox.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xbox.databinding.MostPopularCardBinding
import com.example.xbox.ui.gamepass.DayOne


class DayOneAdapter(var mContext: Context, var dayOneListesi: ArrayList<DayOne>) : RecyclerView.Adapter<DayOneAdapter.MostPopularCardTutucu>() {

    inner class MostPopularCardTutucu(var tasarim: MostPopularCardBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularCardTutucu {
        var binding = MostPopularCardBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return MostPopularCardTutucu(binding)
    }

    override fun onBindViewHolder(holder: MostPopularCardTutucu, position: Int) {
        val dayone = dayOneListesi.get(position)
        val t = holder.tasarim
        t.imageViewMostPopular.setImageResource(
            mContext.resources.getIdentifier(dayone.dayOneResim,"drawable",mContext.packageName)
        )
    }

    override fun getItemCount(): Int {
        return dayOneListesi.size
    }
}