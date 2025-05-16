package com.example.xbox.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xbox.data.repository.GameRepository
import com.example.xbox.databinding.ItemGameCardBinding
import com.example.xbox.databinding.PerksCardBinding
import com.example.xbox.ui.gamepass.Oyunlar


class GameCardAdapter(var mContext: Context, var oyunlarListesi: ArrayList<Oyunlar>) : RecyclerView.Adapter<GameCardAdapter.ItemGameCardTutucu>()
 {

     inner class ItemGameCardTutucu(var tasarim: ItemGameCardBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemGameCardTutucu {
        var binding = ItemGameCardBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return ItemGameCardTutucu(binding)
    }

     override fun onBindViewHolder(holder: ItemGameCardTutucu, position: Int) {
         val oyun = oyunlarListesi.get(position)
         val t = holder.tasarim
         t.imageViewOyun.setImageResource(
             mContext.resources.getIdentifier(oyun.resim,"drawable",mContext.packageName)
         )
     }

     override fun getItemCount(): Int {
         return oyunlarListesi.size
     }

}
