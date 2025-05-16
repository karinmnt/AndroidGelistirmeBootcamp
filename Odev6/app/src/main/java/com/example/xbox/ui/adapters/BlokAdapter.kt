package com.example.xbox.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xbox.databinding.BlokCardBinding
import com.example.xbox.ui.gamepass.Bloklar

class BlokAdapter(var mContext: Context, var blokListesi: ArrayList<Bloklar>) : RecyclerView.Adapter<BlokAdapter.BlokCardTutucu>()
{
    inner class BlokCardTutucu(var tasarim: BlokCardBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlokCardTutucu {
       var binding = BlokCardBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return BlokCardTutucu(binding)
    }

    override fun getItemCount(): Int {
        return blokListesi.size
    }

    override fun onBindViewHolder(holder: BlokCardTutucu, position: Int) {
        val blok = blokListesi.get(position)
        val t = holder.tasarim
        t.imageViewBlok.setImageResource(
            mContext.resources.getIdentifier(blok.resimBlok,"drawable",mContext.packageName)
        )
    }
}