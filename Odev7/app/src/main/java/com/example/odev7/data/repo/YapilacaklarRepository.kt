package com.example.odev7.data.repo


import com.example.odev7.data.entity.Yapilacaklar
import com.example.odev7.data.datasource.YapilacaklarDataSource

class YapilacaklarRepository(var yapilacaklarDataSource : YapilacaklarDataSource) {

    suspend fun kaydet(yapilacaklar_ad: String) {
        yapilacaklarDataSource.kaydet(yapilacaklar_ad)
    }

    suspend fun guncelle(yapilacaklar_id:Int,yapilacaklar_ad: String)
    = yapilacaklarDataSource.guncelle(yapilacaklar_id,yapilacaklar_ad)

    suspend fun sil(yapilacaklar_id:Int) = yapilacaklarDataSource.sil(yapilacaklar_id)

    suspend fun yapilacaklariYukle() : List<Yapilacaklar> = yapilacaklarDataSource.yapilacaklarYukle()

    suspend fun ara(aramaKelimesi:String) : List<Yapilacaklar> = yapilacaklarDataSource.ara(aramaKelimesi)
}