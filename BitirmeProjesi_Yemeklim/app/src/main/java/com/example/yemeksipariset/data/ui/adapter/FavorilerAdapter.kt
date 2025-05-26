package com.example.yemeksipariset.data.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksipariset.data.entity.Favoriler
import com.example.yemeksipariset.databinding.FavorilerCardTasarimBinding
import com.google.android.material.snackbar.Snackbar

class FavorilerAdapter(
    private val mContext: Context,
    private var favoriListesi: List<Favoriler>,
    private val onFavorilerSil: (Favoriler) -> Unit,
    private val onItemClick: (Favoriler) -> Unit
) : RecyclerView.Adapter<FavorilerAdapter.FavorilerViewHolder>() {

    inner class FavorilerViewHolder(val tasarim: FavorilerCardTasarimBinding)
        : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavorilerViewHolder {
        val binding = FavorilerCardTasarimBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return FavorilerViewHolder(binding)
    }

    override fun getItemCount(): Int = favoriListesi.size

    override fun onBindViewHolder(holder: FavorilerViewHolder, position: Int) {

        val favori = favoriListesi[position]
        val t = holder.tasarim

        // Databinding
        t.favorilerNesnesi = favori

        // Resim ayarla
        val resimAdi = favori.yemek_resim_adi.removeSuffix(".png")
        val resimId = mContext.resources.getIdentifier(resimAdi, "drawable", mContext.packageName)
        t.ivFavResim.setImageResource(resimId)

        // Sil butonu
        t.ivFavSil.setOnClickListener {
            Snackbar.make(it, "${favori.yemek_adi} favorilerden kaldırıldı!", Snackbar.LENGTH_SHORT).show()
            onFavorilerSil(favori)
        }

        t.root.setOnClickListener {
            onItemClick(favori)
        }
    }

    fun updateList(yeniListe: List<Favoriler>) {
        favoriListesi = yeniListe
        notifyDataSetChanged()
    }
}
