package com.example.yemeksipariset.data.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksipariset.data.entity.SepetYemekler
import com.example.yemeksipariset.databinding.SepetCardTasarimBinding
import com.google.android.material.snackbar.Snackbar

class SepetAdapter(var mContext: Context, var sepetListesi : List<SepetYemekler>,
    private var silListner:SepettenSil)
    : RecyclerView.Adapter<SepetAdapter.SepetViewHolder>() {

    inner class SepetViewHolder(var tasarim: SepetCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetViewHolder {
        val binding = SepetCardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return SepetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SepetViewHolder, position: Int) {
        val sepetYemek = sepetListesi[position]
        val t = holder.tasarim

        val resimAdi = sepetYemek.yemek_resim_adi.removeSuffix(".png")
        val resimId = mContext.resources.getIdentifier(resimAdi,"drawable",mContext.packageName)
        t.imageViewSepet.setImageResource(resimId)

        t.imageViewSepetSil.setOnClickListener {
            Snackbar.make(it,"${sepetYemek.yemek_adi}silindi",Snackbar.LENGTH_SHORT).show()
            silListner.sepettenSil(sepetYemek.sepet_yemek_id.toInt())
        }

        t.tvSepetAdet.text="${sepetYemek.yemek_siparis_adet}"
    }

    override fun getItemCount(): Int {
        return sepetListesi.size
    }
}