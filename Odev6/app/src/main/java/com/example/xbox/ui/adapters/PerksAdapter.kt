package com.example.xbox.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xbox.databinding.PerksCardBinding
import com.example.xbox.ui.gamepass.Perks

class PerksAdapter(var mContext: Context, var perkListesi: ArrayList<Perks>) : RecyclerView.Adapter<PerksAdapter.PerksCardTutucu>()
{

    inner class PerksCardTutucu(var tasarim: PerksCardBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerksCardTutucu {
        var binding = PerksCardBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return PerksCardTutucu(binding)
    }

    override fun onBindViewHolder(holder: PerksCardTutucu, position: Int) {
        val perk = perkListesi.get(position)
        val t = holder.tasarim
        t.textViewPerks.text = perk.ad
        t.textViewPerksDes.text = perk.des
        t.textViewPerksClaim.text = perk.claim
        t.imageViewPerks.setImageResource(
            mContext.resources.getIdentifier(perk.perksResim,"drawable",mContext.packageName)
        )
    }

    override fun getItemCount(): Int {
        return perkListesi.size
    }
}