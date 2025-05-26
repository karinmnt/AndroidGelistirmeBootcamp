package com.example.yemeksipariset.data.repo

import com.example.yemeksipariset.data.datasource.YemeklerDataSource
import com.example.yemeksipariset.data.entity.CRUDCevap
import com.example.yemeksipariset.data.entity.SepetYemekler
import com.example.yemeksipariset.data.entity.Yemekler

class YemeklerRepo(var yemeklerDataSource: YemeklerDataSource) {

    suspend fun yemekleriYukle() : List<Yemekler> = yemeklerDataSource.yemekleriListele()

    suspend fun sepeteEkle(yemekler: Yemekler,adet:Int,kullaniciAdi:String) : CRUDCevap {
        return yemeklerDataSource.sepeteEkle(yemekler,adet,kullaniciAdi)
    }

    suspend fun sepettenGetir(kullaniciAdi: String) : List<SepetYemekler>{
        return yemeklerDataSource.sepettenGetir(kullaniciAdi)
    }

    suspend fun sepettenSil(sepetYemeklerId: Int, kullaniciAdi: String)
    = yemeklerDataSource.sepettenSil(sepetYemeklerId,kullaniciAdi)



}