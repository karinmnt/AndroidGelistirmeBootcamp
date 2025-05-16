package com.example.xbox.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xbox.databinding.MostPopularCardBinding
import com.example.xbox.ui.gamepass.MostPopular

class MostPopularAdapter (var mContext: Context, var mostPopularListesi: ArrayList<MostPopular>) : RecyclerView.Adapter<MostPopularAdapter.MostPopularCardTutucu>()
{
    inner class MostPopularCardTutucu(var tasarim: MostPopularCardBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularCardTutucu {
        var binding = MostPopularCardBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return MostPopularCardTutucu(binding)
    }

    override fun onBindViewHolder(holder: MostPopularCardTutucu, position: Int) {
        val most = mostPopularListesi.get(position)
        val t = holder.tasarim
        t.imageViewMostPopular.setImageResource(
            mContext.resources.getIdentifier(most.mostPopularResim,"drawable",mContext.packageName)
        )
    }

    override fun getItemCount(): Int {
        return mostPopularListesi.size
    }
}