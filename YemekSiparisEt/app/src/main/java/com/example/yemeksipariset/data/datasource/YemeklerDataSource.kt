package com.example.yemeksipariset.data.datasource

import com.example.yemeksipariset.data.entity.CRUDCevap
import com.example.yemeksipariset.data.entity.SepetYemekler
import com.example.yemeksipariset.data.entity.Yemekler
import com.example.yemeksipariset.data.retrofit.YemeklerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YemeklerDataSource (var yemeklerDao: YemeklerDao) {
    suspend fun yemekleriListele():List<Yemekler> = withContext(Dispatchers.IO){
        return@withContext yemeklerDao.yemekleriYukle().yemekler
    }

    suspend fun sepeteEkle(yemek : Yemekler, adet: Int, kullaniciAdi : String)
    : CRUDCevap = withContext(Dispatchers.IO){
        return@withContext yemeklerDao.sepeteEkle(yemek.yemek_adi,
            yemek.yemek_resim_adi, yemek.yemek_fiyat, adet,kullaniciAdi)
    }
    suspend fun sepettenGetir(kullaniciAdi: String) : List<SepetYemekler> = withContext(Dispatchers.IO){
        return@withContext yemeklerDao.sepettenGetir(kullaniciAdi).sepet_yepemekler
    }

    suspend fun sepettenSil(sepetYemeklerId:Int,kullaniciAdi:String) = withContext(Dispatchers.IO){
        return@withContext yemeklerDao.sepettenSil(sepetYemeklerId,kullaniciAdi)
    }

}