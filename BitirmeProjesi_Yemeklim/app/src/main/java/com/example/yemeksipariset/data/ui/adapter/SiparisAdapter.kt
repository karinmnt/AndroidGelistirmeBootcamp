package com.example.yemeksipariset.data.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksipariset.data.entity.Siparis
import com.example.yemeksipariset.databinding.SiparisCardTasarimBinding

class SiparisAdapter(
    private val mContext: Context,
    private var siparisListesi: List<Siparis>
) : RecyclerView.Adapter<SiparisAdapter.SiparisViewHolder>() {

    inner class SiparisViewHolder(val binding: SiparisCardTasarimBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiparisViewHolder {
        val binding = SiparisCardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return SiparisViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return siparisListesi.size
    }

    override fun onBindViewHolder(holder: SiparisViewHolder, position: Int) {
        val siparis = siparisListesi[position]
        val t = holder.binding

        t.tvSiparisYemekAdi.text = siparis.yemek_adi
        t.tvSiparisAdet.text = "${siparis.yemek_adet} adet"
        t.tvSiparisFiyat.text = "${siparis.toplam_fiyat}₺"

        val resimAdi = siparis.yemek_resim_adi.removeSuffix(".png")
        val resimId = mContext.resources.getIdentifier(resimAdi, "drawable", mContext.packageName)
        t.ivSiparisResim.setImageResource(resimId)
    }

    fun updateList(yeniListe: List<Siparis>) {
        siparisListesi = yeniListe
        notifyDataSetChanged()
    }
}
