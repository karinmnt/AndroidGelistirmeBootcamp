package com.example.yemeksipariset.data.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksipariset.data.entity.Yemekler
import com.example.yemeksipariset.data.ui.fragment.AnasayfaFragmentDirections
import com.example.yemeksipariset.data.ui.viewmodel.AnasayfaViewModel
import com.example.yemeksipariset.databinding.AnasayfaCardTasarimBinding

class YemeklerAdapter(
    private val mContext: Context,
    private val yemeklerListesi: MutableList<Yemekler>,
    private val viewModel: AnasayfaViewModel,
    private val onEkleClick: (Yemekler) -> Unit
)
    : RecyclerView.Adapter<YemeklerAdapter.AnasayfaCardTasarimTutucu>() {

    inner class AnasayfaCardTasarimTutucu(var tasarim : AnasayfaCardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnasayfaCardTasarimTutucu {
        val binding = AnasayfaCardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return AnasayfaCardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }

    override fun onBindViewHolder(holder: AnasayfaCardTasarimTutucu, position: Int) {
        val yemek = yemeklerListesi.get(position)
        val t = holder.tasarim

        t.tvAd.text="${yemek.yemek_adi}"
        t.tvFiyat.text="${yemek.yemek_fiyat} ₺"

        val resimAdi = yemek.yemek_resim_adi.removeSuffix(".png")
        var resimID = mContext.resources.getIdentifier(resimAdi,"drawable",mContext.packageName)
        t.ivYemek.setImageResource(resimID)

        t.ivEkle.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.gecisDetay(yemek)
            Navigation.findNavController(it).navigate(gecis)
        }





    }

    fun updateYemekList(newList: List<Yemekler>){
        yemeklerListesi.clear()
        yemeklerListesi.addAll(newList)
        notifyDataSetChanged()
    }

}


