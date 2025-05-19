package com.example.odev7.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.odev7.data.entity.Yapilacaklar
import com.example.odev7.ui.viewmodel.AnasayfaViewModel
import com.example.odev7.utils.gecisYap
import com.example.odev7.databinding.CardTasarimBinding
import com.example.odev7.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class YapilacaklarAdapter(var mContext: Context,
                          var yapilacaklarListesi: List<Yapilacaklar>,
                          var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yap = yapilacaklarListesi.get(position)
        val t = holder.tasarim
        t.textViewYapilacaklarAd.text = yap.yapilacaklar_ad
        
        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.yapilacaklarDetayGecis(yapilacaklar = yap)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${yap.yapilacaklar_ad} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET") {
                    viewModel.sil(yap.yapilacaklar_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return yapilacaklarListesi.size
    }
}